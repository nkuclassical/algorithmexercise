package string;

import java.util.ArrayList;
import java.util.List;

public class EncodeandDecodeStrings {
	// Encodes a list of strings to a single string.
	public String encode(List<String> strs) {
		StringBuilder sb = new StringBuilder();
		for (String str : strs) {
			sb.append(str.length());
			sb.append('@');
			sb.append(str);
		}
		return sb.toString();
	}

	// Decodes a single string to a list of strings.
	public List<String> decode(String s) {
		int i = 0;
		List<String> ret = new ArrayList<String>();
		while (i < s.length()) {
			int slash = s.indexOf('@', i);
			int size = Integer.valueOf(s.substring(i, slash));
			ret.add(s.substring(slash + 1, slash + 1 + size));
			i = slash + 1 + size;
		}
		return ret;
	}

	public static void main(String[] args) {
		EncodeandDecodeStrings test = new EncodeandDecodeStrings();
		List<String> strs = new ArrayList();
		strs.add("hello");
		strs.add("1@hell1@o1");
		strs.add("hello2");
		strs.add("hello3");
		String temp = test.encode(strs);
		List<String> result = test.decode(temp);
		for (String r : result) {
			System.out.println(r);
		}
	}

}
