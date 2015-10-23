package heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class TopK {
	public List<Integer> findTopBigK(int[] nums, int k) {
		PriorityQueue<Integer>queue=new PriorityQueue<Integer>(new Comparator<Integer>(){
			public int compare(Integer o1, Integer o2){
				return Integer.compare(o1, o2);
			}
		});
		
		for(int i=0;i<nums.length;i++){
			if(queue.size()<k){
				queue.add(nums[i]);
			}else{
				if(queue.peek()<nums[i]){
					queue.poll();
					queue.add(nums[i]);
				}
			}
		}
		
		List<Integer>list=new ArrayList();
		while(!queue.isEmpty()){
			list.add(queue.poll());
		}
		return list;
	}
	
	public List<Integer> findTopSmallK(int[]nums, int k){
		PriorityQueue<Integer>queue=new PriorityQueue<Integer>(new Comparator<Integer>(){
			public int compare(Integer o1, Integer o2){
				return Integer.compare(o2,o1);
			}
		});
		for(int i=0;i<nums.length;i++){
			if(queue.size()<k){
				queue.add(nums[i]);
			}else{
				if(queue.peek()>nums[i]){
					queue.poll();
					queue.add(nums[i]);
				}
			}
		}
		List<Integer>ret=new ArrayList();
		while(!queue.isEmpty()){
			ret.add(queue.poll());
		}
		return ret;
	}
	public static void main(String[]args){
		TopK test=new TopK();
		int[]nums={7,8,9,5,0,4,7,1,3,8,5,5,9,1,5,3,7,5};
		List<Integer>result=test.findTopSmallK(nums, 3);
		for(Integer r:result){
			System.out.println(r);
		}
	}
}
