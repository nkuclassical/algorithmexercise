package dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreakII {

	Map<String, List<String>> results = new HashMap();

	// public List<String> wordBreak(String s, Set<String> wordDict) {
	// return helper(s, wordDict);
	//
	// }

	public List<String> wordBreak(String s, Set<String> wordDict) {
		List<String> ret = new ArrayList();
		for (int i = 1; i <= s.length(); i++) {
			String first = s.substring(0, i);
			if (wordDict.contains(first)) {
				if (i == s.length())
					ret.add(first);
				else {
					String remain = s.substring(i);
					List<String> remainSet = results.containsKey(remain) ? results
							.get(remain) : wordBreak(remain, wordDict);
					results.put(remain, remainSet);
					if (remainSet != null) {
						for (String r : remainSet) {
							ret.add(first + " " + r);
						}
					}
				}
			}
		}
		return ret;
	}

	// Map<String, List<String>> results = new HashMap<String, List<String>>();
	//
	// public List<String> wordBreak(String s, Set<String> dict) {
	// List<String> words = new ArrayList<String>();
	//
	// int len = s.length();
	// for (int i = 1; i <= len; i++) {
	// String front = s.substring(0, i);
	// if (dict.contains(front)) {
	// if (i == len) {
	// words.add(front);
	// } else {
	// String remain = s.substring(i, len);
	// List<String> remainSet = results.containsKey(remain) ? results
	// .get(remain) : wordBreak(remain, dict);
	// if (remainSet != null) {
	// for (String item : remainSet) {
	// words.add(front + " " + item);
	// }
	// results.put(remain, remainSet);
	// }
	//
	// }
	// }
	// }
	// return words;
	// }

	public static void main(String[] args) {
		WordBreakII test = new WordBreakII();
		Set<String> set = new HashSet();
		set.add("cat");
		set.add("cats");
		set.add("and");
		set.add("sand");
		set.add("dog");
		// set.add("cat");
		List<String> result = test.wordBreak("catsanddog", set);
		for (String rt : result) {
			System.out.println(rt);
		}

	}
}
