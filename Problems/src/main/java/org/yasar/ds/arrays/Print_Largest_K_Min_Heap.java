package org.yasar.ds.arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Print_Largest_K_Min_Heap {

	public static void main(String[] args) {
		int arr[] = { 1, 23, 12, 9, 30, 2, 50, 12, 12, 23, 1, 30, 30, 50, 25 };

		OutputArr(arr, 4);

		System.out.println(simple_Min_Heap(arr, 4));

	}

	/**
	 * Adding all elements, similarly if its getter than k, removing
	 * 
	 * @param arr
	 * @param k
	 * @return
	 */
	private static PriorityQueue<Integer> simple_Min_Heap(int[] arr, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int x : arr) {

			
			minHeap.add(x);
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}

		return minHeap;
	}

	static void printLargestK(int[] arr, int n, int k) {
		buildMaxHeap(arr, n);
		System.out.println("K largest are: ");
		for (int i = 0; i < k; i++)
			System.out.println(heapExtractMax(arr, n) + ", ");
	}

	static void buildMaxHeap(int[] arr, int n) {
		for (int i = n / 2 - 1; i >= 0; i--)
			heapifyMax(arr, n, i);
	}

	static void heapifyMax(int[] arr, int n, int i) {
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int largest = i;
		if (left < n && arr[left] > arr[largest])
			largest = left;
		if (right < n && arr[right] > arr[largest])
			largest = right;
		if (largest != i) {
			swap(arr, i, largest);
			heapifyMax(arr, n, largest);
		}
	}

	static int heapExtractMax(int[] arr, int n) {
		int temp = arr[0];
		arr[0] = arr[n - 1];
		n = n - 1;
		heapifyMax(arr, n, 0);
		return temp;
	}

	static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
		return;
	}

	/*
	 * private static void swap(int [] numArray, int i, int j) { int temp =
	 * numArray[i]; numArray[i] = numArray[j]; numArray[j] = temp; }
	 */
	static void OutputArr(int[] arr, int K) {

		printLargestK(arr, arr.length, K);
		/*
		 * for (int i = 0; i < arr.length; i++) System.out.print(arr[i] +", ");
		 * 
		 * System.out.println();
		 */

	}

}