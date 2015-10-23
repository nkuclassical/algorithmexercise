package twopointers;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
    	if(nums.length==0||nums.length==1)return;
	    int slow=0,fast=0;
	    while(slow<nums.length){
		    if(nums[slow]!=0){
    			slow++;
    			fast++;
    		}else break;
    	}
    	while(fast<nums.length){
    		if(nums[fast]!=0){
    			nums[slow]=nums[fast];
    			nums[fast]=0;
    			slow++;
    		}
    		fast++;
    	}
    	return;   
    }	
}
