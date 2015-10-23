package linkedlist;

public class RemoveDuplicatesfromSortedArrayII {
	public int removeDuplicates(int[] nums) {
		if(nums.length<=2)return nums.length;
		int fast=1,slow=0;
		int times=0;
		while(fast<nums.length){
			if(nums[fast]==nums[slow]){
				if(times<1){
					times++;
					nums[slow+1]=nums[fast];
					slow++;
					fast++;
				}else{
					times++;
					fast++;
				}
			}else{
				times=0;
				nums[slow+1]=nums[fast];
				slow++;
				fast++;
			}
		}
		return slow+1;
	}
	
    public int removeDuplicates2(int[] nums) {
        int slow1=0, slow2=0, fast=0;
        for(fast=0;fast<nums.length;fast++){
            if(nums[fast]==nums[slow2]){
                if(slow1==slow2){
                    nums[slow2]=nums[fast];
                    slow2++;
                }
            }else{
                nums[slow2]=nums[fast];
                slow2++;
                slow1=slow2;
            }
        }
        return slow2+1;
    }
	public static void main(String[]args){
		RemoveDuplicatesfromSortedArrayII test=new RemoveDuplicatesfromSortedArrayII();
		int nums[]=new int[8];
		nums[0]=1;
		nums[1]=1;
		nums[2]=3;
		nums[3]=3;
		nums[4]=5;
		nums[5]=6;
		nums[6]=7;
		nums[7]=8;
		int r=test.removeDuplicates2(nums);
		for(int i=0;i<r;i++){
			System.out.println(nums[i]);	
		}
		
		
		
	}
}
