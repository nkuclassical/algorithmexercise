package bitmanipulation;

public class PowerofTwo {
	public boolean isPowerOfTwo(int n) {

		if(n<0)return false;
		while(n!=1){
			if((n&1)!=0)return false;
			else{
				n=n>>1;
			}
		}
		return false;
	}
	public static void main(String[]args){
		PowerofTwo test=new PowerofTwo();
		System.out.println(test.isPowerOfTwo(8));
		
	}
}
