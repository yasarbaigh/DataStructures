package org.yasar.ds.number;

import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class ShuffleSetOfIntegers {

	//	Collections.shuffle
	public static void shuffle(List<Object> list) {
		Random rnd = new Random();
		
		Object arr[] = list.toArray();

         // Shuffle array
		int n = list.size() - 1;
         for (int i=n; i>1; i--) {
          
        	 swap(arr, i, rnd.nextInt(i));
        	 ;
         }
         // Dump array back into list
         ListIterator it = list.listIterator();
         for (int i=0; i<arr.length; i++) {
             it.next();
             it.set(arr[i]);
         }
	}

	private static void swap(Object[] arr, int i, int j) {
		
		Object temp = arr[i];
		arr[i] = arr[j];
		arr[j] =  temp;
	}
}
