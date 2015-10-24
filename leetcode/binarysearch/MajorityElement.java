package binarysearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class MajorityElement {
	public int majorityElement(int[] nums) {
		int ret = nums[0];
		int times = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == ret) {
				times++;
			} else if (times == 0) {
				ret = nums[i];
				times = 1;
			} else {
				times--;
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		int[] nums = new int[3];
		nums[0] = 6;
		nums[1] = 5;
		nums[2] = 5;

		MajorityElement test = new MajorityElement();
		System.out.println(test.majorityElement(nums));
	}
}
