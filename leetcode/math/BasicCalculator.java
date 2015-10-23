package math;

import java.util.Stack;

public class BasicCalculator {

	public int calculate(String s) {
		Stack<Integer> operator = new Stack();
		Stack<Integer> operand = new Stack();
		int number = 0;
		int sign = 1;
		int ret = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				number = number * 10 + s.charAt(i) - '0';
			} else {
				ret += sign * number;
				number = 0;
				if (s.charAt(i) == '+')
					sign = 1;
				if (s.charAt(i) == '-')
					sign = -1;
				if (s.charAt(i) == '(') {
					operand.push(ret);
					operator.push(sign);
					ret = 0;
					sign = 1;
				}
				if (s.charAt(i) == ')' && operator.size() > 0) {
					ret = operator.pop() * ret + operand.pop();
				}
			}
		}
		ret += sign * number;
		return ret;
	}

	public static void main(String[] args) {
		BasicCalculator test = new BasicCalculator();
		// System.out.println(test.calculate("(1+(4+5+2)-3)+(6+8)"));
		System.out.println(test.calculate("2-1+2"));

	}
}
