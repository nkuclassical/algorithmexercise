package stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack();
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].equals("+")) {
				int operand1 = stack.pop();
				int operand2 = stack.pop();
				stack.push(operand1 + operand2);
			} else if (tokens[i].equals("-")) {
				int operand1 = stack.pop();
				int operand2 = stack.pop();
				stack.push(operand2 - operand1);
			} else if (tokens[i].equals("*")) {
				int operand1 = stack.pop();
				int operand2 = stack.pop();
				stack.push(operand1 * operand2);
			} else if (tokens[i].equals("/")) {
				int operand1 = stack.pop();
				int operand2 = stack.pop();
				stack.push(operand2 / operand1);
			}else {
				stack.push(Integer.valueOf(tokens[i]));
			}
		}
		return stack.peek();
	}
	public static void main(String[]args){
		EvaluateReversePolishNotation test=new EvaluateReversePolishNotation();
		String[]string=new String[1];
		string[0]="4";
		
		System.out.println(test.evalRPN(string));
	}
}
