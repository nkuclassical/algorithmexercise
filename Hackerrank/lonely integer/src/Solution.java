import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


public class Solution {
	public static void main(String[]args)
	{
		int N,A[];
		HashMap<Integer,Integer>map=new HashMap<Integer,Integer>();
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		A=new int[N];
		for(int i=0;i<N;i++)
		{
			A[i]=sc.nextInt();
			if(map.containsKey(A[i]))
			{
				map.put(A[i], map.get(A[i])+1);
			}
			else
			{
				map.put(A[i], 1);
			}
		}
		Iterator it=map.entrySet().iterator();
		while(it.hasNext())
		{
			Map.Entry<Integer,Integer>pairs=(Map.Entry<Integer, Integer>)it.next();
			if(pairs.getValue()==1)
			{
				System.out.println(pairs.getKey());
			}
			it.remove();
		}
		
	}
}
