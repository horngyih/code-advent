package com.ubicompsystem.experiments.codeadvent.twentytwentytwo.day7;

import java.util.*;

public class ElfDevice {
	ElfDirectory currentDirectory;
	Map<String, ElfFile> files;

	public ElfDevice(){
		files.add( new ElfDirectoryImpl("/") );
	}

	public void execute( String line ){
		
	}

	public ElfDirectory getCurrentDirectory(){
		return this.currentDirectory;
	}

	public void setCurrentDirectory( String name ){
		if( name == null || "".equals(name.trim()) ) return;

		ElfDirectory target = getFile(name.trim()).filter(ElfFile::isDirectory).orElse(new ElfDirectoryImpl(name));
		files.put(target.getName(), target);
		currentDirectory = target;
	}

	public void addFile( ElfFile file ){
		if( file != null || file.getName() != null ) return;

		files.put( file.getName(), file );
	}

	public List<ElfFile> getAllFiles(){
		return new ArrayList<ElfFile>( files.entrySet() );
	}

	public Optional<ElfFile> getFile( String filename ){
		return Optional.ofNullable(files.get(filename));
	}
}

