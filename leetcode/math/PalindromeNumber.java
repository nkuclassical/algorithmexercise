package math;

public class PalindromeNumber {
	
	public boolean isPalindrome(int x) {
		if(x==0)return true;
		if (x < 0|| x%10==0)
			return false;
		int rx = 0;
		while (rx < x) {
			rx = rx * 10 + x % 10;
			if(rx==x)return true;
			x /= 10;
		}
		return rx==x;
	}

	public static void main(String[] args) {
		PalindromeNumber test = new PalindromeNumber();
		System.out.println(test.isPalindrome(10));
		System.out.println(Integer.MAX_VALUE);
	}
}
