package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SubsetsII {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> ret = new ArrayList();
		if (nums.length == 0)
			return ret;
		Arrays.sort(nums);
		helper(ret, new ArrayList(), nums, 0);
		return ret;
	}

	public void helper(List<List<Integer>> ret, List<Integer> prefix,
			int[] nums, int pos) {
		ret.add(new ArrayList(prefix));
		for (int i = pos; i < nums.length; i++) {
			prefix.add(nums[i]);
			helper(ret, prefix, nums, i + 1);
			prefix.remove(prefix.size() - 1);
			while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
				i++;
			}
		}
	}

	public static void main(String[] args) {
		SubsetsII test = new SubsetsII();
		int[] nums = new int[6];
		nums[0] = 1;
		nums[1] = 2;
		nums[2] = 3;
		nums[3] = 9;
		nums[4] = 8;
		nums[5] = 8;
		List<List<Integer>> result = test.subsetsWithDup(nums);
		for (List<Integer> rt : result) {
			for (Integer r : rt) {
				System.out.print(r + " ");
			}
			System.out.println();
		}

	}

}
