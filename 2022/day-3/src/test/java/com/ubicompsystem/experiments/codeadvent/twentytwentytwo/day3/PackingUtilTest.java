package com.ubicompsystem.experiments.codeadvent.twentytwentytwo.day3;

import static org.junit.Assert.*;
import static com.ubicompsystem.experiments.codeadvent.twentytwentytwo.day3.PackingUtil.*;

import org.junit.Test;

public class PackingUtilTest {

    @Test
    public void defaultTest() {
        for( int i = 0; i < 26; i++ ){
            char c = (char) ((int) 'a' + i );
            System.out.println( String.format( "%c => %d", c, priority(c) ) );
            assertEquals( "Should return the expected priority for " + c, i+1, priority(c) );

            char upperC = (char) ((int) 'A' + i );
            System.out.println( String.format( "%c => %d", upperC, priority(upperC) ) );
            assertEquals( "Should return the expected priority for " + upperC, i+27, priority(upperC) );
        }
    }
}
