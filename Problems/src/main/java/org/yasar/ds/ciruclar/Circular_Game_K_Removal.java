package org.yasar.ds.ciruclar;

import java.util.List;
import java.util.stream.IntStream;

// https://www.codingninjas.com/studio/problems/predict-the-winner_1072979
// https://leetcode.com/problems/find-the-winner-of-the-circular-game/description/

//https://www.youtube.com/watch?v=gAZwWpv_GUM&list=PLDzeHZWIZsTq60eobVporukriHgBamrzK&index=3
public class Circular_Game_K_Removal {

	public static void main(String[] args) {

		System.out.println(findTheWinner(5, 2));
		System.out.println(findTheWinner(6, 5));

	}

	private static int findTheWinner(int n, int k) {

		return 1 + solve(n, k); // adding 1 for 0-index
	}

	public static int predictTheWinner(int n, int k) {
		// Initializing the winner of the game variable
		int winnerOfTheGame = 0;

		// Traversing i from 1 to N
		for (int i = 1; i <= n; i++) {
			// Updating the value of winner in each iteration
			winnerOfTheGame = (winnerOfTheGame + k) % i;
		}

		// Returning the final winner of the game
		return winnerOfTheGame + 1;
	}

	private static int solve(int n, int k) {

		if (n == 1)
			return 0;

		return (solve(n - 1, k) + k) % n;

	}

}
