package hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> ret = new ArrayList();
		HashMap<String, List<String>> map = new HashMap();
		for (String str : strs) {
			String newstr = process(str);
			if (!map.containsKey(newstr)) {
				map.put(newstr, new ArrayList<String>());
			}
			map.get(newstr).add(str);
		}
		for (Entry<String, List<String>> entry : map.entrySet()) {
			List<String> newlist = entry.getValue();
			Collections.sort(newlist);
			ret.add(newlist);
		}
		return ret;
	}

	public String process(String s) {
		char[] c = s.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}

	public static void main(String[] args) {
		GroupAnagrams test = new GroupAnagrams();
		String[] strs = new String[6];
		strs[0] = "eat";
		strs[1] = "tea";
		strs[2] = "tan";
		strs[3] = "ate";
		strs[4] = "nat";
		strs[5] = "bat";
		List<List<String>> result = test.groupAnagrams(strs);
		for (List<String> rt : result) {
			for (String r : rt) {
				System.out.print(r + " ");
			}
			System.out.println();
		}
	}
}
