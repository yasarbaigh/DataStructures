package oy.ds.arrays;

import org.apache.log4j.Logger;

import oy.logger.MyLogger;

public class SortedCircularArray
{
	static final Logger logger = MyLogger.getLog4jLogger(SortedCircularArray.class);	
	private int[] array;

	public SortedCircularArray(int[] array)
	{
		if(array == null || array.length == 0) 
		{
			throw new RuntimeException("Empty Array");
		}
		this.array = array;
	}

	/**
	 * worst case O(n)
	 * Average case O(n)
	 * 
	 * @return
	 */
	public int minRotatedSortedArray()
	{		

		if(array.length == 1) 
		{
			logger.info("Min value: " + array[0]);
			return array[0];
		}
		else if(array[0] < array[array.length - 1]) 
		{
			logger.info("Min value: " + array[0]);
			return array[0];
		}
		else 
		{
			int i=1;
			for (; i < array.length; i++) 
			{
				if(array[i - 1] > array[i]) 
				{
					break;
				}
			}
			logger.info("Min value: " + array[i]);
			return array[i];
		}
	}
	
	/**
	 * Recursive
	 * worst case O(log n)
	 * Average case O(log n)
	 * 
	 * @return
	 */
	public int minRecurBinarySearch()
	{
		if(array.length == 1) 
		{
			logger.info("Min value: " + array[0]);
			return array[0];
		}
		else if(array[0] < array[array.length - 1]) 
		{
			logger.info("Min value: " + array[0]);
			return array[0];
		}
		else 
		{
			int minIndex = findMinIndex(0, array.length -1);	
			
			logger.info("Min value: " + array[minIndex]);
			return array[minIndex];
		}
	}	
	
	private int findMinIndex( int start, int end)
	{
	    

	    if ((end - start) == 1)
	        if(array[start] < array[end])
	        return start;
	        else
	        return end;
	    int mid = (start + end)/2;

	    if (array[mid] > array[end])
	    {
	    	return findMinIndex(mid,end);
	    }
	    else
	    {
	      return  findMinIndex(start,mid);
	    }	    
	}
	
	
	/**
	 * non-Recursive
	 * worst case O(log n)
	 * Average case O(log n)
	 * 
	 * @return
	 */
	public int minBinarySearch()
	{		
		int begin = 0, end = array.length -1, mid = end/2;
		while( (end - begin) != 1)
		{				
		    if(array[mid] > array[end])
			{					
				begin = mid;
			}
			else
			{
				end = mid;
			}
			mid = (begin + end)/2;
		}
		
		int minIndex = array[begin] < array[end] ? begin: end;
		logger.info("Min value: " + array[minIndex]);
		return array[minIndex];
		
	}
	
	

	
	// Search Key
	
	public boolean isKeyExistsRecursive(int key)
	{	    
		return findKeyExistsRecursive(0, array.length-1, key);	    	    
	}
	
	private boolean findKeyExistsRecursive(int begin, int end, int key)
	{
		if(end - begin == 1)
		{
			if(array[begin] == key || array[end] == key)
			{
				return true;
			}
			return false;
		}
		int mid = begin + (end -begin)/2;
		
		if(array[mid] < array[end])
		{
			if(array[mid]<= key && key <= array[end])
			{
				return findKeyExistsRecursive(mid, end, key);
			}
			else
			{
				return findKeyExistsRecursive(begin, mid, key);
			}
		}
		else
		{
			if(array[begin]<= key && key <= array[mid])
			{
				return findKeyExistsRecursive(begin, mid, key);
			}
			else
			{
				return findKeyExistsRecursive(mid, end, key);
			}			
		}		
	}
	
	/**
	 * 
	 * 
	 * @param key
	 * @return key location in array
	 */
	public int isKeyExistsIterative(int key)
	{
		int start = 0, end = array.length - 1, mid = 0;

		while (start <= end) 
		{
			mid = start + (end - start) / 2;

			if(array[mid] == key) {
				return mid;
			}

			if(array[mid] < array[end]) 
			{
				if(array[mid] < key && key <= array[end])
					start = mid + 1;
				else
					end = mid - 1;
			}
			else 
			{
				if(array[start] <= key && key < array[mid])
					end = mid - 1;
				else
					start = mid + 1;
			}

		}

		return -1;
	}

}
