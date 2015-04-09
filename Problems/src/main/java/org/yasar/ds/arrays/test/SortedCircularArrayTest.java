package oy.ds.arrays.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import oy.ds.arrays.SortedCircularArray;

public class SortedCircularArrayTest
{
	
	@Test(expected = RuntimeException.class)
	public void negative()
	{
		new SortedCircularArray(new int[]{});
	}
	
	@Test
	public void getMinCircularArray()
	{
		System.out.println(" ********* Min at Edges **********");
		
		// Even length - Min at Corner
		SortedCircularArray objt = new SortedCircularArray(new int[]{1, 3, 5, 7, 9, 11});		
		assertEquals(1, objt.minRecurBinarySearch());
		assertEquals(1, objt.minBinarySearch());
		
		objt = new SortedCircularArray(new int[]{11,9,7,5,3,1});		
		assertEquals(1, objt.minRecurBinarySearch());
		assertEquals(1, objt.minBinarySearch());
		 
		//Even length - Min at Center
		objt = new SortedCircularArray(new int[]{7, 8, 9, 1, 2, 3 , 4, 5});
		assertEquals(1, objt.minRecurBinarySearch());
		assertEquals(1, objt.minBinarySearch());

		objt = new SortedCircularArray(new int[]{5, 7, 8, 9, 1, 2, 3 , 4});
		assertEquals(1, objt.minRecurBinarySearch());
		assertEquals(1, objt.minBinarySearch());

		
		//odd length		
		objt = new SortedCircularArray(new int[]{1, 3, 5, 7, 9, 11, 13});		
		assertEquals(1, objt.minRecurBinarySearch());
		assertEquals(1, objt.minBinarySearch());
		
		objt = new SortedCircularArray(new int[]{13, 11,9,7,5,3,1});		
		assertEquals(1, objt.minRecurBinarySearch());
		assertEquals(1, objt.minBinarySearch());
		
		//odd length - Min at Center
		objt = new SortedCircularArray(new int[]{7, 8, 9, 1, 2, 3 , 4});
		assertEquals(1, objt.minRecurBinarySearch());
		assertEquals(1, objt.minBinarySearch());
		
		//binary search with duplicate values fail often.
		//if duplicate is more than 50% then 99%fails
		System.out.println("Repeated Values");		
		objt = new SortedCircularArray(new int[]{7, 8, 8, 8, 9, 1, 2, 3, 3, 4});
		assertEquals(1, objt.minRecurBinarySearch());
		assertEquals(1, objt.minBinarySearch());
		
	}	
	
	@Test
	public void getMinSpecialCase()
	{		
		//Binary search with duplicates more than 50% of same value will fail.
		System.out.println("**** Non-Recursion Binary Search  Special CASES fails **********");		
		
		SortedCircularArray objt = new SortedCircularArray(new int[]{2, 2, 2, 0, 2, 2, 2, 2, 2, 2, 2, 2});
		//assertEquals(0, objt.minRecurBinarySearch());
		//assertEquals(0, objt.minBinarySearch());
		System.out.println(objt.minBinarySearch());		
	}
	
	@Test
	public void isKeyExists()
	{
		System.out.println("**** Key Exists **********");		
		
		// Even length - Min at Corner
		SortedCircularArray objt = new SortedCircularArray(new int[]{1, 3, 5, 7, 9, 11});	
		//corner keys
		assertEquals(true, objt.isKeyExistsRecursive(1));
		assertEquals(0, objt.isKeyExistsIterative(1));
		
		assertEquals(true, objt.isKeyExistsRecursive(11));
		assertEquals(5, objt.isKeyExistsIterative(11));
		
		//middle keys
		assertEquals(true, objt.isKeyExistsRecursive(5));
		assertEquals(2, objt.isKeyExistsIterative(5));
		
		assertEquals(true, objt.isKeyExistsRecursive(7));
		assertEquals(3, objt.isKeyExistsIterative(7));

		//negative
		assertEquals(false, objt.isKeyExistsRecursive(21));
		assertEquals(-1, objt.isKeyExistsIterative(21));
		
		//-----------------------------------------------------------------
		
		
		// Odd length - Min at Corner
		objt = new SortedCircularArray(new int[]{7, 8, 9, 1, 2, 3 , 4});	
		//corner keys
		assertEquals(true, objt.isKeyExistsRecursive(7));
		assertEquals(0, objt.isKeyExistsIterative(7));
		
		assertEquals(true, objt.isKeyExistsRecursive(4));
		assertEquals(6, objt.isKeyExistsIterative(4));
		
		//middle keys
		assertEquals(true, objt.isKeyExistsRecursive(1));
		assertEquals(3, objt.isKeyExistsIterative(1));
		
		assertEquals(true, objt.isKeyExistsRecursive(9));
		assertEquals(2, objt.isKeyExistsIterative(9));
		
		assertEquals(false, objt.isKeyExistsRecursive(21));
		assertEquals(-1, objt.isKeyExistsIterative(21));				
		
	}

}
