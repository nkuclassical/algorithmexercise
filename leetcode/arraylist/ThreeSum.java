package arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>>threeSum(int[]nums){
		Arrays.sort(nums);
		List<List<Integer>>ret=new ArrayList();
		for(int i=0;i<nums.length;i++){
			int start=i+1, end=nums.length-1;
			while(start<end){
				int sum=nums[i]+nums[start]+nums[end];
				if(sum==0){
					List<Integer>list=new ArrayList();
					list.add(nums[i]);
					list.add(nums[start]);
					list.add(nums[end]);
					ret.add(list);
					start++;
					end--;
					while(start<end&&nums[start]==nums[start-1])start++;
					while(start<end&&nums[end]==nums[end+1])end--;
				}else if(sum<0){
					start++;
					while(start<end&&nums[start]==nums[start-1])start++;
				}else{
					end--;
					while(start<end&&nums[end]==nums[end+1])end--;
				}
			}
			while(i<nums.length-1&&nums[i]==nums[i+1])i++;
		}
		return ret;
	}
}
