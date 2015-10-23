package arraylist;

import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSum(int[]nums, int target){
		if(nums.length<3)return 0;
		Arrays.sort(nums);
		int ret=nums[0]+nums[1]+nums[2];
		for(int i=0;i<nums.length;i++){
			int start=i+1, end=nums.length-1;
			while(start<end){
				int sum=nums[i]+nums[start]+nums[end];
				ret=(Math.abs(ret-target)>Math.abs(sum-target))?sum:ret;
				if(sum==target)return sum;
				else if(sum<target){
					start++;
					while(start<end&&nums[start]==nums[start-1])start++;
				}else{
					end--;
					while(start<end&&nums[end]==nums[end+1])end--;
				}
			}
			while(i+1<nums.length&&nums[i]==nums[i+1])i++;
		}
		return ret;
	}
}
