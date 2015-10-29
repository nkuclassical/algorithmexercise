package dynamicprogramming;

import java.util.List;

public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null)
			return 0;
		for (int i = 1; i < triangle.size(); i++) {
			int len = triangle.get(i).size();
			for (int j = 0; j < len - 1; j++) {
				int value = triangle.get(i).get(j);
				if (j == 0) {
					triangle.get(i).set(j, value + triangle.get(i - 1).get(j));
				} else {
					triangle.get(i).set(
							j,
							value
									+ Math.min(triangle.get(i - 1).get(j - 1),
											triangle.get(i - 1).get(j)));
				}
			}
			triangle.get(i).set(
					len - 1,
					triangle.get(i).get(len - 1)
							+ triangle.get(i - 1).get(len - 2));
		}
		int row = triangle.size();
		int ret = triangle.get(row - 1).get(0);
		for (int i = 1; i < row; i++) {
			if (ret > triangle.get(row - 1).get(i)) {
				ret = triangle.get(row - 1).get(i);
			}
		}
		return ret;
	}
}
