package dynamicprogramming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class UglyNumberII {
	// void removeprefix(LinkedList<Integer> list, int base, int limit) {
	// int time = list.size();
	// for (int i = 0; i < time; i++) {
	// if (list.get(0) * base > limit) {
	// break;
	// }
	// list.remove(0);
	// }
	// }
	//
	// void inumber(ArrayList<Integer> list, LinkedList<Integer> l2,
	// LinkedList<Integer> l3, LinkedList<Integer> l5) {
	// int lastnumber = list.get(list.size() - 1);
	// removeprefix(l2, 2, lastnumber);
	// removeprefix(l3, 3, lastnumber);
	// removeprefix(l5, 5, lastnumber);
	// int removenumber = Math.min(l2.get(0) * 2,
	// Math.min(l3.get(0) * 3, l5.get(0) * 5));
	// list.add(removenumber);
	// l2.add(removenumber);
	// l3.add(removenumber);
	// l5.add(removenumber);
	// }
	//
	// public int nthUglyNumber(int n) {
	// if (n < 1)
	// return 0;
	// else if (n == 1)
	// return 1;
	//
	// LinkedList<Integer> l2 = new LinkedList<Integer>();
	// LinkedList<Integer> l3 = new LinkedList<Integer>();
	// LinkedList<Integer> l5 = new LinkedList<Integer>();
	// ArrayList<Integer> ilist = new ArrayList<Integer>();
	// ilist.add(1);
	// l2.addAll(ilist);
	// l3.addAll(ilist);
	// l5.addAll(ilist);
	//
	// for (int i = 2; i <= n; i++) {
	// inumber(ilist, l2, l3, l5);
	// }
	//
	// return ilist.get(ilist.size() - 1);
	// }

	public int nthUglyNumber(int n) {
		PriorityQueue<Integer> minheap[] = new PriorityQueue[3];
		for (int i = 0; i < minheap.length; i++) {
			minheap[i] = new PriorityQueue(
					new Comparator<Integer>(){
						public int compare(Integer a, Integer b){
//							return b.compareTo(a);
							if(a>b)return 1;
							else if(a<b)return -
									1;
							else return 0;
						}
					}
					);
			minheap[i].add(1);
		}
		int next = 1;
		for (int i = 2; i <= n; i++) {

			next = Math.min(
					Math.min(minheap[0].isEmpty() ? Integer.MAX_VALUE
							: minheap[0].peek() * 2,
							minheap[1].isEmpty() ? Integer.MAX_VALUE
									: minheap[1].peek() * 3),
					minheap[2].isEmpty() ? Integer.MAX_VALUE : minheap[2]
							.peek() * 5);
			for (int j = 0; j < minheap.length; j++) {
				minheap[j].add(next);
			}
			if (minheap[0].peek()*2 == next)
				minheap[0].poll();
			if (minheap[1].peek()*3 == next)
				minheap[1].poll();
			if (minheap[2].peek()*5 == next)
				minheap[2].poll();
		}
		return next;

	}
	
	 public int nthUglyNumber2(int n) {
	        if(n<1)return 0;
	        if(n==1)return 1;
	        PriorityQueue<Integer> q2=new PriorityQueue();
	        PriorityQueue<Integer> q3=new PriorityQueue();
	        PriorityQueue<Integer> q5=new PriorityQueue();
	        q2.add(1);
	        q3.add(1);
	        q5.add(1);
	        int k=1;
	        for(k=2;k<n;k++){
	            Integer minValue=Math.min(Math.min(q2.peek()*2,q3.peek()*3),q5.peek()*5);
	            q2.add(minValue);
	            q3.add(minValue);
	            q5.add(minValue);
	            if(q2.peek()*2==minValue)q2.poll();
	            if(q3.peek()*3==minValue)q3.poll();
	            if(q5.peek()*5==minValue)q5.poll();
	        }
	        return Math.min(Math.min(q2.peek()*2,q3.peek()*3),q5.peek()*5);
	    }

	public static void main(String[] args) {
		UglyNumberII test = new UglyNumberII();
		for (int i = 1; i < 20; i++) {
			System.out.println(test.nthUglyNumber(i));
		}
	}
}
