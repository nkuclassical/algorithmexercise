package binarysearch;

public class FindPeakElement {
	public int findPeakElement(int[] nums) {
        int l=0,r=nums.length-1;
    	if(nums.length==1)return 0;
    	while(l<=r){
    		int mid=l+(r-l)/2;
    
    		if((mid==0||nums[mid-1]<nums[mid])&&(mid==nums.length-1||nums[mid]>nums[mid+1])){
    			return mid;
    		}
    		if(mid>0&&nums[mid]<nums[mid-1]){
    			r=mid-1;
    		}else{
    			l=mid+1;
    		}
    	}        
    	return 0;
    }
	
	public static void main(String[]args){
		FindPeakElement test=new FindPeakElement();
		int[]nums=new int[2];
		nums[0]=1;
		nums[1]=2;
		System.out.println(test.findPeakElement(nums));
	}
}
