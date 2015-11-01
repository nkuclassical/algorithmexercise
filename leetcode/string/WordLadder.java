package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	int ret;
	public int ladderLength2(String beginWord, String endWord,
			Set<String> wordList) { // Time Limited Exceeded
		if (beginWord.length() == 0)
			return 0;
		ret = wordList.size() + 1;
		HashSet<String> visited = new HashSet();
		helper(new StringBuilder(beginWord), endWord, wordList, 1, visited);
		if (ret == wordList.size() + 1)
			return 0;
		else
			return ret;
	}

	public void helper(StringBuilder beginWord, String endWord,
			Set<String> wordList, int curstep, Set<String> visited) {
		for (int i = 0; i < beginWord.length(); i++) {
			char beginc = beginWord.charAt(i);
			for (char c = 'a'; c <= 'z'; c++) {
				if (c == beginc)
					continue;
				else {
					beginWord.setCharAt(i, c);
					if (beginWord.toString().equals(endWord)) {
						if (ret > curstep + 1)
							ret = curstep + 1;
					}
					if (wordList.contains(beginWord.toString())) {

						if (!visited.contains(beginWord.toString())) {
							visited.add(beginWord.toString());
							helper(beginWord, endWord, wordList, curstep + 1,
									visited);
							visited.remove(beginWord.toString());
						}

					}
					beginWord.setCharAt(i, beginc);
				}
			}
		}
	}

	public int ladderLength(String beginWord, String endWord,
			Set<String> wordList) { // Accepted! 93ms
		if (beginWord.equals(endWord))
			return 1;
		Queue<String> q = new LinkedList();
		q.add(beginWord);
		int len = beginWord.length();
		int level = 2;
		wordList.remove(beginWord);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int k = 0; k < size; k++) {
				String s = q.poll();
				for (int i = 0; i < len; i++) {
					char[] c = s.toCharArray();
					for (char j = 'a'; j <= 'z'; j++) {
						c[i] = j;
						String cur = new String(c);
						if (cur.equals(endWord))
							return level;
						if (wordList.remove(cur)) {
							q.add(cur);
						}
					}
				}
			}
			level++;
		}
		return 0;
	}
	

	public static void main(String[] args) {
		WordLadder test = new WordLadder();
		Set<String> w = new HashSet();
		w.add("hot");
		w.add("dot");
		w.add("dog");
		w.add("lot");
		w.add("log");
		System.out.println(test.ladderLength("hit", "cog", w));
	}
}
