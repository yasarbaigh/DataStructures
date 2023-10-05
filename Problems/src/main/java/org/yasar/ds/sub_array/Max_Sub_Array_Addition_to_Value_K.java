package org.yasar.ds.sub_array;

import java.util.HashMap;
import java.util.List;
// https://www.codingninjas.com/studio/problems/longest-subset-zero-sum_920321?leftPanelTab=2

// 

// 
public class Max_Sub_Array_Addition_to_Value_K {
	public static void main(String[] args) {
		System.out.println(maxLen_HashMap(List.of(15, -2, 2, -8, 1, 7, 10, 23), 0));
		System.out.println(maxLen_Brute_Force(List.of(1, -2, 3, -1, 4, -4), 0));
		System.out.println(getSumOfK(List.of(1, -2, 3, -1, 4, -4), 0));
	}

	private static int getSumOfK(List<Integer> a, int target) {

		return recurse(a, 0, 0, target);
	}

	private static int recurse(List<Integer> a, int src, int idx, int target) {
		if (idx >= a.size()) {
			return 0;
		}

		if (target == 0)
			return 1;

		int a1 = recurse(a, src, idx + 1, target + a.get(idx));
		int a2 = recurse(a, src + 1, idx + 1, target);

		if (a1 != 0) {
			a1 = idx - src;
		}

		if (a2 != 0) {
			a2 = idx - src;
		}
		return Math.max(a1, a2);
	}

	public static int maxLen_HashMap(List<Integer> arr, int target) {
		// Creates an empty hashMap hM
		HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();

		int sum = 0; // Initialize sum of elements
		int max_len = 0; // Initialize result

		// Traverse through the given array
		for (int i = 0; i < arr.size(); i++) {
			// Add current element to sum
			sum += arr.get(i);

			if (sum == 0)
				max_len = i + 1;

			// Look this sum in hash table
			Integer prev_i = hM.get(sum);

			// If this sum is seen before, then update
			// max_len if required
			if (prev_i != null)
				max_len = Math.max(max_len, i - prev_i);
			else // Else put this sum in hash table
				hM.put(sum, i);
		}

		return max_len;
	}

	public static int maxLen_Brute_Force(List<Integer> a, int target) {
		int max_len = 0;
		int N = a.size();
		// Pick a starting point
		for (int i = 0; i < N; i++) {

			// Initialize curr_sum for every
			// starting point
			int curr_sum = 0;

			// try all subarrays starting with 'i'
			for (int j = i; j < N; j++) {
				curr_sum += a.get(j);

				// If curr_sum becomes 0, then update
				// max_len
				if (curr_sum == target)
					max_len = Math.max(max_len, j - i + 1);
			}
		}
		return max_len;
	}

}
