package org.yasar.ds.arrays;

import java.util.ArrayList;

public class FindDuplicateInArray {

	public static int findDuplicate(ArrayList<Integer> arr, int n) {

		for (int i = 0; i < arr.size(); i++) {

			int k = arr.get(i) % n;
			// duplicate index value will be added twice
			arr.set(k, arr.get(k) + n);
		}

		for (int i = 0; i < n; i++) {
			if (arr.get(i) >= n * 2) {
				// duplicate value will be atleast 2n
				return i;
			}
		}

		return -1;

	}

}
