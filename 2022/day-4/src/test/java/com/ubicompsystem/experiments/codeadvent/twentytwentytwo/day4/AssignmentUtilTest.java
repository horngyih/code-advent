package com.ubicompsystem.experiments.codeadvent.twentytwentytwo.day4;

import static org.junit.Assert.*;
import static com.ubicompsystem.experiments.codeadvent.twentytwentytwo.day4.AssignmentUtil.*;

import java.util.*;
import java.util.stream.*;

import org.junit.Test;

public class AssignmentUtilTest {

	@Test
	public void rangeParsingTest() {
		rangeTest( "6-6", new HashSet<Integer>(Arrays.asList(6)) );
		rangeTest( "2-9", new HashSet<Integer>(Arrays.asList(2,3,4,5,6,7,8,9)) );
	}

	@Test
	public void encompassTest(){
		encompassTest("6-6", "7-7", false);
		encompassTest("6-7", "7-8", false);
		encompassTest("6-8", "6-8", true);
		encompassTest("2-9", "6-8", true);
		encompassTest("6-8", "2-9", true);
	}

	@Test
	public void overlapTest(){
		overlapTest( "6-6", "7-7", false );
		overlapTest( "4-9", "5-7", true );
		overlapTest( "2-7", "6-8", true );
	}

	protected void rangeTest( String range, Set<Integer> expectedSet ){
		Set<Integer> rangeSet = parseRangeAsSet(range);
		System.out.println(String.format( "%s => %s", range, rangeSet.toString() ) );
		assertNotNull( "Should return a non-null Set", rangeSet );
		assertEquals( "Should return a set with the expected number of entries", expectedSet.size(), rangeSet.size() );
		assertTrue( "Should return the expected entries", rangeSet.containsAll(expectedSet) );
	}

	public void encompassTest( String firstRange, String secondRange, boolean expected ){
		Set<Integer> firstSet = parseRangeAsSet(firstRange);
		Set<Integer> secondSet = parseRangeAsSet(secondRange);
		boolean encompass = completeEncompass(firstSet, secondSet);
		System.out.println(String.format("%s encompasses %s => %s", firstSet.toString(), secondSet.toString(), "" + encompass ));
		assertEquals( "Should return the expected encompassing state", expected, encompass );
	}

	public void overlapTest( String firstRange, String secondRange, boolean expected ){
		Set<Integer> firstSet = parseRangeAsSet(firstRange);
		Set<Integer> secondSet = parseRangeAsSet(secondRange);
		boolean overlap = overlap(firstSet, secondSet);
		System.out.println(String.format("%s overlaps %s => %s", firstSet.toString(), secondSet.toString(), "" + overlap ));
		assertEquals( "Should return the expected overlap state", expected, overlap );
	}
}
