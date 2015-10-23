package string;

public class LengthofLastWord {
	public int lengthOfLastWord(String s) {
		int endpoint = s.length();
		int startpoint = -1;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (endpoint == s.length() && s.charAt(i) != ' ') {
				endpoint = i;
			}
			if (endpoint < s.length() && s.charAt(i) == ' ') {
				startpoint = i;
				break;
			}
		}
		if (endpoint != s.length()) {
			return endpoint - startpoint;
		}
		return 0;
	}

	public int lengthOfLastWord2(String s) {
		int end = -1, start = -1;
		int i;
		for (i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) != ' ') {
				end = i;
				break;
			}
		}

		if (end == -1)
			return 0;
		for (; i >= 0; i--) {
			if (s.charAt(i) == ' ') {
				start = i + 1;
				break;
			}
		}
		if (start == -1)
			start = 0;
		return end - start + 1;

	}

	public static void main(String[] args) {
		LengthofLastWord test = new LengthofLastWord();
		System.out.println(test.lengthOfLastWord("daffda   "));
	}
}
