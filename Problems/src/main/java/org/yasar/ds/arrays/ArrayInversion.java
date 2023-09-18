package org.yasar.ds.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

// https://www.geeksforgeeks.org/inversion-count-in-array-using-merge-sort/

//https://www.codingninjas.com/studio/problems/count-inversions_615?leftPanelTab=0

public class ArrayInversion {
	/**
	 * 
	 * Inversion is ARR[i] < ARR[j]
	 * 
	 * i> j
	 * 
	 * @param args
	 */

	public static void main(String[] args) {

		System.out.println(getNumOfInversions(new long[] { 1, 20, 6, 4, 5 }));

		System.out.println(getNumOfInversions(new long[] { 2, 5, 1, 3, 4 }));

		System.out.println(getNumOfInversions(new long[] { 52244275, 123047899, 493394237, 922363607, 378906890,
				188674257, 222477309, 902683641, 860884025, 339100162 }));
	}

	public static int getNumOfInversions(long[] arr) {

		int N = arr.length;
		if (N <= 1) {
			return 0;
		}

		// smallest most element is first
		PriorityQueue<long[]> sortList = new PriorityQueue<>((a, b) -> {
			long t = a[0] - b[0];
			return (int) t;
		});

		int result = 0;

		// Heapsort, O(N*log(N))
		for (int i = 0; i < N; i++) {
			sortList.add(new long[] { arr[i], i });

		}

		// Storing array-index in list to check where it can fit ;
		List<Long> indexOfValues = new ArrayList<>();
		while (!sortList.isEmpty()) {

			long[] v = sortList.poll();

			int z = 0;
			if (!indexOfValues.isEmpty()) {
				z = Collections.binarySearch(indexOfValues, v[1]);
				if (z < 0) {
					z = Math.abs(z + 1);
				}
			}

			// i can represent how many elements on the left
			// i - z can find how many bigger nums on the left

			result += v[1] - z;

			indexOfValues.add(v[1]);
			indexOfValues.sort(null);

		}

		return result;
	}
}
