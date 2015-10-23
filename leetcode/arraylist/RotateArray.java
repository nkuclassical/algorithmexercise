package arraylist;

public class RotateArray {
	public void rotate(int[] nums, int k) {
		if (nums.length == 0)
			return;
		k = k % nums.length;
		if (k == 0)
			return;
		int[] ret = nums.clone();
		for (int i = 0; i < k; i++) {
			nums[i] = ret[ret.length - k + i];
		}
		for (int i = k; i < ret.length; i++) {
			nums[i] = ret[i - k];
		}
		
	}
	public static void main(String[]args){
		int[]a=new int[2];
		a[0]=1;
		a[1]=2;
		RotateArray ra=new RotateArray();
		ra.rotate(a, 1);
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
	}
	
}
