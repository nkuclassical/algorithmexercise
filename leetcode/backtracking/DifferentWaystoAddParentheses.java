package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class DifferentWaystoAddParentheses {
	HashMap<String, List<Integer>> map = new HashMap();

	public List<Integer> diffWaysToCompute(String input) {
		if (map.containsKey(input))
			return map.get(input);
		List<Integer> ret = new ArrayList();
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '-' || input.charAt(i) == '*'
					|| input.charAt(i) == '+') {
				String left = input.substring(0, i);
				String right = input.substring(i + 1);
				List<Integer> leftValue = diffWaysToCompute(left);
				List<Integer> rightValue = diffWaysToCompute(right);

				for (Integer l : leftValue) {
					for (Integer r : rightValue) {
						int c = 0;
						switch (input.charAt(i)) {
						case '+':
							c = l + r;
							break;
						case '-':
							c = l - r;
							break;
						case '*':
							c = l * r;
							break;
						}
						ret.add(c);
					}
				}
			}
		}
		if (ret.size() == 0) {
			ret.add(Integer.valueOf(input));
		}
		map.put(input, ret);
		return ret;
	}

	public List<Integer> diffWaysToCompute2(String input) {
		List<Integer> ret = new LinkedList<Integer>();
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '-' || input.charAt(i) == '*'
					|| input.charAt(i) == '+') {
				String part1 = input.substring(0, i);
				String part2 = input.substring(i + 1);
				List<Integer> part1Ret = diffWaysToCompute(part1);
				List<Integer> part2Ret = diffWaysToCompute(part2);
				for (Integer p1 : part1Ret) {
					for (Integer p2 : part2Ret) {
						int c =0;
						switch (input.charAt(i)) {
						case '+':
							c = p1 + p2;
							break;
						case '-':
							c = p1 - p2;
							break;
						case '*':
							c = p1 * p2;
							break;
						}
						ret.add(c);
					}
				}
			}
		}
		if (ret.size() == 0) {
			ret.add(Integer.valueOf(input));
		}
		return ret;
	}

	public static void main(String[] args) {
		DifferentWaystoAddParentheses test = new DifferentWaystoAddParentheses();
//		List<Integer> result = test.diffWaysToCompute("1-2+3*4-5*6-7");
		List<Integer> result = test.diffWaysToCompute("2*3-4*5");
		for (Integer r : result) {
			System.out.println(r);
		}
		System.out.println(result.size());
	}
}
