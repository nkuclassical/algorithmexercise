package twopointers;

public class RemoveDuplicatefromSortedArray {
	public int removeDuplicates(int[] nums) {
		if(nums.length==0)return 0;
		if(nums.length==1)return 1;
		int left=0,right=1;
		while(right<nums.length){
			if(nums[right]!=nums[right-1]){
				nums[left+1]=nums[right];
				left++;
			}
			right++;
		}
		return left+1;
	}
	
    public int removeDuplicates2(int[] nums) {
        int slow=0, fast=1;
        for(fast=1;fast<nums.length;fast++){
            if(nums[slow]!=nums[fast]){
                nums[slow+1]=nums[fast];
                slow++;
            }
        }
        return slow+1;
    }
	public static void main(String[]args){
		RemoveDuplicatefromSortedArray test=new RemoveDuplicatefromSortedArray();
		int[]nums=new int[3];
		nums[0]=1;
		nums[1]=1;
		nums[2]=2;
//		nums[3]=3;
//		nums[4]=3;	
		int size=test.removeDuplicates2(nums);
		for(int i=0;i<size;i++){
			System.out.println(nums[i]);
		}
		
	}
}
