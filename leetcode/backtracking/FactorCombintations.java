package backtracking;

import java.util.ArrayList;
import java.util.List;

public class FactorCombintations {
	List<List<Integer>> ret = new ArrayList();

	public List<List<Integer>> getFactors(int n) {
		helper(new ArrayList<Integer>(), 2, n);
		return ret;
	}

	public void helper(List<Integer> item, int start, int n) {
		if (n <= 1) {
			if (item.size() > 1) {
				ret.add(new ArrayList<Integer>(item));
			}
			return;
		}
		for (int i = start; i <= n; i++) {
			if (n % i == 0) {
				item.add(i);
				helper(item, i, n / i);
				item.remove(item.size() - 1);
			}
		}
	}

	public List<List<Integer>> getFactors2(int n) {
		List<List<Integer>> ret = new ArrayList();
		for (int i = 2; i <= Math.sqrt(n); i++) {
			List<Integer> prefix = new ArrayList();
			if (n % i == 0) {
				prefix.add(i);
				helper(ret, n / i, prefix);
			}
		}
		return ret;
	}

	public void helper(List<List<Integer>> ret, int n, List<Integer> prefix) {
		int limit = prefix.get(prefix.size() - 1);
		if (n == 1) {
			ret.add(new ArrayList(prefix));
			return;
		}
		if (n < limit)
			return;
		for (int i = limit; i <= n; i++) {
			if (n % i == 0) {
				prefix.add(i);
				helper(ret, n / i, prefix);
				prefix.remove(prefix.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		FactorCombintations test = new FactorCombintations();
		List<List<Integer>> result = test.getFactors(32);
		for (List<Integer> rs : result) {
			for (Integer r : rs) {
				System.out.print(r + " ");
			}
			System.out.println();
		}
	}
}
