package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PermutationsII {
	List<List<Integer>> ret = new ArrayList();

	public List<List<Integer>> permuteUnique2(int[] nums) {
		List<Integer> unadded = new ArrayList<Integer>(nums.length);
		for (int i = 0; i < nums.length; i++) {
			unadded.add(i, nums[i]);
		}
		Collections.sort(unadded);
		helper(new ArrayList<Integer>(), unadded);
		return ret;
	}

	public void helper(List<Integer> added, List<Integer> unadded) {
		if (unadded.size() == 0) {
			List<Integer> temp = new ArrayList<Integer>();
			temp.addAll(added);
			ret.add(temp);
		} else {
			for (int i = 0; i < unadded.size(); i++) {

				int value = unadded.get(i);
				if (i > 0) {
					if (unadded.get(i - 1) == value)
						continue;
				}

				added.add(value);
				unadded.remove(i);
				helper(added, unadded);
				unadded.add(i, value);
				added.remove(added.size() - 1);
			}

		}
	}

	public List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> ret = new ArrayList();
		List<Integer> candidates = new ArrayList();
		for (int i = 0; i < nums.length; i++) {
			candidates.add(nums[i]);
		}
		helper(ret,candidates,new ArrayList());
		return ret;
	}

	public void helper(List<List<Integer>> ret, List<Integer> candidates,
			List<Integer> prefix) {
		if (candidates.size() == 0) {
			ret.add(new ArrayList(prefix));
			return;
		}
		for (int i = 0; i < candidates.size(); i++) {
			if (i > 0 && candidates.get(i).equals(candidates.get(i - 1)))
				continue;
			Integer candidate = candidates.get(i);
			candidates.remove(i);
			prefix.add(candidate);
			helper(ret, candidates, prefix);
			candidates.add(i, candidate);
			prefix.remove(prefix.size() - 1);
		}
	}

	public static void main(String[] args) {
		PermutationsII test = new PermutationsII();
		int[] nums = new int[4];
		nums[0] = 1;
		nums[1] = 1;
		nums[2] = 3;
		nums[3] = 3;

		List<List<Integer>> result = test.permuteUnique(nums);
		for (List<Integer> r : result) {
			for (Integer item : r) {
				System.out.print(item + " ");
			}
			System.out.println();
		}
	}
}
