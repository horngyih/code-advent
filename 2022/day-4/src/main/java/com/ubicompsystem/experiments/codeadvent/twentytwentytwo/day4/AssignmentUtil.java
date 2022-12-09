package com.ubicompsystem.experiments.codeadvent.twentytwentytwo.day4;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class AssignmentUtil {

	public static Set<Integer> parseRangeAsSet( String str ){
		if( str == null || "".equals(str.trim()) ) return new HashSet<>();

		try{ 
		String[] tokens = str.split("-");
		int start = Integer.parseInt(tokens[0].trim());
		int end = Integer.parseInt(tokens[1].trim());
		return IntStream.rangeClosed( start, end ).collect(
			HashSet::new,
			(acc, i)->acc.add(i),
			(a,b)->b.addAll(a)
		);
		} catch( NumberFormatException numEx ){
			return new HashSet<>();
		}
	}

	public static boolean completeEncompass( Set<Integer> firstSet, Set<Integer> secondSet ){
		if( firstSet == null || secondSet == null ) return false;

		return (firstSet.size()>=secondSet.size())?firstSet.containsAll(secondSet):secondSet.containsAll(firstSet);
	}

	public static boolean overlap( Set<Integer> firstSet, Set<Integer> secondSet ){
		if( firstSet == null || secondSet == null ) return false;
		return !Collections.disjoint( firstSet, secondSet );
	}

}
