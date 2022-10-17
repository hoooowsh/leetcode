package assesment;

import java.util.HashMap;

import hard.WordSearch2_212.TrieNode;

public class Cisco_WordinMatrix {

	public static void funcPuzzle(char[][] grid, String word) {
		///////////////////////////////////////////////////////////////////////////////////////
		//// this question can be solved without trie, but it's something good to know
		/////////////////////////////////////////////////////////////////////////////////////// ////////
		///////////////////////////////////////////////////////////////////////////////////////

		// first set up the trienode tree
//		TrieNode root = new TrieNode();
//		for (String word : words) {
//			TrieNode node = root;
//			for (Character letter : word.toCharArray()) {
//				if (node.children.containsKey(letter)) {
//					node = node.children.get(letter);
//				} else {
//					TrieNode newNode = new TrieNode();
//					node.children.put(letter, newNode);
//					node = newNode;
//				}
//			}
//			node.word = word;
//		}

		// start iterating through grid
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				// only execute if the first letter matches
				if (grid[i][j] == word.charAt(0)) {

				}
			}
		}

	}

	// define a trie tree
	public static class TrieNode {
		HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
		String word = null;

		public TrieNode() {

		}
	}
}
