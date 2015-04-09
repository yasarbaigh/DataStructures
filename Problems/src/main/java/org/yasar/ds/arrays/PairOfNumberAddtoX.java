package oy.ds.arrays;

import org.apache.log4j.Logger;

import oy.ds.bits.BitsAndBytes;
import oy.logger.MyLogger;

public class PairOfNumberAddtoX
{
	
	static final Logger logger = MyLogger.getLog4jLogger(BitsAndBytes.class);
	
	/**
	 * 
	 * A sorted array should be given, from which pairs of numbers which should have sumToMatch should be found
	 * at order of O(n)
	 * 
	 * Examples:
	 * <pre><blockquote>
     * A sorted array a[] find the pairs of number that add up to x.
     * For eg: a[]={1,2,4,5,8,15,18,22} x=20
     * Output: (2,18) , (5,15)
     * </pre></blockquote>
	 * 
	 * @param sortedArray
	 * @param sumToMatch
	 * 
	 */
	public static void pairsOfNumbersWithSameSum(int[] sortedArray, int sumToMatch)
	{
		if(null == sortedArray || sortedArray.length<2)
		{
			logger.error("Array is in Lesser Size");
		}
		int i = 0, j = sortedArray.length -1, temp;
		
		while(i<j)
		{
			temp = sortedArray[i] + sortedArray[j];
			if(temp < sumToMatch)
			{
				i++;
				
			}
			else if(temp> sumToMatch)
			{
				j--;
			}
			else // temp & sumToMatch are same
			{
				logger.info("{"+ sortedArray[i] + ", " + sortedArray[j] + "}");
				i++;
				j--;				
			}			
		}
		logger.info(MyLogger.END_OF_MESSAGE);
	}
	
	
	/**
	 * 
	 * Array (sorted| unsorted) should be given, from which pairs of numbers which should have sumToMatch should be found
	 * at order of O(n^2)
	 * 
	 * Examples:
	 * <pre><blockquote>
     * A sorted array a[] find the pairs of number that add up to x.
     * For eg: a[]={1,2,4,5,8,15,18,22} x=20
     * Output: (2,18) , (5,15)
     * </pre></blockquote>
	 * 
	 * @param sortedArray
	 * @param sumToMatch
	 * 
	 */
	public static void findPairOfSumBruteForce(int[] arrayOfNum, int sumToMatch)
	{
		int arraySize = arrayOfNum.length;
		for (int i = 0; i < arraySize; i++)
		{
		    for (int j = i; j < arraySize; j++)
		    {
		      if (arrayOfNum[i] + arrayOfNum[j] == sumToMatch)
		      logger.info("{" + arrayOfNum[i] + ", " + arrayOfNum[j] + "}");
		    }
	  }
		logger.info(MyLogger.END_OF_MESSAGE);
	} 
}
