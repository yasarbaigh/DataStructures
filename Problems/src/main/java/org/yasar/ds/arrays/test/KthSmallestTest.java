package org.yasar.ds.arrays.test;

import org.junit.Assert;
import org.junit.Test;
import org.yasar.ds.arrays.KthSmallestElement;

public class KthSmallestTest
{

	@Test
	public void testA()
	{
		KthSmallestElement objt;// = new KthSmallestElement(new int[]{10, 12, 11, 14, 13});
		/*System.out.println(objt.kSmallest(4, 0, 4));
		System.out.println(objt.kSmallest(0, 0, 4));
		System.out.println(objt.kSmallest(2, 0, 4));
		*/
		objt = new KthSmallestElement(new int[]{5, 6, 1, 4, 8});
		System.out.println(objt.kSmallest(5, 0, 4));
	}
	
	@Test
	public void testB()
	{
		KthSmallestElement objt = new KthSmallestElement(new int[]{77, 99, 10, 66, 11, 44, 33, 55, 22, 88});
		Assert.assertEquals(99, objt.kSmallest(9, 0, 9));
		Assert.assertEquals(10, objt.kSmallest(0, 0, 9));
		Assert.assertEquals(22, objt.kSmallest(2, 0, 5));
	}
	/*
	@Test
	public void testC()
	{
		KthSmallestElement objt = new KthSmallestElement(new int[]{77, 99, 10, 66, 11, 44, 33, 55, 22, 88});
		Assert.assertEquals(99, objt.kthIterative(9));
		
		objt = new KthSmallestElement(new int[]{77, 99, 10, 66, 11, 44, 33, 55, 22, 88});
		Assert.assertEquals(10, objt.kthIterative(0));
		
		objt = new KthSmallestElement(new int[]{77, 99, 10, 66, 11, 44, 33, 55, 22, 88});
		Assert.assertEquals(22, objt.kthIterative(2));
	}
	*/
}

