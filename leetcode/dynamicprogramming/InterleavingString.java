package dynamicprogramming;

public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() == 0)
			return s3.equals(s2);
		if (s2.length() == 0)
			return s3.equals(s1);

		int row = s1.length();
		int col = s2.length();
		if (row + col != s3.length())
			return false;
		boolean matrix[][] = new boolean[row + 1][col + 1];
		for (int i = 0; i <= row; i++) {
			for (int j = 0; j <= col; j++)
				matrix[i][j] = false;
		}
		matrix[0][0] = true;
		for (int i = 1; i <= row; i++)
			matrix[i][0] = (s1.charAt(i - 1) == s3.charAt(i - 1))
					&& matrix[i - 1][0];
		for (int i = 1; i <= col; i++)
			matrix[0][i] = (s2.charAt(i - 1) == s3.charAt(i - 1))
					&& matrix[0][i - 1];
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= col; j++) {
				if (s3.charAt(i + j - 1) == s1.charAt(i - 1)
						&& matrix[i - 1][j]
						|| s3.charAt(i + j - 1) == s2.charAt(j - 1)
						&& matrix[i][j - 1])
					matrix[i][j] = true;
				else
					matrix[i][j] = false;
			}
		}

		for (int i = 0; i <= row; i++) {

			for (int j = 0; j <= col; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		return matrix[row][col];
	}

	public static void main(String[] args) {
		InterleavingString test = new InterleavingString();
		String s1, s2, s3;
		// s1="aabcc";
		// s2="dbbca";
		// s3="aadbbcbcac";
		// s3="aadbbbaccc";
		s1 = "ab";
		s2 = "bc";
		s3 = "bbac";
		System.out.println(test.isInterleave(s1, s2, s3));
	}
}
