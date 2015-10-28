package arraylist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PascalsTriangleII {	
	public List<Integer>getRow2(int rowIndex){
		List<Integer>ret=new ArrayList();
		ret.add(1);
		long previous=1;
		for(int i=1;i<=rowIndex;i++){
			previous=previous*(rowIndex-i+1)/i;
			ret.add((int)previous);
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
