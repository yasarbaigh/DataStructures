package oy.ds.arrays;

/**
 * http://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/
 * 
 * http://www.sysexpand.com/?path=exercises/kth-smallest
 * 
 * @author jyasar
 * 
 */
public class KthSmallestElement
{
	int[] numArray;
	public KthSmallestElement(int [] array)
	{
		numArray = array;
	}
	
	
	private int partition(int k, int[] numArray, int low, int high)
	{
		// input check
		int pivot = numArray[high - 1];		
		int j = low;
		for (int i = low; i < high; i++) {
			if(numArray[i] < pivot) {				
				swap(i, j);
				j++;
			}
		}
		swap(j, high - 1);
		return j;
	}

	public int kSmallest(int k, int low, int high)
	{
		// input check
		// k - 0-based
		int pivot = partition(k,numArray, low, high);
		if(k < pivot) {
			return kSmallest(k, low, pivot);
		}
		else if(k > pivot) {
			return kSmallest(k, pivot + 1, high);
		}
		else {
			return numArray[k];
		}
	}

	private void swap(int i, int j)
	{
		int temp = numArray[i];
		numArray[i] = numArray[j];
		numArray[j] = temp;
	}
	
	
	/*
	//not completely correct
	public int kthIterative(int k)
	{
		int left = 0, right = numArray.length -1, pivotIndex =0;
		
		if( left == right)
			return numArray[left];
		
		while(left<right)
		{
			pivotIndex = partition(pivotIndex, numArray, left, right);
			if(k == pivotIndex)
			{
				return numArray[k];
			}
			else if(k< pivotIndex)
			{
				right = pivotIndex - 1;
			}
			else
			{
				left = pivotIndex + 1;
			}			
		}
		return numArray[k];
	}
	*/
}
