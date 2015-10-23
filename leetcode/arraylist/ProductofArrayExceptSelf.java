package arraylist;

public class ProductofArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		int length=nums.length;
		if(length==0)return nums;
		int[]ret=new int[length];
		int result=1;
		for(int i=0;i<length;i++){
			ret[i]=result;
			result*=nums[i];
		}
		result=1;
		for(int i=length-1;i>=0;i--){
			ret[i]*=result;
			result*=nums[i];
		}
		return ret;
	}
}
