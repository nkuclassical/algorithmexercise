package arraylist;

public class RemoveElement {
	public int removeElement(int[] nums, int val) {
		int length=nums.length;
		if(length==0)return 0;
		if(length==1)return nums[0]==val?0:1;
		for(int i=length-1;i>=0;i--){
			if(nums[i]==val){
				nums[i]=nums[length-1];
				length--;
			}
		}
		return length;
	}
}
