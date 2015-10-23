package hashtable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class GroupShiftStrings {
	public List<List<String>> groupStrings(String[] strings) {
		List<List<String>> ret = new ArrayList();
		HashMap<String, List<String>> map = new HashMap();
		for (String str : strings) {
			if (str.length() == 0)
				continue;
			else {
				String temp = "";
				int offset = str.charAt(0) - 'a';
				for (int i = 0; i < str.length(); i++) {
					char c = (char) (str.charAt(i) - offset);
					if (c < 'a')
						c += 26;
					temp += c;
				}
				if (map.containsKey(temp)) {
					map.get(temp).add(str);
				} else {
					List<String> list = new ArrayList();
					map.put(temp, list);
					map.get(temp).add(str);
				}
			}
		}
		for (Entry<String, List<String>> entry : map.entrySet()) {
			List<String> l = entry.getValue();
			Collections.sort(l);
			ret.add(l);
		}
		return ret;
	}

	public static void main(String[] args) {
		GroupShiftStrings test = new GroupShiftStrings();
		String[] strings = { "abc", "bcd", "acef", "xyz", "az", "ba", "a", "z" };
		List<List<String>> r = test.groupStrings(strings);
	}
}
