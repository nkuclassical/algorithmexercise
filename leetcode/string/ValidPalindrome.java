package string;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		s = s.toLowerCase();
		s.trim().replaceAll(" +", "");
		int start = 0, end = s.length() - 1;
		while (start < end) {
			char l = s.charAt(start);
			char r = s.charAt(end);
			if (!((l >= 'a' && l <= 'z') ||(l>='0'&&l<='9'))){
				start++;
				continue;
			}
			if(!((r>='a'&&r<='z')||(r>='0'&&r<='9'))){
				end--;
				continue;
			}
			if(l!=r)return false;
			start++;
			end--;
		}
		return true;
	}
	
	public static void main(String[]args){
		ValidPalindrome test=new ValidPalindrome();
//		System.out.println(test.isPalindrome("A man, a plan, a canal: Panama"));
//		System.out.println(test.isPalindrome("race a car"));
		System.out.println(test.isPalindrome("d1D"));
	}
}
