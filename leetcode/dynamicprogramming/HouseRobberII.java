package dynamicprogramming;

public class HouseRobberII {
	public int rob(int[] nums) {
		if(nums.length==0)return 0;
		return Math.max(robSub(nums,1,nums.length), robSub(nums,2,nums.length-1)+nums[0]);
	}
	public int robSub(int[]nums,int start,int end){
		int previous1=0,previous2=0;
		for(int i=start;i<end;i++){
			int temp=Math.max(previous1,previous2+nums[i]);
			previous2=previous1;
			previous1=temp;
		}
		return previous1;
	}
	public static void main(String[]args){
		HouseRobberII test=new HouseRobberII();
		int[]nums=new int[0];
		System.out.println(test.rob(nums));
		
	}
	
}
