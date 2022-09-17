package medium;

public class NumberofIslands_200 {

	public static void main(String args[]) {
		char[][] grid = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '0', '0', '0' } };
		int i = numIslands(grid);
		System.out.println(i);
	}

	// dfs version, using recursion. should not be that slow tho, leetcode similar
	// dfs version beats 90
	public static int numIslands(char[][] grid) {
		int counter = 2;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					helper(grid, i, j, (char) (counter + '0'));
					counter++;
				}
			}
		}
		return counter - 2;
	}

	public static void helper(char[][] grid, int row, int col, char num) {
		if (row >= grid.length || col >= grid[0].length || col < 0 || row < 0) {
			return;
		}
		if (grid[row][col] == '1') {
			grid[row][col] = num;
			helper(grid, row + 1, col, num);
			helper(grid, row - 1, col, num);
			helper(grid, row, col + 1, num);
			helper(grid, row, col - 1, num);
		} else {
			return;
		}
	}

}
