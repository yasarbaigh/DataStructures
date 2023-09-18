package org.yasar.ds.arrays;

import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

// https://www.youtube.com/watch?v=BSRTUtvJSIk&list=PLDzeHZWIZsTomOPnCiU3J95WufjE36wsb&index=29

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

// https://www.youtube.com/watch?v=dlKGCNVel6A&list=PLDzeHZWIZsTomOPnCiU3J95WufjE36wsb&index=30
public class BuyStockAndSell_1_2 {

	public static void main(String[] args) {

		System.out.println(maximumProfit(Arrays.asList(new Integer[] { 1, 2, 3, 4 })));

		System.out.println(maximumProfit(Arrays.asList(new Integer[] { 7, 1, 5, 3, 6, 4 })));

		System.out.println("------------------------------------=");

		System.out.println(mutipleBuySell(Arrays.asList(new Integer[] { 7, 1, 5, 3, 6, 4 })));
	}

	/*
	 * Single Buy-Sell
	 */
	public static int maximumProfit(List<Integer> prices) {
		int buy = Integer.MAX_VALUE;

		int max_profit = 0;
		for (Integer x : prices) {

			if (x.intValue() < buy) {
				buy = x.intValue();
			}

			if ((x.intValue() - buy) > max_profit) {
				max_profit = x.intValue() - buy;
			}
		}

		return max_profit;
	}

	/*
	 * Multi buy-sell,
	 * 
	 * At each indx, we might buy/skip-(buy-later) after we might
	 * sell/skip-(sell-later) with this recursive thought below solutions are built
	 */
	public static int mutipleBuySell(List<Integer> prices) {

		int[] ip = prices.stream().mapToInt(Integer::intValue).toArray();

		int[][] dp = new int[ip.length + 1][2]; // ip.lenght, true/false so 2-D array

		for (int[] a : dp)
			Arrays.fill(a, -1);

		// return solveRecMultipleBuySell(0, true, ip);
		// return solveRecMultipleBuySellMemoiztn(0, true, ip, dp);
		// return solveRecMultipleBuySellTabltn(ip, dp);
		return solveRecMultipleBuySellTabltn_Space_Optimized(ip, dp);
	}

	public static int solveRecMultipleBuySellTabltn_Space_Optimized(int[] ip, int[][] dp) {
		/**
		 * T= O-N S=O-1 fixed space
		 * 
		 * insead of dp[n][2] is replaced with nextRow[2], currentRow[2]
		 */
		for (int[] a : dp)
			Arrays.fill(a, 0);

		int profit = 0;

		// int flag = canBuyStock ? 1 : 0;
		int[] nextRow = new int[2];
		int[] currentRow = new int[2];

		for (int idx = ip.length - 1; idx >= 0; idx--) {
			for (int flag = 0; flag <= 1; flag++) {

				if (flag == 1) {
					int buyKaro = -ip[idx] + nextRow[0];
					int skipKaro = 0 + nextRow[1];

					profit = Math.max(skipKaro, buyKaro);
					currentRow[flag] = profit;

				} else {

					int sellKaro = ip[idx] + nextRow[1];
					int skipKaro = 0 + nextRow[0];

					profit = Math.max(skipKaro, sellKaro);
					currentRow[flag] = profit;

				}
			}

			nextRow = currentRow;

		}

		// its decided tat return will idx 0,1 due to for recursion we pass , 0,buy-true
		// value;
		return currentRow[1];

	}

	public static int solveRecMultipleBuySellTabltn(int[] ip, int[][] dp) {
		/*
		 * T= O-N S=O-N
		 */
		for (int[] a : dp)
			Arrays.fill(a, 0);

		int profit = 0;

		// int flag = canBuyStock ? 1 : 0;

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

		// its decided tat return will idx 0,1 due to for recursion we pass , 0,buy-true
		// value;
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
			// since bought, flag is modified to false.
			int buyKaro = -ip[idx] + solveRecMultipleBuySellMemoiztn(idx + 1, false, ip, dp);

			// since skip, flag BUY is retained
			int skipKaro = 0 + solveRecMultipleBuySellMemoiztn(idx + 1, true, ip, dp);

			profit = Math.max(skipKaro, buyKaro);

		} else {
			// since sold, flag SELL modified to BUY-TRUE
			int sellKaro = ip[idx] + solveRecMultipleBuySellMemoiztn(idx + 1, true, ip, dp);

			// since skip, flag SELL-false is retained
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
