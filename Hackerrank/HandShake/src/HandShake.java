import java.util.Scanner;


public class HandShake {
	public static void main(String[]args)
	{
		int T,N;
		Scanner sc=new Scanner(System.in);
		T=sc.nextInt();
		for(int i=0;i<T;i++)
		{
			N=sc.nextInt();
			System.out.println(N*(N-1)/2);
		}
	}
}
