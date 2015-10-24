package binarysearch;

public class Searcha2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;
		int row = matrix.length;
		int col = matrix[0].length;
		int findrow = -1, findcol = -1;
		int start = 0, end = row - 1;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (matrix[mid][0] == target)
				return true;
			else if (matrix[mid][0] < target) {
				if (matrix[mid][col - 1] >= target) {
					findrow = mid;
					break;
				} else
					start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		if (findrow == -1) {
			if (start == end)
				findrow = start;
			else
				return false;
		}
		start = 0;
		end = col - 1;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (matrix[findrow][mid] == target)
				return true;
			else if (matrix[findrow][mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		if (start == end)
			return matrix[findrow][start] == target;
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
		System.out.println(test.searchMatrix(matrix, 34));

	}
}
