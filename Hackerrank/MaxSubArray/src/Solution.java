import java.util.Scanner;
public class Solution {
	public static void main(String[]args)
	{
		int T,N,A[],B[],maxSumContinguous,maxSumNonContinguous;
		Scanner sc=new Scanner(System.in);
		T=sc.nextInt();
		for(int i=0;i<T;i++)
		{
			N=sc.nextInt();
			A=new int[N];
			B=new int[N];
			A[0]=sc.nextInt();
			B[0]=A[0];
			maxSumContinguous=B[0];
			maxSumNonContinguous=B[0];
			for(int j=1;j<N;j++)
			{
				A[j]=sc.nextInt();
				B[j]=Math.max(A[j],B[j-1]+A[j]);
				if(maxSumContinguous<B[j])maxSumContinguous=B[j];
				if(maxSumNonContinguous<0 && A[j]>0)maxSumNonContinguous=A[j];
				else if(maxSumNonContinguous>0 && A[j]>0)maxSumNonContinguous+=A[j];
			}
			System.out.println(maxSumContinguous+" "+maxSumNonContinguous);
		}
	}
}
