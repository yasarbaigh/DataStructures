package org.yasar.other;

//	http://ideone.com/2ecUuD


public class WaterGlass {

	static float total_water = 50;
	static int N = 20;
	static glass[][] pyramid = new glass[N][N];

	public static void main(String[] args) {
		build_pyramid();
		pour_water(0, 0, total_water);
		print_pyramid();
		print_total_water_stored();
	}

	private static void print_total_water_stored() {
		float total = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++)
				total += pyramid[i][j].filled;
		}
		System.out.println("total water stored= " + total);
	}

	private static void pour_water(int row, int col, float water) {
		if (water >= (pyramid[row][col].capacity - pyramid[row][col].filled)) {
			water -= (pyramid[row][col].capacity - pyramid[row][col].filled);
			pyramid[row][col].filled = pyramid[row][col].capacity;
			pour_water(row + 1, col, water / 2);
			pour_water(row + 1, col + 1, water / 2);
		} else {
			pyramid[row][col].filled += water;
		}
	}

	public static void build_pyramid() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				pyramid[i][j] = new glass(1);
		}
	}

	public static void print_pyramid() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++)
				System.out.print(pyramid[i][j].filled + " ");
			System.out.println();
		}
	}
}

class glass {
	float capacity;
	float filled;

	glass(float cap) {
		capacity = cap;
		filled = 0;
	}
}
