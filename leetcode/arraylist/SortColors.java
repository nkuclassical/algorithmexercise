package arraylist;

public class SortColors {
	public void sortColors(int[] nums) {
		for(int i=0;i<nums.length;i++){
			for(int j=i;j<nums.length;j++){
				if(nums[i]>nums[j]){
					int temp=nums[i];
					nums[i]=nums[j];
					nums[j]=temp;
				}
			}
		}
	}
	
    public void sortColors2(int[] nums) {
        int index0=0,index2=nums.length-1;
        for(int i=0;i<=index2;){
            if(nums[i]==0){
            	nums[i]=nums[index0];
                nums[index0]=0;
                if(nums[i]==0)i++;
                index0++;
            }else if(nums[i]==2){
            	nums[i]=nums[index2];
                nums[index2]=2;
                index2--;               
            }else{
            	i++;
            }
        }
    }
    
    public void sortColor3(int []nums){
    	int index0=0, index2=nums.length-1;
    	while(index0<index2){
    		if(nums[index0]==0){
    			index0++;
    		}else 
    		if(nums[index2]==2){
    			index2--;
    		}
    	}
    }
    
    public static void main(String[]args){
    	SortColors test=new SortColors();
    	int[]nums={1,2,0};
    	test.sortColors2(nums);
    	for(int n:nums){
    		System.out.println(n);
    	}
    	
    }
}
