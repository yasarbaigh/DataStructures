package org.yasar.hackerRank.dp.numbers;


//https://www.codingninjas.com/studio/problems/ninja-and-the-fence_3210208?leftPanelTab=1
//https://www.youtube.com/watch?v=5eFh5CC-8KY&list=PLDzeHZWIZsTomOPnCiU3J95WufjE36wsb&index=9
public class ColorFence {

	static long MOD = 1000000007;

	public static int numberOfWays(int n, int k) {
		// Write your code here.

		if (n < 0) {
			return 0;
		}
		if (n == 1) {
			return k;
		}

		if (n == 2) {
			return k * k;
		}

		long[] op = solveRecursion(n, k);
		return (int) op[2];

		// return (int) solveTabulation(n, k);

	}

	public static long[] solveRecursion(int n, int k) {

		if (n == 2) {
			// last-2-same-color, last-2-differnt-color, sum-of-both
			long[] r = { k, k * (k - 1), k * k };
			return r;
		}

		long[] previous_op = solveRecursion(n - 1, k);

		long last_2_same_color = previous_op[1];
		long last_2_diff_color = previous_op[2] * (k - 1);
		long total = last_2_same_color + last_2_diff_color;
		long[] current_op = { last_2_same_color % MOD, last_2_diff_color % MOD, total % MOD };

		return current_op;

	}

}
