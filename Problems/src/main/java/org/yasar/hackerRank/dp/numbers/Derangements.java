package org.yasar.hackerRank.dp.numbers;

import java.util.Arrays;

//https://www.codingninjas.com/studio/problems/count-derangements_873861?leftPanelTab=0

public class Derangements {

	static long MOD = 1000000007;

	public static long countDerangements(int n) {

		// return solve(n);

		long[] dp = new long[n + 1];
		Arrays.fill(dp, -1);
		// return solveMemoization(n, dp);

		// return solveTabulatn(n, dp);

		return solveTabltnSpaceOptimized(n);
	}

	public static long solve(int n) {

		if (n <= 1)
			return 0;
		if (n == 2)
			return 1;

		return (n - 1) * (solve(n - 1) + solve(n - 2));
	}

	public static long solveMemoization(int n, long[] dp) {

		if (n <= 1)
			return 0;
		if (n == 2)
			return 1;

		if (dp[n] != -1)
			return dp[n];

		return dp[n] = (((n - 1) % MOD) * ((solveMemoization(n - 1, dp) % MOD) + (solveMemoization(n - 2, dp) % MOD)))
				% MOD;
	}

	public static long solveTabulatn(int n, long[] dp) {

		if (n <= 1)
			return 0;
		if (n == 2)
			return 1;

		dp[0] = 0;
		dp[1] = 0;
		dp[2] = 1;
		long mdlo1 = 0, mdlo2 = 0;
		for (int i = 3; i <= n; i++) {

			mdlo1 = dp[i - 1] % MOD;

			mdlo2 = dp[i - 2] % MOD;

			dp[i] = (((i - 1) % MOD) * (mdlo1 + mdlo2)) % MOD;

		}

		return dp[n];
	}

	public static long solveTabltnSpaceOptimized(int n) {

		if (n <= 1)
			return 0;
		if (n == 2)
			return 1;

		long prev2 = 0; // n = 1
		long prev1 = 1; // n = 2

		long mdlo1 = 0, mdlo2 = 0, ans = 0;
		for (int i = 3; i <= n; i++) {

			mdlo1 = prev1 % MOD;

			mdlo2 = prev2 % MOD;

			ans = (((i - 1) % MOD) * (mdlo1 + mdlo2)) % MOD;

			prev2 = prev1;
			prev1 = ans;

		}

		return ans;
	}
}
