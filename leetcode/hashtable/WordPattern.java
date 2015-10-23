package hashtable;

import java.util.HashMap;

public class WordPattern {
	public boolean wordPattern(String pattern, String str) {
		HashMap<Character, String> map = new HashMap();
		HashMap<String, Character> rmap = new HashMap();
	
		String[] strings = str.split(" ");
		if (strings.length != pattern.length())
			return false;
		for (int i = 0; i < pattern.length(); i++) {
			if (map.containsKey(pattern.charAt(i))) {
				if (!rmap.containsKey(strings[i])
						|| rmap.get(strings[i]) != pattern.charAt(i))
					return false;
				if (map.get(pattern.charAt(i)).equals(strings[i]))
					continue;
				else
					return false;
			} else {
				if (rmap.containsKey(strings[i]))
					return false;
				map.put(pattern.charAt(i), strings[i]);
				rmap.put(strings[i], pattern.charAt(i));
			}

		}
		return true;
	}
	
	public static void main(String[]args){
		WordPattern test=new WordPattern();
		System.out.println(test.wordPattern("abba", "dog dog dog dog"));
		System.out.println(test.wordPattern("abba", "dog cat cat dog"));
	}
}
