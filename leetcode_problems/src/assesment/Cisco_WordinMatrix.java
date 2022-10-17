package assesment;

import java.util.HashMap;

import hard.WordSearch2_212.TrieNode;

public class Cisco_WordinMatrix {
	public static void main(String args[]) {
		char[][] grid = { { 'C', 'A', 'T' }, { 'I', 'D', 'O' }, { 'N', 'O', 'M' } };
		String s1 = "CAT";
		String s2 = "TOM";
		String s3 = "ADO";
		String s4 = "MOM";
		String s5 = "OM";
		String s6 = "TOMM";
		String s7 = "";
		System.out.println(funcPuzzle(grid, s1));
		System.out.println(funcPuzzle(grid, s2));
		System.out.println(funcPuzzle(grid, s3));
		System.out.println(funcPuzzle(grid, s4));
		System.out.println(funcPuzzle(grid, s5));
		System.out.println(funcPuzzle(grid, s6));
		System.out.println(funcPuzzle(grid, s7));
	}

	public static boolean funcPuzzle(char[][] grid, String word) {
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
		if (word == null || word.length() == 0) {
			return false;
		}
		boolean result = false;
		// start iterating through grid
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				// only execute if the first letter matches
				if (grid[i][j] == word.charAt(0)) {
					// checking top, i change, j not change
					int counter = 0;
					int len = word.length();
					for (int k = i; k >= 0; k--) {
						if (counter > len) {
							return true;
						}
						if (grid[k][j] == word.charAt(counter)) {
							counter++;
							if (counter == len) {
								return true;
							}
						} else {
							break;
						}
					}
					// checking bot, i change, j not change
					counter = 0;
					for (int k = i; k < grid.length; k++) {
						if (counter > len) {
							return true;
						}
						if (grid[k][j] == word.charAt(counter)) {
							counter++;
							if (counter == len) {
								return true;
							}
						} else {
							break;
						}
					}
					// checking left, j change, i not change
					counter = 0;
					for (int k = j; k >= 0; k--) {
						if (counter > len) {
							return true;
						}
						if (grid[i][k] == word.charAt(counter)) {
							counter++;
							if (counter == len) {
								return true;
							}
						} else {
							break;
						}
					}
					// checking right, j change, i not change
					counter = 0;
					for (int k = j; k < grid[0].length; k++) {
						if (counter > len) {
							return true;
						}
						if (grid[i][k] == word.charAt(counter)) {
							counter++;
							if (counter == len) {
								return true;
							}
						} else {
							break;
						}
					}
				}
			}
		}
		return result;
	}

	// define a trie tree
	public static class TrieNode {
		HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
		String word = null;

		public TrieNode() {

		}
	}
}
