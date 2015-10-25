package arraylist;

import java.util.PriorityQueue;

public class MergeKSortedArray {
	public int[]MergeKSortedArray(int[][]nums){
		PriorityQueue<ArrayContainer>heap=new PriorityQueue();
		int k=nums.length;
		int totallen=0;
		for(int i=0;i<k;i++){
			totallen+=nums[i].length;
			heap.add(new ArrayContainer(nums[i]));
		}
		int[]ret=new int[totallen];
		int index=0;
		while(!heap.isEmpty()){
			ArrayContainer array=heap.poll();
			ret[index++]=array.getNext();
			if(array.isEmpty())continue;
			heap.add(array);
		}
		return ret;
	}
	
	class ArrayContainer implements Comparable<ArrayContainer> {
		private int[]array;
		private int startIndex;
		public int getPeek(){
			return array[startIndex];
		}
		public ArrayContainer(int[]arr){
			this.array=arr;
			startIndex=0;
		}
		public boolean isEmpty(){
			return (startIndex>=array.length);
		}
		public int getNext(){
			return array[startIndex++];
		}
		//@Override
		public int compareTo(ArrayContainer o) {
			// TODO Auto-generated method stub
			return Integer.compare(getPeek(), o.getPeek());
		}
	}
	public static void main(String[]args){
		MergeKSortedArray test=new MergeKSortedArray();
		int[][]array={{1,4,5,6,10},{1,2,3,10,15},{2,3,7,8,9,11}};
		int[]ret=test.MergeKSortedArray(array);
		for(int r:ret){
			System.out.println(r);
		}
	}
}
