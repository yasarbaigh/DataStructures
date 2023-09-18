package org.yasar.ds.matrix;

import java.util.HashSet;
import java.util.Set;

public class AppleContinousChainOfNumbers {

	public static void main(String[] args) {
		int[][] a = new int[][] { { 1, 16, 14, 15 }, { 2, 3, 11, 13 }, { 12, 4, 9, 8 }, { 10, 5, 6, 7 } };

		int m = 4, n = 4;

		Set<String> op = new HashSet<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				op.add(findSnake(a, i, j, m, n));
			}
		}
		System.out.println(op);
	}

	private static String findSnake(int[][] a, int i, int j, int m, int n) {

		String op = a[i][j] + "-";
		int next = a[i][j] + 1;

		int x = i, y = j;

		boolean goAhaed = true, adjacnt = false;
		while (goAhaed) {
			int previous = next;
			if (i + 1 < m && a[i + 1][j] == next) {

				i = i + 1;
				next++;
			} else if (i - 1 > 0 && a[i - 1][j] == next) {

				i = i - 1;
				next++;
			} else if (j - 1 > 0 && a[i][j - 1] == next) {

				j = j - 1;
				next++;
			} else if (j + 1 < n && a[i][j + 1] == next) {
				j = j + 1;
				next++;
			}

			if (previous != next) {
				// adjacent element
				op +=   a[i][j] + "-";
				adjacnt = true;

			} else {
				goAhaed = false;
			}
		}

		return adjacnt ? op : "";

	}

}
