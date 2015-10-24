package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class PermutationsII {
	public List<List<Integer>> permuteUnique(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
			} else {
				map.put(nums[i], 1);
			}
		}
		List<List<Integer>> ret = new ArrayList();
		helper(ret, map, new ArrayList(), nums.length);
		return ret;
	}

	public void helper(List<List<Integer>> ret, HashMap<Integer, Integer> map,
			List<Integer> prefix, int total) {
		if (prefix.size() == total) {
			ret.add(new ArrayList(prefix));
			return;
		}
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			int key = entry.getKey();
			int value = entry.getValue();
			if (value > 0) {
				prefix.add(key);
				map.put(key, value - 1);
				helper(ret, map, prefix, total);
				map.put(key, value);
				prefix.remove(prefix.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		PermutationsII test = new PermutationsII();
		int[] nums = new int[3];
		nums[0] = 1;
		nums[1] = 1;
		nums[2] = 3;
		// nums[3] = 3;

		List<List<Integer>> result = test.permuteUnique(nums);
		for (List<Integer> r : result) {
			for (Integer item : r) {
				System.out.print(item + " ");
			}
			System.out.println();
		}
	}
}
