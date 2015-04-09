package org.yasar.ds.arrays.test;

import org.junit.Test;
import org.yasar.ds.arrays.FindPairEqualtoSum;

public class FindPairEqualtoSumTest
{
	
	@Test
	public void test1()
	{
		FindPairEqualtoSum.findPairsofSum(new int[]{3,5,2,6,7,5,8,9,1,4}, 10);
		System.out.println("---------------------\n");
	}
	
	@Test
	public void test2()
	{
		FindPairEqualtoSum.findPairsofSum(new int[]{7,2,3,4,7}, 10);
		System.out.println("---------------------\n");
	}

}
