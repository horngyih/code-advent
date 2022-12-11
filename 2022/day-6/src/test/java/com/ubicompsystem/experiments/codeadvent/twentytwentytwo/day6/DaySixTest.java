package com.ubicompsystem.experiments.codeadvent.twentytwentytwo.day6;

import org.junit.Test;

import com.ubicompsystem.experiments.codeadvent.twentytwentytwo.day6.*;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class DaySixTest {

	@Test
	public void defaultTest() throws Exception {
		System.out.println( "==== Day 6 : Tuning Trouble ====\n" );

		String input = input();
		WindowSpliterator.windowed(Arrays.asList(input.split("")), 4)
			.map(Packet::new)
			.filter(packet->packet.packetChars.size()==4)
			.findFirst()
		.ifPresent(System.out::println);

		System.out.println( "\n==== END Day 6 : Tuning Trouble ====\n" );
	}

	public String input() throws Exception {
		InputStream resourceStream = this.getClass().getClassLoader().getResourceAsStream("input.txt");
		if( resourceStream != null ){
			StringBuffer buffer = new StringBuffer();
			try( InputStreamReader isr = new InputStreamReader(resourceStream); BufferedReader br = new BufferedReader(isr); ){
				while(br.ready()) {
					buffer.append(br.readLine());
				}
			}
			return buffer.toString();
		}
		throw new Exception( "No Input" );
	}
}

