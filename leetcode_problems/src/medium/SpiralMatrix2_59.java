package medium;

public class SpiralMatrix2_59 {
	public static void main(String[] args) {
	}

	public int[][] generateMatrix(int n) {
		int[][] result = new int[n][n];
		int total = n * n;
		int counter = 1;
		int row = 0;
		int col = 0;
		// 1 going right, 2 going down, 3 going left, 4 going up
		int direction = 1;
		while (counter <= total) {
			if (direction == 1) {
				result[row][col] = counter;
				col++;
				if (col >= n || result[row][col] > 0) {
					col--;
					direction = 2;
					row++;
				}
				counter++;
			} else if (direction == 2) {
				result[row][col] = counter;
				row++;
				if (row >= n || result[row][col] > 0) {
					row--;
					direction = 3;
					col--;
				}
				counter++;
			} else if (direction == 3) {
				result[row][col] = counter;
				col--;
				if (col < 0 || result[row][col] > 0) {
					col++;
					direction = 4;
					row--;
				}
				counter++;
			} else {
				result[row][col] = counter;
				row--;
				if (row < 0 || result[row][col] > 0) {
					row++;
					direction = 1;
					col++;
				}
				counter++;
			}
		}
		return result;
	}
}
