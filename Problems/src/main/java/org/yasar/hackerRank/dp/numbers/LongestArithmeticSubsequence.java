package org.yasar.hackerRank.dp.numbers;

import java.util.Arrays;

//https://www.youtube.com/watch?v=YaMcX7sem70&list=PLDzeHZWIZsTomOPnCiU3J95WufjE36wsb&index=24

// https://practice.geeksforgeeks.org/problems/longest-arithmetic-progression1019/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
public class LongestArithmeticSubsequence {

	public static void main(String[] args) {

		System.out.println(getLongSequence(new int[] { 1, 7, 10, 13, 14, 19 }));
		System.out.println(getLongSequenceBottomUp(new int[] { 1, 7, 10, 13, 14, 19 }));
	}

	static int getLongSequenceBottomUp(int[] A) {

		// a+2d , a+3d, a+4d
		// a+2d + a+4d = 2(a+3d) formula
		int ans = 2;
		int n = A.length;
		if (n <= 2)
			return n;

		int[] llap = new int[n];
		for (int i = 0; i < n; i++)
			llap[i] = 2;

		Arrays.sort(A);

		for (int j = n - 2; j >= 0; j--) {
			int i = j - 1;
			int k = j + 1;
			while (i >= 0 && k < n) {
				if (A[i] + A[k] == 2 * A[j]) { // a+2d + a+4d = 2(a+3d) formula this is checked here
					llap[j] = Math.max(llap[k] + 1, llap[j]);
					ans = Math.max(ans, llap[j]);
					i -= 1;
					k += 1;
				} else if (A[i] + A[k] < 2 * A[j])
					k += 1;
				else
					i -= 1;
			}
		}
		return ans;
	}

	// T- o-N2
	private static int getLongSequence(int[] ip) {
		if (ip.length <= 2)
			return ip.length;

		int ans = 0;
		for (int i = 0; i < ip.length; i++) {
			for (int j = i + 1; j < ip.length; j++) {

				ans = Math.max(ans, 2 + checkPreviousArithmeticNumbrs(i, ip[j] - ip[i], ip));

			}
		}
		return ans;

	}

	private static int checkPreviousArithmeticNumbrs(int idx, int diff, int[] ip) {

		if (idx < 0)
			return 0;
		int ans = 0;
		for (int k = idx - 1; k >= 0; k--) {

			if (ip[idx] - ip[k] == diff) {
				// ans = Math.max(ans, 1 + checkPreviousArithmeticNumbrs(k, diff, ip));
				ans++;
				idx = k;

			}

		}

		return ans;
	}

}
