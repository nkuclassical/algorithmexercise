package backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {
	List<String> ret = new ArrayList();

	public List<String> restoreIpAddresses(String s) {
		helper(s, "", 4);
		return ret;
	}

	public void helper(String successor, String prefix, int left) {
		if (successor.length() == 0 && left == 0) {
			ret.add(new String(prefix));
			return;
		} else if (left == 0)
			return;
		else {
			// int newip=0;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 3 && i < successor.length(); i++) {
				// newip=newip*10+Integer.valueOf(successor.charAt(i)-'0');
				sb.append(successor.charAt(i));
				if (sb.length() > 1 && sb.charAt(0) != '0') {
					if (Integer.valueOf(sb.toString()) < 256) {
						if (prefix.length() == 0) {
							helper(successor.substring(i + 1), sb.toString(),
									left - 1);
						} else
							helper(successor.substring(i + 1), new String(
									prefix + "." + sb.toString()), left - 1);
					} else
						break;
				} else if (sb.length() == 1) {
					if (prefix.length() == 0) {
						helper(successor.substring(i + 1), sb.toString(),
								left - 1);
					} else
						helper(successor.substring(i + 1), new String(prefix
								+ "." + sb.toString()), left - 1);
				} else
					break;
			}
		}
	}

	public static void main(String[] args) {
		RestoreIPAddress test = new RestoreIPAddress();
//		String input = "25525511135";
		 String input="010010";
		List<String> result = test.restoreIpAddresses(input);
		for (String r : result) {
			System.out.println(r);
		}
	}
}
