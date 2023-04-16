package medium;

import java.util.HashSet;

public class WordSearch_79 {

	public static void main(String[] args) {
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		String word = "SEE";
//		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
//		String word = "ABCB";
//		char[][] board = { { 'a', 'a' } };
//		String word = "aaa";
		boolean test = exist(board, word);
		System.out.println(test);
	}

	public static boolean exist(char[][] board, String word) {
		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (dfs(board, visited, word, i, j, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean dfs(char[][] board, boolean[][] visited, String word, int pos_x, int pos_y, int index) {
		// if it is out of 2d array
		if (pos_x < 0 || pos_x >= board.length || pos_y < 0 || pos_y >= board[0].length) {
			return false;
		}
		// if it is visited before
		if (visited[pos_x][pos_y]) {
			return false;
		}
		// if current letter is matching current 2d char
		boolean b1 = false;
		boolean b2 = false;
		boolean b3 = false;
		boolean b4 = false;
		if (board[pos_x][pos_y] == word.charAt(index)) {
			// if the current index is the last letter of the word
			if (index + 1 >= word.length()) {
				return true;
			} else {
				visited[pos_x][pos_y] = true;
				b1 = dfs(board, visited, word, pos_x - 1, pos_y, index + 1);
				b2 = dfs(board, visited, word, pos_x + 1, pos_y, index + 1);
				b3 = dfs(board, visited, word, pos_x, pos_y - 1, index + 1);
				b4 = dfs(board, visited, word, pos_x, pos_y + 1, index + 1);
				visited[pos_x][pos_y] = false;
			}
		} else {
			return false;
		}
		return b1 || b2 || b3 || b4;
	}
}
