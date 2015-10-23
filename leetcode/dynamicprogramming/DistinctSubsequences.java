package dynamicprogramming;

public class DistinctSubsequences {
	public int numDistinct(String s, String t) {
		int col = s.length();
		int row = t.length();
		int[][] matrix = new int[row + 1][col + 1];
		matrix[0][0] = 1;
		for (int i = 0; i <= col; i++)
			matrix[0][i] = 1;
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= col; j++) {
				if (t.charAt(i - 1) == s.charAt(j - 1))
					matrix[i][j] = matrix[i][j - 1] + matrix[i - 1][j - 1];
				else {
					matrix[i][j] = matrix[i][j - 1];
				}
			}
		}
		return matrix[row][col];
	}

	 public int numDistinct2(String s, String t) {
	        int row=s.length(), col=t.length();
	        int matrix[][]=new int[row+1][col+1];
	        matrix[0][0]=1;
	        for(int i=0;i<matrix.length;i++){
	            matrix[i][0]=1;
	        }
	        for(int i=1;i<=row;i++){
	            for(int j=1;j<=col;j++){
	                if(s.charAt(i-1)==t.charAt(j-1)){
	                    matrix[i][j]=matrix[i-1][j-1]+matrix[i-1][j];
	                }else matrix[i][j]=matrix[i-1][j];
	            }
	        }
	        return matrix[row][col];
	    }
	public static void main(String[] args) {
		DistinctSubsequences test = new DistinctSubsequences();
		System.out.println(test.numDistinct2("cccc", "c"));
	}
}
