package dynamicprogramming;

public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		int row = grid.length;
		int column = grid[0].length;
		for (int i = 1; i < column; i++) {
			grid[0][i] += grid[0][i - 1];
		}
		for (int i = 1; i < row; i++) {
			grid[i][0] += grid[i - 1][0];
		}
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < column; j++) {
				grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
			}
		}
		return grid[row - 1][column - 1];
	}
}
