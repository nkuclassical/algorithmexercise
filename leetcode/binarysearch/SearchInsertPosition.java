package binarysearch;

public class SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
		return binarySearch(nums,0,nums.length-1,target);
	}
	public int binarySearch(int[]nums,int start,int end,int target){
		if(start>end)return -1;
		if(nums[start]>target)return start;
		if(nums[end]<target)return end+1;
		if(start==end){
			if(nums[start]>=target)return start;
			else return start+1;
		}
		if(start==end-1){
			if(nums[start]>=target)return start;
			else if(nums[start]<target&&nums[end]>=target)return end;
			else return end+1;
		}
		int mid=start+(end-start)/2;
		if(nums[mid]==target)return mid;
		else if(nums[mid]<target)return binarySearch(nums,mid+1,end,target);
		else return binarySearch(nums,start,mid-1,target);
	}
	public static void main(String[]args){
		SearchInsertPosition test=new SearchInsertPosition();
		int[]nums=new int[4];
		nums[0]=1;
		nums[1]=3;
		nums[2]=5;
		nums[3]=6;
		for(int i=0;i<8;i++)
			System.out.println(test.searchInsert(nums, i));
	}
}
