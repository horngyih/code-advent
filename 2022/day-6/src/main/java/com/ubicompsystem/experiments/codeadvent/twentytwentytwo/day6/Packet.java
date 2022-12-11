package com.ubicompsystem.experiments.codeadvent.twentytwentytwo.day6;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Packet {
	public int indexStart;
	public String packet;
	public Set<String> packetChars;

	public Packet( String packetString ){
		String[] tokens = packetString.split(",");
		if( tokens.length < 1 ) throw new IllegalArgumentException( "Invalid packet string" );

		indexStart = Integer.parseInt(tokens[0].trim());
		packet = tokens[1];
		packetChars = new HashSet<String>( Arrays.asList(tokens[1].split("")) );
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer("{");
		buffer.append( " indexStart : " ).append( indexStart ).append(",");
		buffer.append( " packet : " ).append( packet ).append(",");
		buffer.append( " packetChars : " ).append( packetChars );
		return buffer.append( "}" ).toString();
	}
}
