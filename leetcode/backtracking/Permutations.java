package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {
	
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ret = new ArrayList();
		List<Integer> candidates = new ArrayList<Integer>(nums.length);
		for (int i = 0; i < nums.length; i++) {
			candidates.add(nums[i]);
		}
		
		helper(ret,candidates,new ArrayList<Integer>());
		return ret;
	}

	public void helper(List<List<Integer>>ret,List<Integer> candidates, List<Integer> prefix) {
		if (candidates.size() == 0) {
			ret.add(new ArrayList(prefix));
		} else {
			for (int i = 0; i < candidates.size(); i++) {

				int candidate = candidates.get(i);
				prefix.add(candidate);
				candidates.remove(i);
				helper(ret,candidates, prefix);
				candidates.add(i, candidate);
				prefix.remove(prefix.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		Permutations test = new Permutations();
		int[] nums = new int[4];
		nums[0] = 1;
		nums[1] = 1;
		nums[2] = 3;
		nums[3] = 3;
		List<List<Integer>> result = test.permute(nums);
		for (List<Integer> r : result) {
			for (Integer item : r) {
				System.out.print(item + " ");
			}
			System.out.println();
		}
	}
}
