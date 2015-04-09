package org.yasar.ds.arrays.test;

import org.junit.Test;
import org.yasar.ds.arrays.FindMaxIncrDecrArray;

public class FindMaxIncrDecrArrayTest
{
	@Test
	public void getMinCircularArray()
	{
		System.out.println(" ********* Max at Edges **********");
		FindMaxIncrDecrArray objt = new FindMaxIncrDecrArray(new int[]{1,3,5,6,89,99,11});
		objt.getMaxBinarySearch();
		
		objt = new FindMaxIncrDecrArray(new int[]{1,333,55,46,19,9,5});
		objt.getMaxBinarySearch();		
		
		System.out.println(" ********* Max at Middle **********");
		//even mid
		objt = new FindMaxIncrDecrArray(new int[]{1,5,7,4,3});
		objt.getMaxBinarySearch();
		
		//odd mid
		objt = new FindMaxIncrDecrArray(new int[]{1,5,7,4,3,2});
		objt.getMaxBinarySearch();
		
		//odd mid
		objt = new FindMaxIncrDecrArray(new int[]{1,5,3});
		objt.getMaxBinarySearch();
	}

}
