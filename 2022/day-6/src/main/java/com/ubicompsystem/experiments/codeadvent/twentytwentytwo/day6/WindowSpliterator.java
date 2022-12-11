package com.ubicompsystem.experiments.codeadvent.twentytwentytwo.day6;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class WindowSpliterator implements Spliterator<String> {
	private final Queue<String> buffer;
	private final Iterator<String> sourceIterator;

	private final int windowSize;
	private final int size;

	private int currentIndex;

	public static Stream<String> windowed( Collection<String> source, int windowSize ){
		return StreamSupport.stream(new WindowSpliterator(source, windowSize), false);
	}

	private WindowSpliterator( Collection<String> source, int window ){
		this.buffer = new ArrayDeque<String>();
		this.sourceIterator = Objects.requireNonNull(source).iterator();
		this.windowSize = window;
		this.size = calculateSize(source, window);
		this.currentIndex = -1;
	}

	@Override
	public boolean tryAdvance( Consumer<? super String> action ){
		if( windowSize < 1 ) return false;

		while( sourceIterator.hasNext() ){
			currentIndex++;
			buffer.add(sourceIterator.next());
			if( buffer.size() == windowSize ){
				String window = currentIndex + "," + buffer.stream().collect(Collectors.joining());
				action.accept(window);
				buffer.poll();
				return true;
			}
		}

		return false;
	}

	@Override
	public Spliterator<String> trySplit() {
		return null;
	}

	@Override
	public long estimateSize() {
		return size;
	}

	@Override
	public int characteristics() {
		return ORDERED | NONNULL | SIZED;
	}


	private static int calculateSize(Collection<?> source, int windowSize ){
		return source.size() < windowSize ? 0 : source.size() - windowSize + 1;
	}
}
