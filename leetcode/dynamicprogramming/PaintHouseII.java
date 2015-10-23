package dynamicprogramming;

public class PaintHouseII {
	public int minCostII(int[][] costs) { //bad
		int n = costs.length;
		if (n == 0)
			return 0;
		int k = costs[0].length;
		int[][] midcosts = new int[n][k];
		int firstmin = Integer.MAX_VALUE - 1;
		int secondmin = Integer.MAX_VALUE;
		int curfirstmin = Integer.MAX_VALUE - 1;
		int cursecondmin = Integer.MAX_VALUE;
		for (int i = 0; i < k; i++) {
			midcosts[0][i] = costs[0][i];
			if (midcosts[0][i] < curfirstmin) {
				cursecondmin = curfirstmin;
				curfirstmin = midcosts[0][i];
			} else if (midcosts[0][i] >= curfirstmin
					&& midcosts[0][i] < cursecondmin) {
				cursecondmin = midcosts[0][i];
			}
		}

		if (curfirstmin < firstmin)
			firstmin = curfirstmin;
		if (cursecondmin < secondmin)
			secondmin = cursecondmin;

		for (int i = 1; i < n; i++) {
			curfirstmin = Integer.MAX_VALUE - 1;
			cursecondmin = Integer.MAX_VALUE;
			for (int j = 0; j < k; j++) {
				if (midcosts[i - 1][j] == firstmin) {
					midcosts[i][j] = secondmin+costs[i][j];
				} else
					midcosts[i][j] = firstmin+costs[i][j];

				if (midcosts[i][j] < curfirstmin) {
					cursecondmin = curfirstmin;
					curfirstmin = midcosts[i][j];
				} else if (midcosts[i][j] >= curfirstmin
						&& midcosts[i][j] < cursecondmin) {
					cursecondmin = midcosts[i][j];
				}
			}
				firstmin = curfirstmin;
				secondmin = cursecondmin;
		}
		return firstmin;
	}
	
	public int minCostII2(int[][] costs) { //perfect
        if(costs.length==0||costs[0].length==0)return 0;
        int row=costs.length;
        int col=costs[0].length;
        for(int i=1;i<row;i++){
            for(int j=0;j<col;j++){
                int minvalue=costs[i-1][(j+1)%col];
                for(int k=2;k<col;k++){
                    if(minvalue>costs[i-1][(j+k)%col]){
                        minvalue=costs[i-1][(j+k)%col];
                    }
                }
                costs[i][j]+=minvalue;
            }
        }
        int ret=costs[row-1][0];
        for(int i=0;i<col;i++){
            if(ret>costs[row-1][i]){
                ret=costs[row-1][i];
            }
        }
        return ret;
    }
	
	
	
    public int minCostII3(int[][] costs) { //perfect O(nm);
        if(costs.length==0||costs[0].length==0)return 0;
        int row=costs.length;
        int col=costs[0].length;
        int min1_old=Integer.MAX_VALUE, min2_old=Integer.MAX_VALUE;
        int min1=Integer.MAX_VALUE, min2=Integer.MAX_VALUE;
        for(int i=0;i<row;i++){
            min1_old=min1;
            min2_old=min2;
            min1=Integer.MAX_VALUE;
            min2=Integer.MAX_VALUE;
            for(int j=0;j<col;j++){
                if(i!=0){
                    if(costs[i-1][j]==min1_old){
                        costs[i][j]+=min2_old;
                    }else{
                        costs[i][j]+=min1_old;
                    }
                }
                
                if(costs[i][j]<min1){
                    if(min1!=Integer.MAX_VALUE){
                        min2=min1;
                        min1=costs[i][j];
                    }else{
                        min1=costs[i][j];
                    }
                }else if(costs[i][j]<min2){
                    min2=costs[i][j];
                }
                
            }
        }
        int ret=costs[row-1][0];
        for(int i=0;i<col;i++){
            if(ret>costs[row-1][i]){
                ret=costs[row-1][i];
            }
        }
        return ret;
    }
    
	public static void main(String[]args){
		int [][]a=new int[2][3];
		a[0][0]=1;
		a[0][1]=5;
		a[0][2]=3;
		a[1][0]=2;
		a[1][1]=9;
		a[1][2]=4;
		PaintHouseII test=new PaintHouseII();
		System.out.println(test.minCostII(a));
	}
}
