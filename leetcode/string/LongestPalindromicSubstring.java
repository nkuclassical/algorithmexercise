package string;

public class LongestPalindromicSubstring {
	int maxValue = 0, startIndex = 0;

	public String longestPalindrome(String s) {
		if (s == null || s.length() < 2)
			return s;

		for (int i = 0; i < s.length(); i++) {
			helper(s, i, i);
			helper(s, i, i + 1);
		}

		return s.substring(startIndex, startIndex + maxValue);
	}

	public void helper(String s, int i, int j) {
		while (i >= 0 && j < s.length()) {
			if (s.charAt(i) == s.charAt(j)) {
				i--;
				j++;
			} else {
				if ((j - i - 1) > maxValue) {
					startIndex = i + 1;
					maxValue = j - i - 1;
				}
				return;
			}
		}
		if ((j - i - 1) > maxValue) {
			startIndex = i + 1;
			maxValue = j - i - 1;
		}
		return;
	}

	int maxLen = 0, start = 0;

	public String longestPalindrome2(String s) {
		if (s == null || s.length() == 0 || s.length() == 1)
			return s;
		for (int i = 0; i < s.length(); i++) {
			helper2(s, i, i);
			helper2(s, i, i + 1);
		}
		return s.substring(start, start + maxLen);
	}

	public void helper2(String s, int start1, int start2) {
		while (start1 >= 0 && start2 < s.length()) {
			if (s.charAt(start1) == s.charAt(start2)) {
				if (start2 - start1 + 1 > maxLen) {
					start = start1;
					maxLen = start2 - start1 + 1;
					
				} 
				
				start1--;
				start2++;

			}
			else {
				break;
			}
		}
	}

	public static void main(String[] args) {
		LongestPalindromicSubstring test = new LongestPalindromicSubstring();
		String s = "abb";
		System.out.println(test.longestPalindrome2(s));
	}
}
