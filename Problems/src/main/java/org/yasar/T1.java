package org.yasar;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class T1 {

	public static void main(String[] args) {

		int[] myIntArray = new int[3]; // each element of the array is initialised to 0
		int[] myIntArray1 = { 1, 2, 3 };
		int[] arr = new int[] { 1, 3, 5, 6, 7, 8, 3 };

		int[] myIntArray11 = IntStream.range(0, 100).toArray(); // From 0 to 99
		int[] myIntArray12 = IntStream.rangeClosed(0, 100).toArray(); // From 0 to 100
		int[] myIntArray13 = IntStream.of(12, 25, 36, 85, 28, 96, 47).toArray(); // The order is preserved.
		int[] myIntArray14 = IntStream.of(12, 25, 36, 85, 28, 96, 47).sorted().toArray();

		int[][] num = new int[5][2];

		predicateExample();
		maxMinElement();

		List<Integer> longest_path = new ArrayList<>();
		Collections.reverse(longest_path);

		// PriorityQueue<Integer> pq = new PriorityQueue<>(new PQDescComparator());
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer x, Integer y) {
				// desc comparator
				return (x > y) ? -1 : ((x == y) ? 0 : 1);
			}
		});
		pq.add(22);
		pq.add(24);
		pq.add(2);
		pq.add(022);
		pq.add(212);
		pq.add(2012);

		System.out.println(pq);
		System.out.println("max \t " + Math.max(5, 5));

		Queue<int[]> weekly_q = new ArrayDeque<>();
		int[] t = { 4, 5 };
		weekly_q.add(t);
		int[] t1 = { 45, 44 };
		weekly_q.add(t1);

		System.out.println(weekly_q);
		System.out.println(weekly_q.peek()[1]);

		printArr(t1);
		rec(t1);
		printArr(t1);

	}

	private static void maxMinElement() {
		Integer highest = Stream.of(1, 2, 3, 77, 6, 5).max(Comparator.comparing(Integer::valueOf)).get();


		Integer lowest = Stream.of(1, 2, 3, 77, 6, 5).min(Comparator.comparing(Integer::valueOf)).get();

	}

	private static void predicateExample() {
		Predicate<Integer> greaterThanTen = (i) -> i > 10;

		// Creating predicate
		Predicate<Integer> lowerThanTwenty = (i) -> i < 20;
		boolean result = greaterThanTen.and(lowerThanTwenty).test(15);
		System.out.println(result);

		// Calling Predicate method
		boolean result2 = greaterThanTen.and(lowerThanTwenty).negate().test(15);
		System.out.println(result2);

		greaterThanTen.test(1);

	}

	public static void printArr(int[] arr) {
		for (int a : arr) {
			System.out.print(a + "\t");
		}
		System.out.println();
	}

	public static int rec(int[] n) {

		for (int i = 0; i < n.length; i++)
			n[i] += 1000;

		return 0;
	}

}

class PQDescComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer x, Integer y) {

		return (x > y) ? -1 : ((x == y) ? 0 : 1);
	}

}
