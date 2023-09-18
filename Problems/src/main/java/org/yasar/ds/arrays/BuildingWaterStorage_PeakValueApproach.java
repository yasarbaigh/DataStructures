package org.yasar.ds.arrays;

// https://youtu.be/apCqNG2EXq4

// https://www.codingninjas.com/studio/problems/trapping-rainwater_630519?leftPanelTab=2https://www.codingninjas.com/studio/problems/trapping-rainwater_630519?leftPanelTab=2
public class BuildingWaterStorage_PeakValueApproach {

	public static void main(String[] args) {
		System.out.println(getTrappedWater(new long[] { 2, 1, 1, 4 }, 4));
		System.out.println(getTrappedWater(new long[] { 8, 1, 8, 2, 4 }, 5));

		System.out.println(getTrappedWater(new long[] { 2, 10, 3, 4, 12, 13, 14, 6, 3, 10, 6 }, 11));

		System.out.println(getTrappedWater(new long[] { 5, 1, 14, 12, 6, 4, 4, 2, 12, 3, 5 }, 11));

		System.out.println(getTrappedWater(new long[] { 12, 12, 5, 4, 13, 10, 4, 12, 3, 10 }, 11));

	}

	public static long getTrappedWater(long[] arr, int n) {

		/*
		 * Peak value approrach
		 * 
		 * 
		 * Time O-N ,space 1
		 */

		// Reference point.
		long peak = 0;

		// Result.
		long ans = 0;
		n = arr.length;
		if (n == 0) {
			return 0;
		}

		long peakVal = arr[0];

		// Moving left to right.
		for (int i = 0; i < n; i++) {
			if (arr[i] >= peakVal) {
				peak = i;
				peakVal = arr[i];
			}
		}

		// Initializing a min value.
		long maxSoFar = Long.MIN_VALUE;
		long countSubmerged = 0;
		long submergedArea = 0;

		// Traversing over a peak.
		for (int i = 0; i <= peak; i++) {
			if (arr[i] >= maxSoFar) {

				// Calculation.
				ans += (countSubmerged * maxSoFar - submergedArea);
				maxSoFar = arr[i];
				countSubmerged = 0;
				submergedArea = 0;
			} else {
				submergedArea += arr[i];
				countSubmerged++;
			}
		}

		// Initializing a min value.
		maxSoFar = Long.MIN_VALUE;
		countSubmerged = 0;
		submergedArea = 0;

		// Moving right to left.
		for (int i = n - 1; i >= peak; i--) {
			if (arr[i] >= maxSoFar) {

				// Calculation.
				ans += (countSubmerged * maxSoFar - submergedArea);
				maxSoFar = arr[i];
				countSubmerged = 0;
				submergedArea = 0;
			} else {
				submergedArea += arr[i];
				countSubmerged++;
			}
		}

		return ans;
	}

	public static long getTrappedWater_HugeSpace(long[] arr, int n) {
		/*
		 * Left max right max approach time
		 * 
		 * o-3n, space o-2n
		 */
		// Base case.
		if (n == 0) {
			return 0;
		}

		// Result.
		long totalWaterStored = 0;

		// Storing leftMax and rightMax.
		long[] leftMax = new long[n];
		long[] rightMax = new long[n];

		leftMax[0] = arr[0];

		// Filling leftMax.
		for (int i = 1; i < n; i++) {
			leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
		}

		rightMax[n - 1] = arr[n - 1];

		// Filling rightMax.
		for (int i = n - 2; i >= 0; i--) {
			rightMax[i] = Math.max(arr[i], rightMax[i + 1]);
		}

		// Calculate result.
		for (int i = 1; i < n - 1; i++) {
			totalWaterStored += Math.min(rightMax[i], leftMax[i]) - arr[i];
		}

		return totalWaterStored;
	}

}
