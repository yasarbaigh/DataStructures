package org.yasar.hackerRank.dp.string;

import java.util.Arrays;

//https://www.youtube.com/watch?v=y1b8pObvndA

// https://practice.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1
public class LongestCommonSubSequenceIn2Strings {

	public static void main(String[] args) {

		System.out.println(lcs("XYa", "aXY", 0, 0));

	}

	public static int lcs(String s1, String s2, int i, int j) {

		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		for (int a[] : dp)
			Arrays.fill(a, -1);

		// return maxCommonStringLength_Recursion(s1, s2, i, j);

		// return maxCommonStringLength_Memoiztn(s1, s2, i, j, dp);
		return maxCommonStringLength_Tabltn(s1, s2);

	}

	/*
	 * Since memoiztn, top-down 1->n , so Tabltn will be bottom-up approach n->1
	 * 
	 * 2 pointers changing i,j so 2D-array for dp // return will be starting point
	 * from memoiztn- top-down-approach
	 * 
	 */
	public static int maxCommonStringLength_Tabltn(String s1, String s2) {

		int[][] dp = new int[s1.length() + 1][s2.length() + 1];

		int ans = 0;

		for (int i = s1.length() - 1; i >= 0; i--) {

			for (int j = s2.length() - 1; j >= 0; j--) {
				ans = 0;
				if (s1.charAt(i) == s2.charAt(j)) {
					ans = 1 + dp[i + 1][j + 1];
				} else {
					int a1 = dp[i + 1][j];
					int a2 = dp[i][j + 1];

					ans = Math.max(a1, a2);
				}

				dp[i][j] = ans;

			}
		}

		// return will be starting point from memoiztn- top-down-approach
		return dp[0][0];

	}

	public static int maxCommonStringLength_Memoiztn(String s1, String s2, int i, int j, int[][] dp) {

		if (i >= s1.length() || j >= s2.length())
			return 0;

		int ans = 0;

		if (dp[i][j] != -1)
			return dp[i][j];

		if (s1.charAt(i) == s2.charAt(j)) {
			ans = 1 + maxCommonStringLength_Memoiztn(s1, s2, i + 1, j + 1, dp);
		} else {
			int a1 = maxCommonStringLength_Memoiztn(s1, s2, i + 1, j, dp);
			int a2 = maxCommonStringLength_Memoiztn(s1, s2, i, j + 1, dp);

			ans = Math.max(a1, a2);
		}

		return dp[i][j] = ans;

	}

	public static int maxCommonStringLength_Recursion(String s1, String s2, int i, int j) {

		if (i >= s1.length() || j >= s2.length())
			return 0;

		int ans = 0;

		if (s1.charAt(i) == s2.charAt(j)) {
			ans = 1 + maxCommonStringLength_Recursion(s1, s2, i + 1, j + 1);
		} else {
			int a1 = maxCommonStringLength_Recursion(s1, s2, i + 1, j);
			int a2 = maxCommonStringLength_Recursion(s1, s2, i, j + 1);

			ans = Math.max(a1, a2);
		}

		return ans;

	}

}
