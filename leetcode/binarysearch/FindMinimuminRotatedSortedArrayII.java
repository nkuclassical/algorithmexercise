package binarysearch;

public class FindMinimuminRotatedSortedArrayII {
	public int findMin(int[] nums) {
		if (nums == null || nums.length == 0)
			return Integer.MAX_VALUE;
		int start = 0;
		int end = nums.length - 1;
		return find(nums, start, end);
	}

	public int find(int[] nums, int start, int end) {
		if (start == end - 1)
			return Math.min(nums[start], nums[end]);
		if(start>end)
			return nums[0];
		int mid = (start + end) / 2;
		if (mid > 0 && nums[mid - 1] > nums[mid])
			return nums[mid];
		if (mid + 1 <= end && nums[mid] > nums[mid + 1])
			return nums[mid + 1];
		if (nums[start] == nums[end] && nums[mid] == nums[start]) {
			return Math.min(find(nums, start, mid - 1),
					find(nums, mid + 1, end));
		}
		if (nums[start] <= nums[mid]) {
			return find(nums, mid + 1, end);
		} else
			return find(nums, start, mid - 1);
	}
}
