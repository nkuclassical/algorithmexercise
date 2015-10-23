package arraylist;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ret = new ArrayList();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return ret;
		int row = matrix.length;
		int column = matrix[0].length;

		int round = Math.min(row, column) / 2;

		for (int r = 0; r <= round; r++) {
			for (int i = r; i < column - r; i++)
				ret.add(matrix[r][i]);
			for (int i = r + 1; i < row - r; i++)
				ret.add(matrix[i][column - r - 1]);
			if (r < row / 2) {
				for (int i = column - r - 2; i >= r; i--)
					ret.add(matrix[row - r - 1][i]);
			}
			if (r < column / 2) {
				for (int i = row - r - 2; i > r; i--)
					ret.add(matrix[i][r]);
			}
			if (r == round - 1 && Math.min(row, column) % 2 == 0)
				break;
		}

		return ret;

	}

	public List<Integer> spiralOrder2(int[][] matrix) {
		List<Integer> ret = new ArrayList();
		int row = matrix.length;
		int column = matrix[0].length;
		int x = 0, y = 0;
		while (row > 0 && column > 0) {
			if (row == 1) {
				for (int i = 0; i < column; i++) {
					ret.add(matrix[x][y++]);
				}
				break;
			}

			if (column == 1) {
				for (int i = 0; i < row; i++) {
					ret.add(matrix[x++][y]);
				}
				break;
			}
			for (int i = 0; i < column - 1; i++) {
				ret.add(matrix[x][y++]);
			}
			for (int i = 0; i < row - 1; i++) {
				ret.add(matrix[x++][y]);
			}
			for (int i = 0; i < column - 1; i++) {
				ret.add(matrix[x][y--]);
			}
			for (int i = 0; i < row - 1; i++) {
				ret.add(matrix[x--][y]);
			}

			row -= 2;
			column -= 2;
			x++;
			y++;
		}
		return ret;
	}

	public List<Integer> spiralOrder3(int[][] matrix) {
		List<Integer> ret = new ArrayList();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return ret;
		int row = matrix.length;
		int col = matrix[0].length;
		int round = Math.min(row, col);
		for (int i = 0; i < round / 2; i++) {
			for (int j = i; j < col - i; j++) {
				ret.add(matrix[i][j]);
			}
			for (int j = i + 1; j < row - i; j++) {
				ret.add(matrix[j][col - i - 1]);
			}
			for (int j = col - 2 - i; j >= i; j--) {
				ret.add(matrix[row - i - 1][j]);
			}
			for (int j = row - 2 - i; j > i; j--) {
				ret.add(matrix[j][i]);
			}
		}

		if (round % 2 == 1) {
			if (row < col) {
				for (int j = round / 2; j < col - round / 2 ; j++) {
					ret.add(matrix[round / 2][j]);
				}
			} else {
				for (int j = round / 2; j < row - round / 2 ; j++) {
					ret.add(matrix[j][round / 2]);
				}
			}

		}
		return ret;
	}

	public static void main(String[] args) {
		SpiralMatrix test = new SpiralMatrix();
		int row = 2;
		int column = 3;
		int[][] m = new int[row][column];
		int count = 1;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				m[i][j] = count;
				System.out.print(count + " ");
				count++;
			}
			System.out.println();
		}
		List<Integer> result = test.spiralOrder3(m);
		System.out.println();
		for (Integer r : result) {
			System.out.print(r + " ");
		}
	}
}
