package com.ubicompsystem.experiments.codeadvent.twentytwentytwo.day7;

import java.util.List;

public interface ElfDirectory extends ElfFile {
	void setParent( ElfDirectory directory );
	ElfDirectory getParent();
	void addFile( EflFile file );
	List<ElfFile> getFiles();
}
