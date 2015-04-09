package oy.ds.arrays;

import org.apache.log4j.Logger;

import oy.logger.MyLogger;

/**
 * Find max value of an array which increases first then decreases
 * http://www.geeksforgeeks.org/find-the-maximum-element-in-an-array-which-is-first-increasing-and-then-decreasing/
 * 
 * @author jyasar
 *
 */
public class FindMaxIncrDecrArray
{
	static final Logger logger = MyLogger.getLog4jLogger(FindMaxIncrDecrArray.class);	
	private int[] incrDecrArray;

	public FindMaxIncrDecrArray(int[] array)
	{
		this.incrDecrArray = array;
	}

	/**
	 * worst case O(n)
	 * Average case O(n)
	 * 
	 * @return
	 */
	public int getMaxBinarySearch()
	{
		if(incrDecrArray == null || incrDecrArray.length == 0) 
		{
			throw new RuntimeException("Empty Array");
		}

		if(incrDecrArray.length == 1) 
		{
			logger.info("Max value: " + incrDecrArray[0]);
			return incrDecrArray[0];
		}		
		else 
		{
			int begin =0, end = incrDecrArray.length -1, mid = end/2, maxIndex = -1;
			while( begin < end)
			{
				
			    if((incrDecrArray[mid] > incrDecrArray[mid+1]) && (incrDecrArray[mid] > incrDecrArray[mid-1])) 
				{	
			    	maxIndex = mid;
			    	break;
				}
			    else if((incrDecrArray[mid-1] < incrDecrArray[mid]) && (incrDecrArray[mid] < incrDecrArray[mid+1]))
			    {		
			    	begin = mid+1;			    	
				}
				else
				{
					end = mid-1;
				}				
				mid = (begin + end)/2;
			}
				
			logger.info("Max value: " + incrDecrArray[maxIndex]);
			return incrDecrArray[maxIndex];
		}
	}
	

}
