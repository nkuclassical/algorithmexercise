package bitmanipulation;

public class ReverseBits {
	public int reverseBits(int n) {
		int ret=0;
		for(int i=0;i<32;i++){
			int cur=n&1;
			ret=(ret<<1)+cur;
			n=n>>1;
		}
		return ret;
	}
	
	public static void main(String[]args){
		ReverseBits test=new ReverseBits();
		
		System.out.println(test.reverseBits(43261596));
		
	}
}
