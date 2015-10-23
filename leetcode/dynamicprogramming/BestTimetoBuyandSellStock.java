package dynamicprogramming;

public class BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices) {
		if(prices.length<2)return 0;
		int buyprice=prices[0],profit=0;
		for(int i=1;i<prices.length;i++){
			if(prices[i]<buyprice)buyprice=prices[i];
			if(prices[i]-buyprice>profit)profit=prices[i]-buyprice;
		}
		return profit;
	}
}
