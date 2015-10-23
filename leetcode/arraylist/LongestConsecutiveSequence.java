package arraylist;

import java.util.HashSet;

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		int max = 0, M = 0;
		HashSet<Integer> set = new HashSet();
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}

		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				max = 1;
				int temp = nums[i];
				while (set.contains(--temp)) {
					max++;
					set.remove(temp);
				}
				temp = nums[i];
				while (set.contains(++temp)) {
					max++;
					set.remove(temp);
				}
			}
			if (max > M)
				M = max;
		}
		return M;
	}
	
	public static void main(String[]args){
		LongestConsecutiveSequence test=new LongestConsecutiveSequence();
		int[]nums=new int[6];
		nums[0]=100;
		nums[1]=4;
		nums[2]=200;
		nums[3]=1;
		nums[4]=2;
		nums[5]=3;
		System.out.println(test.longestConsecutive(nums));
	}
}
