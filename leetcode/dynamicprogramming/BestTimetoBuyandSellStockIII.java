package dynamicprogramming;

public class BestTimetoBuyandSellStockIII {
	public int maxProfit(int[] prices) {
		int[][]states=new int[prices.length+1][4];
		states[0][0]=Integer.MIN_VALUE;
		states[0][1]=0;
		states[0][2]=Integer.MIN_VALUE;
		states[0][3]=0;
		for(int i=1;i<prices.length;i++){
			states[i][0]=Math.max(states[i-1][0], -prices[i-1]);
			states[i][1]=Math.max(states[i-1][1],states[i-1][0]+prices[i-1]);
			states[i][2]=Math.max(states[i-1][2], states[i-1][1]-prices[i-1]);
			states[i][3]=Math.max(states[i-1][3], states[i-1][2]+prices[i-1]);
		}
		return Math.max(states[prices.length][1], states[prices.length][3]);
	}
	
	
}
