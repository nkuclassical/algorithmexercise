package dynamicprogramming;

import java.util.Stack;

public class LongestValidParentheses {
	public int longestValidParenthese1(String s) {
		Stack<Integer> stack = new Stack();
		int start = -1, ret = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(')
				stack.push(i);
			else {
				if (!stack.isEmpty()) {
					stack.pop();
					if(!stack.isEmpty()){
						ret=Math.max(ret, (i-stack.peek()));	
					}else{
						ret=Math.max(ret, i-start);
					}
					
				}else{
					start=i;
				}
			}
		}
		return ret;
	}
}
