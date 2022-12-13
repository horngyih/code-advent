package com.ubicompsystem.experiments.codeadvent.twentytwentytwo.day7;

import java.util.List;
import java.util.ArrayList;

public class ElfDirectoryImpl extends ElfFileImpl implements ElfDirectory {

	ElfDirectory parent;
	List<ElfFile> files;

	public ElfDirectoryImpl( String filename ){
		this.name = filename;
		files = new ArrayList<>();
	}

	public ElfDirectoryImpl( String filename, ElfDirectory parent ){
		this(filename);
		this.parent = parent;
	}

	@Override
	public int getSize(){
		return (int) files.stream().mapToInt(ElfFile::getSize).sum();
	}

	@Override
	public List<ElfFile> getFiles(){
		return new ArrayList<>(this.files);
	}

	@Override
	public boolean isDirectory(){
		return true;
	}

	@Override
	public void setParent( ElfDirectory directory ){
		this.parent = directory;
	}

	@Override
	publid ElfDirectory getParent(){
		return this.parent;
	}
}

