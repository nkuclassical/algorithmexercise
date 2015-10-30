package binarysearch;

public class SearchinRotatedSortedArray {
	public int search(int[] nums, int target) {
		int start = 0, end = nums.length - 1;
		while (start < end) {
			int r = nums[end];
			int l = nums[start];
			if (l == target)
				return start;
			if (r == target)
				return end;
			int mid = start + (end - start) / 2;
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] < target) {
				if (nums[mid] > l || target < r) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			} else {
				if (target < r && nums[mid] > l && l > r) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		if (nums[start] == target)
			return start;
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
