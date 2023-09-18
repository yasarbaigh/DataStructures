package org.yasar.leet_code;

import java.util.Arrays;
import java.util.Collections;

public class Hints {

	public static void main(String[] args) {
		double[] d1Array = { 5.5, 55, 66.6, -23, 44, +77, 23, 88 };
		int[][] d2Array = { { 1, 5 }, { 10, 11 }, { 12, 18 }, { 20, 25 }, { 30, 32 } };
		System.out.println(helper(d1Array, d2Array, 10));

	}

	public static int helper(double[] d1Array, int[][] d2Array, int q) {

		Arrays.sort(d1Array);
		// easy way print 2D array
		System.out.println(Arrays.toString(d1Array));

		// ---------------------------------------

		Arrays.sort(d2Array, (a, b) -> {
			return a[0] - b[0];
		});
		// easy way print 2D array
		for (int[] row : d2Array)
			System.out.println(Arrays.toString(row));

		// sort 2D array, based 0 index of j array;
		System.out.println("===============================");

		Arrays.sort(d2Array, (a, b) -> {
			// Descending Order
			return b[0] - a[0];
		});
		
		
		for (int[] row : d2Array) {
			//easy way to fill default values
			Arrays.fill(row,-100);
			System.out.println(Arrays.toString(row));
		}

		return 0;
	}
}
