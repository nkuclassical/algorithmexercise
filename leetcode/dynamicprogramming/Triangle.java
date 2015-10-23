package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		int[] result = new int[triangle.size()];
		for(int i=0;i<result.length;i++)result[i]=Integer.MAX_VALUE;
		result[0] = triangle.get(0).get(0);
		
		for (int i = 1; i < triangle.size(); i++) {
			int prev=result[0];
			result[0]+=triangle.get(i).get(0);
			for (int j = 1; j < triangle.get(i).size() ; j++) {
				int temp=result[j];
				result[j]=Math.min(prev, temp)+triangle.get(i).get(j);
				prev=temp;
			}
		}

		int minValue = Integer.MAX_VALUE;

		for (int i = 0; i < result.length; i++) {
			minValue=result[i]<minValue?result[i]:minValue;
		}
		return minValue;
	}

	public static void main(String[] args) {
		Triangle test = new Triangle();
//		List<List<Integer>> triangle = new ArrayList();
		List<Integer> item = new ArrayList();
		item.add(null);
		System.out.println(item.size());
//		item.add(-1);
//		triangle.add(new ArrayList(item));
//		item.clear();
//		item.add(-2);
//		item.add(-3);
//		triangle.add(new ArrayList(item));
//		item.clear();
//		item.add(6);
//		item.add(5);
//		item.add(7);
//		triangle.add(new ArrayList(item));
//		item.clear();
//		item.add(4);
//		item.add(1);
//		item.add(8);
//		item.add(3);
//		triangle.add(new ArrayList(item));
//		item.clear();
//		System.out.println(test.minimumTotal(triangle));

	}
}
