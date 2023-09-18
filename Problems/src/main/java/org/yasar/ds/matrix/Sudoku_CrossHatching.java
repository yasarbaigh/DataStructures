package org.yasar.ds.matrix;

//Java code
import java.util.*;

public class Sudoku_CrossHatching {

	public static void main(String[] args) {
		char[][] brd1 = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

		solve(brd1, 0, 0);
		for (char[] row : brd1)
			System.out.println(Arrays.toString(row));
	}

	private static boolean solve(char[][] board, int row, int col) {
		// Base case: If row is equal to board length, entire board has been filled
		if (row == board.length) {
			return true;
		}

		// Move to next row when current row is fully filled
		if (col == board[0].length) {
			return solve(board, row + 1, 0);
		}

		// Skip cells that are already filled
		if (board[row][col] != '.') {
			return solve(board, row, col + 1);
		}

		// Try different numbers in current cell
		for (char num = '1'; num <= '9'; num++) {
			if (isValidPlacement(board, row, col, num)) {
				board[row][col] = num; // Fill current cell with valid number

				// Move to next cell
				if (solve(board, row, col + 1)) {
					return true;
				}

				// Backtrack to previous state if solution not found
				board[row][col] = '.';
			}
		}

		// No valid solution found
		return false;
	}

	private static boolean isValidPlacement(char[][] board, int row, int col, char num) {
		// Check if num is already in the same row, column or 3x3 subgrid
		for (int i = 0; i < board.length; i++) {
			// Check row
			if (board[i][col] == num) {
				return false;
			}

			// Check column
			if (board[row][i] == num) {
				return false;
			}
		}

		int subgridRow = 3 * (row / 3);
		int subgridCol = 3 * (col / 3);

		for (int i = subgridRow; i < subgridRow + 3; i++) {
			for (int j = subgridCol; j < subgridCol + 3; j++) {
				if (board[i][j] == num) {
					return false;
				}
			}
		}

		// Placement is valid
		return true;
	}
}
