package com.ubicompsystem.experiments.codeadvent.twentytwentytwo.day3;

import static org.junit.Assert.*;
import static com.ubicompsystem.experiments.codeadvent.twentytwentytwo.day3.PackingUtil.*;

import org.junit.*;
import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class DayThreeTest {

    boolean verbose = System.getProperty("verbose")!=null;

    @Test
    public void defaultTest() throws Exception {
        System.out.println( "==== Day 3 : Rucksack Reorganization ====\n" );

        GroupingConsumer<String> grouping = new GroupingConsumer<String>(3);
        int prioritySum = inputLines().stream()
            .peek(grouping)
            .map(this::parseLine)
            .map(rucksack->overlap(rucksack.compartment1, rucksack.compartment2))
            .flatMap(Collection::stream)
            .peek(item->{ if(verbose) System.out.println(item); })
            .map(item->item.charAt(0))
            .mapToInt(PackingUtil::priority)
        .sum();
        System.out.println( "Priority Sum : " + prioritySum );

        int groupedPrioritySum = grouping.groups().stream()
            .map(group->group.stream()
                    .map(str->str.split(""))
                .collect(Collectors.toList()))
            .map(sets->PackingUtil.overlaps(sets))
            .flatMap(Collection::stream)
            .map(str->str.charAt(0))
            .mapToInt(PackingUtil::priority)
            .peek(System.out::println)
        .sum();

        System.out.println( "Grouped Priority Sum : " + groupedPrioritySum );

        System.out.println( "\n==== END Day 3 : Rucksack Reorganization ====\n" );
    }

    public Rucksack parseLine( String line ) {
        if( line != null && !"".equals(line.trim()) ){
            Rucksack rucksack = new Rucksack();
            int lineLength = line.length();
            rucksack.compartment1 = line.substring(0, (lineLength/2));
            rucksack.compartment2 = line.substring(lineLength/2);
            return rucksack;
        }
        return null;
    }

    public List<String> inputLines() throws Exception {
        InputStream resourceStream = this.getClass().getClassLoader().getResourceAsStream( "input.txt" );
        if( resourceStream != null ){
            try( InputStreamReader isr = new InputStreamReader(resourceStream); ){
                try( BufferedReader br = new BufferedReader(isr); ) {
                    List<String> lines = new ArrayList<>();
                    while(br.ready()){
                        lines.add(br.readLine().trim());
                    }
                    return lines;
                }
            }
        }
        throw new Exception( "No Input" );
    }

    public class Rucksack {
        public String compartment1;
        public String compartment2;
        public String toString(){
            StringBuffer buffer = new StringBuffer("{");
            buffer.append( "\tcompartment1 : " ).append( compartment1 ).append( ",\n" );
            buffer.append( "\tcompartment2 : " ).append( compartment2 ).append( ",\n" );
            buffer.append("}");
            return buffer.toString();
        }
    }

    public class GroupingConsumer<T> implements Consumer<T> {
        final int groupSize;
        List<T> currentGroup;
        List<List<T>> groups;

        public GroupingConsumer( int size ){
            this.groupSize = size;
            this.currentGroup = new ArrayList<>();
            this.groups = new ArrayList<>();
        }

        public void accept( T item ){
            if( currentGroup.size() == groupSize ){
                groups.add(currentGroup);
                currentGroup = new ArrayList<>();
            }
            currentGroup.add(item);
        }

        public List<List<T>> groups(){
            if( currentGroup != null && currentGroup.size() > 0 ){
                groups.add(currentGroup);
                currentGroup = null;
            }
            return groups;
        }
    }
}
