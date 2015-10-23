package stack;

import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
				stack.add(s.charAt(i));
			} else if (s.charAt(i) == ')') {
				if (stack.empty() || stack.pop() != '(')
					return false;
			} else if (s.charAt(i) == ']') {
				if (stack.empty() || stack.pop() != '[')
					return false;
			} else if (s.charAt(i) == '}') {
				if (stack.empty() || stack.pop() != '{')
					return false;
			}

		}
		if (stack.empty())
			return true;
		return false;
	}

	public boolean isValid2(String s) {
		Stack<Character> stack = new Stack();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '[' || c == '{')
				stack.push(s.charAt(i));
			else if (stack.isEmpty()) {
				if (c == ')' || c == ']' || c == '}')
					return false;
			} else {
				char sc = stack.pop();
				if (c == ')' && sc != '(')
					return false;
				else if (c == ']' && sc != '[')
					return false;
				else if (c == '{' && sc != '{')
					return false;
			}
		}
		if (stack.isEmpty())
			return true;
		else
			return false;

	}
	
    public boolean isValid3(String s) {
        Stack<Character>stack=new Stack();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('||c=='{'||c=='[')stack.push(c);
            else if(stack.isEmpty())return false;
            else if(c==')'){
                if(stack.peek()!='(')return false;
            }else if(c==']'){
                if(stack.peek()!='[')return false;
            }else if(c=='}'){
                if(stack.peek()!='{')return false;
            }
        }
        if(stack.isEmpty())return true;
        else return false;
    }
    
    public static void main(String[]args){
    	ValidParentheses test=new ValidParentheses();
    	System.out.println(test.isValid3("("));
    }

}
