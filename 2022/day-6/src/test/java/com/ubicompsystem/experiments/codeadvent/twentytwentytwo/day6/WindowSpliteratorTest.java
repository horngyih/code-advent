package com.ubicompsystem.experiments.codeadvent.twentytwentytwo.day6;

import org.junit.Test;

import java.util.*;
import java.util.stream.*;

public class WindowSpliteratorTest {

	@Test
	public void defaultTest(){
		String testPacketStream = "ABCSSESCEECE";

		System.out.println( testPacketStream );
		WindowSpliterator.windowed( Arrays.asList( testPacketStream.split("") ), 4 ).map(Packet::new).forEach(System.out::println);

	}
}

