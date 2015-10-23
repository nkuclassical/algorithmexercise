package dynamicprogramming;

import java.util.Arrays;

public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		if(nums.length==0)return Integer.MIN_VALUE;
		int previous=nums[0];
		int max=previous;
		for(int i=1;i<nums.length;i++){
			if(previous<0)previous=nums[i];
			else previous+=nums[i];
			if(previous>max)max=previous;
		}
		return max;
	}
	
	public static void main(String[]args){
		MaximumSubarray test=new MaximumSubarray();
		int [] nums=new int[9];
		nums[0]=-2;
		nums[1]=1;
		nums[2]=-3;
		nums[3]=4;
		nums[4]=-1;
		nums[5]=2;
		nums[6]=1;
		nums[7]=-5;
		nums[8]=4;
		System.out.println(test.maxSubArray(nums));
		
		Arrays.sort(nums);
		for(int item:nums){
			System.out.println(item);
		}
	}
}
