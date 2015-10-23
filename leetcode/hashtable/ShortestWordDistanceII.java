package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShortestWordDistanceII {
	HashMap<String,List<Integer>>map=new HashMap();
	public ShortestWordDistanceII(String[]words) {
		for(int i=0;i<words.length;i++){
			if(map.containsKey(words[i])){
				map.get(words[i]).add(i);
			}else{
				List<Integer>tempList=new ArrayList();
				tempList.add(i);
				map.put(words[i], tempList);
			}
		}
	}

	public int shortest(String word1, String word2) {
		List<Integer>list1=map.get(word1);
		List<Integer>list2=map.get(word2);
		int minDistance=Integer.MAX_VALUE;
		for(int i=0,j=0;i<list1.size()&&j<list2.size();){
			int index1=list1.get(i);
			int index2=list2.get(j);
			if(index1<index2){
				minDistance=Math.min(index2-index1, minDistance);
				i++;
//				i=(i<list1.size()-1)?i:i+1;
			}else{
				minDistance=Math.min(index1-index2, minDistance);
//				j=(j<list2.size()-1)?j:j+1;
				j++;
				
			}
		}
		return minDistance;
	}
	
	public static void main(String[]args){
		String[]words=new String[4];
		words[0]="a";
		words[1]="c";
		words[2]="b";
		words[3]="a";
		ShortestWordDistanceII test=new ShortestWordDistanceII(words);
		System.out.println(test.shortest("a", "b"));
		System.out.println(test.shortest("b", "a"));
		
	}
}
