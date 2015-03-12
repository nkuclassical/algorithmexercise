import java.util.Scanner;


public class Solution {
	
	public static void main(String[]args)
	{
		int N,x[],shifts=0;
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		x=new int[N];
		for(int i=0;i<N;i++)
			x[i]=sc.nextInt();
		for(int i=0;i<N;i++)
		{
			for(int j=i-1;j>=0;j--)
			{
				if(x[j]>x[j+1])
				{
					x[j+1]^=x[j];
					x[j]^=x[j+1];
					x[j+1]^=x[j];
					shifts++;
				}
			}
		}
		//System.out.println(shifts);
		for(int xx:x)
			System.out.print(xx+" ");
		System.out.println();
		quicksort(x);
	}
}
