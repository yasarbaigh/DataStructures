package org.yasar.ds.matrix;

import java.util.Arrays;

import com.google.common.math.BigIntegerMath;

public class UniquePath {

	public static void main(String[] args) {

		System.out.println(uniquePaths(5, 6) + "\t" + ncr(5, 6));
		System.out.println(uniquePaths(3, 4) + "\t" + ncr(3, 4));
		System.out.println(uniquePaths(2, 2) + "\t" + ncr(2, 2));
	}

	public static int ncr(int m, int n) {

		return BigIntegerMath.factorial(m + n ).intValue()
				/ (BigIntegerMath.factorial(m).intValue() * BigIntegerMath.factorial(n).intValue());
	}

	public static int uniquePaths(int m, int n) {
		// Write your code here.
		int[][] dp = new int[m][n];

		for (int[] a : dp) {
			Arrays.fill(a, -1);
		}

		return recurseTabultn(0, 0, m, n);
		// return recurseMemoiztn(0, 0, m, n, dp );
		// return recurse(0,0, m, n);
	}

	public static int recurseTabultn(int i, int j, int m, int n) {

		int[][] dp = new int[m][n];

		// Count of paths to reach any cell in first row is 1
		for (i = 0; i < m; i++)
			dp[i][0] = 1;

		for (j = 0; j < n; j++)
			dp[0][j] = 1;

		for (i = 1; i < m; i++) {
			for (j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}

		return dp[m - 1][n - 1];

	}

	public static int recurseMemoiztn(int i, int j, int m, int n, int[][] dp) {

		if (i < 0 || j < 0) {
			return 0;
		}

		if (i == m - 1 && j == n - 1) {
			return 1;
		}

		if (i >= m || j >= n) {
			return 0;
		}

		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		return dp[i][j] = recurseMemoiztn(i + 1, j, m, n, dp) + recurseMemoiztn(i, j + 1, m, n, dp);
	}

	public static int recurse(int i, int j, int m, int n) {

		if (i < 0 || j < 0) {
			return 0;
		}

		if (i == m - 1 && j == n - 1) {
			return 1;
		}

		if (i >= m || j >= n) {
			return 0;
		}

		return recurse(i + 1, j, m, n) + recurse(i, j + 1, m, n);

	}
}
