package org.yasar.hackerRank.dp.string;

import java.util.Arrays;

// https://leetcode.com/problems/edit-distance/description/

// https://www.youtube.com/watch?v=8HEjwf28LyE&list=PLDzeHZWIZsTomOPnCiU3J95WufjE36wsb&index=36

// What is the minimum modification/insert/delete is required to change S1 as S2
public class EditDistance_Operations_Change_S1_to_S2 {

	public static void main(String[] args) {

		System.out.println(minDistance("intention", "execution"));
	}

	public static int minDistance(String s1, String s2) {

		/*
		 * CRUD of S1 as S2, involves 3-operations for non-matching chars
		 * 
		 * 1. either insert mis-match char in S1 ie increase S2-J only
		 * 
		 * 2. either delete mis-match char in S1 ie increase S1-I only
		 * 
		 * 3. either repliace mis-match char in S1 ie increase S1-I & S2-J only
		 * 
		 * all involves 1 opertaion, so increase their count
		 */

		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		for (int a[] : dp)
			Arrays.fill(a, -1);

		// return find_change_count_recursion(s1, s2, 0, 0);
		// return find_change_count_Memoiztn(s1, s2, 0, 0, dp);

		return find_change_count_Tablutn(s1, s2);
	}

	public static int find_change_count_Tablutn_Space_Optimized(String s1, String s2) {
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];

		// dp intialization its based on memoiztn/recursion base-case
		for (int j = 0; j < s2.length(); j++) {
			dp[s1.length()][j] = s2.length() - j;
		}

		for (int i = 0; i < s1.length(); i++) {
			dp[i][s2.length()] = s1.length() - i;
		}

		for (int i = s1.length() - 1; i >= 0; i--) {

			for (int j = s2.length() - 1; j >= 0; j--) {
				int ans = 0;

				if (s1.charAt(i) == s2.charAt(j)) {

					ans = dp[i + 1][j + 1];
				} else {

					/*
					 * CRUD of S1 as S2, involves 3-operations for non-matching chars
					 * 
					 * 1. either insert mis-match char in S1 ie increase S2-J only
					 * 
					 * 2. either delete mis-match char in S1 ie increase S1-I only
					 * 
					 * 3. either repliace mis-match char in S1 ie increase S1-I & S2-J only
					 * 
					 * all involves 1 opertaion, so increase their count
					 */
					int inserted = 1 + dp[i][j + 1];
					int deleted = 1 + dp[i + 1][j];
					int replaced = 1 + dp[i + 1][j + 1];

					ans = Math.min(inserted, Math.min(deleted, replaced));

				}
				dp[i][j] = ans;
			}

		}

		return dp[0][0];

	}

	public static int find_change_count_Tablutn(String s1, String s2) {
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];

		// dp intialization its based on memoiztn/recursion base-case
		for (int j = 0; j < s2.length(); j++) {
			dp[s1.length()][j] = s2.length() - j;
		}

		for (int i = 0; i < s1.length(); i++) {
			dp[i][s2.length()] = s1.length() - i;
		}

		for (int i = s1.length() - 1; i >= 0; i--) {

			for (int j = s2.length() - 1; j >= 0; j--) {
				int ans = 0;

				if (s1.charAt(i) == s2.charAt(j)) {

					ans = dp[i + 1][j + 1];
				} else {

					/*
					 * CRUD of S1 as S2, involves 3-operations for non-matching chars
					 * 
					 * 1. either insert mis-match char in S1 ie increase S2-J only
					 * 
					 * 2. either delete mis-match char in S1 ie increase S1-I only
					 * 
					 * 3. either repliace mis-match char in S1 ie increase S1-I & S2-J only
					 * 
					 * all involves 1 opertaion, so increase their count
					 */
					int inserted = 1 + dp[i][j + 1];
					int deleted = 1 + dp[i + 1][j];
					int replaced = 1 + dp[i + 1][j + 1];

					ans = Math.min(inserted, Math.min(deleted, replaced));

				}
				dp[i][j] = ans;
			}

		}

		return dp[0][0];

	}

	public static int find_change_count_Memoiztn(String s1, String s2, int i, int j, int[][] dp) {

		if (i == s1.length()) {
			return s2.length() - j;
		}

		if (j == s2.length()) {
			return s1.length() - i;
		}

		if (dp[i][j] != -1)
			return dp[i][j];
		int ans = 0;
		if (s1.charAt(i) == s2.charAt(j)) {

			ans = find_change_count_Memoiztn(s1, s2, i + 1, j + 1, dp);
		} else {

			/*
			 * CRUD of S1 as S2, involves 3-operations for non-matching chars
			 * 
			 * 1. either insert mis-match char in S1 ie increase S2-J only
			 * 
			 * 2. either delete mis-match char in S1 ie increase S1-I only
			 * 
			 * 3. either repliace mis-match char in S1 ie increase S1-I & S2-J only
			 * 
			 * all involves 1 opertaion, so increase their count
			 */
			int inserted = 1 + find_change_count_Memoiztn(s1, s2, i, j + 1, dp);
			int deleted = 1 + find_change_count_Memoiztn(s1, s2, i + 1, j, dp);
			int replaced = 1 + find_change_count_Memoiztn(s1, s2, i + 1, j + 1, dp);

			ans = Math.min(inserted, Math.min(deleted, replaced));

		}

		return dp[i][j] = ans;

	}

	public static int find_change_count_recursion(String s1, String s2, int i, int j) {

		if (i == s1.length()) {
			return s2.length() - j;
		}

		if (j == s2.length()) {
			return s1.length() - i;
		}
		int ans = 0;
		if (s1.charAt(i) == s2.charAt(j)) {

			ans = find_change_count_recursion(s1, s2, i + 1, j + 1);
		} else {

			/*
			 * CRUD of S1 as S2, involves 3-operations for non-matching chars
			 * 
			 * 1. either insert mis-match char in S1 ie increase S2-J only 2. either delete
			 * mis-match char in S1 ie increase S1-I only 3. either repliace mis-match char
			 * in S1 ie increase S1-I & S2-J only
			 * 
			 * all involves 1 opertaion, so increase their count
			 */
			int inserted = 1 + find_change_count_recursion(s1, s2, i, j + 1);
			int deleted = 1 + find_change_count_recursion(s1, s2, i + 1, j);
			int replaced = 1 + find_change_count_recursion(s1, s2, i + 1, j + 1);

			ans = Math.min(inserted, Math.min(deleted, replaced));

		}

		return ans;

	}

}
