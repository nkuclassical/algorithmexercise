package arraylist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PascalsTriangleII {
	public long p(int m) {
		long ret = 1;
		for (int i = 2; i <= m; i++) {
			ret *= i;
		}
		return ret;
	}

	public int c(int n, int m) {
		long ret = 1;
		for (int i = m - n + 1; i <= m; i++) {
			ret *= i;
		}
		return (int) (ret / p(n));
	}

	public List<Integer> getRow(int rowIndex) {
		HashMap<Integer, Integer> map = new HashMap();
		List<Integer> ret = new ArrayList();
		for (int i = 0; i <= rowIndex; i++) {
			if (map.containsKey(rowIndex - i)) {
				ret.add(map.get(rowIndex - i));
				continue;
			}
			int temp=c(i,rowIndex);
			ret.add(temp);
			map.put(i, temp);
		}
		return ret;
	}
	
	public List<Integer>getRow2(int rowIndex){
		List<Integer>ret=new ArrayList();
		ret.add(1);
		long previous=1;
		for(int i=1;i<=rowIndex;i++){
			previous=previous*(rowIndex-i+1)/i;
			ret.add(i,(int)previous);
		}
		return ret;
	}

	public static void main(String[] args) {
		PascalsTriangleII test = new PascalsTriangleII();
		List<Integer> ret = test.getRow2(3);
		for (Integer r : ret) {
			System.out.print(r + " ");
		}
		System.out.println();
	}
}
