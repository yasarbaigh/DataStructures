package org.yasar.ds.arrays;

import java.util.Arrays;
import java.util.List;

public class BuyStockAndSell_3_Limit_Transaction {

	public static void main(String[] args) {
		System.out.println("------------------------------------=");

		System.out.println(limited_BuySell(Arrays.asList(new Integer[] { 3, 3, 5, 0, 0, 3, 1, 4 }), 2));
	}

	/*
	 * Limited buy-sell he,
	 * 
	 * At each indx, we might buy/skip-(buy-later) after we might
	 * sell/skip-(sell-later) with this recursive thought below solutions are built
	 */
	public static int limited_BuySell(List<Integer> prices, int max_limit) {

		int[] ip = prices.stream().mapToInt(Integer::intValue).toArray();

		int[][][] dp = new int[ip.length + 1][2][max_limit + 1]; // ip.lenght, true/false so 2-D array

		for (int[][] a : dp)
			for (int[] b : a)
				Arrays.fill(b, -1);

		// return solveRecMultipleBuySell(0, true, ip, max_limit);
		// return solveRecMultipleBuySell_Memoiztn(0, true, ip, max_limit, dp);
		// return solveRecMultipleBuySell_Tabultn(ip, max_limit);
		return solveRecMultipleBuySell_Tabultn_Space_optimized(ip, max_limit);
	}

	public static int solveRecMultipleBuySell_Tabultn_Space_optimized(int[] ip, int max_limit) {
		int[][] currentRow = new int[2][max_limit + 1];
		int[][] nextRow = new int[2][max_limit + 1];

		for (int idx = ip.length - 1; idx >= 0; idx--) {
			for (int buyflag = 0; buyflag <= 1; buyflag++) {
				for (int limit = 1; limit <= max_limit; limit++) {

					int profit = 0;
					if (buyflag == 1) {
						int buyKaro = -ip[idx] + nextRow[0][limit];
						int skipKaro = 0 + nextRow[1][limit];

						profit = Math.max(skipKaro, buyKaro);

					} else {

						int sellKaro = ip[idx] + nextRow[1][limit - 1];
						int skipKaro = 0 + nextRow[0][limit];

						profit = Math.max(skipKaro, sellKaro);

					}
					currentRow[buyflag][limit] = profit;
				}
			}
			nextRow = currentRow;
		}

		return currentRow[1][max_limit];

	}

	public static int solveRecMultipleBuySell_Tabultn(int[] ip, int max_limit) {
		int[][][] dp = new int[ip.length + 1][2][max_limit + 1];

		for (int idx = ip.length - 1; idx >= 0; idx--) {
			for (int buyflag = 0; buyflag <= 1; buyflag++) {
				for (int limit = 1; limit <= max_limit; limit++) {

					int profit = 0;
					if (buyflag == 1) {
						int buyKaro = -ip[idx] + dp[idx + 1][0][limit];
						int skipKaro = 0 + dp[idx + 1][1][limit];

						profit = Math.max(skipKaro, buyKaro);

					} else {

						int sellKaro = ip[idx] + dp[idx + 1][1][limit - 1];
						int skipKaro = 0 + dp[idx + 1][0][limit];

						profit = Math.max(skipKaro, sellKaro);

					}
					dp[idx][buyflag][limit] = profit;
				}
			}
		}

		return dp[0][1][max_limit];

	}

	public static int solveRecMultipleBuySell_Memoiztn(int idx, boolean canBuyStock, int[] ip, int limit,
			int[][][] dp) {

		if (idx >= ip.length || limit <= 0)
			return 0;

		int flag = canBuyStock ? 1 : 0;

		if (dp[idx][flag][limit] != -1)
			return dp[idx][flag][limit];

		int profit = 0;

		if (canBuyStock) {
			int buyKaro = -ip[idx] + solveRecMultipleBuySell_Memoiztn(idx + 1, false, ip, limit, dp);
			int skipKaro = 0 + solveRecMultipleBuySell_Memoiztn(idx + 1, true, ip, limit, dp);

			profit = Math.max(skipKaro, buyKaro);

		} else {

			int sellKaro = ip[idx] + solveRecMultipleBuySell_Memoiztn(idx + 1, true, ip, limit - 1, dp);
			int skipKaro = 0 + solveRecMultipleBuySell_Memoiztn(idx + 1, false, ip, limit, dp);

			profit = Math.max(skipKaro, sellKaro);

		}

		return dp[idx][flag][limit] = profit;

	}

	public static int solveRecMultipleBuySell(int idx, boolean canBuyStock, int[] ip, int limit) {
		if (idx >= ip.length || limit <= 0)
			return 0;
		int profit = 0;
		if (canBuyStock) {
			int buyKaro = -ip[idx] + solveRecMultipleBuySell(idx + 1, false, ip, limit);
			int skipKaro = 0 + solveRecMultipleBuySell(idx + 1, true, ip, limit);

			profit = Math.max(skipKaro, buyKaro);

		} else {

			int sellKaro = ip[idx] + solveRecMultipleBuySell(idx + 1, true, ip, limit - 1);
			int skipKaro = 0 + solveRecMultipleBuySell(idx + 1, false, ip, limit);

			profit = Math.max(skipKaro, sellKaro);

		}

		return profit;

	}

}
