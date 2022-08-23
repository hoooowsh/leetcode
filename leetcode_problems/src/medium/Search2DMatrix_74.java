package medium;

public class Search2DMatrix_74 {
	public static void main(String args[]) {
		int[][] test = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
		int[][] test2 = { { 1 } };

		boolean tt = searchMatrix(test, 3);
		System.out.println(tt);
	}

	// using binary search
	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null) {
			return false;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int lo = 0;
		int hi = m * n - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int row = mid / n;
			int col = mid % n;
			int temp = matrix[row][col];
			if (matrix[row][col] == target) {
				return true;
			} else if (matrix[row][col] < target) {
				lo = mid + 1;
				continue;
			} else {
				hi = mid - 1;
				continue;
			}
		}

		return false;
	}
}
