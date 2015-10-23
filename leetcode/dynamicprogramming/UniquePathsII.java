package dynamicprogramming;

public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] g) {
		int row=g.length;
		int col=g[0].length;
		if(g==null||row==0||col==0)return 0;
		if(g[0][0]==1||g[row-1][col-1]==1)return 0;
		else g[0][0]=1;
		for(int i=1;i<row;i++){			
			g[i][0]=(g[i][0]==1)?0:g[i-1][0];
		}
		for(int i=1;i<col;i++){
			g[0][i]=(g[0][i]==1)?0:g[0][i-1];
		}
		
		for(int i=1;i<row;i++){
			for(int j=1;j<col;j++){
				g[i][j]=(g[i][j]==1)?0:g[i-1][j]+g[i][j-1];
			}
		}
		return g[row-1][col-1];
	}
}
