package dynamicprogramming;

public class BestTimetoBuyandSellStockIV {
	public int maxProfit(int k, int[] prices) {
		int ret = 0;
		if (k > prices.length / 2) {
			for (int i = 1; i < prices.length; i++) {
				ret += Math.max(prices[i] - prices[i - 1], 0);

			}
			return ret;
		}
		int[][] states = new int[2][2 * k];
		for (int i = 0; i < 2 * k; i++) {
			if (i % 2 == 0)
				states[0][i] = Integer.MIN_VALUE;
			else
				states[0][i] = 0;
		}
		int cur = 0, next = 1;
		for (int i = 1; i <= prices.length; i++) {
			for (int j = 0; j < 2 * k; j++) {
				if (j == 0)
					states[next][j] = Math.max(states[cur][j], -prices[i - 1]);
				else if (j % 2 == 0)
					states[next][j] = Math.max(states[cur][j],
							states[cur][j - 1] - prices[i - 1]);
				else
					states[next][j] = Math.max(states[cur][j],
							states[cur][j - 1] + prices[i - 1]);
			}
			int temp = cur;
			cur = next;
			next = temp;
		}
		for (int i = 1; i < k; i += 2) {
			ret = Math.max(ret, states[cur][i]);
		}
		return ret;
	}

	public int maxProfit2(int k, int[] prices) {
		int ret = 0;
		int len = prices.length;
		if (k > len / 2) {
			for (int i = 1; i < len; i++) {
				ret += Math.max(0, prices[i] - prices[i - 1]);
			}
			return ret;
		}

		int[] sell = new int[k+1];
		int[] buy = new int[k+1];
		for (int i = 0; i <= k; i++) {
			sell[i] = 0;
			buy[i] = Integer.MIN_VALUE;
		}

		for (int i = 0; i < len; i++) {
			for (int j = 1; j <=k; j++) {
				sell[j]=Math.max(sell[j], buy[j]+prices[i]);
				buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
			}
		}
		return sell[k];

	}

	public int maxProfit3(int k, int[] prices) {
        if(prices==null||prices.length<2||k==0)return 0;
        int len=prices.length;
        int ret=0;
        if(k>len/2){
            for(int i=1;i<len;i++){
                ret+=Math.max(0,prices[i]-prices[i-1]);
            }
            return ret;
        }
        int[]sell=new int[k+1];
        int[]buy=new int[k+1];
        for(int i=0;i<=k;i++){
            sell[i]=0;
            buy[i]=Integer.MIN_VALUE;
        }
        for(int i=0;i<len;i++){
            for(int j=1;j<=k;j++){
                sell[j]=Math.max(sell[j],buy[j]+prices[i]);
                buy[j]=Math.max(buy[j],sell[j-1]-prices[i]);
            }
        }
        
        return sell[k];
    }
	public static void main(String[] args) {
		BestTimetoBuyandSellStockIV test = new BestTimetoBuyandSellStockIV();
		int[] nums = new int[2];
		nums[0] = 1;
		nums[1] = 2;
		System.out.println(test.maxProfit3(1, nums));
	}
}
