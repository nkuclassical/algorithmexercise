package binarysearch;

public class SearchinRotatedSortedArrayII {
	public boolean search(int[] nums, int target) {
		if (nums.length == 0)
			return false;
		if (nums.length == 1)
			return nums[0] == target;
		int start = 0, end = nums.length - 1;
		while (start < end - 1) {
			int mid = start + (end - start) / 2;
			if (nums[start] == target || nums[mid] == target
					|| nums[end] == target)
				return true;
			if(nums[mid]==nums[start])start++;
			else if(nums[mid]==nums[end])end--;
			else if (nums[mid] > target) {
				if (nums[start] >= nums[mid])
					end = mid;
				else if (nums[start] > target)
					start = mid;
				else if (nums[start] < target) {
					end = mid;
				}
			} else {
				if (nums[start] < nums[mid]) {
					start = mid;
				} else if (nums[end] > target) {
					start = mid;

				} else if (nums[end] < target) {
					end = mid;
				}
			}
		}
		if (nums[start] == target || nums[end] == target)
			return true;
		return false;
	}

	public static void main(String[] args) {
		int[] nums = new int[4];
		nums[0] = 1;
		nums[1] = 1;
		nums[2] = 3;
		nums[3] = 1;
		// nums[4] = 7;
		// nums[5] = 2;
		// nums[6] = 2;
		SearchinRotatedSortedArrayII test = new SearchinRotatedSortedArrayII();
		int i=3;
//		for (int i = 0; i < 9; i++) {
			System.out.println(i + " -> " + test.search(nums, i));
//		}
	}
}
