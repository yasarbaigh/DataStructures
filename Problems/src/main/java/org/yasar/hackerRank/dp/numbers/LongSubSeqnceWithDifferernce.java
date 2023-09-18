package org.yasar.hackerRank.dp.numbers;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/description/

//https://www.youtube.com/watch?v=IOOFHFXenQU&list=PLDzeHZWIZsTomOPnCiU3J95WufjE36wsb&index=25
public class LongSubSeqnceWithDifferernce {

	public static void main(String[] args) {

		System.out.println(longestSubsequence(new int[] { 1, 2, 3, 4 }, 1));
		System.out.println(longestSubsequence(new int[] { 1, 5, 7, 8, 5, 3, 4, 2, 1 }, -2));
	}

	public static int longestSubsequence(int[] arr, int difference) {
		/*
		 * createing a dp map, with KEY AS current_element - diference, VALUE-AS 1+(previsou_element_diff)
		 */
		int ans = 0;

		Map<Integer, Integer> mp = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {

			int temp = arr[i] - difference;

			int cnt = 1 + mp.getOrDefault(temp, 0);
			mp.put(arr[i], cnt);

			ans = Math.max(ans, cnt);

		}
		return ans;
	}
}
