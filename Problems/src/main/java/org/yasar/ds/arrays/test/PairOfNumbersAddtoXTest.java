package org.yasar.ds.arrays.test;

import org.junit.Test;
import org.yasar.ds.arrays.PairOfNumberAddtoX;

public class PairOfNumbersAddtoXTest
{
	@Test
	public void test1()
	{
		PairOfNumberAddtoX.pairsOfNumbersWithSameSum(new int[]{1,2,4,5,8,15,18,22}, 20);
		//fails for unsorted array
		PairOfNumberAddtoX.pairsOfNumbersWithSameSum(new int[]{0,1,2,3,4,5,6,7,8,9}, 7);
		PairOfNumberAddtoX.pairsOfNumbersWithSameSum(new int[]{0, 1, 2, 3, 4, 5, 7}, 5);
	}
	
	@Test
	public void test2()
	{
		PairOfNumberAddtoX.findPairOfSumBruteForce(new int[]{22,1,5,8,4,15,2,18}, 20);
		//fails for unsorted array
		PairOfNumberAddtoX.findPairOfSumBruteForce(new int[]{9,3,6,0,4,5,1,7,8,2}, 7);
		PairOfNumberAddtoX.findPairOfSumBruteForce(new int[]{1, 7, 2, 5, 3, 4, 0}, 5);
	}

}
