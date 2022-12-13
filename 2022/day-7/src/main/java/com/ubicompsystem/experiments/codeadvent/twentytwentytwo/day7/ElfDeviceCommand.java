package com.ubicompsystem.experiments.codeadvent.twentytwentytwo.day7;

public interface ElfDeviceCommand {
	public boolean handles( String line );
	public boolean executeOn( String line, ElfDevice device );
}
