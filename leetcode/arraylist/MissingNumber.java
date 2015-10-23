package arraylist;

public class MissingNumber {
	public int missginNumber(int[] nums) {
		int len = nums.length;
		int sum = len * (len + 1) / 2;
		int cursum = 0;
		for (int num : nums) {
			cursum += num;
		}
		return sum - cursum;
	}
}
