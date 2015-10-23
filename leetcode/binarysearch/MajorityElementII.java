package binarysearch;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer>ret=new ArrayList();
        if(nums==null||nums.length==0)return ret;
        int firstnum=nums[0],firstaccount=0,secondnum=nums[0],secondaccount=0;
        for(int num:nums){
            if(firstaccount==0){
                firstnum=num;
                firstaccount=1;
            }else if(firstnum==num){
                firstaccount++;
            }else if(secondaccount==0){
                secondnum=num;
                secondaccount=1;
            }else if(secondnum==num){
                secondaccount++;
            }else{
                firstaccount--;
                secondaccount--;
            }
        }
        
        if(count(nums,firstnum)>nums.length/3)ret.add(firstnum);
        if(secondnum!=firstnum&&count(nums,secondnum)>nums.length/3)ret.add(secondnum);
        return ret;
    }
    
    public int count(int[]nums,int target){
    	int ret=0;
    	for(int i:nums){
    		if(i==target)ret++;
    	}
    	return ret;
    }
    public static void main(String[]args){
    	MajorityElementII test=new MajorityElementII();
    	int[]nums=new int[4];
    	nums[0]=2;
    	nums[1]=2;
    	nums[2]=1;
    	nums[3]=3;
    	List<Integer>result=test.majorityElement(nums);
    	result.toString();
    	
    	
    }
    
}
