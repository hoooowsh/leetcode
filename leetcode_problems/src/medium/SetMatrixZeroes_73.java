package medium;

import java.util.ArrayList;

public class SetMatrixZeroes_73 {
	public static void main(String[] args) {
		int[][] test = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		int[][] test2 = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
		int[][] test3 = { { 1, 0, 3 } };
		setZeroes2(test3);
	}

	public static void setZeroes(int[][] matrix) {
		if (matrix == null) {
			return;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		ArrayList<int[]> zeros = new ArrayList<>();
		// go over the matrix and get all 0
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					int[] temp = new int[2];
					temp[0] = i;
					temp[1] = j;
					zeros.add(temp);
				}
			}
		}
		// make row and col be 0
		for (int i = 0; i < zeros.size(); i++) {
			int row = zeros.get(i)[0];
			int col = zeros.get(i)[1];
			for (int j = 0; j < matrix.length; j++) {
				matrix[j][col] = 0;
			}
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[row][j] = 0;
			}
		}
		return;
	}

	// this approach using the first element as a flag to indicates if the row or
	// col need to become 0, very smart
	public static void setZeroes2(int[][] matrix) {
		if (matrix == null) {
			return;
		}
		int m = matrix.length;
		int n = matrix[0].length;

		boolean firstrow = false;
		boolean firstcol = false;
		// go through the matrix, find 0 and record it
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					if (i == 0) {
						firstrow = true;
					}
					if (j == 0) {
						firstcol = true;
					}
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		// check first col
		for (int i = 1; i < m; i++) {
			if (matrix[i][0] == 0) {
				for (int j = 0; j < n; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		// check first row
		for (int i = 1; i < n; i++) {
			if (matrix[0][i] == 0) {
				for (int j = 0; j < m; j++) {
					matrix[j][i] = 0;
				}
			}
		}
		if (firstrow) {
			for (int i = 0; i < n; i++) {
				matrix[0][i] = 0;
			}
		}
		if (firstcol) {
			for (int i = 0; i < m; i++) {
				matrix[i][0] = 0;
			}
		}
		return;
	}
}
