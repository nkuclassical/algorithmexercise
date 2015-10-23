package dynamicprogramming;

import java.util.HashMap;

public class UniqueBinarySearchTrees {
	public int numTrees(int n) {
		HashMap<Integer,Integer>map=new HashMap();
		map.put(0, 1);
		map.put(1, 1);
		map.put(2, 2);
		for(int i=3;i<=n;i++){
			int sum=0;	
			for(int j=0;j<i;j++){
				sum+=map.get(j)*map.get(i-j-1);
			}
			map.put(i, sum);
		}
		return map.get(n);
	}
	
	public static void main(String[]args){
		UniqueBinarySearchTrees test=new UniqueBinarySearchTrees();
		System.out.println(test.numTrees(3));
	}
}
