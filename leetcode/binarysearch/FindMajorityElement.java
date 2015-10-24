package binarysearch;

import java.util.ArrayList;
import java.util.List;
/**
 * Using O(logn) runtime and O(1) space to get the major element from a sorted array
 * major element is defined as a number has appears more than 1/4 times
 * @author yanqiaozhan
 *
 */
public class FindMajorityElement {
	public List<Integer> find(int[] nums) {
		List<Integer>ret=new ArrayList();
		if(nums.length==0)return ret;
		int l=nums.length;
		int option1=l/4-1;
		int option2=l/2-1;
		int option3=l*3/4-1;
		int len1=0, len2=0, len3=0;
		int first1=findFirst(nums,0,l/2-1,nums[option1]);
		int last1=findLast(nums,l/4,l/2-1,nums[option1]);
		if(first1!=-1&&last1!=-1)
			len1=last1-first1+1;
		int first2=findFirst(nums,l/4,l/2-1,nums[option2]);
		int last2=findLast(nums,l/2,l*3/4-1,nums[option2]);
		if(first2!=-1&&last2!=-1)
			len2=last2-first2+1;
		int first3=findFirst(nums,l/2,l*3/4-1,nums[option3]);
		int last3=findLast(nums,l*3/4,l-1,nums[option3]);
		if(first3!=-1&&last3!=-1)
			len3=last3-first3+1;
		if(len1>l/4){
			ret.add(nums[option1]);
		}
		if(len2>l/4&&nums[option1]!=nums[option2]){
			
			ret.add(nums[option2]);
		}
		if(len3>l/4&&nums[option3]!=nums[option1]&&nums[option3]!=nums[option2]){
			ret.add(nums[option3]);
		}
		
		return ret;
	}
	public int findFirst(int[]nums, int start, int end, int target){
		while(start<=end){
			if(nums[start]==target)return start;
			else if(nums[start]>target)return -1;
			int mid=start+(end-start)/2;	
			if(nums[mid]<target){
				start=mid+1;
			}else if(nums[mid]>target){
				end=mid-1;
			}else{
				if(mid>0&&nums[mid-1]==target){
					end=mid-1;
				}else return mid;
			}
			start++;
			end--;
		}
		return -1;
	}
		
    public int findLast(int[]nums,int start, int end,int target){        
        int mid;
        while(start<=end){
            mid=start+(end-start)/2;
            if(nums[end]==target)return end;
            else if(nums[end]<target)return -1;
            if(nums[mid]==target){
                if(mid+1<nums.length&&nums[mid+1]==target)
                    start=mid+1;
                else return mid;
            }else if(nums[mid]<target){
                start=mid+1;
            }else {
                end=mid-1;
            }
        }
        return -1;
    }
	public static void main(String[]args){
		FindMajorityElement test=new FindMajorityElement();
		int[]nums={0,1,1,2,2,2,3,3,3,3,8,9};
		List<Integer>ret=test.find(nums);
		for(Integer r:ret){
			System.out.println(r);
		}
	}
}
