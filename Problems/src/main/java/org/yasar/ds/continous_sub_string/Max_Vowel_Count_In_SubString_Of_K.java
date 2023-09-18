package org.yasar.ds.continous_sub_string;

//https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/
public class Max_Vowel_Count_In_SubString_Of_K {

	public static void main(String[] args) {

		System.out.println(maxVowels("abciiidef", 3));
		System.out.println(maxVowels("aeiou", 2));
		System.out.println(maxVowels("leetcode", 3));
		System.out.println(maxVowels("weallloveyou", 7));

	}

	public static int maxVowels(String s, int k) {
		System.out.println("inputs " + s + "\t " + k);

		

		char[] ar = s.toLowerCase().toCharArray();
		int maxv = 0, current_v = 0;
		for (int i = 0; i < k; i++) {
			if (isVowel(ar[i]))
				current_v++;
		}

		maxv = current_v;

		if (maxv == k)
			return k;

		for (int j = k; j < ar.length; j++) {
			if (isVowel(ar[j - k]))
				current_v--;
			if (isVowel(ar[j]))
				current_v++;
			maxv = Math.max(maxv, current_v);
			if (maxv == k)
				return k;
		}
		return maxv;
	}

	static boolean isVowel(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}
}