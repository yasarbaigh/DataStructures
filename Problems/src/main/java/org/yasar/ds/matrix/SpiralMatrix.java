package org.yasar.ds.matrix;

public class SpiralMatrix
{
	/**
	 * one bug remains, middle of odd order matrix isnot displayed see below
	 * recursion
	 * 
	 */
	public static void spiral()
	{
		int m = 5, cnt = 0, i, j;
		int[][] array = new int[m][m];

		for (i = 0; i < m; i++)
			for (j = 0; j < m; j++)
			{
				cnt++;
				array[i][j] = cnt;
			}

		int k = 0, l = m - 1;
		while (k < (m / 2))
		{
			for (i = k; i < l; i++)
			{
				System.out.print(array[k][i] + ", ");
			}

			for (j = k; j < l; j++)
			{
				System.out.print(array[j][l] + ", ");
			}

			for (j = l; j > k; j--)
			{
				System.out.print(array[l][j] + ", ");
			}

			for (i = l; i > k; i--)
			{
				System.out.print(array[i][k] + ", ");
			}
			k++;
			l--;
		}
		
		if(m%2 !=0)
		{
			System.out.print(array[m/2][m/2] + ", ");			
		}
	}

	public static void main(String[] args)
	{
		spiral();
		
		int m =5, n=4, cnt=0;
		int[][] array = new int[m][n];

		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
			{
				cnt++;
				array[i][j] = cnt;
			}
		
		//printSpiral(array, 0);
	}

	private static void printSpiral(int[][] matrix, int depth)
	{
		if(matrix == null && matrix.length == 0)
			return;
		int rows = matrix.length;
		int cols = matrix[0].length;
		if(2 * depth > Math.min(rows, cols))
			return;
		for (int i = depth; i < cols - depth - 1; ++i)
		{
			System.out.print(matrix[depth][i] + ",");
		}
		for (int i = depth; i < rows - depth - 1; ++i)
		{
			System.out.print(matrix[i][cols - depth - 1] + ",");
		}
		for (int i = rows - depth -1; i > depth; --i)
		{
			System.out.print(matrix[rows - depth - 1][i] + ",");
		}
		for (int i = rows - depth - 1; i > depth; --i)
		{
			System.out.print(matrix[i][depth] + ",");
		}
		printSpiral(matrix, ++depth);
	}

}
