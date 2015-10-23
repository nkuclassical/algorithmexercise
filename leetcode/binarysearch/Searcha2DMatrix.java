package binarysearch;

public class Searcha2DMatrix {
	public boolean searchCol(int[][] matrix, int target, int start, int end,
			int row) {
		if (start == end) {
			if (matrix[row][start] == target)
				return true;
			else
				return false;
		}
		if (start == end - 1) {
			if (matrix[row][start] == target)
				return true;
			else if (matrix[row][end] == target)
				return true;
			else
				return false;
		}
		int middle = (start + end) / 2;
		if (matrix[row][middle] == target)
			return true;
		else if (matrix[row][middle] < target)
			return searchCol(matrix, target, middle, end, row);
		else
			return searchCol(matrix, target, start, middle, row);

	}

	public int searchRow(int[][] matrix, int target, int start, int end) {
		int column = matrix[start].length - 1;
		if (start == end)
			return start;
		else if (start == end - 1) {
			if (matrix[start][column] >= target)
				return start;
			else if (matrix[end][0] <= target)
				return end;
			else
				return -1;
		} else {
			int middle = (start + end) / 2;
			if (matrix[middle][column] >= target)
				return searchRow(matrix, target, start, middle);
			else if (matrix[middle][0] <= target)
				return searchRow(matrix, target, middle, end);
			else
				return -1;
		}
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;
		if (matrix[0][0] > target)
			return false;
		int start = 0;
		int end = matrix.length - 1;
		if (matrix[end][matrix[end].length - 1] < target)
			return false;
		int row = searchRow(matrix, target, start, end);
		System.out.println(row);
		if (row < 0)
			return false;
		return searchCol(matrix, target, 0, matrix[0].length - 1, row);
	}

	public boolean searchMatrix2(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;
		int startrow = 0, endrow = matrix.length - 1;
		int currow = 0, curcol = 0;
		int startcol = 0, endcol = matrix[0].length - 1;
		while (startrow <= endrow) {
			int midrow = startrow + (endrow - startrow) / 2;
			if (matrix[midrow][0] > target)
				endrow = midrow - 1;
			else if (matrix[midrow][endcol] < target)
				startrow = midrow + 1;
			else {
				currow = midrow;
				break;
			}
		}
		
		while (startcol <= endcol) {
			int midcol = startcol + (endcol - startcol) / 2;
			if (matrix[currow][midcol] < target) {
				startcol = midcol + 1;
			} else if (matrix[currow][midcol] > target) {
				endcol = midcol - 1;
			} else {
				curcol = midcol;
				break;
			}
		}

		if (matrix[currow][curcol] == target)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		int[][] matrix = new int[3][4];
		matrix[0][0] = 1;
		matrix[0][1] = 3;
		matrix[0][2] = 5;
		matrix[0][3] = 7;
		matrix[1][0] = 10;
		matrix[1][1] = 11;
		matrix[1][2] = 16;
		matrix[1][3] = 20;
		matrix[2][0] = 23;
		matrix[2][1] = 30;
		matrix[2][2] = 34;
		matrix[2][3] = 50;
		Searcha2DMatrix test = new Searcha2DMatrix();
		System.out.println(test.searchMatrix2(matrix, 34));

	}
}
