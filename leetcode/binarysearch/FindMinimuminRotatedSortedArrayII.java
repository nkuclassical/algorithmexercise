package binarysearch;

public class FindMinimuminRotatedSortedArrayII {	
	public int findMin(int[] nums) {
        int start=0, end=nums.length-1;
        while(start<end){
        	while(start<end&&nums[start]==nums[end])start++;
        	int mid=start+(end-start)/2;
            if(mid-1>=0&&nums[mid-1]>nums[mid])return nums[mid];
            if(mid+1<nums.length&&nums[mid]>nums[mid+1])return nums[mid+1];
            if(nums[mid]<=nums[end]){
                end=mid;
            }else if(nums[mid]>=nums[start]){
                start=mid;
            }
        }
        return nums[start];
    }
	
	public static void main(String[]args){
		FindMinimuminRotatedSortedArrayII test=new FindMinimuminRotatedSortedArrayII();
		int[]nums={1,1,3,1};
		System.out.println(test.findMin(nums));
	}
	
}
