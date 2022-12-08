package com.ubicompsystem.experiments.codeadvent.twentytwentytwo.day2;

import static org.junit.Assert.*;
import static com.ubicompsystem.experiments.codeadvent.twentytwentytwo.day2.RockPaperScissors.*;
import org.junit.Test;

public class RockPaperScissorsTest {

    @Test
    public void translateTest(){
        System.out.println( "==== Translate RockPaperScissors Test ====\n" );
        translationTest( "A", ROCK );
        translationTest( "X", ROCK );
        translationTest( "B", PAPER );
        translationTest( "Y", PAPER );
        translationTest( "C", SCISSORS );
        translationTest( "Z", SCISSORS );

        System.out.println( "\n==== END Translate RockPaperScissors Test ====\n" );
    }

    @Test
    public void matchTest() {
        System.out.println( "===== Match RockPaperScissors Test ====\n" );
        matchTest( ROCK, PAPER, 0 );
        matchTest( ROCK, ROCK, 3 );
        matchTest( ROCK, SCISSORS, 6 );

        matchTest( PAPER, SCISSORS, 0 );
        matchTest( PAPER, PAPER, 3 );
        matchTest( PAPER, ROCK, 6 );

        matchTest( SCISSORS, ROCK, 0 );
        matchTest( SCISSORS, SCISSORS, 3 );
        matchTest( SCISSORS, PAPER, 6 );
        System.out.println( "\n==== END Match RockPaperScissors Test ====\n" );
    }

    public void matchTest( RockPaperScissors play1, RockPaperScissors play2, int expected ){
        assertNotNull( "Should have a non-null play1", play1 );
        assertNotNull( "Should have a non-null play2", play2 );

        int matchScore = play1.match(play2);
        System.out.println( String.format( "%s vs %s = %d", play1.name(), play2.name(), matchScore  ) );
        assertEquals( "Should have the expected match outcome", matchScore, expected );
    }

    public void translationTest( String str, RockPaperScissors expected ){
        RockPaperScissors result = translate(str);
        System.out.println( str + " -> " + result.name() );
        assertEquals( "Should translate " + str + " to " + expected.name(), expected, result );
    }
}
