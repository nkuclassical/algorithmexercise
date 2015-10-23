package binarysearch;

public class FindMinimuminRotatedSortedArray {
	public int findMin(int[] nums) {
		if (nums == null || nums.length == 0)
			return Integer.MAX_VALUE;
		int start = 0;
		int end = nums.length-1;
		while (start < end-1) {
			int mid=(start+end)/2;
			if(nums[mid]<nums[end]){
				end=mid;
			}else if(nums[mid]>nums[start]){
				start=mid;
			}
		}
		if(start==end-1){
			return Math.min(nums[start], nums[end]);
		}else return nums[start];
	}
	
	public static void main(String[]args){
		FindMinimuminRotatedSortedArray test=new FindMinimuminRotatedSortedArray();
		int[]nums={1,2,3};
		System.out.println(test.findMin(nums));
	}
}
