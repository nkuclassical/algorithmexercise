package hashtable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class GroupShiftStrings {
	public List<List<String>> groupStrings(String[] strings) {
		HashMap<String, List<String>> map = new HashMap();
		List<List<String>> ret = new ArrayList();
		for (String string : strings) {
			if (string == null || string.length() == 0)
				continue;
			int offset = string.charAt(0) - 'a';
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < string.length(); i++) {
				char c = (char) (string.charAt(i) - offset);
				if (c < 'a') {
					c = (char) (c + 26);
				}
				sb.append(c);
			}
			if (!map.containsKey(sb.toString())) {
				map.put(sb.toString(), new ArrayList<String>());
			}
			map.get(sb.toString()).add(string);
		}
		for (Entry<String, List<String>> entry : map.entrySet()) {
			List<String> value = entry.getValue();
			Collections.sort(value);
			ret.add(value);
		}
		return ret;
	}

	public static void main(String[] args) {
		GroupShiftStrings test = new GroupShiftStrings();
		String[] strings = { "abc", "bcd", "acef", "xyz", "az", "ba", "a", "z" };
		List<List<String>> r = test.groupStrings(strings);
	}
}
