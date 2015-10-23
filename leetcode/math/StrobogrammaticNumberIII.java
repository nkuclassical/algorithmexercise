package math;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class StrobogrammaticNumberIII {
	List<String> ret = new ArrayList();

	public List<String> findStrobogrammatic(int n) {
		if (n == 0)
			return ret;
		else if (n == 1)
			helper(new StringBuilder(), 1);
		else {
			helper(new StringBuilder("11"), n - 2);
			helper(new StringBuilder("69"), n - 2);
			helper(new StringBuilder("88"), n - 2);
			helper(new StringBuilder("96"), n - 2);
		}
		return ret;

	}

	public void helper(StringBuilder sb, int n) {
		if (n == 0) {
			ret.add(sb.toString());
		} else if (n == 1) {
			int midIndex = sb.length() / 2;
			sb.insert(midIndex, "0");
			ret.add(sb.toString());
			sb.deleteCharAt(midIndex);
			sb.insert(midIndex, "1");
			ret.add(sb.toString());
			sb.deleteCharAt(midIndex);
			sb.insert(midIndex, "8");
			ret.add(sb.toString());
			sb.deleteCharAt(midIndex);
			return;
		} else {
			int midIndex = sb.length() / 2;
			helper(sb.insert(midIndex, "00"), n - 2);
			sb.delete(midIndex, midIndex + 2);
			helper(sb.insert(midIndex, "11"), n - 2);
			sb.delete(midIndex, midIndex + 2);
			helper(sb.insert(midIndex, "69"), n - 2);
			sb.delete(midIndex, midIndex + 2);
			helper(sb.insert(midIndex, "88"), n - 2);
			sb.delete(midIndex, midIndex + 2);
			helper(sb.insert(midIndex, "96"), n - 2);
			sb.delete(midIndex, midIndex + 2);
		}
	} 
	public int strobogrammaticInRange(String low, String high) {
		
		for(int i=low.length();i<=high.length();i++){
			findStrobogrammatic(i);
		}
		int count=0;
		for(int i=0;i<ret.size();i++){
			if(ret.get(i).length()==low.length()){
				if(ret.get(i).compareTo(low)<0)continue;
			}
			
			if(ret.get(i).length()==high.length()){
				if(ret.get(i).compareTo(high)>0)continue;
			}
			count++;
		}
		return count;
	}
	
	public static void main(String[]args){
		StrobogrammaticNumberIII test=new StrobogrammaticNumberIII();
		System.out.println(test.strobogrammaticInRange("50", "100"));
		PriorityQueue<Integer>q=new PriorityQueue<Integer>();
	}
}
