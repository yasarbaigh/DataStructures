package org.yasar.ds.arrays_2;

public class From_2_Aray_Combine_And_Sort_In_1_Array {

	public static void getSortedArr(int ArrA[], int ArrB[], int output[], int i, int j, int m, int n, int len,
			boolean isSelectFromArrA) {
		if (isSelectFromArrA) {
			if (len != 0)
				printArray(output, len + 1);
			for (int k = i; k < m; k++) {
				if (len == 0) {
					output[len] = ArrA[k];
					getSortedArr(ArrA, ArrB, output, k + 1, j, m, n, len, !isSelectFromArrA);
				} else {
					if (ArrA[k] > output[len]) {
						output[len + 1] = ArrA[k];
						getSortedArr(ArrA, ArrB, output, k + 1, j, m, n, len + 1, !isSelectFromArrA);
					}
				}
			}
		} else {
			for (int l = j; l < n; l++) {
				if (ArrB[l] > output[len]) {
					output[len + 1] = ArrB[l];
					getSortedArr(ArrA, ArrB, output, i, l + 1, m, n, len + 1, !isSelectFromArrA);
				}
			}
		}
	}

	public static void generate(int ArrA[], int ArrB[], int m, int n) {
		m = ArrA.length;
		n = ArrB.length;
		int output[] = new int[m + n];
		getSortedArr(ArrA, ArrB, output, 0, 0, m, n, 0, true);

		System.out.println("----------------");
	}

	public static void printArray(int arr[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		System.out.println();

	}

	public static void main(String[] args) {
		int ArrA[] = { 9, 12, 66 };
		int ArrB[] = { 10, 15, 25 };
		int n = ArrA.length;
		int m = ArrB.length;
		generate(ArrA, ArrB, n, m);

		generate(new int[] { 1, 5, 20, 30 }, new int[]  { 10, 15, 25 } , 0, 0);
	}
}
