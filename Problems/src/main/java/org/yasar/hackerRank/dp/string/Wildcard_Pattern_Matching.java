package org.yasar.hackerRank.dp.string;

import java.util.Arrays;

public class Wildcard_Pattern_Matching {

	public static void main(String[] args) {
		System.out.println(isMatch("aa", "a")); // false
		System.out.println(isMatch("aa", "*")); // true
		System.out.println(isMatch("ca", "?b")); // false
		System.out.println(isMatch("mississippi", "m??*ss*?i*pi")); // false
		System.out.println(isMatch("aa", "aa")); // true

		System.out.println("-------------------");

		System.out.println(isMatch("abbabbbaabaaabbbbbabbabbabbbabbaaabbbababbabaaabbab", "*aabb***aa**a******aa*")); // true
		System.out.println("-----------------");
	}

	public static boolean isMatch(String s, String p) {

		int[][] dp = new int[s.length() + 1][p.length() + 1];
		for (int a[] : dp)
			Arrays.fill(a, -1);

		// return is_match_recusr(s, p, s.length() - 1, p.length() - 1);

		// return is_match_recusr_Memoiztn(s, p, s.length() - 1, p.length() - 1, dp);

		return is_match_recusr_Tabultn(s, p);

	}

	private static boolean is_match_recusr_Tabultn(String s, String p) {

		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

		dp[0][0] = true; // Memoiztn/Recursion 1st Base-Case i<0 and j<0 full S & P matched

		// base condition -2 not required, since all values are set false by default

		// base condition -3
		for (int j = 0; j <= p.length(); j++) {
			boolean flag = true;
			// check the bekow k-loop as in recursion
			for (int k = 0; k < j; k++) {
				if (p.charAt(k) != '*')
					flag = false;
			}
			dp[0][j] = flag;
		}

		for (int i = 1; i <= s.length(); i++) {

			for (int j = 1; j <= p.length(); j++) {

				boolean ans = false;
				if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
					ans = dp[i - 1][j - 1];
				} else if (p.charAt(j - 1) == '*') {

					boolean f1 = dp[i - 1][j];
					boolean f2 = dp[i][j - 1];

					ans = f1 || f2;
				} else {
					ans = false;
				}

				dp[i][j] = ans;
			}
		}

		return dp[s.length()][p.length()]; // this is the input wat we pass for Recursion functoin
	}

	private static boolean is_match_recusr_Memoiztn(String s, String p, int i, int j, int[][] dp) {

		// base condition -1
		if (i < 0 && j < 0) {
			return true; // came till last-match, so S & P are matching
		}

		// base condition -2
		if (i >= 0 && j < 0)
			// pattern exhausted
			return false;

		// base condition -3
		if (i < 0 && j >= 0) {

			// string exhausted, so checking for only * in pattern string

			for (int k = 0; k <= j; k++) {
				if (p.charAt(k) != '*')
					return false;
			}
			return true;
		}

		if (dp[i][j] != -1)
			return dp[i][j] == 1 ? true : false;

		boolean ans = false;
		if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
			ans = is_match_recusr_Memoiztn(s, p, i - 1, j - 1, dp);
		} else if (p.charAt(j) == '*') {

			boolean f1 = is_match_recusr_Memoiztn(s, p, i - 1, j, dp);
			boolean f2 = is_match_recusr_Memoiztn(s, p, i, j - 1, dp);

			ans = f1 || f2;
		} else {
			ans = false;
		}

		dp[i][j] = ans ? 1 : 0;
		return ans;
	}

	private static boolean is_match_recusr(String s, String p, int i, int j) {
		if (i < 0 && j < 0) {
			return true; // came till last-match, so S & P are matching
		}

		if (i >= 0 && j < 0)
			// pattern exhausted
			return false;

		if (i < 0 && j >= 0) {

			// string exhausted, so checking for only * in pattern string

			for (int k = 0; k <= j; k++) {
				if (p.charAt(k) != '*')
					return false;
			}
			return true;
		}

		if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
			return is_match_recusr(s, p, i - 1, j - 1);
		} else if (p.charAt(j) == '*') {

			boolean f1 = is_match_recusr(s, p, i - 1, j);
			boolean f2 = is_match_recusr(s, p, i, j - 1);

			return f1 || f2;
		} else {
			return false;
		}

	}

}
