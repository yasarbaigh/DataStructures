package oy.ds.arrays.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import oy.ds.arrays.UnSortedArray;
import oy.ds.arrays.UnSortedArray.MinMaxSubClass;

public class UnSortedArrayTest
{
	@Test
	public void test3Nby2Comparison()
	{
		int[] array = new int[]{10,9,5,4,11,100,120,110};
		UnSortedArray arrayObjt = new UnSortedArray(array);
		MinMaxSubClass result = arrayObjt.getMinMaxinOrderofn();
		assertEquals(result.getMaxValue(), 120);
		assertEquals(result.getMinValue(), 4);
	}
	
	@Test
	public void testKthIndex()
	{
		int[] array = new int[]{10,9,5,4,11,100,120,110};
		UnSortedArray arrayObjt = new UnSortedArray(array);
		//assertEquals(110, arrayObjt.getKLargestIndex(2));
		
		int[] array1 = new int[]{10,76,9,500,4,11,4,9,10,22,76,23,11,100,120,3,110};
		arrayObjt = new UnSortedArray(array1);
		//assertEquals(76, arrayObjt.getKLargestIndex(5));
	}		
}

