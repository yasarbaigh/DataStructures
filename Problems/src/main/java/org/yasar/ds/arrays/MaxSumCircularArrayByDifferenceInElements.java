package org.yasar.ds.arrays;

import java.util.Arrays;


// https://practice.geeksforgeeks.org/problems/swap-and-maximize5859/1
public class MaxSumCircularArrayByDifferenceInElements {
	
	public static void main(String[] args) {
		System.out.println(maxSum(new long[] {4, 2, 1, 8}, 4));
	}
	static long maxSum(long arr[] ,int n)
    {
		n = arr.length;
        long sum = 0;
  
        // Sorting the array.
        Arrays.sort(arr);
      
        // Subtracting a1, a2, a3,....., a(n/2)-1,
        // an/2 twice and adding a(n/2)+1, a(n/2)+2,
        // a(n/2)+3,....., an - 1, an twice.
        for (int i = 0; i < n/2; i++)
        {
            sum -= (2 * arr[i]);
            sum += (2 * arr[n - i - 1]);
        }
      
        return sum;
    }
}


