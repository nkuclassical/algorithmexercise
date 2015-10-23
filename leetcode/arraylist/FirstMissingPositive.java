package arraylist;

public class FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {
		bucket_sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (i + 1 != nums[i])
				return i + 1;
		}
		return nums.length + 1;
	}

	public void bucket_sort(int[] nums) {
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			while (nums[i] != i + 1) {
				if (nums[i] <= 0 || nums[i] > len
						|| nums[i] == nums[nums[i] - 1])
					break;
				swap(nums, i, nums[i] - 1);
			}
		}
	}
    public int firstMissingPositive2(int[] nums) {
        for(int i=0;i<nums.length;i++){
            while(nums[i]!=i+1){
                if(nums[i]<=0||nums[i]>nums.length||nums[i]==nums[nums[i]-1]){
                    break;
                }else{
                	swap(nums,i, nums[i]-1);
                }
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1)return i+1; 
        }
        return nums.length+1;
    }
	public void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	public static void main(String[]args){
		FirstMissingPositive test=new FirstMissingPositive();
		int[]a=new int[2];
		a[0]=2;
		a[1]=1;
//		a[2]=-1;
//		a[3]=1;
		System.out.println(test.firstMissingPositive2(a));
	}
}
