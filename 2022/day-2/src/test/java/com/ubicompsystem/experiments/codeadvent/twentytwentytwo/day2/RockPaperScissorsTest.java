package com.ubicompsystem.experiments.codeadvent.twentytwentytwo.day2;

import static org.junit.Assert.*;
import static com.ubicompsystem.experiments.codeadvent.twentytwentytwo.day2.RockPaperScissors.*;
import org.junit.Test;

public class RockPaperScissorsTest {

    @Test
    public void translateTest(){
        System.out.println( "Translate RockPaperScissors Test" );
        translationTest( "A", ROCK );
        translationTest( "X", ROCK );
        translationTest( "B", PAPER );
        translationTest( "Y", PAPER );
        translationTest( "C", SCISSORS );
        translationTest( "Z", SCISSORS );
    }

    public void translationTest( String str, RockPaperScissors expected ){
        RockPaperScissors result = translate(str);
        System.out.println( str + " -> " + result.name() );
        assertEquals( "Should translate " + str + " to " + expected.name(), expected, result );
    }
}
