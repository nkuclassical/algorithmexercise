package arraylist;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (numRows <= 0)
			return ret;
		for (int i = 0; i < numRows; i++) {
			List<Integer> row = new ArrayList<Integer>();
			if (i > 0) {
				List<Integer> prevRow = ret.get(i - 1);
				row.add(1);
				for (int j = 0; j < prevRow.size() - 1; j++) {
					row.add(prevRow.get(j) + prevRow.get(j + 1));
				}
			}
			row.add(1);
			ret.add(row);
		}
		return ret;
	}

	public static void main(String[] args) {
		PascalsTriangle test = new PascalsTriangle();
		List<List<Integer>> ret = test.generate(5);
		for (int i = 0; i < ret.size(); i++) {
			for (int j = 0; j < ret.get(i).size(); j++) {
				System.out.print(ret.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
}
