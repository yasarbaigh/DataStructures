package org.yasar;

import java.util.Arrays;

public class T2 {

}

class Solution {
	public int maxProfit(int[] ip) {
		int[][] dp = new int[ip.length + 1][2]; // ip.lenght, true/false so 2-D array

		for (int[] a : dp)
			Arrays.fill(a, -1);

		// return solveRecMultipleBuySell(0, true, ip);
		return solveRecMultipleBuySellMemoiztn(0, true, ip, dp);

		// return solveRecMultipleBuySellTabltn( ip, dp);
	}

	public static int solveRecMultipleBuySellTabltn(int[] ip, int[][] dp) {
		for (int[] a : dp)
			Arrays.fill(a, 0);

		int profit = 0;

		for (int idx = ip.length - 1; idx >= 0; idx--) {
			for (int flag = 0; flag <= 1; flag++) {

				if (flag == 1) {
					int buyKaro = -ip[idx] + dp[idx + 1][0];
					int skipKaro = 0 + dp[idx + 1][1];

					profit = Math.max(skipKaro, buyKaro);
					dp[idx][flag] = profit;

				} else {

					int sellKaro = ip[idx] + dp[idx + 1][1];
					int skipKaro = 0 + dp[idx + 1][0];

					profit = Math.max(skipKaro, sellKaro);
					dp[idx][flag] = profit;

				}
			}

		}

		return dp[0][1];

	}

	public static int solveRecMultipleBuySellMemoiztn(int idx, boolean canBuyStock, int[] ip, int[][] dp) {

		if (idx >= ip.length)
			return 0;
		int profit = 0;

		int flag = canBuyStock ? 1 : 0;

		if (dp[idx][flag] != -1)
			return dp[idx][flag];

		if (canBuyStock) {
			int buyKaro = -ip[idx] + solveRecMultipleBuySellMemoiztn(idx + 1, false, ip, dp);
			int skipKaro = 0 + solveRecMultipleBuySellMemoiztn(idx + 1, true, ip, dp);

			profit = Math.max(skipKaro, buyKaro);

		} else {

			int sellKaro = ip[idx] + solveRecMultipleBuySellMemoiztn(idx + 1, true, ip, dp);
			int skipKaro = 0 + solveRecMultipleBuySellMemoiztn(idx + 1, false, ip, dp);

			profit = Math.max(skipKaro, sellKaro);

		}

		return dp[idx][flag] = profit;
	}

	public static int solveRecMultipleBuySell(int idx, boolean canBuyStock, int[] ip) {

		if (idx >= ip.length)
			return 0;
		int profit = 0;
		if (canBuyStock) {
			int buyKaro = -ip[idx] + solveRecMultipleBuySell(idx + 1, false, ip);
			int skipKaro = 0 + solveRecMultipleBuySell(idx + 1, true, ip);

			profit = Math.max(skipKaro, buyKaro);

		} else {

			int sellKaro = ip[idx] + solveRecMultipleBuySell(idx + 1, true, ip);
			int skipKaro = 0 + solveRecMultipleBuySell(idx + 1, false, ip);

			profit = Math.max(skipKaro, sellKaro);

		}
		return profit;

	}
}