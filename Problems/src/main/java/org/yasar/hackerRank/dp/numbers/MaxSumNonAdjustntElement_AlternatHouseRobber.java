package org.yasar.hackerRank.dp.numbers;

import java.util.Arrays;

public class MaxSumNonAdjustntElement_AlternatHouseRobber {

	public static int rob(int[] nums) {

		int[] dp = new int[nums.length + 1];
		Arrays.fill(dp, -1);
		return calcualteRecursionDP(nums, 0, dp);
		// return calcualteRecursion(nums, 0);

	}

	public static int calcualteRecursion(int[] nums, int x) {
		if (x >= nums.length) {
			return 0;
		}

		int step_2 = 0;
		if (x + 1 < nums.length) {
			step_2 = nums[x + 1] + calcualteRecursion(nums, x + 3);
		}

		return Math.max(nums[x] + calcualteRecursion(nums, x + 2), step_2);
	}

	public static int calcualteRecursionDP(int[] nums, int x, int[] dp) {

		if (x >= nums.length) {
			return 0;
		}
		if (dp[x] != -1) {
			return dp[x];
		}

		int step_2 = 0;
		if (x + 1 < nums.length) {
			step_2 = nums[x + 1] + calcualteRecursionDP(nums, x + 3, dp);
		}

		return dp[x] = Math.max(nums[x] + calcualteRecursionDP(nums, x + 2, dp), step_2);
	}

	public static void main(String[] args) {
		int[] a1 = { 2, 1, 1, 2 };
		System.out.println(rob(a1));
	}
}
