package dynamicprogramming;

public class HouseRobber {
	public int rob(int[] nums) {
		if(nums.length==0)return 0;
		int[]E=new int[nums.length+1];
		E[0]=nums[nums.length-1];
		E[1]=nums[0];
		for(int i=1;i<nums.length;i++){
			E[i+1]=Math.max(E[i], E[i-1]+nums[i]);
		}
		return E[nums.length];
	}
	
	public static void main(String[]args){
		HouseRobber test=new HouseRobber();
		int[]nums=new int[1];
		nums[0]=5;
//		nums[1]=100;
//		nums[2]=99;
//		nums[3]=1;
		System.out.println(test.rob(nums));
	}
}
