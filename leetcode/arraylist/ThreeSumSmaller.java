package arraylist;

import java.util.Arrays;

public class ThreeSumSmaller {
	public int threeSmaller(int[] nums, int target) {
		int ret=0;
		Arrays.sort(nums);
		for(int i=0;i<nums.length;i++){
			int j=i+1, k=nums.length-1;
			while(j<k){
				int sum=nums[i]+nums[j]+nums[k];
				if(sum<target){
					ret+=k-j;
					j++;
				}else{
					k--;
				}
			}
		}
		return ret;
	}
}
