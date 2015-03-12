import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	static ArrayList<Integer> partition(ArrayList<Integer>ar)
	{
		
		ArrayList<Integer> left=new ArrayList<Integer>(),right=new ArrayList<Integer>();
		int part=ar.get(0);
		for(int i:ar)
		{
			if(i<part)
				left.add(i);
			else if(i>part)
				right.add(i);
		}
		if(left.size()>1)
		{
			left=partition(left);
		}
		
		if(right.size()>1)
		{
			right=partition(right);
		}
		
		left.add(part);
		left.addAll(right);
		for(int i:left)
			System.out.print(i+" ");
		System.out.println();
		
		return left;
	}
	public static void main(String[]args)
	{
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		ArrayList<Integer> ar=new ArrayList<Integer>();
		for(int i=0;i<n;i++)
			ar.add(in.nextInt());
		partition(ar);
	}
}
