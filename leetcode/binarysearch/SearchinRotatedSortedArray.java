package binarysearch;

public class SearchinRotatedSortedArray {
	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;
		int start = 0;
		int end = nums.length - 1;
		while (start < end - 1) {
			int mid = (start + end) / 2;
			if (target == nums[start])
				return start;
			if (target == nums[end])
				return end;
			if (target == nums[mid])
				return mid;
			if (target < nums[start] && target < nums[mid]) {
				if(nums[mid]<nums[start])
					end = mid;
				else 
					start=mid;
			} else if (target < nums[start] && target > nums[mid]) {
					start = mid;
			} else if (target > nums[start] && target < nums[mid]) {
				end = mid;
			} else if (target > nums[start] && target > nums[mid]) {
				if(nums[mid]<nums[start])
					end=mid;
				else
					start = mid;
			}
		}
		if (nums[start] == target)
			return start;
		if (nums[end] == target)
			return end;
		return -1;
	}

	public static void main(String[] args) {
		SearchinRotatedSortedArray t = new SearchinRotatedSortedArray();
		int[] a = new int[9];
		a[0] = 5;
		a[1] = 6;
		a[2] = 7;
		a[3] = 8;
		a[4] = 0;
		a[5] = 1;
		a[6] = 2;
		a[7] = 3;
		a[8] = 4;
		for (int i = 0; i <= 8; i++) {
			int ret = t.search(a, i);
			System.out.println(ret);
		}
	}
}
