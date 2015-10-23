package string;

public class ScrambleString {
	public boolean isScramble(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		if (s1.equals(s2))
			return true;
		int[] counts = new int[256];
		for (int i = 0; i < s1.length(); i++) {
			counts[s1.charAt(i)]++;
			counts[s2.charAt(i)]--;
		}
		for (int i = 0; i < 256; i++) {
			if (counts[i] != 0)
				return false;
		}
		for (int i = 1; i < s1.length() ; i++) {
			if (isScramble(s1.substring(0, i), s2.substring(0, i))
					&& isScramble(s1.substring(i), s2.substring(i)))
				return true;
			if (isScramble(s1.substring(0, i), s2.substring(s1.length() - i))
					&& isScramble(s1.substring(i),
							s2.substring(0, s1.length()-i)))
				return true;
		}
		return false;

	}
	
	public static void main(String[]args){
		ScrambleString test=new ScrambleString();
		System.out.println(test.isScramble("abc", "bca"));
		StringBuilder sb=new StringBuilder();
		sb.de
	}
}
