package heap;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
	    if(nums.length==0)return nums;
		Deque<Integer>deque=new ArrayDeque();
	    int[]ret=new int[nums.length-k+1];
	    deque.add(nums[0]);
	    for(int i=1;i<k;i++){
	    	while(!deque.isEmpty()&&deque.peekLast()<nums[i]){
	    		deque.pollLast();
	    	}
	    	deque.add(nums[i]);
	    }
	    
	    for(int i=k;i<nums.length;i++){
	    	ret[i-k]=deque.peekFirst();
	    	if(nums[i-k]==ret[i-k])deque.pollFirst();
	    	while(!deque.isEmpty()&&deque.peekLast()<nums[i]){
	    		deque.pollLast();
	    	}
	    	deque.add(nums[i]);
	    }
		ret[nums.length-k]=deque.pollFirst();
		return ret;
	}
	public int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums.length==0)return nums;
        Deque<Integer>maxValue=new ArrayDeque();
        int[]ret=new int[nums.length-k+1];
        
        for(int i=0;i<k;i++){
            while(!maxValue.isEmpty()&&maxValue.peekLast()<nums[i]){
                maxValue.pollLast();
            }
            maxValue.add(nums[i]);
        }
        for(int i=k;i<nums.length;i++){
            ret[i-k]=maxValue.peekFirst();
            if(nums[i-k]==maxValue.peekFirst())maxValue.pollFirst();
            while(!maxValue.isEmpty()&&maxValue.peekLast()<nums[i]){
                maxValue.pollLast();
            }
            maxValue.add(nums[i]);
        }
        ret[nums.length-k]=maxValue.pollFirst();
        return ret;
    }
	public static void main(String[]args){
		int[]nums=new int[8];
		nums[0]=1;
		nums[1]=3;
		nums[2]=-1;
		nums[3]=-3;
		nums[4]=-5;
		nums[5]=-3;
		nums[6]=6;
		nums[7]=7;
		SlidingWindowMaximum test=new SlidingWindowMaximum();
		int[]result=test.maxSlidingWindow2(nums,2);
		for(int r:result){
			System.out.println(r);
		}
	}
}
