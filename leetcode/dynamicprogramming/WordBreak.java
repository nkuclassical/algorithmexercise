package dynamicprogramming;

import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, Set<String> wordDict) {
		boolean[] match = new boolean[s.length() + 1];
		match[0] = true;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j >= 0; j--) {
				String sub = s.substring(j, i + 1);
				if (wordDict.contains(sub)) {
					if (match[j]) {
						match[i + 1] = true;
						break;
					}
				}
			}
		}
		return match[s.length()];
	}
}
