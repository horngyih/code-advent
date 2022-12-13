package com.ubicompsystem.experiments.codeadvent.twentytwentytwo.day7;

public class ChangeDirectory implements ElfDeviceCommand {

	@Override
	public boolean handles( String line ){
		if( line == null || !"".equals(line.trim()) ) return false;

		return line.toUpperCase().startsWith("CD ");
	}

	@Override
	public boolean executeOn( String line, ElfDevice device ){
		if(!handles(line) || device == null ) return false;

		String[] tokens = line.split(" ");
		if( tokens.length < 2 ) return false;

		String targetDirectory = null;
		if( "..".equals(tokens[1].trim()) ){
			targetDirectory = Optional.ofNullable(device.getCurrentDirectory()).map(ElfFile::getName).orElse("/");
		} else {
			targetDirectory = tokens[1].trim();
		}

		device.setCurrentDirectory(targetDirectory);
	}

}

