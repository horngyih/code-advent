package com.ubicompsystem.experiments.codeadvent.twentytwentytwo.day7;

public class ElfFileImpl implements ElfFile {
	int size;
	String name;

	public ElfFileImpl() {}

	public ElfFileImpl( String filename, int size ){
		this.size = size;
		this.name = filename;
	}

	@Override
	public int getSize(){
		return this.size;
	}

	@Override
	public String getName(){
		return this.name;
	}

	@Override
	public boolean isDirectory(){
		return false;
	}
}
