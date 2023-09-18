package org.yasar.ds.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://www.geeksforgeeks.org/check-if-a-string-is-a-scrambled-form-of-another-string/
public class ScrambleSTring {

	static Map<String, Boolean> mp = new HashMap<>();

	public static boolean isScramble(String s1, String s2) {

		if (s1.length() != s2.length())
			return false;

		if (s1.equals(s2))
			return true;

		String key = s1 + " " + s2;
		if (mp.get(key) != null && mp.get(key) == true) {
			return true;
		}

		char[] a1 = s1.toCharArray();
		char[] a2 = s2.toCharArray();

		Arrays.sort(a1);
		Arrays.sort(a2);

		if (!new String(a1).equals(new String(a2))) {
			return false;
		}

		for (int i = 1; i < s1.length(); i++) {
			String s11 = s1.substring(0, i);
			String s12 = s1.substring(i, s1.length());
			String s21 = s2.substring(0, i);
			String s22 = s2.substring(i, s2.length());

			if (isScramble(s11, s21) && isScramble(s12, s22)) {
				mp.put(key, true);
				return true;
			}

			String s23 = s2.substring(0, s2.length() - i);
			String s24 = s2.substring(s2.length() - i, s2.length());

			if (isScramble(s12, s23) && isScramble(s11, s24)) {
				mp.put(key, true);
				return true;
			}
		}
		mp.put(key, false);
		return false;
	}

	public static void main(String[] args) {
		String s1 = "great";
		String s2 = "rgeat";

		System.out.println(isScramble("great", "rgeat"));
		System.out.println(isScramble("coder", "ocder"));
		System.out.println(isScramble("abcde", "caebd"));

		System.out.println(isScramble("abcde", "edcba"));

	}

}
