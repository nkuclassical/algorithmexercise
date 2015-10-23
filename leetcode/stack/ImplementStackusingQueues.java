package stack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackusingQueues {
	Queue<Integer>queuea=new LinkedList<Integer>();
	Queue<Integer>queueb=new LinkedList<Integer>();
	// Push element x onto stack.
    public void push(int x) {
        while(!queuea.isEmpty()){
        	queueb.add(queuea.poll());
        }
        queuea.add(x);
        while(!queueb.isEmpty()){
        	queuea.add(queueb.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        queuea.poll();
    }

    // Get the top element.
    public int top() {
        return queuea.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queuea.isEmpty();
    }
    
    public static void main(String[]args){
    	ImplementStackusingQueues test=new ImplementStackusingQueues();
    	for(int i=0;i<5;i++){
    		test.push(i);
    	}
    	while(!test.empty()){
    		System.out.println(test.top());
    		test.pop();
    	}
    }
}
