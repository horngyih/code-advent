package com.ubicompsystem.experiments.codeadvent.twentytwentytwo.day2;

import static com.ubicompsystem.experiments.codeadvent.twentytwentytwo.day2.RockPaperScissors.*;

import org.junit.*;

import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;


public class DayTwoTest {

    boolean verbose = System.getProperty("verbose")!=null;

    @Test
    public void defaultTest() throws Exception {
        System.out.println( "Day Two : Rock Paper Scissors" );

        List<String> matchLines = inputLines();
        System.out.println( "Play Strategy:\n" );

        int matchFinalScore = matchLines.stream()
            .map(this::parseMatches)
            .mapToInt(play->match(play[1], play[0]))
        .sum();
        System.out.println( "Match final score : " + matchFinalScore );
    }

    public int match( RockPaperScissors play, RockPaperScissors opponent ){
        if( play == null || opponent == null ) return -1;

        int finalScore = play.match(opponent) + play.score;
        if( verbose ){
            System.out.println( String.format( "%s vs %s = %d", play.name(), opponent.name(), finalScore ) );
        }

        return finalScore;
    }

    public RockPaperScissors[] parseMatches( String line ){
        String[] tokens = line.split(" ");
        if( tokens.length > 1 ){
            RockPaperScissors play = RockPaperScissors.translate(tokens[0]);
            RockPaperScissors strategy = RockPaperScissors.translateStrategy(play, tokens[1]);
            return new RockPaperScissors[]{ play, strategy };
        } else {
            System.out.println( String.format( "Invalid line %s - not enough parameters", line ) );
            return null;
        }
    }

    public String reportMatch( RockPaperScissors[] match ){
        if( match == null || match.length < 2 ) return "Invalid Match";
        return String.format( "%s vs %s = %d", match[0].name(), match[1].name(), match[1].match(match[0]) );
    }

    public List<String> inputLines() throws Exception {
        InputStream resourceStream = this.getClass().getClassLoader().getResourceAsStream( "input.txt" );
        if( resourceStream != null ){
            List<String> result = new ArrayList<>();
            try( InputStreamReader isr = new InputStreamReader(resourceStream) ){
                try( BufferedReader br = new BufferedReader( isr ) ){
                    while( br.ready() ){
                        result.add(br.readLine().trim());
                    }
                }
            }
            return result;
        }
        throw new Exception( "No Input" );
    }
}
