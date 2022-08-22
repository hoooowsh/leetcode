package medium;

public class UniquePath2_63 {
	public static void main(String[] args) {
		int[][] test = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		int[][] test2 = { { 0, 1 }, { 0, 0 } };
		int tt = uniquePathsWithObstacles(test2);
		System.out.println(tt);
	}

	// same as 62, just add obstacles in
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null) {
			return 0;
		}
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		// check if there is obstacle in first row
		for (int i = 0; i < m; i++) {
			if (obstacleGrid[i][0] == 1) {
				obstacleGrid[i][0] = -1;
				for (int j = i; j < m; j++) {
					obstacleGrid[j][0] = -1;
				}
				break;
			} else {
				obstacleGrid[i][0] = 1;
			}
		}
		// check if there is obstacle in first col
		for (int i = 0; i < n; i++) {
			if (i == 0 && obstacleGrid[0][0] == -1) {
				for (int j = i; j < n; j++) {
					obstacleGrid[0][j] = -1;
				}
				break;
			}
			if (i != 0 && obstacleGrid[0][i] == 1) {
				obstacleGrid[0][i] = -1;
				for (int j = i; j < n; j++) {
					obstacleGrid[0][j] = -1;
				}
				break;
			} else {
				obstacleGrid[0][i] = 1;
			}
		}
		// check if there is obstacle inside this matrix
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 1) {
					obstacleGrid[i][j] = -1;
					continue;
				}
			}
		}
		// go through the matrix
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (obstacleGrid[j][i] == -1) {
					continue;
				} else if (obstacleGrid[j - 1][i] == -1 && obstacleGrid[j][i - 1] == -1) {
					obstacleGrid[j][i] = 0;
					continue;
				} else if (obstacleGrid[j - 1][i] == -1 || obstacleGrid[j][i - 1] == -1) {
					obstacleGrid[j][i] = obstacleGrid[j - 1][i] + obstacleGrid[j][i - 1] + 1;
					continue;
				} else {
					obstacleGrid[j][i] = obstacleGrid[j - 1][i] + obstacleGrid[j][i - 1];
				}
			}
		}
		if (obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == -1) {
			return 0;
		}
		return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
	}
}
