package medium;

public class MinimumPathSum_64 {
	public static void main(String[] args) {
		int[][] test = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		int tt = minPathSum(test);
		System.out.println(tt);
	}

	public static int minPathSum(int[][] grid) {
		if (grid == null) {
			return 0;
		}
		int[][] dp = new int[grid.length][grid[0].length];
		int m = grid.length;
		int n = grid[0].length;
		// go first col
		for (int i = 0; i < m; i++) {
			if (i == 0) {
				dp[0][0] = grid[0][0];
			} else {
				dp[i][0] = dp[i - 1][0] + grid[i][0];
			}
		}
		// go first row
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				dp[0][0] = grid[0][0];
			} else {
				dp[0][i] = dp[0][i - 1] + grid[0][i];
			}
		}
		// then calculate the rest
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				dp[j][i] = Math.min(dp[j - 1][i], dp[j][i - 1]) + grid[j][i];
			}
		}
		return dp[m - 1][n - 1];
	}
}
