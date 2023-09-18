package org.yasar.hackerRank.dp.numbers;

import java.util.Arrays;

public class MininumSquaresForA_Target {
	// get-minimum-squares
	// https://practice.geeksforgeeks.org/problems/get-minimum-squares0538/1
	// https://www.youtube.com/watch?v=aJTCcyPrPOA&list=PLDzeHZWIZsTomOPnCiU3J95WufjE36wsb&index=11

	public int MinSquares(int n) {
		// return solveRecursion(n);
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		// return solveMemoiztn(n, dp);

		return solveTabltn(n, dp);
	}

	public int solveTabltn(int n, int[] dp) {

		Arrays.fill(dp, Integer.MAX_VALUE);

		dp[0] = 0;
		dp[1] = 1;

		int ans = n, temp = 0;
		for (int i = 2; i <= n; i++) {

			for (int j = 1; j * j <= n; j++) {
				temp = j * j;

				if (i - temp >= 0)
					dp[i] = Math.min(dp[i], 1 + dp[i - temp]);
			}

		}

		return dp[n];
	}

	public int solveMemoiztn(int n, int[] dp) {

		if (n == 0) {
			return 0;
		}

		if (n == 1) {
			return 1;
		}

		if (dp[n] != -1) {
			return dp[n];
		}

		int ans = n, temp = 0;
		for (int i = 2; i * i <= n; i++) {

			temp = i * i;

			ans = Math.min(ans, 1 + solveMemoiztn(n - temp, dp));
		}

		return dp[n] = ans;
	}

	public int solveRecursion(int n) {

		if (n <= 0) {
			return 0;
		}

		if (n == 1) {
			return 1;
		}

		int ans = n, temp = 0;
		for (int i = 2; i * i <= n; i++) {

			temp = i * i;

			ans = Math.min(ans, 1 + solveRecursion(n - temp));
		}

		return ans;
	}

}
