package com.ubicompsystem.experiments.codeadvent.twentytwentytwo.day5;

import java.util.*;
import java.util.stream.*;

public class Warehouse {
	List<Stack<String>> crateStacks = new ArrayList<>();
	boolean moveInStacks = false;

	public boolean move( int sourceStack, int targetStack, int numOfCrates ){
		Collection<String> moveQueue = (moveInStacks)? new Stack<String>():new LinkedList<String>();
		getStack(sourceStack).ifPresent(stack->{
			for( int i = 0; i < numOfCrates; i++ ){
				if(!stack.isEmpty()){
					String crate = stack.pop();
					if(moveQueue instanceof LinkedList ){
						((LinkedList) moveQueue).add(crate);
					} else if( moveQueue instanceof Stack ){
						((Stack) moveQueue).push(crate);
					}
				} else {
					break;
				}
			}
		});
		

		int moveQueueSize = moveQueue.size();
		getStack(targetStack).ifPresent(stack->{
			while(!moveQueue.isEmpty()){
				if(moveQueue instanceof LinkedList ){
					stack.push((String)((LinkedList)moveQueue).poll());
				} else if( moveQueue instanceof Stack ) {
					stack.push((String)((Stack)moveQueue).pop());
				}
			}
		});

		return moveQueueSize - moveQueue.size() > 0;
	}

	public void setMoveInStacks( boolean flag ){
		this.moveInStacks = flag;
	}

	public List<Stack<String>> getCrateStacks(){
		return crateStacks;
	}

	public Optional<Stack<String>> getStack( int i ){
		if( i < 1 || i > crateStacks.size() ) return Optional.empty();
		return Optional.of(crateStacks.get(i-1));
	}

	public void addStack( Stack<String> stack ){
		crateStacks.add(stack);
	}

	public void addStack( String stackString ){
		if( stackString != null && !"".equals(stackString.trim()) ){
			String[] crates = stackString.split(",");
			Stack<String> crateStack = new Stack<>();
			for( String crate : crates ) {
				crateStack.push(crate.trim());
			}
			addStack(crateStack);
		}
	}

	public int stackCount(){
		return crateStacks.size();
	}

	public String toString(){
		final StringBuffer buffer = new StringBuffer("");
		for( int i = 0; i < crateStacks.size(); i++ ){
			buffer.append( i+1 ).append( ":" );
			buffer.append(crateStacks.get(i));
			buffer.append("\n");
		}
		return buffer.toString();
	}
}
