package math;

public class PerfectSquares {
	public int numSquares(int n) {
        if((int)Math.sqrt(n)*(int)Math.sqrt(n) == n)return 1;
        int[]square=new int[n];
        square[0]=1;
        for(int i=1;i<n;i++){
            if((int)Math.sqrt(i+1)*(int)Math.sqrt(i+1) == i+1){
                square[i]=1;
            }else{
                int time=Integer.MAX_VALUE;
                for(int j=1;j<=Math.sqrt(i);j++){
                    time=Math.min(time,square[i-j*j]+1);
                }
                square[i]=time;
            }
        }
        return square[n-1];
    }	
	public static void main(String[]args){
		PerfectSquares test=new PerfectSquares();
		System.out.println(test.numSquares(16));
//		int n=0;
//		if((int)Math.sqrt(n)*(int)Math.sqrt(n) == n)System.out.print("true");
//		int a=(int) Math.sqrt(n);
//		System.out.print(a);
		
	}
}
