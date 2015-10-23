package sort;

import java.util.Arrays;

public class WiggleSort {
	public void wiggleSort(int[] nums) {
		Arrays.sort(nums);
		for(int i=1;i+1<nums.length;i+=2){
			int temp=nums[i];
			nums[i]=nums[i+1];
			nums[i+1]=temp;
		}
	}
	
	public void wiggleSort2(int[]nums){
		for(int i=0;i<nums.length;i++){
			if(i%2==1){
				if(nums[i-1]>nums[i])
					swap(nums,i);
			}else{
				if(i!=0&&nums[i-1]<nums[i])
					swap(nums,i);
			}
		}
	}
	private void swap(int[]nums, int i){
		int temp=nums[i];
		nums[i]=nums[i-1];
		nums[i-1]=temp;
	}
	public static void main(String[]args){
		int[]nums=new int[6];
		nums[0]=3;
		nums[1]=5;
		nums[2]=2;
		nums[3]=1;
		nums[4]=6;
		nums[5]=4;
		WiggleSort test=new WiggleSort();
		test.wiggleSort(nums);
		for(int i:nums){
			System.out.println(i);
		}
	}
}
