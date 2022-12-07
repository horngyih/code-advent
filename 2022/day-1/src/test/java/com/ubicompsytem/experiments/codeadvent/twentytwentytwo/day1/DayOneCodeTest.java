package com.ubicompsystem.experiments.codeadvent.twentytwentytwo.day1;

import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import org.junit.Test;

public class DayOneCodeTest{

    @Test
    public void defaultTest() throws Exception {
        System.out.println( "Code Advent 2022 - Day 1" );
        List<String> lines = readFile("input.txt");
        List<List<String>> elfLoads = new ArrayList<>();
        List<String> current = new ArrayList<>();
        for( String line : lines ){
            if( line == null || "".equals(line.trim()) ){
                if( !current.isEmpty() ){
                    elfLoads.add(current);
                    current = new ArrayList<>();
                }
            } else {
                current.add(line.trim());
            }
        }
        if( !current.isEmpty() ) elfLoads.add(current);
        List<Integer> elfLoadSums = elfLoads.stream()
        .map( load->load.stream()
            .map(Integer::parseInt).reduce(0,Integer::sum) 
        ).collect(Collectors.toList());

        OptionalInt max = elfLoadSums.stream().mapToInt(sum->sum.intValue()).max();
        System.out.println( "Largest Elf Load : " + max.getAsInt() );
        Collections.sort(elfLoadSums);
        Collections.reverse(elfLoadSums);
        int n = 3;
        int top3Sum = elfLoadSums.stream().limit(n).mapToInt(sum->sum.intValue()).sum();
        System.out.println( String.format("Top %d Sum:", n ) + top3Sum);
    }

    public List<String> readFile( String fileName ) throws Exception {
        InputStream resourceStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
        if( resourceStream != null ){
            List<String> lines = new ArrayList<String>();
            try( InputStreamReader isr = new InputStreamReader(resourceStream) ){
                try( BufferedReader br = new BufferedReader(isr) ){
                    while(br.ready()){
                        lines.add(br.readLine());
                    }
                }
            }
            return lines;
        } else {
            throw new Exception( "No Input found" );
        }
    }
}
