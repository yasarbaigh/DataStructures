package org.yasar.ds.tree;

import java.util.Arrays;

// https://leetcode.com/problems/unique-binary-search-trees/description/

// https://leetcode.com/problems/unique-binary-search-trees/description/

// Catalan number for n =   (2n)!/ (n!) * (n+1)!

public class StructurallyUniqueBinarySearchTreesForN {
	public static void main(String[] args) {

		int[] dp = new int[1000];
		Arrays.fill(dp, -1);
		System.out.println(getStructurllayUniqueBinaryTreeCount(13));
		System.out.println(getStructurllayUniqueBinaryTreeCountMemoizn(13, dp));
		System.out.println(getStructurllayUniqueBinaryTreeCountTabulatn(13, dp));
	}

	public static int getStructurllayUniqueBinaryTreeCountTabulatn(int n, int[] dp) {
		Arrays.fill(dp, 0);
		dp[0] = 1;
		dp[1] = 1;

		int ans = 0;
		// no. of nodes
		for (int i = 2; i <= n; i++) {

			// making each node-i as root-node
			for (int j = 1; j <= i; j++) {
				dp[i] += dp[j-1] * dp[i - j];
			}
		}

		return dp[n];
	}

	public static int getStructurllayUniqueBinaryTreeCountMemoizn(int n, int[] dp) {

		if (n <= 1)
			return 1;

		if (dp[n] != -1) {
			return dp[n];
		}

		int ans = 0;
		for (int i = 1; i <= n; i++) {

			ans += getStructurllayUniqueBinaryTreeCount(i - 1) * getStructurllayUniqueBinaryTreeCount(n - i);
		}

		return dp[n] = ans;
	}

	public static int getStructurllayUniqueBinaryTreeCount(int n) {

		if (n <= 1)
			return 1;
		int ans = 0;
		for (int i = 1; i <= n; i++) {

			ans += getStructurllayUniqueBinaryTreeCount(i - 1) * getStructurllayUniqueBinaryTreeCount(n - i);
		}

		return ans;
	}
}
