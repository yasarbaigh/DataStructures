package org.yasar.hackerRank.dp.string;

import java.util.Arrays;

// https://www.youtube.com/watch?v=U095bJJtW3w&list=PLDzeHZWIZsTomOPnCiU3J95WufjE36wsb&index=35 

// https://www.codingninjas.com/studio/problems/longest-palindromic-subsequence_842787
public class LongestPalindrome_Sub_Sequennce {
	/*
	 * 
	 * LongestCommonSubSequenceIn2Strings part of this
	 * 
	 * 
	 * if
	 */

	public static void main(String[] args) {
		System.out.println(longestPalindromeSubsequence("bbabcbcab"));
	}

	public static int longestPalindromeSubsequence(String s1) {
		/*
		 * if S1 is reversed, max-common-pattern in 2 strings is checked, then
		 * max-palindrome string will be there for us.
		 * 
		 */
		int[][] dp = new int[s1.length() + 1][s1.length() + 1];
		for (int a[] : dp)
			Arrays.fill(a, -1);

		return maxCommonStringLength_Memoiztn(s1, new StringBuilder(s1).reverse().toString(), 0, 0, dp);
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

}
