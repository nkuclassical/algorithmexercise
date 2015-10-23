package sort;

public class KthLargest {
	public int findKthLargest(int[] nums, int k) {
		return helper(nums,k-1,0,nums.length-1);
	}

	public int helper(int[]nums,int k,int l,int r){
		if(l>=r)return nums[l];
		else{
			int mid=sortOneTime(nums,l,r);
			if(mid>k){
				return helper(nums,k,l,mid-1);
			}else if(mid<k){
				return helper(nums,k,mid+1,r);
			}else return nums[mid];
		}
	}
	public int sortOneTime(int[] nums, int l, int r) {
		int pivot = nums[l];
		while (l < r) {
			while (l < r && nums[r] <= pivot) {
				r--;
			}
			if (l < r) {
				swap(l,r,nums);
			}
			while(l<r&&nums[l]>=pivot){
				l++;
			}
			if(l<r){
				swap(l,r,nums);	
			}
		}
		nums[l]=pivot;
		return l;
		
	}
	public void swap(int l,int r,int []nums){
		int temp = nums[r];
		nums[r]=nums[l];
		nums[l]=temp;
	}
	
	public static void main(String[]args){
		KthLargest test=new KthLargest();
		int[]nums=new int[5];
		nums[0]=3;
		nums[1]=10;
		nums[2]=1;
		nums[3]=5;
		nums[4]=6;
//		nums[5]=4;
		System.out.println(test.findKthLargest(nums, 2));
	}
}
