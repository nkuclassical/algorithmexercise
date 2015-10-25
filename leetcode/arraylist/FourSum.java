package arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>>ret=new ArrayList();
        if(nums.length==0)return ret;
        Arrays.sort(nums);
        int i=0,j=1;
        while(i<nums.length-3){
            j=i+1;
            while(j<nums.length-2){
                int start=j+1;
                int end=nums.length-1;
                int prefix=nums[i]+nums[j];
                while(start<end){
                    if(prefix+nums[start]+nums[end]==target){
                        List<Integer>line=new ArrayList();
                        line.add(nums[i]);
                        line.add(nums[j]);
                        line.add(nums[start]);
                        line.add(nums[end]);
                        ret.add(line);
                        start++;
                        end--;
                        while(start<end&&nums[start]==nums[start-1]){
                            start++;
                        }
                        while(start<end&&nums[end]==nums[end+1]){
                            end--;
                        }
                    }else if(prefix+nums[start]+nums[end]<target){
                        start++;
                        while(start<end&&nums[start]==nums[start-1]){
                            start++;
                        }
                    }else{
                        end--;
                        while(start<end&&nums[end]==nums[end+1]){
                            end--;
                        }
                    }
                }
                j++;
                while(j<nums.length-2&&nums[j]==nums[j-1])j++;
            }
            i++;
            while(i<nums.length-3&&nums[i]==nums[i-1])i++;
        }
        return ret;
    }
	
	public static void main(String[]args){
		int[]nums={1, 0, -1, 0, -2, 2};
		FourSum test=new FourSum();
		List<List<Integer>>ret=test.fourSum(nums, 0);
		for(List<Integer>r:ret){
			for(Integer r1:r){
				System.out.print(r1+" ");
			}
			System.out.println();
		}
	}
}
