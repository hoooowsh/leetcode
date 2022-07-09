package medium;

import java.util.HashSet;

public class ValidSudoku_36 {
	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			// hash is for row
			HashSet<Character> hash = new HashSet<Character>();
			// hash2 is for col
			HashSet<Character> hash2 = new HashSet<Character>();

			for (int j = 0; j < 9; j++) {
				// first if for row
				if (board[i][j] != '.') {
					if (hash.contains(board[i][j])) {
						return false;
					} else {
						hash.add(board[i][j]);
					}
				}
				// second if for col
				if (board[j][i] != '.') {
					if (hash2.contains(board[j][i])) {
						return false;
					} else {
						hash2.add(board[j][i]);
					}
				}
			}
		}

		// code below for 3x3 squre
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				HashSet<Character> hash3 = new HashSet<Character>();
				for (int k = 0; k < 3; k++) {
					for (int l = 0; l < 3; l++) {
						if (board[i * 3 + k][j * 3 + l] != '.') {
							if (hash3.contains(board[i * 3 + k][j * 3 + l])) {
								return false;
							} else {
								hash3.add(board[i * 3 + k][j * 3 + l]);
							}
						}
					}
				}
			}
		}

		return true;
	}
}
