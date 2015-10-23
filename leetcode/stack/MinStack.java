package stack;

import java.util.Stack;

public class MinStack {
    Stack<Integer>numstack=new Stack();;
    Stack<Integer>minstack=new Stack();
	public void push(int x) {
        numstack.add(x);
        if(minstack.empty())minstack.add(x);
        else if(minstack.peek()>=x)minstack.add(x);
    }

    public void pop() {
        if(minstack.peek().equals(numstack.peek()))minstack.pop();
        numstack.pop();
    }

    public int top() {
        return numstack.peek();
    }

    public int getMin() {
        return minstack.peek();
    }
    
    public static void main(String[]args){
    	MinStack test=new MinStack();
    	test.push(512);
    	test.push(-1024);
    	test.push(-1024);
    	test.push(512);
    	test.pop();
    	System.out.println(test.getMin());
    	test.pop();
    	System.out.println(test.getMin());
    	test.pop();
    	System.out.println(test.getMin());
//    	test.pop();
//    	System.out.println(test.getMin());
//    	test.pop();
//    	System.out.println(test.getMin());
//    	test.pop();
//    	System.out.println(test.getMin());
    	
    }
}
