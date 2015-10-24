package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
	public String getPermutation(int n, int k) {
		k--;
		List<Integer> candidates = new ArrayList();
		for (int i = 1; i <= n; i++) {
			candidates.add(i);
		}
		int ret = 1;
		for (int i = 2; i <= n; i++) {
			ret *= i;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = n - 1; i >= 0; i--) {
			ret/=(i+1);
			int temp = ret;
			int index = k / temp;
			sb.append(candidates.get(index));
			candidates.remove(index);
			k -= index * temp;
		}
		return sb.toString();

	}

	

	public static void main(String[] args) {
		PermutationSequence test = new PermutationSequence();
		System.out.println(test.getPermutation(4, 3));
	}
}
