package hashtable;

import java.util.HashMap;
import java.util.Map.Entry;

public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		int[] tmap = new int[256];
		int[] smap = new int[256];
		for (int i = 0; i < t.length(); i++) {
			tmap[t.charAt(i)]++;

		}
		String ret = "";
		int length = Integer.MAX_VALUE;
		int i = 0, j = 0, found = 0;
		while (j < s.length()) {
			if (tmap[s.charAt(j)] > 0) {
				smap[s.charAt(j)]++;
				if (smap[s.charAt(j)] <= tmap[s.charAt(j)]) {
					found++;
				}

			}
			j++;

			while (found == t.length()) {
				if (j - i < length) {
					length = j - i;
					ret = s.substring(i, j);
				}
				if (tmap[s.charAt(i)] > 0) {
					smap[s.charAt(i)]--;
					if (smap[s.charAt(i)] < tmap[s.charAt(i)]) {
						found--;
					}
				}
				i++;
			}
		}

		return ret;
	}

	public String minWindow2(String s, String t) {
		int[] smap = new int[256];
		int[] tmap = new int[256];
		for (int i = 0; i < s.length(); i++) {
			tmap[t.charAt(i)]++;
		}
		String ret = "";
		int length = Integer.MAX_VALUE;
		int fast = 0, slow = 0, found = 0;
		while (fast < s.length()) {
			if (tmap[s.charAt(fast)] > 0) {
				smap[s.charAt(fast)]++;
				if (smap[s.charAt(fast)] <= tmap[s.charAt(fast)]) {
					found++;
				}
			}
			fast++;
			while (found == t.length()) {
				if (fast - slow < length) {
					length = fast - slow;
					ret = s.substring(slow, fast);
				}
				if (tmap[s.charAt(slow)] > 0) {
					smap[s.charAt(slow)]--;
					if (smap[s.charAt(slow)] < tmap[s.charAt(slow)]) {
						found--;
					}
				}
				slow++;
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		MinimumWindowSubstring test = new MinimumWindowSubstring();
		System.out.println(test.minWindow("ADOBECODEBANC", "ABC"));
	}

}
