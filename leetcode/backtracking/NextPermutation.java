package backtracking;

public class NextPermutation {
	public void nextPermutation(int[] nums) {
		int pos = -1;
		for (int i = nums.length - 1; i > 0; i--) {
			if (nums[i] > nums[i - 1]) {
				pos = i - 1;
				break;
			}
		}
		if (pos < 0) {
			reverse(nums, 0, nums.length - 1);
			return ;
		}
		for (int i = nums.length - 1; i > pos; i--) {
			if (nums[i] > nums[pos]) {
				int temp = nums[pos];
				nums[pos] = nums[i];
				nums[i] = temp;
				break;
			}
		}
		reverse(nums, pos + 1, nums.length - 1);
	}

	public void reverse(int[] nums, int start, int end) {
		int i = start, j = end;
		while (i < j) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			i++;
			j--;
		}
	}

	public static void main(String[] args) {
		NextPermutation test = new NextPermutation();
		int[] nums = new int[3];
		nums[0] = 1;
		 nums[1]=3;
		 nums[2]=2;
//		 nums[3]=2;
		test.nextPermutation(nums);
		for (int item : nums) {
			System.out.println(item);
		}
	}
}
