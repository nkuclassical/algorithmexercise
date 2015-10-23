package math;

public class BasicCalculatorII {
	public int calculate(String s) {
		int ret = 0;
		int prev = 0, cur = 0, i = 0;
		char signal = '+';
		s = s.trim().replaceAll(" +", "");
		while (i < s.length()) {
			cur = 0;
			while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				cur = cur * 10 + s.charAt(i) - '0';
				i++;
			}
			switch (signal) {
			case '+':
				ret += prev;
				prev = cur;
				break;
			case '-':
				ret += prev;
				prev = -cur;
				break;
			case '*':
				prev *= cur;
				break;
			case '/':
				prev /= cur;
				break;
			}
			if (i < s.length()) {
				signal = s.charAt(i);
				i++;
			}
		}
		ret += prev;
		return ret;
	}

	public static void main(String[] args) {
		BasicCalculatorII test = new BasicCalculatorII();
		System.out.println(test.calculate("3 + 2*5 - 4/2"));
	}
}
