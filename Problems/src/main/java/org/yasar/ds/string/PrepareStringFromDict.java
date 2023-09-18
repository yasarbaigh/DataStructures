package org.yasar.ds.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://www.codingninjas.com/studio/problems/word-break-ii_983635
public class PrepareStringFromDict {

	public static void main(String[] args) {
		List<String> op = null;
		op = wordBreak("godisnowherenowhere",
				Arrays.asList(new String[] { "god", "is", "now", "no", "where", "here" }));

		op.forEach(x -> System.out.println(x));
	}

	public static ArrayList<String> wordBreak(String s, List<String> dictionary) {
		HashSet<String> hash = new HashSet<>();
		for (String wrd : dictionary)
			hash.add(wrd);

		ArrayList<String> ans = new ArrayList<>();
		generate(new StringBuilder(), s, hash, ans);
		return ans;
	}

	public static void generate(StringBuilder str, String s, HashSet<String> hash, ArrayList<String> ans) {
		if (s.length() == 0) {
			str.deleteCharAt(str.length() - 1);
			ans.add(new StringBuilder(str).toString());
			return;
		}

		StringBuilder word = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			word.append(ch);

			if (hash.contains(word.toString())) {
				StringBuilder b = new StringBuilder(str.toString() + word + " ");
				generate(b, s.substring(i + 1), hash, ans);
			}
		}

	}
}