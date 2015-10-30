package binarysearch;

public class SearchinRotatedSortedArray {
	public int search(int[] nums, int target) {
		int start = 0, end = nums.length - 1;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target)
				return mid;
			if (target == nums[end])
				return end;
			else if (target > nums[end]) {
				if (nums[end] > nums[start])
					return -1;
				if (nums[mid] < nums[end]) {
					end = mid - 1;
				} else {
					if (target > nums[mid]) {
						start = mid + 1;
					} else {
						end = mid - 1;
					}
				}
			} else {
				if (nums[end] > nums[start]) {
					if (nums[mid] < target) {
						start = mid + 1;
					} else {
						end = mid - 1;
					}
				} else {
					if (nums[mid] > nums[end]) {
						start = mid + 1;
					} else {
						if (nums[mid] < target) {
							start = mid + 1;
						} else {
							end = mid - 1;
						}
					}
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
