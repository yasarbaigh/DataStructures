package org.yasar.hackerRank.dp.numbers;

import java.util.Arrays;

// https://www.youtube.com/watch?v=x--bMzT1Xhk&list=PLDzeHZWIZsTomOPnCiU3J95WufjE36wsb&index=27
// https://leetcode.com/problems/guess-number-higher-or-lower-ii/
public class GuessNumberHigherOrLowerCoins {

	public static void main(String[] args) {
		System.out.println(guessNumberHigherOrLowerCoins(10));
	}

	private static int guessNumberHigherOrLowerCoins(int n) {
		// TODO Auto-generated method stub

		int[][] dp = new int[n + 1][n + 1];
		for (int[] a : dp)
			Arrays.fill(a, -1);
		// return solveRecursion(1, n);
		// return solveRecursionMemoizn(1, n, dp);
		return solveTabluation(n, dp);
	}

	private static int solveTabluation(int n, int[][] dp) {
		// if Memoizn in top-down approach, obviously Tabulation is Bottom-approach
		for (int[] a : dp)
			Arrays.fill(a, 0);

		// Bottom-up approach, going n->1
		for (int start = n; start >= 1; start--) {

			for (int end = start; end <= n; end++) {
				// going through all elements

				if (start == end) {
					continue;
				} else {
					// recursive part is copied and pasted
					int ans = Integer.MAX_VALUE;
					for (int i = start; i < end; i++) {
						ans = Math.min(ans, i + Math.max(dp[start][i - 1], dp[i + 1][end]));
					}
					dp[start][end] = ans;
				}

			}

		}

		return dp[1][n];
	}

	private static int solveRecursionMemoizn(int start, int end, int[][] dp) {
		// 2 changing vrbls, start&end, so 2D-dp-array
		if (end <= start) {
			return 0;
		}

		int ans = Integer.MAX_VALUE;
		if (dp[start][end] != -1) {
			return dp[start][end];
		}

		for (int i = start; i <= end; i++) {
			ans = Math.min(ans,
					i + Math.max(solveRecursionMemoizn(start, i - 1, dp), solveRecursionMemoizn(i + 1, end, dp)));
		}

		return dp[start][end] = ans;
	}

	private static int solveRecursion(int start, int end) {
		if (end <= start) {
			return 0;
		}

		int ans = Integer.MAX_VALUE;

		for (int i = start; i <= end; i++) {
			ans = Math.min(ans, i + Math.max(solveRecursion(start, i - 1), solveRecursion(i + 1, end)));
		}

		return ans;
	}

}
