package org.yasar.ds.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// http://www.geeksforgeeks.org/find-the-longest-substring-with-k-unique-characters-in-a-given-string/
public class MaxStringWithUniqueChars {

	
	public static void main(String[] args) {
		
		System.out.println(longestStrKUnique("aabbcdefc", 3));
		
	}
	public static List<String> longestStrKUnique(String str, int k) {
		int uc = 0;
		Set<Character> chars = new HashSet<>();
		int start = 0;
		List<String> strs = new ArrayList<>();
		char ch[] = str.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			boolean isPresent = !chars.add(ch[i]);
			if (uc == k && !isPresent) {
				strs.add(str.substring(start, i));
				uc--;
				i--;
				chars.remove(ch[start]);
				char a = ch[start];
				for (int j = start; j < ch.length; j++) {
					if (a == ch[j])
						start = j;
				}
				start++;
			}
			if (uc < k && !isPresent) {
				uc++;
			}
		}
		if (uc == k) {
			strs.add(str.substring(start, ch.length));
		}
		return strs;
	}
}
