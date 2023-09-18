package org.yasar.ds.ciruclar;

public class Josephlus_Circular_K_killed {

	// Method for finding the winning child.
	private static int josephus(int n, int k) {
		int sum = 0;

		// For finding out the removed
		// chairs in each iteration
		for (int i = 2; i <= n; i++) {
			sum = (sum + k) % i;
		}

		return sum + 1;
	}

	// Driver Program to test above method
	public static void main(String[] args) {
		int n = 5;
		int k = 2;

		System.out.println(josephus(5, 2));
		System.out.println(josephus(7, 4));
		System.out.println(josephus(7, 3));
	}
}