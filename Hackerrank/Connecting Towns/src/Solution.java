import java.util.Scanner;


public class Solution {
	public static void main(String[]args)
	{
		int T,N,Ni[],product=1;
		Scanner sc=new Scanner(System.in);
		T=sc.nextInt();
		for(int i=0;i<T;i++)
		{
			product=1;
			N=sc.nextInt();
			Ni=new int[N];
			for(int j=0;j<N-1;j++)
			{
				Ni[j]=sc.nextInt();
				product*=Ni[j];
				product%=1234567;
			}
			System.out.println(product%1234567);
		}
	}
}
