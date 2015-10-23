package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsNEW {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>>ret=new ArrayList();
		Arrays.sort(nums);
		boolean []seats=new boolean[nums.length];
		helper(ret,nums,seats,0);
		return ret;
	}
	
	public void helper(List<List<Integer>>ret,int[]nums,boolean[]seats,int index){
		if(index==nums.length){
			List<Integer>list=new ArrayList();
			for(int i=0;i<nums.length;i++){
				if(seats[i])list.add(nums[i]);
			}
			ret.add(list);
			return;
		}
		
		seats[index]=true;
		helper(ret,nums,seats,index+1);
		seats[index]=false;
		helper(ret,nums,seats,index+1);
	}
}
