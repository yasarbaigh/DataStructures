package org.yasar.ds.matrix;

public class SmallestRowHighestCol
{

	public static int specialElement(int[][] matrix)
	{
		int row = matrix.length;
		int min;
		for (int i = 0; i < row; i++) {
			// FINDING MINIMUM IN EACH ROW//
			min = matrix[i][0];
			for (int j = 1; j < matrix[i].length; j++) {
				if(min > matrix[i][j]) {
					min = matrix[i][j];
				}
			}// END//

			int k;
			for (int j = 0; j < matrix[i].length; j++) {
				if(min == matrix[i][j]) {
					// CHECK IF THE SELECTED MIN, IS THE GREATEST IN THE
					// CORRESPONDING COLUMN//
					for (k = 0; k < row; k++) {
						if(min < matrix[k][j])
							break;
					}

					if(k == row)
						return min;

				}
			}

		}
		return -1;
	}
}
