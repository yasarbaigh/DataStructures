package org.yasar.ds.matrix.subsquare;

import java.util.HashMap;
import java.util.Map;

class MutableInt {
	private int maxSize = 0;

	MutableInt(int i) {
		maxSize = i;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}
}
public class LargestSubMatrixof1 {


	

	
		// Function to find the size of largest square sub-matrix of 1's
		// present in the given binary matrix
		public static int findLargestSquare(int[][] M, int m, int n,
											MutableInt maxSize)
		{
			// base condition
			if (m == 0 || n == 0) {
				return M[m][n];
			}

			// find largest square matrix ending at M[m][n-1]
			int left = findLargestSquare(M, m, n - 1, maxSize);

			// find largest square matrix ending at M[m-1][n]
			int top = findLargestSquare(M, m - 1, n, maxSize);

			// find largest square matrix ending at M[m-1][n-1]
			int diagonal = findLargestSquare(M, m - 1, n - 1, maxSize);

			// largest square matrix ending at M[m][n] will be 1 plus
			// minimum of largest square matrix ending at M[m][n-1],
			// M[m-1][n] and M[m-1][n-1]

			int size = 0;
			if (M[m][n] != 0) {
				size = 1 + Integer.min(Integer.min(top, left), diagonal);
			}

			// update maximum size found so far
			maxSize.setMaxSize(Integer.max(maxSize.getMaxSize(), size));

			// return the size of largest square matrix ending at M[m][n]
			return size;
		}

		// main function
		public static void main(String[] args)
		{
			int[][] M =
			{
				/*{ 0, 0, 1, 0, 1, 1 },
				{ 0, 1, 1, 1, 0, 0 },
				{ 0, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 0, 1, 1 }*/
					
					
					{1, 0, 1},
					{0, 1, 1,},
					{1, 1, 1}
			};

			// size stores the size of largest square sub-matrix of 1's
			// and it is passed by reference
			MutableInt size = new MutableInt(0);

			findLargestSquare(M, M.length - 1, M[0].length - 1, size);
			System.out.print("The size of largest square sub-matrix of 1's is "
							+ size.getMaxSize());
		}
	}

