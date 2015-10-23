package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SubsetsII {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> ret = new ArrayList();
		Arrays.sort(nums);
		helper(ret, new Stack(), nums, 0);
		return ret;
	}

	public void helper(List<List<Integer>> ret, Stack<Integer> prefix,
			int[] nums, int index) {
		if (index <= nums.length) {
			ret.add(new ArrayList(prefix));
		}
		for (int i = index; i < nums.length; i++) {
			prefix.push(nums[i]);
			helper(ret, prefix, nums, i + 1);
			prefix.pop();
			while (i < nums.length - 1 && nums[i + 1] == nums[i])
				i++;
		}
	}

	public static void main(String[] args) {
		SubsetsII test = new SubsetsII();
		int[] nums = new int[3];
		nums[0] = 1;
		nums[1] = 2;
		nums[2] = 2;
		List<List<Integer>> result = test.subsetsWithDup(nums);
		for (List<Integer> rt : result) {
			for (Integer r : rt) {
				System.out.print(r + " ");
			}
			System.out.println();
		}

	}

}
