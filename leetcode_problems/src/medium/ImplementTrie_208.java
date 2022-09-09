package medium;

import java.util.HashMap;

public class ImplementTrie_208 {
	public static void main(String args[]) {
		Trie trie = new Trie();
		trie.insert("apple");
		trie.search("apple");
		trie.search("app");
		trie.startsWith("app");
		trie.insert("app");
		trie.search("app");
	}

	public static class Trie {
		TreeNode tn;

		public Trie() {
			tn = new TreeNode(' ');
		}

		public void insert(String word) {
			TreeNode temp = tn;
			for (int i = 0; i < word.length(); i++) {
				if (temp.hash.containsKey(word.charAt(i))) {
					temp = temp.hash.get(word.charAt(i));
				} else {
					temp.hash.put(word.charAt(i), new TreeNode(word.charAt(i)));
					temp = temp.hash.get(word.charAt(i));
				}
			}
			temp.setlast(true);
		}

		public boolean search(String word) {
			TreeNode temp = tn;
			for (int i = 0; i < word.length(); i++) {
				if (temp.hash.containsKey(word.charAt(i))) {
					temp = temp.hash.get(word.charAt(i));
				} else {
					return false;
				}
			}
			if (temp.boo == true) {
				return true;
			} else {
				return false;
			}
		}

		public boolean startsWith(String prefix) {
			TreeNode temp = tn;
			for (int i = 0; i < prefix.length(); i++) {
				if (temp.hash.containsKey(prefix.charAt(i))) {
					temp = temp.hash.get(prefix.charAt(i));
				} else {
					return false;
				}
			}
			return true;
		}
	}

	public static class TreeNode {
		char val;
		boolean boo = false;
		HashMap<Character, TreeNode> hash;

		public TreeNode(char s) {
			this.val = s;
			hash = new HashMap<>();
		}

		public void setlast(boolean b) {
			this.boo = b;
		}
	}
}
