package bitmanipulation;

public class SingleNumber {
	public int singleNumber(int[] nums) {
		int a=0;
		for(int i=0;i<nums.length;i++){
			a^=nums[i];
		}
		return a;
	}
	public static void main(String[]args){
		SingleNumber test=new SingleNumber();
		int[]a=new int[7];
		a[0]=1;
		a[1]=3;
		a[2]=3;
		a[3]=1;
		a[4]=5;
		a[5]=7;
		a[6]=7;
		System.out.println(test.singleNumber(a));
	}
}
