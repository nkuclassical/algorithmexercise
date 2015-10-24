package backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {
	public List<String> restoreIpAddresses(String s) {
		List<String> ret = new ArrayList();
		if (s.length() > 12)
			return ret;
		helper(ret, new ArrayList<String>(), s);
		return ret;
	}

	public void helper(List<String> ret, List<String> prefix, String s) {
		StringBuilder sb = new StringBuilder();
		if (prefix.size() == 4) {
			if (s.length() == 0) {
				for (int i = 0; i < prefix.size() - 1; i++) {
					sb.append(prefix.get(i) + ".");
				}
				sb.append(prefix.get(prefix.size() - 1));
				ret.add(sb.toString());
			}
		} else {
			for (int i = 0; i < s.length(); i++) {
				sb.append(s.charAt(i));
				if (getValue(sb.toString()) < 256) {
					if (sb.length() > 1 && sb.charAt(0) == '0')
						return;
					prefix.add(sb.toString());
					helper(ret, prefix, s.substring(i + 1));
					prefix.remove(prefix.size() - 1);
				} else {
					return;
				}
			}
		}
	}

	public int getValue(String s) {
		return Integer.valueOf(s);
	}

	public static void main(String[] args) {
		RestoreIPAddress test = new RestoreIPAddress();
		String input = "010010";
		List<String> result = test.restoreIpAddresses(input);
		for (String r : result) {
			System.out.println(r);
		}
	}
}
