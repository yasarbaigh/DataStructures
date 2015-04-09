package org.yasar.ds.matrix;

public class BitSet
{
	/**
	 * 
	 * http://stackoverflow.com/questions/339262/best-algorithm-for-this-interview-problem
	 * 
	 * Given a NxN matrix with 0s and 1s. 
	 * Set every row that contains a 0 to all 0s and set every column that contains a 0 to all 0s.
	 * 
	 * 
	 * A Microsoft Engineer told me that there is a solution that involves no extra memory, 
	 * just two boolean variables and one pass, so I'm looking for that answer.
	 * @param args
	 */
	public static void main(String[] args)
	{
		int [][]mtrx = {{ 1, 0, 1, 1, 0 }, 
						{ 0, 1, 1, 1, 0 }, 
						{ 1, 1, 1, 1, 1 }, 
						{ 1, 0, 1, 1, 1 },
						{ 1, 1, 1, 1, 1 }};
		
		processMatrix(mtrx);
	}
	
	static void processMatrix(int[][] mtrx)
	{
		int dim = mtrx.length;

		for (int j = 0; j < dim; j++)
		{
			for (int i = 0; i < dim; i++)
			{
				System.out.print(
						(mtrx[0][j] & mtrx[1][j] & mtrx[2][j] & mtrx[3][j] & mtrx[4][j]) &
						(mtrx[i][0] & mtrx[i][1] & mtrx[i][2] & mtrx[i][3] & mtrx[i][4]));
			}
			System.out.println();
		}
	}

}
