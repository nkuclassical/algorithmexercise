package stack;

import java.util.Stack;

public class ImplementQueueusingStacks {
	Stack<Integer>stacka=new Stack<Integer>();
	Stack<Integer>stackb=new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
    	
        while(!stacka.empty()){
        	stackb.push(stacka.pop());
        }
        stacka.push(x);
        while(!stackb.empty()){
        	stacka.push(stackb.pop());
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        stacka.pop();
    }

    // Get the front element.
    public int peek() {
        return stacka.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stacka.empty();
    }
    
    public static void main(String[]args){
    	ImplementQueueusingStacks test=new ImplementQueueusingStacks();
//    	test.push(1);
//    	test.push(2);
//    	test.push(3);
//    	test.push(4);
//    	test.push(5);
//    	test.push(6);
    	while(!test.empty()){
    		System.out.println(test.peek());
        	test.pop();	
    	}
    	    	
    }
}
