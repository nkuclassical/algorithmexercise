package twopointers;

public class MinimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
		if(nums.length==0)return 0;
		int slow=0,fast=0;
		int partSum=0;
		int ret=Integer.MAX_VALUE;
		while(fast<nums.length){
			if(partSum<s){
				partSum+=nums[fast];
				fast++;
			}else{
				while(partSum>=s){
					ret=(fast-slow<ret)?fast-slow:ret;
					partSum-=nums[slow];
					slow++;
				}
			}
		}
		
		while(partSum>=s){
			ret=(fast-slow<ret)?fast-slow:ret;
			partSum-=nums[slow];
			slow++;
		}
		return ret==Integer.MAX_VALUE?0:ret;
		
	}
	
	public static void main(String[]args){
		MinimumSizeSubarraySum test=new MinimumSizeSubarraySum();
		int[]nums=new int[6];
		nums[0]=2;
		nums[1]=3;
		nums[2]=1;
		nums[3]=2;
		nums[4]=4;
		nums[5]=3;
		System.out.println(test.minSubArrayLen(7, nums));
	}
}
