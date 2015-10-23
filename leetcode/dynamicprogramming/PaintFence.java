package dynamicprogramming;

public class PaintFence {
	public int numWays(int n, int k) {
		if (n == 0 || k == 0)
			return 0;
		if (n == 1)
			return k;
		int[] a = new int[2];

		a[0] = 1;
		a[1] = k;
		for (int i = 2; i < n; i++) {
			int cur = (k - 1) * (a[0] + a[1]);
			a[0] = a[1];
			a[1] = cur;
		}
		return a[1] * k;
	}

	public int numWays2(int n, int k) {
		int ways[] = new int[n];
		if (n == 0 || k == 0)
			return 0;
		if (n == 1)
			return k;
		ways[0] = k;
		ways[1] = k * k;
		for (int i = 2; i < n; i++) {
			ways[i] = (k - 1) * ways[i - 2] + ways[i - 1] * (k - 1);
		}
		return ways[n - 1];
	}
	
	public int numWays3(int n, int k) {//easy to understand
        if(k==0||n==0)return 0;
        int a[]=new int[2];
        int b[]=new int[2];
        a[0]=0;
        a[1]=k;
        for(int i=1;i<n;i++){
            b[0]=a[1];
            b[1]=(k-1)*(a[0]+a[1]);
            a[0]=b[0];
            a[1]=b[1];
        }
        return a[0]+a[1];
    }
}
