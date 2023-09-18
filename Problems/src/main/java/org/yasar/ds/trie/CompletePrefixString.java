package org.yasar.ds.trie;

//https://www.codingninjas.com/studio/problems/complete-string_2687860?leftPanelTab=0
//https://www.youtube.com/watch?v=AWnBa91lThI

public class CompletePrefixString {
	public static void main(String[] args) {
		String[] ips = new String[] { "n", "ni", "nin", "ninj", "ninja", "ninga" };
		System.out.println(checker(ips));
		System.out.println(checker(new String[] { "ab", "bc" }));
	}

	public static String checker(String[] arr) {

		TrieNodeOps obj = new TrieNodeOps();
		for (String word : arr)
			obj.insert(word);

		String longest = "";
		for (String word : arr) {
			if (obj.checkIfAllPrefixExists(word)) {
				if (word.length() > longest.length()) {
					longest = word;
				} else if (word.length() == longest.length() && word.compareTo(longest) <= 0) {
					longest = word;
				}
			}
		}
		if (longest == "")
			return "None";
		return longest;
	}
}