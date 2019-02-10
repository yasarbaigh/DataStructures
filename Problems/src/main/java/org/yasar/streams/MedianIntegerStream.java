package org.yasar.streams;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianIntegerStream {

	
	public static void main(String[] args) {
        int a[] = {5, 15, 10, 20, 3};
        int length = a.length;
        double mid = 0;
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };
        
        //its max-heap, but median/numbers-lesser to median will be in this heap
        //i.e first half, where are the small-numbers will be there
        //but first element will be maximum  of it.        
        PriorityQueue<Integer> maxPriorityQueue = new PriorityQueue<>(comparator);
        
        //its min-heap, but median/number-greater to median will be in this heap
        //i.e second half, where are the big-numbers will be there
        //but first element will be minimum of it.
        PriorityQueue<Integer> minPriorityQueue = new PriorityQueue<>();
        
        
        maxPriorityQueue.add(a[0]);
        mid = a[0];
        System.out.println(mid);
        for (int i = 1; i < length; i++) {
            mid = median(maxPriorityQueue, minPriorityQueue, mid, a[i]);
            System.out.println(mid);
        }
    }
        private static double median(PriorityQueue<Integer> maxPriorityQueue,
                                 PriorityQueue<Integer> minPriorityQueue, double median, int x) {
        if (maxPriorityQueue.size() > minPriorityQueue.size()) {
            if (x > median) {
                minPriorityQueue.add(x);
            } else {
                int top = maxPriorityQueue.poll();
                minPriorityQueue.add(top);
                maxPriorityQueue.add(x);
            }
            median = (maxPriorityQueue.peek() + minPriorityQueue.peek()) / 2.0;
        } else if (minPriorityQueue.size() > maxPriorityQueue.size()) {
            if (x > median) {
                int top = minPriorityQueue.poll();
                maxPriorityQueue.add(top);
                minPriorityQueue.add(x);
            } else {
                maxPriorityQueue.add(x);
            }
            median = (maxPriorityQueue.peek() + minPriorityQueue.peek()) / 2.0;
        } else {
            if (median >= x) {
                maxPriorityQueue.add(x);
                median = maxPriorityQueue.peek();
            } else {
                minPriorityQueue.add(x);
                median = minPriorityQueue.peek();
            }
 
        }
        return median;
    }
 
}
