package org.yasar.ds.arrays;

import java.util.Arrays;

// https://www.youtube.com/watch?v=UGY7FMHt-M8&list=PLDzeHZWIZsTomOPnCiU3J95WufjE36wsb&index=22

// https://practice.geeksforgeeks.org/problems/subset-sum-problem2014/1
public class Partition_Array_In_2_For_Equal_Sum {

	public static void main(String[] args) {

		System.out.println("Partion Possible : " + equalPartition(9, new int[] { 1, 5, 11, 5 }));
	}

	public static boolean equalPartition(int N, int arr[]) {
		int total = 0;
		for (int x : arr) {
			total += x;
		}

		if (total % 2 == 1) {
			// if s is odd, then 2-partition cannot have a odd value.
			// System.out.println("Single part with a sum is not possible");
			return false;
		}

		int target = total / 2;

		// creating 2d dp-array, due to 2-changing fields index & target
		int dp[][] = new int[arr.length][target + 1];
		for (int[] a : dp)
			Arrays.fill(a, -1);

		// return check(arr, 0, s / 2, "") ? 1 : 0;
		return checkMemoiztn(arr, 0, target, "", dp);
	}

	private static boolean checkMemoiztn(int[] arr, int x, int target, String combo, int[][] dp) {

		if (x >= arr.length || target < 0) {
			return false;
		}

		if (dp[x][target] != -1)
			return dp[x][target] == 1 ? true : false;

		if (target == 0) {
			// System.out.println(combo);
			return true;
		} else if (target < 0) {
			return false;
		}

		boolean f1 = checkMemoiztn(arr, x + 1, target - arr[x], combo + " " + arr[x], dp);
		boolean f2 = checkMemoiztn(arr, x + 1, target, combo, dp);

		dp[x][target] = f1 || f2 ? 1 : 0;
		return f1 || f2;
	}

	private static boolean check(int[] arr, int x, int current, String combo) {

		if (x >= arr.length) {
			return false;
		}

		if (current == 0) {
			// System.out.println(combo);
			return true;
		} else if (current < 0) {
			return false;
		}

		boolean f1 = check(arr, x + 1, current - arr[x], combo + " " + arr[x]);
		boolean f2 = check(arr, x + 1, current, combo);

		return f1 || f2;
	}

}
