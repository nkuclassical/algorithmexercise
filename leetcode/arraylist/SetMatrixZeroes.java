package arraylist;

public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) { //in place method!
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return;
		int row = matrix.length;
		int col = matrix[0].length;
		boolean row0 = false;
		boolean col0 = false;
		for (int i = 0; i < row; i++) {
			if (matrix[i][0] == 0) {
				row0 = true;
				break;
			}
		}
		for (int i = 0; i < col; i++) {
			if (matrix[0][i] == 0) {
				col0 = true;
				break;
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (matrix[0][j] == 0 || matrix[i][0] == 0)
					matrix[i][j] = 0;
			}
		}
		if (row0) {
			for (int i = 0; i < row; i++) {
				matrix[i][0] = 0;
			}
		}
		if (col0) {
			for (int i = 0; i < col; i++) {
				matrix[0][i] = 0;
			}
		}
	}

	public static void main(String[] args) {
		SetMatrixZeroes sz = new SetMatrixZeroes();
		int[][] matrix = { { 0, 0, 0, 5 }, { 4, 3, 1, 4 }, { 0, 1, 1, 4 },
				{ 1, 2, 1, 3 }, { 0, 0, 1, 1 } };
		int row = matrix.length;
		int column = matrix[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		sz.setZeroes(matrix);

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
