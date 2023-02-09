package medium;

public class MaxAreaofIsland_695 {
	public int maxAreaOfIsland(int[][] grid) {
		int max = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					int temp = helper(grid, i, j);
					if (temp > max) {
						max = temp;
					}
				}
			}
		}
		return max;
	}

	public int helper(int[][] grid, int row, int col) {
		if (row < 0 || col < 0 || row > grid.length - 1 || col > grid[0].length - 1) {
			return 0;
		}
		if (grid[row][col] == 1) {
			grid[row][col] = 2;
			return 1 + helper(grid, row + 1, col) + helper(grid, row - 1, col) + helper(grid, row, col + 1)
					+ helper(grid, row, col - 1);
		}
		return 0;
	}
}
