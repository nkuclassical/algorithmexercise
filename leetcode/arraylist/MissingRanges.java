package arraylist;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		int start = lower;
		List<String> ret = new ArrayList();
		String temp;
		for (int i = 0; i < nums.length; i++) {
			
			if (nums[i] > start) {
				if (nums[i] > start + 1) {
					temp = String.valueOf(start) + "->"
							+ String.valueOf(nums[i] - 1);
					ret.add(temp);

				} else if (nums[i] == start + 1) {
					temp = String.valueOf(start);
					ret.add(temp);
				}
			}
			start = Math.max(start, nums[i] + 1);
			if(start>upper)break;
		}
		if(start<upper){
			ret.add(String.valueOf(start)+"->"+String.valueOf(upper));
		}else if(start==upper){
			ret.add(String.valueOf(upper));
		}
		return ret;
	}
	public List<String> findMissingRanges2(int[] nums, int lower, int upper) {
        int i=0,j=0;
        List<String>ret=new ArrayList();
        for(;i<nums.length;i++){
            if(nums[i]>=lower){
                break;
            }
        }
        int cur=lower;
        for(j=i;j<nums.length&&nums[j]<=upper;j++){
            if(cur==nums[j])cur++;
            else if(cur+1==nums[j]){
                ret.add(String.valueOf(cur));
                cur=nums[j]+1;
            }else if(cur+1<nums[j]){
                ret.add(String.valueOf(cur)+"->"+String.valueOf(nums[j]-1));
                cur=nums[j]+1;
            }
        }
        if(j==nums.length){
            if(nums[nums.length-1]+1<upper){
                ret.add(String.valueOf(nums[nums.length-1]+1)+"->"+String.valueOf(upper));
            }else if(nums[nums.length-1]==upper-1){
                ret.add(String.valueOf(upper));
            }
            
        }else{
            if(nums[j-1]+1<upper){
                ret.add(String.valueOf(nums[j-1]+1)+"->"+String.valueOf(upper));
            }else if(nums[j-1]==upper-1){
                ret.add(String.valueOf(upper));
            }
        }
        return ret;
        
    }
	public static void main(String[]args){
		MissingRanges test=new MissingRanges();
		int[]n=new int[5];
		n[0]=0;
		n[1]=1;
		n[2]=3;
		n[3]=50;
		n[4]=75;
		List<String>result=test.findMissingRanges2(n, 1, 1);
		for(String r:result){
			System.out.println(r);
		}
		
		result=test.findMissingRanges(n, 1, 1);
		for(String r:result){
			System.out.println(r);
		}
	}
}
