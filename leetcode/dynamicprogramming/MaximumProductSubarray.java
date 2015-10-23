package dynamicprogramming;

public class MaximumProductSubarray {
	public int maxProduct(int[] nums) {
		long max=nums[0],min=nums[0];
		int ret=nums[0];
		for(int i=1;i<nums.length;i++){
			if(nums[i]>0){
				max=Math.max(nums[i], max*nums[i]);
				min=Math.min(nums[i],min*nums[i]);
			}else{
				long temp=max;
				max=Math.max(nums[i], min*nums[i]);
				min=Math.min(nums[i], temp*nums[i]);
			}
			ret=(int) Math.max(max, ret);
		}
		return ret;
	}
	public static void main(String[]args){
		MaximumProductSubarray test=new MaximumProductSubarray();
		int[]nums=new int[4];
		nums[0]=2;
		nums[1]=3;
		nums[2]=-2;
		nums[3]=4;
		System.out.println(test.maxProduct(nums));
		
	}
}
