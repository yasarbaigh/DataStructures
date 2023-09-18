package org.yasar.ds.arrays;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/description/

// https://www.youtube.com/watch?v=IeT9Qz_vqHo&list=PLDzeHZWIZsTomOPnCiU3J95WufjE36wsb&index=23
public class MinSwapForIncreaseSubSequence {

	public static void main(String[] args) {
		System.out.println(findMinSwapsforIncreasingSubSequence(new int[] { 1, 3, 5, 4 }, new int[] { 1, 2, 3, 7 }));

		System.out.println(
				findMinSwapsforIncreasingSubSequence(new int[] { 0, 3, 5, 8, 9 }, new int[] { 2, 1, 4, 6, 9 }));
	}

	static int findMinSwapsforIncreasingSubSequence(int[] a1, int[] a2) {

		int[] b1 = new int[a1.length + 1];
		int[] b2 = new int[a2.length + 1];

		// inserting 1-more element in HEAD , for recursion adjstment while indxing i-1;
		b1[0] = -1;
		b2[0] = -1;

		for (int i = 0; i < a1.length; i++) {
			b1[1 + i] = a1[i];
			b2[1 + i] = a2[i];
		}

		// creating 2d dp-array due, to index & swapping-boolean 2 changing vrbls
		int dp[][] = new int[a1.length + 1][2];

		for (int[] a : dp)
			Arrays.fill(a, -1);

		// return solve(b1, b2, 1, false);

		return solveMemoztn(b1, b2, 1, false, dp);

		// return solveTabltn(b1, b2, dp);
	}

	static int solveMemoztn(int[] a1, int[] a2, int idx, boolean swapp, int[][] dp) {

		if (idx >= a1.length) {
			return 0;
		}

		int boolIdx = swapp ? 1 : 0;

		if (dp[idx][boolIdx] != -1)
			return dp[idx][boolIdx];

		int prev1 = a1[idx - 1];
		int prev2 = a2[idx - 1];
		if (swapp) {
			prev1 = a2[idx - 1];
			prev2 = a1[idx - 1];
		}

		int ans = Integer.MAX_VALUE;
		if (prev1 < a1[idx] && prev2 < a2[idx]) {
			ans = solveMemoztn(a1, a2, 1 + idx, false, dp);
		}

		if (prev1 < a2[idx] && prev2 < a1[idx]) {
			ans = Math.min(ans, 1 + solveMemoztn(a1, a2, 1 + idx, true, dp));
		}

		return dp[idx][boolIdx] = ans;
	}

	static int solve(int[] a1, int[] a2, int idx, boolean swapp) {

		if (idx >= a1.length) {
			return 0;
		}

		int prev1 = a1[idx - 1];
		int prev2 = a2[idx - 1];
		if (swapp) {
			prev1 = a2[idx - 1];
			prev2 = a1[idx - 1];
		}

		int ans = Integer.MAX_VALUE;
		if (prev1 < a1[idx] && prev2 < a2[idx]) {
			ans = solve(a1, a2, 1 + idx, false);
		}

		if (prev1 < a2[idx] && prev2 < a1[idx]) {
			ans = Math.min(ans, 1 + solve(a1, a2, 1 + idx, true));
		}

		return ans;
	}

	static int solveTabltn_NOT_WORKING(int[] a1, int[] a2, int[][] dp) {
		for (int[] a : dp)
			Arrays.fill(a, 0);

		// since Memitzn is 1->N, then Tablutn is Bottom up approach

		// so we go from n->1 , True->False i.e. swapp/not-swapp for Bottom up approach
		for (int idx = a1.length - 1; idx >= 0; idx--) {

			boolean prev_swapped = false;
			for (int swapped = 1; swapped >= 0; swapped--) {

				int prev1 = a1[idx - 1];
				int prev2 = a2[idx - 1];
				if (swapped == 1 || prev_swapped) {
					prev1 = a2[idx - 1];
					prev2 = a1[idx - 1];
				}

				int ans = Integer.MAX_VALUE;
				if (prev1 < a1[idx] && prev2 < a2[idx]) {
					// not-swapped
					ans = dp[1 + idx][0];
				}

				if (prev1 < a2[idx] && prev2 < a1[idx]) {
					// swapped
					ans = Math.min(ans, 1 + dp[1 + idx][1]);
					prev_swapped = true;
				}

				return dp[idx][swapped] = ans;

			}
		}

		// its Bottom up approach , we came from N->1 , True->False, so return will be
		// 1,0;
		return dp[1][0];

	}

}
