package arraylist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TwoSum {

	public int[] twoSum2(int[] nums, int target) {
		HashMap<Integer, List<Integer>> map = new HashMap();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], new ArrayList());
			}
			map.get(nums[i]).add(i);
		}
		int[] ret = new int[2];
		for (Entry<Integer, List<Integer>> entry : map.entrySet()) {
			if (entry.getKey() * 2 == target) {
				if (entry.getValue().size() >= 2) {
					ret[0] = entry.getValue().get(0) + 1;
					ret[1] = entry.getValue().get(1) + 1;
					return ret;
				}
			} else {
				if (map.containsKey(target - entry.getKey())) {
					int a = entry.getValue().get(0);
					int b = map.get(target - entry.getKey()).get(0);
					ret[0] = Math.min(a, b) + 1;
					ret[1] = Math.max(a, b) + 1;
					return ret;
				}
			}
		}
		return ret;
	}

}
