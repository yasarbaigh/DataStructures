package org.yasar.ds.arrays;

import org.apache.log4j.Logger;
import org.yasar.logger.MyLogger;

/**
 * NOTE : BinarySearch can be performed only in Sorted Array
 * 
 * @author jyasar
 * 
 */
public class UnSortedArray
{
	private static final Logger logger = MyLogger.getLog4jLogger(UnSortedArray.class);

	private int[] unSortedArray;

	final public class MinMaxSubClass
	{
		final private int minValue, maxValue;

		public MinMaxSubClass(int min, int max)
		{
			minValue = min;
			maxValue = max;
		}
		
		public int getMinValue()
		{
			return minValue;
		}

		public int getMaxValue()
		{
			return maxValue;
		}		
	}

	public UnSortedArray(int[] sharePrices)
	{
		if(sharePrices == null || sharePrices.length < 1) {
			throw new RuntimeException("Create Array of min of 2 elements.");
		}
		this.unSortedArray = sharePrices;
	}	

	/**
	 * 
	 * In Un-Sorted Array, max and min elements can be located anywhere so,
	 * 
	 * One algorithm, which finds both min & max elements in 3n/2 +1 comparisons.
	 * 
	 * http://stackoverflow.com/a/1183989
	 * 
	 * 
	 * @param unSortedArray
	 * @return
	 */
	public MinMaxSubClass getMinMaxinOrderofn()
	{		
		int minIndex = 0, maxIndex = 0, index = 0;
		
		if(unSortedArray.length%2 == 0)
		{
			minIndex = maxIndex = 0;
			index = 2;
			
			if (unSortedArray[0] < unSortedArray[1] ) //one comparison
			{			       
				maxIndex = 1;
			}
			else
			{
				minIndex = 1;
			}
		}
		else
		{
			minIndex = maxIndex = 0;
			index = 1;			
		}
		
		int big, small;
		for (int i = index; i < unSortedArray.length-1; i+= 2) 
		{			
			if(unSortedArray[i] < unSortedArray[i+1]) 			//one comparison
			{
				small = i;
				big = i+1;
			}
			else
			{
				big = i;
				small = i+1;
			}
			
			if(unSortedArray[minIndex] > unSortedArray[small])	//one comparison
			{
				minIndex = small;
			}
			
			if(unSortedArray[maxIndex] < unSortedArray[big])	//one comparison
			{
				maxIndex = big;
			}
		}
		return new MinMaxSubClass(unSortedArray[minIndex], unSortedArray[maxIndex]);
	}

	
	
}