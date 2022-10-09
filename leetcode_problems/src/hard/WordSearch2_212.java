package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class WordSearch2_212 {
	public static void main(String args[]) {

	}

	public static List<String> findWords(char[][] board, String[] words) {
		// first set up the trienode tree
		TrieNode root = new TrieNode();
		for (String word : words) {
			TrieNode node = root;
			for (Character letter : word.toCharArray()) {
				if (node.children.containsKey(letter)) {
					node = node.children.get(letter);
				} else {
					TrieNode newNode = new TrieNode();
					node.children.put(letter, newNode);
					node = newNode;
				}
			}
			node.word = word;
		}

		// check every position from board
		List<String> result = new ArrayList<>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (root.children.containsKey(board[i][j])) {

				}
			}
		}

		return result;
	}

	public static void backtracking(char[][] board, List<String> result, TrieNode cur, int row, int col) {

	}

	// This is a helper trie node class for word searching
	public static class TrieNode {
		HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
		String word = null;

		public TrieNode() {

		}
	}
}
