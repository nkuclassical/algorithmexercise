package arraylist;

public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		
		int[][]ret=new int[n][n];
		
		int cur=1;
		int round=n/2;
		for(int i=0;i<round;i++){

			for(int j=i;j<n-i;j++){
				ret[i][j]=cur;
				cur++;
			}
			for(int j=i+1;j<n-i;j++){
				ret[j][n-i-1]=cur;
				cur++;
			}
			for(int j=n-i-2;j>=i;j--){
				ret[n-i-1][j]=cur;
				cur++;
			}
			for(int j=n-i-2;j>i;j--){
				ret[j][i]=cur;
				cur++;
			}
		}
		if(n%2==1){
			ret[round][round]=cur;
		}
		return ret;
	}
	
	public static void main(String[]args){
		SpiralMatrixII test=new SpiralMatrixII();
		int [][]result=test.generateMatrix(4);
		result.toString();
	}
}
