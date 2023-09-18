package org.yasar.hackerRank.interview;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ArrayKSpikes {

	static class Node {
		Integer value, index;

		public Node(Integer v, Integer index) {
			this.value = v;
			this.index = index;
		}
	}

	public static void main(String[] args) {
		int[] p1 = { 1, 2, 8, 5, 3, 4 }; // k=2; Output is 2
		System.out.println(countKSpikes(p1, 2));

		int[] p2 = { 1, 3, 2, 5, 4 }; // k=1; Output is 2
		System.out.println(countKSpikes(p2, 1));

		int[] p3 = { 1, 2, 8, 3, 7, 5, 4 }; // k=2; Output is 2
		System.out.println(countKSpikes(p3, 2));

		int[] p4 = { 1, 2, 8, 3, 7, 4, 6, 5 }; // ; k=3; Output is 1
		System.out.println(countKSpikes(p4, 3));

		int[] p5 = { 1, 2, 8, 3, 7, 4, 16, 15 }; // ; k=3; Output is 1
		System.out.println(countKSpikes(p5, 2));
	}

	public static int countKSpikes(int[] p, int k) {
		int n = p.length;
		int count = 0;

		PriorityQueue<Integer> maxHeapLeft = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Node> maxHeapRight = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// reverse-comparator , descending-order
				return o2.value - o1.value;
			}

		});

		for (int i = 0, j = n - 1; i < k && j > n - k - 1; i++, j--) {
			maxHeapLeft.add(p[i]);
			maxHeapRight.add(new ArrayKSpikes.Node(p[j], j));
		}

		for (int i = k; i < n - k; i++) {
			int currentElement = p[i];
			// Check the lest-side for k-spikes
			int countLeft = 0;

			if (maxHeapLeft.peek() < currentElement) {
				countLeft = k;
				// since k elements in max-heap are less than currentElement

			} else {
				// currentElement less than max-heap, so removing largest-value of max-heap,
				// inserting further small-value in heap
				maxHeapLeft.poll();
				maxHeapLeft.add(currentElement);

			}

			// Check the right-side for k-spikes
			int countRight = 0;

			if (maxHeapRight.peek().value < currentElement && maxHeapRight.peek().index > i) {
				countRight = k;
			} else {
				// Increases-time-complexity for some-inputs only
				for (int j = n - 1; j > i; j--) {
					if (p[j] < currentElement) {
						countRight++;

						if (j < maxHeapRight.peek().index) {
							maxHeapRight.poll();
							maxHeapRight.add(new ArrayKSpikes.Node(p[j], j));
						}
						if (countRight >= k) {
							break;
						}
					}
				}
			}
			// If both conditions are satisfied, increment the count
			if (countLeft == k && countRight == k) {
				count++;
			}
		}
		return count;
	}

	public static int countKSpikesCorrect(int[] prices, int k) {
		int n = prices.length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			int currentElement = prices[i];
			// Check the first condition for k-spikes
			int countLeft = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (prices[j] < currentElement) {
					countLeft++;
					if (countLeft >= k) {
						break;
					}
				}
			}
			// Check the second condition for k-spikes
			int countRight = 0;
			for (int j = i + 1; j < n; j++) {
				if (prices[j] < currentElement) {
					countRight++;
					if (countRight >= k) {
						break;
					}
				}
			}
			// If both conditions are satisfied, increment the count
			if (countLeft >= k && countRight >= k) {
				count++;
			}
		}
		return count;
	}

}
