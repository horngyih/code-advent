package com.ubicompsystem.experiments.codeadvent.twentytwentytwo.day5;

import static java.lang.Integer.parseInt;
import static org.junit.Assert.*;

import com.ubicompsystem.experiments.codeadvent.twentytwentytwo.day5.Warehouse;
import java.lang.reflect.Array;
import java.io.*;
import java.util.*;
import java.util.stream.*;

import org.junit.Test;

public class DayFiveTest {
	boolean verbose = System.getProperty("verbose")!=null;

	@Test
	public void defaultTest() throws Exception {
		System.out.println( "==== Day 5 : Supply Stacks ====\n" );

		List<String> inputLines = inputLines();

		Warehouse crateMover9000 = prepareWarehouse(inputLines);
		System.out.println( crateMover9000 );
		executeCommands(crateMover9000, inputLines);

		System.out.printf( "CrateMover 9000 : Stack tops : %s\n", getStackTops(crateMover9000) );

		Warehouse crateMover9001 = prepareWarehouse(inputLines);
		crateMover9001.setMoveInStacks(true);
		executeCommands(crateMover9001, inputLines);

		System.out.printf( "CrateMover 9001 : Stack tops : %s\n", getStackTops(crateMover9001) );

		System.out.println( "\n==== END Day 5 : Supply Stacks ====" );
	}

	protected String getStackTops( Warehouse warehouse ){
		if( warehouse == null ) return "";
		List<String> stackTops = new ArrayList<>();
		for( int i = 1; i <= warehouse.stackCount(); i++ ){
			stackTops.add( warehouse.getStack(i).get().peek() );
		}
		return stackTops.stream().collect(Collectors.joining());
	}

	protected List<String> inputLines() throws Exception {
		InputStream resourceStream = this.getClass().getClassLoader().getResourceAsStream("input-modified.txt");
		if( resourceStream != null ){
			try( InputStreamReader isr = new InputStreamReader(resourceStream); BufferedReader br = new BufferedReader(isr) ){
				List<String> inputLines = new ArrayList<>();
				while(br.ready()){
					inputLines.add(br.readLine().trim());
				}
				return inputLines;
			}
		}
		throw new Exception( "No Input" );
	}

	protected Warehouse prepareWarehouse(List<String> input ){
		Warehouse warehouse = new Warehouse();
		for( String line : input ){
			if( line.startsWith( "==" ) ){
				break;
			}
			String[] tokens = line.split(":");
			if( tokens.length >= 1 ){
				warehouse.addStack(tokens[1]);
			}
		}
		return warehouse;
	}

	protected void executeCommands( Warehouse warehouse, List<String> input ){
		if( warehouse == null || input == null || input.isEmpty() ) return;

		boolean startExecution = false;
		for( String line : input ){
			if( !startExecution ){
				if( line.startsWith("==") ){
					startExecution = true;
				}
				continue;
			}
			String[] pnemonic = line.replaceAll("move", "").replaceAll( "from|to", "," ).split(","); 
			warehouse.move( parseInt(pnemonic[1].trim()), parseInt(pnemonic[2].trim()), parseInt(pnemonic[0].trim()));
			if( verbose ) {
				System.out.println( "Command : " + line );
				System.out.printf( "Warehouse : \n%s\n", warehouse );
			}
		}

	}
}

