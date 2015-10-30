package string;

public class ZigZagConversion {
	public String convert(String s, int numRows) {
		if (s == null || s.length() == 0)
			return s;
		if (numRows == 1)
			return s;
		StringBuilder sb = new StringBuilder();
		int j = 0;
		while (j < s.length()) {
			sb.append(s.charAt(j));
			j += 2 * (numRows - 1);
		}
		for (int i = 1; i < numRows - 1; i++) {
			j = i;
			while (j < s.length()) {
				sb.append(s.charAt(j));
				j += 2 * (numRows - 1 - i);
				if (j < s.length())
					sb.append(s.charAt(j));
				j += 2 * i;
			}
		}
		j = numRows - 1;
		while (j < s.length()) {
			sb.append(s.charAt(j));
			j += 2 * (numRows - 1);
		}
		return sb.toString();
	}
}
