package org.yasar.hackerRank.dp.numbers;

import java.util.ArrayList;
import java.util.Arrays;

// https://www.codingninjas.com/studio/problems/0-1-knapsack_1072980?leftPanelTab=0
//https://www.youtube.com/watch?v=xdPv2SZJLVI&list=PLDzeHZWIZsTomOPnCiU3J95WufjE36wsb&index=9
public class KnapSnackThiefWeigh {

	public static int solveRecursion(ArrayList<Integer> values, ArrayList<Integer> weights, int i, int capacity) {

		// Base-Case
		if (i == 0) {

			if (capacity >= weights.get(i)) {
				return values.get(i);
			} else {
				return 0;
			}
		}

		int v1 = 0, v2 = 0;

		if (capacity >= weights.get(i)) {
			v1 = values.get(i) + solveRecursion(values, weights, i - 1, capacity - weights.get(i));
		}

		v2 = solveRecursion(values, weights, i - 1, capacity);

		return Math.max(v1, v2);

	}

	public static int solveMemoiztn(ArrayList<Integer> values, ArrayList<Integer> weights, int i, int capacity,
			int[][] dp) {

		// Base-Case
		if (i == 0) {

			if (capacity >= weights.get(i)) {
				return values.get(i);
			} else {
				return 0;
			}
		}

		// Memoiztn
		if (dp[i][capacity] != -1)
			return dp[i][capacity];

		int v1 = 0, v2 = 0;

		if (capacity >= weights.get(i)) {
			v1 = values.get(i) + solveMemoiztn(values, weights, i - 1, capacity - weights.get(i), dp);
		}

		v2 = solveMemoiztn(values, weights, i - 1, capacity, dp);

		return dp[i][capacity] = Math.max(v1, v2);

	}

	public static int solveTablrztn(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int capacity) {

		int[][] dp = new int[n][capacity + 1];

		// Base-Case
		for (int j = 0; j <= capacity; j++) {
			if (weights.get(0) <= j) {
				dp[0][j] = values.get(0);
			} else {
				dp[0][j] = 0;
			}
		}

		int v1, v2;
		for (int p = 1; p < n; p++) {
			for (int q = 0; q <= capacity; q++) {

				v1 = 0;
				if (weights.get(p) <= q)
					v1 = values.get(p) + (dp[p - 1][q - weights.get(p)]);

				v2 = dp[p - 1][q];
				dp[p][q] = Math.max(v1, v2);
			}
		}

		return dp[n - 1][capacity];

	}

	public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
		// Write your code here.
		// return solveRecursion(values, weights,n-1, w);

		int[][] dp = new int[n][w + 1];

		for (int[] r : dp)
			Arrays.fill(r, -1);
		return solveMemoiztn(values, weights, n - 1, w, dp);

		// return solveTablrztn(values, weights, n-1, w);

	}
}
