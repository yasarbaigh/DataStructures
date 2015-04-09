package org.yasar.ds.arrays.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.yasar.ds.arrays.MinJumps;

public class MinJumpsTest
{
	@Test
	public void testA()
	{
		int hops = MinJumps.minJumps(new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9});		
		assertEquals(3, hops); //1-3-9
		
		hops = MinJumps.minJumps(new int[]{1, 3, 6, 3, 2, 3, 6, 8, 9, 5});		
		assertEquals(4, hops); //1-3-6-9
		
		hops = MinJumps.minJumps(new int[]{1, 3, 6, 1, 0, 9});		
		assertEquals(3, hops); //1-3-6
		
		hops = MinJumps.minJumps(new int[]{10,1,1,1,1,1});		
		assertEquals(1, hops); //10
		
		hops = MinJumps.minJumps(new int[]{1,1,1,1,1,1});		
		assertEquals(5, hops); //1,1,1,1,1,1
		
		hops = MinJumps.minJumps(new int[]{2, 5, 10, 1, 1, 3, 0, 0, 2, 5, 1, 1, 1, 2, 0, 1, 1});		
		assertEquals(5, hops); //1-3-9
		
	}

}
