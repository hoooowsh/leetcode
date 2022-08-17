package medium;

public class RotateImage_48 {
	public static void main(String[] args) {
		int[][] matrix = { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };
		rotate(matrix);

	}

	// 00 -> 02 | 02-> 22 | 22 -> 20 | 20 -> 00
	// 01 -> 12
	public static void rotate(int[][] matrix) {
		int curlen = matrix.length;
		int currow = 0;
		while (curlen - currow > 0) {
			for (int i = currow; i < curlen - 1; i++) {
				// done
				int test1 = matrix[currow][i];
				int test2 = matrix[i][curlen - 1];
				// not yet
				int test3 = matrix[currow + curlen - i - 1][currow];
				int test4 = matrix[matrix.length - currow - 1][matrix.length - 1 - i];
				swap(matrix, currow, i, i, curlen - 1);
				swap(matrix, currow, i, currow + curlen - i - 1, currow);
				swap(matrix, matrix.length - currow - 1, matrix.length - 1 - i, currow + curlen - i - 1,
						currow);
			}
			currow++;
			curlen--;
		}
	}

	public static void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
		int temp = matrix[x1][y1];
		matrix[x1][y1] = matrix[x2][y2];
		matrix[x2][y2] = temp;
	}
}
