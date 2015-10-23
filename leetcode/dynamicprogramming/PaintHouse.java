package dynamicprogramming;

public class PaintHouse {
	public int minCost(int[][] costs) {
		int row = costs.length;
		if (row == 0)
			return 0;
		int[][] midcosts = new int[row][3];
		midcosts[0][0] = costs[0][0];
		midcosts[0][1] = costs[0][1];
		midcosts[0][2] = costs[0][2];
		for (int i = 1; i < row; i++) {
			midcosts[i][0] = Math.min(midcosts[i - 1][1], midcosts[i - 1][2])
					+ costs[i][0];
			midcosts[i][1] = Math.min(midcosts[i - 1][0], midcosts[i - 1][2])
					+ costs[i][1];
			midcosts[i][2] = Math.min(midcosts[i - 1][1], midcosts[i - 1][0])
					+ costs[i][2];
		}
		return Math.min(Math.min(midcosts[row - 1][0], midcosts[row - 1][1]),
				midcosts[row - 1][2]);
	}
	
	 public int minCost2(int[][] costs) {
	        if(costs.length==0||costs[0].length==0)return 0;
	        int row=costs.length;
	        int col=3;
	        for(int i=1;i<row;i++){
	            for(int j=0;j<col;j++){
	                costs[i][j]+=Math.min(costs[i-1][(j+1)%3],costs[i-1][(j+2)%3]);
	            }
	        }
	        int ret=costs[row-1][0];
	        for(int i=0;i<3;i++){
	            if(ret>costs[row-1][i]){
	                ret=costs[row-1][i];
	            }
	        }
	        return ret;
	    }
}
