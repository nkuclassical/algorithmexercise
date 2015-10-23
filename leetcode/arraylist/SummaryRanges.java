package arraylist;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
	public List<String> summaryRanges(int[] nums) {
		List<String> ret = new ArrayList();
		int start = nums[0];
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1] + 1)
				continue;
			else if (nums[i - 1] == start) {
				sb.append(start);
				ret.add(sb.toString());
				sb.delete(0, sb.length());
				start = nums[i];
			} else {
				sb.append(start);
				sb.append("->");
				sb.append(nums[i - 1]);
				ret.add(sb.toString());
				sb.delete(0, sb.length());
				start = nums[i];
			}
		}
		if (start == nums[nums.length - 1]) {
			sb.append(start);
		} else {
			sb.append(start);
			sb.append("->");
			sb.append(nums[nums.length - 1]);
		}
		ret.add(sb.toString());
		return ret;
	}

	public static void main(String[] args) {
		SummaryRanges test = new SummaryRanges();
		int[] nums = new int[6];
		nums[0] = 0;
		nums[1] = 1;
		nums[2] = 2;
		nums[3] = 4;
		nums[4] = 5;
		nums[5] = 6;
		List<String> result = test.summaryRanges(nums);
		for (String rt : result) {
			System.out.println(rt);
		}
	}
}
