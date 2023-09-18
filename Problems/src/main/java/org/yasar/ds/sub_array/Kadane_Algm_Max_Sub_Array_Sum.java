package org.yasar.ds.sub_array;

// https://leetcode.com/problems/maximum-subarray/

// https://www.youtube.com/watch?v=w4W6yya1PIc&list=PLDzeHZWIZsTq60eobVporukriHgBamrzK
public class Kadane_Algm_Max_Sub_Array_Sum {

	public static void main(String[] args) {
		System.out.println(max_Sub_Array_sum_int(new int[] { 1, 2, 3, -2, 5 }));

		System.out.println(max_Sub_Array_sum_Long(new int[] { -4, -1, -2, -3, }));
	}

	private static int max_Sub_Array_sum_int(int[] ip) {
		int sum = 0;
		int max = ip[0];

		for (int i = 0; i < ip.length; i++) {
			sum += ip[i];

			max = Math.max(max, sum);
			if (sum < 0) {
				sum = 0;
			}
		}

		return max;
	}

	private static long max_Sub_Array_sum_Long(int[] ip) {
		long sum = 0;
		long max = Long.parseLong("" + ip[0]);

		for (int i = 0; i < ip.length; i++) {
			sum += ip[i];

			max = Math.max(max, sum);
			if (sum < 0L) {
				sum = 0L;
			}
		}

		return max;
	}

}
