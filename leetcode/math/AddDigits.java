package math;

public class AddDigits {
	public int addDigits(int num) {
		return num-(num-1)/9*9;
	}
	public static void main(String[]args){
		AddDigits test=new AddDigits();
		System.out.println(test.addDigits(12));
	}
}
