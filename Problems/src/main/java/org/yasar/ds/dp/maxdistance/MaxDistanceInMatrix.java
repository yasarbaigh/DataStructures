package org.yasar.ds.dp.maxdistance;

//https://www.geeksforgeeks.org/find-the-longest-path-in-a-matrix-with-given-constraints/

/**
 * 
 * Given a n*n matrix where all numbers are distinct, find the maximum length
 * path (starting from any cell) such that all cells along the path are in
 * increasing order with a difference of 1.
 * 
 * We can move in 4 directions from a given cell (i, j),
 * 
 * i.e., we can move to (i+1, j) or (i, j+1) or (i-1, j) or (i, j-1) with the
 * condition that the adjacent cells have a difference of 1.
 * 
 * Example:
 * 
 * Input: mat[][] = {{1, 2, 9} {5, 3, 8} {4, 6, 7}} Output: 4 The longest path
 * is 6-7-8-9.
 * 
 * 
 * @author kingpin
 *
 */
public class MaxDistanceInMatrix {

	int[][] mat;
	int n;

	public MaxDistanceInMatrix(int[][] myMatrix) {
		this.mat = myMatrix;
		this.n = myMatrix.length;
	}

	int findLongestFromACell(int i, int j, int dp[][]) {
		// Base case
		if (i < 0 || i >= n || j < 0 || j >= n)
			return 0;

		// If this subproblem is already solved
		if (dp[i][j] != -1)
			return dp[i][j];

		// Since all numbers are unique and in range from 1 to n*n,
		// there is atmost one possible direction from any cell

		// checking right
		if (j < n - 1 && ((mat[i][j] + 1) == mat[i][j + 1]))
			return dp[i][j] = 1 + findLongestFromACell(i, j + 1, dp);

		// checking left
		if (j > 0 && (mat[i][j] + 1 == mat[i][j - 1]))
			return dp[i][j] = 1 + findLongestFromACell(i, j - 1, dp);

		// checking top
		if (i > 0 && (mat[i][j] + 1 == mat[i - 1][j]))
			return dp[i][j] = 1 + findLongestFromACell(i - 1, j, dp);

		// checking bottom
		if (i < n - 1 && (mat[i][j] + 1 == mat[i + 1][j]))
			return dp[i][j] = 1 + findLongestFromACell(i + 1, j, dp);

		// If none of the adjacent fours is one greater
		return dp[i][j] = 1;
	}

	// Function that returns length of the longest path
	// beginning with any cell
	public int finLongestOverAll() {
		// Initialize result
		int result = 1;

		// Create a lookup table and fill all entries in it as -1
		int[][] dp = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				dp[i][j] = -1;

		// Compute longest path beginning from all cells
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (dp[i][j] == -1)
					findLongestFromACell(i, j, dp);

				// Update result if needed
				result = Math.max(result, dp[i][j]);
			}
		}

		return result;
	}

	public static void main(String[] args) {

		// int mat[][] = { { 1, 2, 9 }, { 5, 3, 8 }, { 4, 6, 7 } };

		int mat[][] = { { 1, 15, 16, 14 }, { 2, 3, 4, 13 }, { 7, 6, 5, 12 }, { 8, 9, 10, 11 } };

		MaxDistanceInMatrix objt = new MaxDistanceInMatrix(mat);

		System.out.println("Length of the longest path is " + objt.finLongestOverAll());

	}

}