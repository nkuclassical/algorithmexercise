package binarysearch;

public class Searcha2DMatrixII {
	public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0)return false;
        int row=matrix.length;
        int col=matrix[0].length;
        int i=row-1, j=0;
        while(i>=0&&j<col){
            if(matrix[i][j]<target){
                j++;
            }else if(matrix[i][j]>target){
                i--;
            }else return true;
        }
        return false;
    }
}
