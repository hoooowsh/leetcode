package medium;

import java.util.Arrays;

public class UniquePaths_62 {
	public static void main(String[] args) {
	}

	// using dp, first col and first row will all be 1, then for the rest of all
	// other elements, it equals to matrix[j][i] = matrix[j][i - 1] + matrix[j - 1][i];
	public static int uniquePaths(int m, int n) {
		int[][] matrix = new int[m][n];
		for (int i = 0; i < m; i++) {
			matrix[i][0] = 1;
		}
		for (int i = 0; i < n; i++) {
			matrix[0][i] = 1;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				matrix[j][i] = matrix[j][i - 1] + matrix[j - 1][i];
			}
		}
		return matrix[m - 1][n - 1];
	}
}
