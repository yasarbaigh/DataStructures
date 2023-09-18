package org.yasar.ds.string;

// https://www.codingninjas.com/studio/problems/word-search_630520?leftPanelTab=3
public class CrossWordCountRepeatedString {

	static int R, C;
	static int[] x = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] y = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) {
		String[] grid1 = { "RIAN", "IAIR", "AIRI" };

		System.out.println("AIR is found " + wordSearch(grid1, "AIR") + " times.");
	}

	public static int wordSearch(String grid[], String word) {
		R = grid.length;
		C = grid[0].length();
		char[][] cGrid = new char[R][C];

		int i = 0, j = 0;
		for (String s : grid) {
			for (j = 0; j < s.length(); j++)
				cGrid[i][j] = s.charAt(j);
			i++;
		}

		char c1 = word.charAt(0);
		int cnt = 0;
		for (i = 0; i < R; i++) {
			for (j = 0; j < C; j++) {
				if (cGrid[i][j] == c1) {
					cnt += search2D(cGrid, i, j, word);
				}
			}
		}
		return cnt;
	}

	// This function searches in all
	// 8-direction from point
	// (row, col) in grid[][]
	public static int search2D(char[][] grid, int row, int col, String word) {
		// If first character of word
		// doesn't match with
		// given starting point in grid.
		int cnt = 0;
		if (grid[row][col] != word.charAt(0))
			return 0;

		int len = word.length();

		// Search word in all 8 directions
		// starting from (row, col)
		for (int dir = 0; dir < 8; dir++) {
			// Initialize starting point
			// for current direction
			int k, rd = row + x[dir], cd = col + y[dir];

			// First character is already checked,
			// match remaining characters
			for (k = 1; k < len; k++) {
				// If out of bound break
				if (rd >= R || rd < 0 || cd >= C || cd < 0)
					break;

				// If not matched, break
				if (grid[rd][cd] != word.charAt(k))
					break;

				// Moving in particular direction
				rd += x[dir];
				cd += y[dir];
			}

			// If all character matched,
			// then value of must
			// be equal to length of word
			if (k == len)
				cnt++;
		}
		return cnt;
	}

}