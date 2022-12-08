package com.ubicompsystem.experiments.codeadvent.twentytwentytwo.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PackingUtil {

    public static int priority( char c ){
        int charValue = (int) c;
        if( charValue >= 65 && charValue <= 90 ){
            return charValue - 38;
        } else if( charValue >= 97 && charValue <= 122 ){
            return charValue - 96;
        }
        return 0;
    }
    public static Set<String> overlap( String str1, String str2 ){
        if( str1 != null && str2 != null ){
            Set<String> stringSet1 = new HashSet<>( Arrays.asList(str1.split("")) );
            Set<String> stringSet2 = new HashSet<>( Arrays.asList(str2.split("")) );
            stringSet1.retainAll(stringSet2);
            return stringSet1;
        }
        return null;
    }

    public static Set<String> overlaps( List<String[]> sets ){
        if(sets == null) return new HashSet<>();
        sets = new ArrayList<>(sets);
        if(sets.size() == 1 ) return asSet(sets.get(0));
        Set<String> base = asSet(sets.get(0));
        for( int i = 1; i < sets.size(); i++ ){
            base.retainAll(asSet(sets.get(i)));
        }
        return base;
    }

    public static Set<String> asSet( String[] strArray ){
        if( strArray == null ) return new HashSet<>();
        return new HashSet<String>(Arrays.asList(strArray));
    }
}
