package dynamicprogramming;

public class EditDistance {
	public int minDistance(String word1, String word2) {
		int row = word1.length() + 1;
		int column = word2.length() + 1;
		int[][] matrix = new int[row][column];
		for (int i = 0; i < row; i++)
			matrix[i][0] = i;
		for (int i = 0; i < column; i++)
			matrix[0][i] = i;
		for(int i=1;i<row;i++){
			for(int j=1;j<column;j++){
				if(word1.charAt(i-1)==word2.charAt(j-1))matrix[i][j]=matrix[i-1][j-1];
				else{
					matrix[i][j]=1+Math.min(Math.min(matrix[i-1][j-1],matrix[i-1][j]), matrix[i][j-1]);
				}
			}
		}
		return matrix[row-1][column-1];
	} 
}
