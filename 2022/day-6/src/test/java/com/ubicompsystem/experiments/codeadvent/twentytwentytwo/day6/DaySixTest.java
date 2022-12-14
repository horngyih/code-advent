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

		final int windowSize = 4;
		System.out.printf( "Marker Packet size = %d\n", windowSize);
		String input = input();
		WindowSpliterator.windowed(Arrays.asList(input.split("")), windowSize)
			.map(Packet::new)
			.filter(packet->packet.packetChars.size()==windowSize)
			.findFirst()
		.ifPresent(System.out::println);

		final int newWindowSize = 14;
		System.out.printf( "Marker Packet size = %d\n", newWindowSize);
		WindowSpliterator.windowed(Arrays.asList(input.split("")), newWindowSize)
			.map(Packet::new)
			.filter(packet->packet.packetChars.size()==newWindowSize)
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

