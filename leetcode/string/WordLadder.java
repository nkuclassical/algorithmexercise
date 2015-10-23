package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	public int ladderLength(String beginWord, String endWord,
			Set<String> wordList) {
		Queue<String> queue = new LinkedList();
		HashMap<String, Integer> map = new HashMap();
		queue.add(beginWord);
		map.put(beginWord, 1);
		while (!queue.isEmpty()) {
			String curWord = queue.poll();
			int curTime = map.get(curWord);
			for (int i = 0; i < curWord.length(); i++) {
				for (char j = 'a'; j <= 'z'; j++) {
					if (j == curWord.charAt(i))
						continue;
					StringBuilder newWord = new StringBuilder(curWord);
					newWord.setCharAt(i, j);
					if (newWord.toString().equals(endWord))
						return curTime + 1;
					if (wordList.contains(newWord.toString())
							&& !map.containsKey(newWord.toString())) {
						map.put(newWord.toString(), curTime + 1);
						queue.add(newWord.toString());
					}
				}
			}
		}
		return 0;
	}

	public int ladderLength2(String beginWord, String endWord,
			Set<String> wordList) {
		Queue<String> q = new LinkedList();
		HashMap<String, Integer> map = new HashMap();
		q.add(beginWord);
		map.put(beginWord, 1);
		while (!q.isEmpty()) {
			String s = q.poll();

			for (int i = 0; i < s.length(); i++) {
				for (char j = 'a'; j <= 'z'; j++) {
					StringBuilder cur = new StringBuilder(s);
					cur.setCharAt(i, (char) j);
//					if (cur.toString().equals(s))
//						continue;
					if (cur.toString().equals(endWord))
						return map.get(s) + 1;
					if (wordList.contains(cur.toString())
							&& !map.containsKey(cur.toString())) {
						map.put(cur.toString(), map.get(s) + 1);
						q.add(cur.toString());
					}
				}
			}
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
		System.out.println(test.ladderLength2("hit", "cog", w));
	}
}
