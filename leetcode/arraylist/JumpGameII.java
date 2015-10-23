package arraylist;

public class JumpGameII {
	public int jump(int[] nums) {
		int curReach = 0;
		int curMax = 0;
		int ret = 0;
		for (int i = 0; i < nums.length; i++) {
			if (curReach < i) {
				curReach = curMax;
				ret++;
			}
			curMax = Math.max(curMax, nums[i] + i);
		}
		return ret;
	}
}
