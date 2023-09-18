package org.yasar.ds.sub_array;

// https://www.youtube.com/watch?v=hnswaLJvr6g
// https://leetcode.com/problems/maximum-product-subarray/

// For long over-lapping go for , python

public class Max_Multiplied_Continous_Sub_Array {

	public static void main(String[] args) {
		// System.out.println(solution_N3(new int[] { 2, 3, -2, 4 }));
		// System.out.println(solution_N3(new int[] { -2,0,-1}));

		System.out.println(max_mutliplied_Continous_SubArray_O_of_N(new int[] { 2, 3, -2, 4 }));

		System.out.println(max_mutliplied_Continous_SubArray_O_of_N(new int[] { -2, 0, -1 }));

		System.out.println(max_mutliplied_Continous_SubArray_O_of_N(new int[] { 3, 2, -1, 4, -6, 3, -2, 6 }));

		// for this test-case it will fail, due to long exceed use python for this
		//System.out.println(max_mutliplied_Continous_SubArray_O_of_N(
		//		new int[] { 0, 10, 10, 10, 10, 10, 10, 10, 10, 10, -10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 0 })); // 1000000000

	}

	private static long max_mutliplied_Continous_SubArray_O_of_N(int[] ip) {
		long max = Long.MIN_VALUE;
		int n = ip.length - 1;
		long prefix = 1l, suffix = 1l;
		for (int i = 0; i < ip.length; i++) {

			prefix *= ip[i];
			suffix *= ip[n - i];
			max = Math.max(max, Math.max(prefix, suffix));
			if (ip[i] == 0) {
				prefix = 1l;

			}

			if (ip[n - i] == 0) {
				suffix = 1l;
			}

		}

		return max;
	}

	/*
	 * o-N2 n-squared solution
	 */
	private static int max_mutliplied_Continous_SubArray_N2(int[] ip) {
		int max = 0;
		for (int i = 0; i < ip.length; i++) {
			int prod = 1;
			for (int j = i; j < ip.length; j++) {

				prod *= ip[j];

				max = Math.max(max, prod);
			}
		}

		return max;
	}

	/*
	 * o-N3 n-cube solution
	 */
	private static int solution_N3(int[] ip) {
		int max = 0;
		for (int i = 0; i < ip.length; i++) {
			for (int j = i; j < ip.length; j++) {

				int prod = 1;
				for (int k = i; k <= j; k++) {
					prod *= ip[k];
				}
				max = Math.max(max, prod);
			}
		}

		return max;
	}

}
