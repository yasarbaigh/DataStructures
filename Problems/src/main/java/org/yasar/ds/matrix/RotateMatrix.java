package org.yasar.ds.matrix;

/**
 * Rotate a Matrix by 90 degrees
 * 
 * 
 * @author Kingpin
 * 
 */
public class RotateMatrix
{
	/**
	 * Rotate a Matrix by 90 degrees eg: 1 2 3 4 5 6 7 8 9 after rotation
	 * 
	 * 3 6 9 2 5 8 1 4 7
	 */
	public static void rotateMatrix90(int[][] matrix)
	{
		int n = matrix.length, temp;
		int f = n / 2;
		int c = (int)Math.ceil(n / 2f);

		for (int x = 0; x < f; x++)
			for (int y = 0; y < c; y++)
			{
				
				temp = matrix[x][y];
				matrix[x][y] = matrix[y][n - 1 - x];
				matrix[y][n - 1 - x] = matrix[n - 1 - x][n - 1 - y];
				matrix[n - 1 - x][n - 1 - y] = matrix[n - 1 - y][x];
				matrix[n - 1 - y][x] = temp;
				
				
				
				
				/*temp = array[x][y];
				array[x][y] = array[n - 1 - x][n - 1 - y];
				array[n - 1 - x][n - 1 - y] = temp;
				
				temp = array[y][n - 1 - x];
				array[y][n - 1 - x] = array[n - 1 - x][y];
				array[n - 1 - x][y] = temp;
				*/
			}
		
		System.out.println("RotateMatrix.rotateMatrix90()");
	}

	public static void main(String[] args)
	{
		
		int n = 5, cnt = 0, i, j;
		int[][] matrix = new int[n][n];

		for (i = 0; i < n; i++)
			for (j = 0; j < n; j++)
			{
				cnt++;
				matrix[i][j] = cnt;
			}
		printMatrix(matrix);
		rotateMatrix90(matrix);
		printMatrix(matrix);
		
	}
	
	static void printMatrix(int[][] matrix)
	{
		for(int i=0;i<matrix.length ; i++)
		{
			for(int j=0; j<matrix.length ; j++)
			{
				System.out.print(matrix[i][j] + "\t");
				
			}
			System.out.println();
		}
	}
}
