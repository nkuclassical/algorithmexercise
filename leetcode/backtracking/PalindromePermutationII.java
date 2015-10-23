package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class PalindromePermutationII {
	List<String> ret = new ArrayList();
	HashMap<Character,Integer>map=new HashMap();
	public List<String> generatePalindromes(String s) {
		if (checkPalindromes(s)==-1)
			return ret;
		List<Character> unadded = new ArrayList();
		for (int i = 0; i < s.length(); i++) {
			unadded.add(s.charAt(i));
		}
		helper(unadded, new StringBuilder());
		return ret;
	}

	public void helper(List<Character> unadded, StringBuilder added) {
		if (unadded.size() == 0) {
				ret.add(added.toString());
		}
		for (int i = 0; i < unadded.size(); i++) {
			if (i > 0) {
				if (unadded.get(i) == unadded.get(i - 1)) {
					continue;
				}
			}
			Character c = unadded.get(i);
			added.append(c);
			unadded.remove(i);
			helper(unadded, added);
			unadded.add(i, c);
			added.deleteCharAt(added.length() - 1);
		}
	}

	public int checkPalindromes(String s) {
		
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				int time = map.get(s.charAt(i));
				map.put(s.charAt(i), time + 1);
			} else
				map.put(s.charAt(i), 1);
		}
		Iterator it = map.entrySet().iterator();
		int odd = 0;
		while (it.hasNext()) {
			Map.Entry<Character, Integer> entry = (Entry<Character, Integer>) it
					.next();
			if (entry.getValue() % 2 != 0) {
				odd++;
				if (odd > 1)
					return -1;
			}
		}
		if(odd==1)return 1;
		return 0;
	}

	

	public static void main(String[] args) {
		PalindromePermutationII test = new PalindromePermutationII();
		List<String> result = test.generatePalindromes("aabbccddeeff");
		for (String item : result) {
			System.out.println(item);
		}
	}
}
