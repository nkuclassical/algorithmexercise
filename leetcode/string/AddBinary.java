package string;

public class AddBinary {
	public int bintodec(String a) {
		int ret = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == '0') {
				ret *= 2;
			} else {
				ret = ret * 2 + 1;
			}
		}
		return ret;
	}

	public String dectobin(int a) {
		StringBuilder ret = new StringBuilder();
		if (a == 0)
			return "0";
		while (a > 0) {
			if (a % 2 == 0) {
				ret.append("0");
			} else
				ret.append("1");
			a /= 2;
		}
		return ret.reverse().toString();

	}

	public String addBinary(String a, String b) {
		return dectobin(bintodec(a) + bintodec(b));
	}

	public String addBinary2(String a, String b) {
		StringBuilder ret = new StringBuilder();
		int inc = 0;
		int i = a.length() - 1, j = b.length() - 1;
		for (; i >= 0 && j >= 0; i--, j--) {
			int anum = a.charAt(i) - '0';
			int bnum = b.charAt(j) - '0';
			ret.append(String.valueOf((anum + bnum + inc) % 2));
			if ((anum + bnum + inc) >= 2)
				inc = 1;
			else
				inc = 0;
		}
		while (i >= 0) {
			int anum = a.charAt(i) - '0';
			ret.append(String.valueOf((anum + inc) % 2));
			if ((anum + inc) >= 2)
				inc = 1;
			else
				inc = 0;
			i--;
		}
		while (j >= 0) {
			int bnum = b.charAt(j) - '0';
			ret.append(String.valueOf((bnum + inc) % 2));
			if ((bnum + inc) >= 2)
				inc = 1;
			else
				inc = 0;
			j--;
		}
		if (inc == 1)
			ret.append("1");
		return ret.reverse().toString();
	}

	public String addBinary3(String a, String b) {
		if (a.length() > b.length()) {
			String temp = a;
			a = b;
			b = temp;
		}
		a = reverse(a);
		b = reverse(b);
		StringBuilder ret = new StringBuilder();
		int inc = 0;
		for (int i = 0; i < a.length() && i < b.length(); i++) {
			int temp = a.charAt(i) + b.charAt(i) - '0' - '0' + inc;
			if (temp > 1) {
				inc = 1;
				temp -= 2;
			} else
				inc = 0;
			ret.append(temp);
		}
		for (int i = a.length(); i < b.length(); i++) {
			int temp = b.charAt(i) - '0' + inc;
			if (temp > 1) {
				inc = 1;
				temp -= 2;
			} else
				inc = 0;
			ret.append(temp);
		}
		if(inc!=0)ret.append(inc);
		return reverse(ret.toString());

	}

	public String reverse(String a) {
		StringBuilder ret = new StringBuilder();
		for (int i = a.length() - 1; i >= 0; i--) {
			ret.append(a.charAt(i));
		}
		ret.set
		return ret.toString();
	}

	public static void main(String[] args) {
		AddBinary test = new AddBinary();
		System.out
				.println(test
						.addBinary3(
								"10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
								"110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
	}
}
