package binarysearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class MajorityElement {
	public int majorityElement(int[] nums) {
		int m = nums[0];
		int c = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == m) {
				c++;
			} else if (c > 0)
				c--;
			else {
				m = nums[i];
				c = 1;
			}
		}
		return m;
	}

	public int majorityElement2(int[] nums) {
		if (nums == null || nums.length == 0)
			return -1;
		if (nums.length == 1)
			return nums[0];
		HashMap<Integer, Integer> hashtable = new HashMap();
		for (int num : nums) {
			if (hashtable.containsKey(num)) {
				hashtable.put(num, hashtable.get(num) + 1);
				if (hashtable.get(num) > nums.length / 2)
					return num;
			} else {
				hashtable.put(num, 1);
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = new int[3];
		nums[0] = 6;
		nums[1] = 5;
		nums[2] = 5;
		// nums[3] = 1 ;
		// nums[4] = 6;

		MajorityElement test = new MajorityElement();
		System.out.println(test.majorityElement(nums));
	}
}
