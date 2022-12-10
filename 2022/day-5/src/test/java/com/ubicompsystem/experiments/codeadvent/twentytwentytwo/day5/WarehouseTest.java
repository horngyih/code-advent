package com.ubicompsystem.experiments.codeadvent.twentytwentytwo.day5;

import static org.junit.Assert.*;

import com.ubicompsystem.experiments.codeadvent.twentytwentytwo.day5.Warehouse;
import org.junit.Test;

public class WarehouseTest {

	@Test
	public void defaultTest(){
		Warehouse warehouse = new Warehouse();

		String stackOne = "a,b,c";
		String stackTwo = "d";
		String stackThree = "e,f";

		warehouse.addStack( stackOne );
		warehouse.addStack( stackTwo );
		warehouse.addStack( stackThree);

		System.out.printf( "Warehouse : \n%s\n", warehouse );
		System.out.printf( "Warehouse stacks count = %s\n", warehouse.stackCount() );
		assertEquals( "Should have the expected stack", 3, warehouse.stackCount() );

		System.out.println( "Move 2 from 1 to 2" );
		warehouse.move(1,2,2);
		System.out.printf( "Warehouse : \n%s\n", warehouse );
		assertEquals( "Should have the expected first stack", "[a]", warehouse.getStack(1).get().toString() ); 
		assertEquals( "Should have the expected second stack", "[d, c, b]", warehouse.getStack(2).get().toString() );
		assertEquals( "Should have the expected third stack", "[e, f]", warehouse.getStack(3).get().toString() );

		System.out.println( "Move 1 from 2 to 3" );
		warehouse.move(2,3,1);
		System.out.printf("Warehouse : \n%s\n", warehouse);
		assertEquals( "Should have the expected first stack", "[a]", warehouse.getStack(1).get().toString() );
		assertEquals( "Should have the expected second stack", "[d, c]", warehouse.getStack(2).get().toString() );
		assertEquals( "Should have the expected third stack", "[e, f, b]", warehouse.getStack(3).get().toString() );

	}
}
