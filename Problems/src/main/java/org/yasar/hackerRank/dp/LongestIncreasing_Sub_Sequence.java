package org.yasar.hackerRank.dp;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

//https://www.youtube.com/watch?v=on2hvxBXJH4
// https://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
public class LongestIncreasing_Sub_Sequence {

	/*
	 * Complete the 'longestIncreasingSubsequence' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts
	 * INTEGER_ARRAY arr as parameter.
	 */

	public static int longestIncreasingSubsequence_Recursion(List<Integer> arr) {
		// Binary search approach
		int n = arr.size(), y = 0;
		int[] nums = new int[n];
		for (Integer x : arr) {
			nums[y++] = x;
		}
		return re(nums, 0, -1);
	}

	public static int re(int[] ar, int current_i, int prev_i) {

		if (current_i == ar.length)
			return 0;

		int take = 0;
		if (prev_i == -1 || (ar[current_i] >= ar[prev_i]))
			take = 1 + re(ar, current_i + 1, current_i);

		int notTaken = re(ar, current_i + 1, prev_i);

		return Math.max(take, notTaken);
	}

	public static int longestIncreasingSubsequence(int [] nums) {
		// Binary search approach
		

		List<Integer> ans = new ArrayList<>();

		// Initialize the answer list with the
		// first element of nums
		ans.add(nums[0]);

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > ans.get(ans.size() - 1)) {
				// If the current number is greater
				// than the last element of the answer
				// list, it means we have found a
				// longer increasing subsequence.
				// Hence, we append the current number
				// to the answer list.
				ans.add(nums[i]);
			} else {
				// If the current number is not
				// greater than the last element of
				// the answer list, we perform
				// a binary search to find the smallest
				// element in the answer list that
				// is greater than or equal to the
				// current number.

				// The binarySearch method returns
				// the index of the first element that is not less than
				// the current number.
				int low = Collections.binarySearch(ans, nums[i]);

				// We update the element at the
				// found position with the current number.
				// By doing this, we are maintaining
				// a sorted order in the answer list.
				if (low < 0) {
					low = -(low + 1);
				}
				ans.set(low, nums[i]);
			}
		}

		// The size of the answer list
		// represents the length of the
		// longest increasing subsequence.
		return ans.size();
	}



	public static void main(String[] args) throws IOException {
		int[] ar = { 10, 22, 9, 33, 21, 50, 41, 60 };
		System.out.println(longestIncreasingSubsequence(ar));
	}
}
