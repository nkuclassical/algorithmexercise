package arraylist;

public class JumpGame {
	public boolean canJump(int[] nums) {
		if (nums == null || nums.length == 0)
			return false;
		if (nums.length == 1)
			return true;
		int step = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i + nums[i] > step) {
				step = i + nums[i];
				if (step >= nums.length - 1)
					return true;
			}
			if (i == step && nums[i] == 0 && i != nums.length - 1) {
				return false;
			}
		}
		return false;
	}

	public boolean canJump2(int[] nums) {
		if (nums.length == 0)
			return false;
		int maxStep = nums[0];
		for (int i = 0; i < nums.length; i++) {
			if (maxStep < i)
				return false;
			maxStep = (maxStep < i + nums[i]) ? i + nums[i] : maxStep;
			if (maxStep >= nums.length - 1)
				return true;
		}
		return true;
	}

	public static void main(String[] args) {
		JumpGame jg = new JumpGame();
		int[] test = { 0 };
		System.out.println(jg.canJump(test));
	}
}
