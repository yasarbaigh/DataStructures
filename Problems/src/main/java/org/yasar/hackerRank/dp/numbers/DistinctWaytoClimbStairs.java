package org.yasar.hackerRank.dp.numbers;

//https://leetcode.com/problems/climbing-stairs/description/
public class DistinctWaytoClimbStairs {

	public int climbStairs(int n) {
		// return climbRecursion(0, n);
		int[] dp = new int[n + 1];
		// return climbMemoization(0, n, dp);
		return countWaysTabulation(n);
	}

	static int countWaysTabulation(int n) {
		int dp[] = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= n; i++)
			dp[i] = dp[i - 1] + dp[i - 2];
		return dp[n];
	}

	public int climbMemoization(int at, int n, int[] dp) {
		if (at == n)
			return dp[n] = 1;

		if (at > n)
			return dp[n] = 0;

		if (dp[at] != 0)
			return dp[at];

		dp[at] = climbMemoization(at + 1, n, dp) + climbMemoization(at + 2, n, dp);

		return dp[at];

	}

	public int climbRecursion(int at, int n) {
		if (at == n)
			return 1;

		if (at > n)
			return 0;

		return climbRecursion(at + 1, n) + climbRecursion(at + 2, n);

	}
	public static void main(String[] args) {
	
		System.out.println(countWaysTabulation(3));
		System.out.println(countWaysTabulation(4));
	}
}
