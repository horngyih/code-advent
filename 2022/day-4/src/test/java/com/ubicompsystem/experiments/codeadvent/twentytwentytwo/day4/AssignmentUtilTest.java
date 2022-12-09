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
		encompassTest(parseRangeAsSet("6-6"), parseRangeAsSet("7-7"), false);
		encompassTest(parseRangeAsSet("6-7"), parseRangeAsSet("7-8"), false);
		encompassTest(parseRangeAsSet("6-8"), parseRangeAsSet("6-8"), true);
		encompassTest(parseRangeAsSet("2-9"), parseRangeAsSet("6-8"), true);
		encompassTest(parseRangeAsSet("6-8"), parseRangeAsSet("2-9"), true);
	}

	protected void rangeTest( String range, Set<Integer> expectedSet ){
		Set<Integer> rangeSet = parseRangeAsSet(range);
		System.out.println(String.format( "%s => %s", range, rangeSet.toString() ) );
		assertNotNull( "Should return a non-null Set", rangeSet );
		assertEquals( "Should return a set with the expected number of entries", expectedSet.size(), rangeSet.size() );
		assertTrue( "Should return the expected entries", rangeSet.containsAll(expectedSet) );
	}

	public void encompassTest( Set<Integer> firstSet, Set<Integer> secondSet, boolean expected ){
		boolean encompass = completeEncompass(firstSet, secondSet);
		System.out.println(String.format("%s encompasses %s => %s", firstSet.toString(), secondSet.toString(), "" + encompass ));
		assertEquals( "Should return the expected encompassing state", expected, encompass );
	}
}
