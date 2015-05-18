package org.yasar.ds.arrays;

//	http://stackoverflow.com/questions/4607945/how-to-find-the-kth-smallest-element-in-the-union-of-two-sorted-arrays
public class KthSmallestin2Arrays<E> {

	private E kthSmallestFast(int k, E[] A1, E[]A2) {
	    // System.out.println("this is an O(log k) speed algorithm with meaningful variables name");
	    int size1 = A1.length, size2 = A2.length;

	    int index1 = 0, index2 = 0, step = 0;
	    while (index1 + index2 < k - 1) {
	        step = (k - index1 - index2) / 2;
	        int step1 = index1 + step;
	        int step2 = index2 + step;
	        if (size1 > step1 - 1
	                && (size2 <= step2 - 1 || A1[step1 - 1].compareTo(A2[step2 - 1]) < 0)) {
	            index1 = step1; // commit to element at index = step1 - 1
	        } else {
	            index2 = step2;
	        }
	    }
	    // the base case of (index1 + index2 == k - 1)
	    if (size1 > index1 && (size2 <= index2 || A1[index1].compareTo(A2[index2]) < 0)) {
	        return A1[index1];
	    } else {
	        return A2[index2];
	    }
	}
}
