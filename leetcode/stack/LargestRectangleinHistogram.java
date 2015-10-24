package stack;

import java.util.Stack;

public class LargestRectangleinHistogram {
	public int largestRectangleArea(int[] height) {
		if (height.length == 0)
			return 0;
		Stack<Integer> stack = new Stack();
		int ret = 0;
		for (int i = 0; i < height.length; i++) {
			if (stack.isEmpty() || height[stack.peek()] < height[i]) {
				stack.push(i);
			} else {
				int start = stack.pop();
				int width = stack.isEmpty() ? i : i - stack.peek() - 1;
				ret = Math.max(ret, height[start] * width);
				i--;
			}
		}
		while (!stack.isEmpty()) {
			int start = stack.pop();
			int width = stack.isEmpty() ? height.length : height.length
					- stack.peek() - 1;
			ret = Math.max(ret, height[start] * width);
		}
		return ret;
	}
	
	public static void main(String[]args){
		LargestRectangleinHistogram test=new LargestRectangleinHistogram();
		int[]height={4,2};
		System.out.println(test.largestRectangleArea(height));
	}
	
}
