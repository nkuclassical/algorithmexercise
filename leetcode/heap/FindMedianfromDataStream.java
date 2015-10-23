package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianfromDataStream {
	PriorityQueue<Integer> high = new PriorityQueue<Integer>();
	PriorityQueue<Integer> low =new PriorityQueue<Integer>(new Comparator<Integer>(){
		public int compare(Integer a, Integer b){
			return b.compareTo(a);
		}
	});
	
	
	// Adds a number into the data structure.
	public void addNum(int num) {
		if(high.size()==0){
			high.add(num);
		}else{
			if(high.peek()<=num){
				high.add(num);
			}else{
				low.add(num);
			}
		}
		while(high.size()-low.size()>1){
			int temp=high.poll();
			low.add(temp);
		}
		while(low.size()-high.size()>=1){
			int temp=low.poll();
			high.add(temp);
		}
	}

	// Returns the median of current data stream
	public double findMedian() {
		if(high.size()==low.size()){
			return ((double)high.peek()+low.peek())/2;
		}else{
			return high.peek();
		}
	}
	
	public static void main(String[]args){
		FindMedianfromDataStream test=new FindMedianfromDataStream();
		for(int i=1;i<=10;i++){
			test.addNum(i);
			System.out.println(test.findMedian());
		}
		
	}
}
