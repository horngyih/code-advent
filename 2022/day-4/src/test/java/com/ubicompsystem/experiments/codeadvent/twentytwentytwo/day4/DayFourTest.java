package com.ubicompsystem.experiments.codeadvent.twentytwentytwo.day4;

import static com.ubicompsystem.experiments.codeadvent.twentytwentytwo.day4.AssignmentUtil.*;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import org.junit.Test;

public class DayFourTest {

	@Test
	public void defaultTest() throws Exception {
		List<ElfAssignment> assignments = inputLines().stream()
			.map(this::parseElfAssignment)
		.collect(Collectors.toList());

		long countEncompasses = assignments.stream().filter(assignment->assignment.encompass).count();
		System.out.println( "Elf pairs who encompass each other = " + countEncompasses );

		long countOverlaps = assignments.stream().filter(assignment->assignment.overlap).count();
		System.out.println( "Elf pairs who overlaps each other = " + countOverlaps );
	}

	protected List<String> inputLines() throws Exception {
		InputStream resourceStream = this.getClass().getClassLoader().getResourceAsStream( "input.txt" );
		if( resourceStream != null ){
			try( InputStreamReader isr = new InputStreamReader(resourceStream) ){
				try( BufferedReader br = new BufferedReader(isr) ){
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

	public ElfAssignment parseElfAssignment( String line ){
		String[] ranges = line.split(",");
		return new ElfAssignment(parseRangeAsSet(ranges[0]), parseRangeAsSet(ranges[1]) );
	}

	public class ElfAssignment{
		public Set<Integer> elf1;
		public Set<Integer> elf2;
		boolean encompass;
		boolean overlap;

		public ElfAssignment( Set<Integer> elf1Assignment, Set<Integer>elf2Assignment ){
			elf1 = elf1Assignment;
			elf2 = elf2Assignment;
			encompass = completeEncompass(elf1, elf2);
			overlap = overlap(elf1, elf2);
		}

		public String toString(){
			StringBuffer buffer = new StringBuffer("{");
			buffer.append( "elf1 : " + elf1 ).append(", ");
			buffer.append( "elf2 : " + elf2 ).append( ", ");
			buffer.append( "encompass : " + encompass );
			buffer.append( "overlap : " + overlap );
			buffer.append( "}" );
			return buffer.toString();
		}
	}
}
