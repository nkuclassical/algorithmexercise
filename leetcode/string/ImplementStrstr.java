package string;

public class ImplementStrstr {
	public int strStr(String haystack, String needle) {
		if (haystack.length() < needle.length())
			return -1;
		if (needle.length() == 0)
			return 0;
		char hc[] = haystack.toCharArray();
		char nc[] = needle.toCharArray();

		for (int i = 0; i < haystack.length(); i++) {
			if (hc[i] == nc[0]) {
				int j = 1;
				for (; j < needle.length(); j++) {
					if (i + j >= haystack.length() || hc[i + j] != nc[j]) {
						break;
					}
				}
				if (j == needle.length())
					return i;
			}
		}
		return -1;
	}
}
