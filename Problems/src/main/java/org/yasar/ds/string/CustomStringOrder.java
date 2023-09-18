package org.yasar.ds.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomStringOrder {

	static Map<Character, Integer> mp = new HashMap<>();

	public static void main(String[] args) {

		System.out.println(
				sorter("hlabcdefgijkmnopqrstuvwxyz", Arrays.asList(new String[] { "hello", "geeksforgeeks" })));

		System.out
				.println(sorter("worldabcefghijkmnpqstuvxyz", Arrays.asList(new String[] { "row", "word", "world", })));

	}

	private static List<String> sorter(String map, List<String> ips) {

		char[] cr = map.toCharArray();
		for (int i = 0; i < cr.length; i++) {
			mp.put(cr[i], i);
		}

		Collections.sort(ips, new Charc());
		return ips;

	}

	static class Charc implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {
			if (o1.equals(o2))
				return 0;

			char[] a = o1.toCharArray();
			char[] b = o2.toCharArray();
			int min = Math.min(o1.length(), o2.length());
			for (int i = 0; i < min; i++) {

				if (mp.get(a[i]) != mp.get(b[i])) {

					return mp.get(b[i]) - mp.get(a[i]);
				}
			}

			return a.length - b.length;

		}

	}

}
