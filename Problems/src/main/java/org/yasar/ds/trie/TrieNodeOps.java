package org.yasar.ds.trie;

import java.util.HashMap;
import java.util.Map;
// https://www.codingninjas.com/studio/problems/complete-string_2687860?leftPanelTab=0
// https://www.youtube.com/watch?v=AWnBa91lThI

class TrieNode {
	private final Map<Character, TrieNode> children = new HashMap<>();
	private boolean endOfWord;

	Map<Character, TrieNode> getChildren() {
		return children;
	}

	boolean isEndOfWord() {
		return endOfWord;
	}

	void setEndOfWord(boolean endOfWord) {
		this.endOfWord = endOfWord;
	}

	TrieNode getChildrenOf(char c) {
		return children.get(c);
	}

}

public class TrieNodeOps {
	private TrieNode root;

	public TrieNodeOps() {
		root = new TrieNode();
	}

	void insert(String word) {
		TrieNode current = root;

		for (char l : word.toCharArray()) {
			current = current.getChildren().computeIfAbsent(l, c -> new TrieNode());
		}
		current.setEndOfWord(true);
	}

	boolean delete(String word) {
		return delete(root, word, 0);
	}

	boolean containsNode(String word) {
		TrieNode current = root;

		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.getChildren().get(ch);
			if (node == null) {
				return false;
			}
			current = node;
		}
		return current.isEndOfWord();
	}

	boolean isEmpty() {
		return root == null;
	}

	private boolean delete(TrieNode current, String word, int index) {
		if (index == word.length()) {
			if (!current.isEndOfWord()) {
				return false;
			}
			current.setEndOfWord(false);
			return current.getChildren().isEmpty();
		}
		char ch = word.charAt(index);
		TrieNode node = current.getChildren().get(ch);
		if (node == null) {
			return false;
		}
		boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.isEndOfWord();

		if (shouldDeleteCurrentNode) {
			current.getChildren().remove(ch);
			return current.getChildren().isEmpty();
		}
		return false;
	}

	boolean checkIfAllPrefixExists(String word) {
		TrieNode node = root;
		boolean flag = true;
		for (int i = 0; i < word.length() && flag; i++) {
			if (node.getChildrenOf(word.charAt(i)) != null) {
				node = node.getChildrenOf(word.charAt(i));

				flag = flag & node.isEndOfWord(); // this is check whether what-never node we are, whether is full-word
													// or chain
			} else {
				return false;
			}
		}
		return flag;
	}

}