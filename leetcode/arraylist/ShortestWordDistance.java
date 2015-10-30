package arraylist;

import java.util.ArrayList;
import java.util.List;

public class ShortestWordDistance {
	public int shortestDistance(String[] words, String word1, String word2) {
		int result = Integer.MAX_VALUE;
		int position1 = -1;
		int position2 = -1;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1)) {
				position1 = i;
				if (words[i].equals(word1) && position2 != -1) {
					if (Math.abs(i - position2) < result) {
						result = Math.abs(i - position2);
					}
				}
			} else if (words[i].equals(word2)) {
				position2 = i;
				if (position1 != -1) {
					if (Math.abs(i - position1) < result) {
						result = Math.abs(i - position1);
					}
				}
			}
		}
		return result;
	}
	
	public int shortestDistance2(String[] words, String word1, String word2) {//solution 2, refer to WordDistance.java
        List<Integer>l1=new ArrayList();
        List<Integer>l2=new ArrayList();
        for(int i=0;i<words.length;i++){
            if(words[i].equals(word1)){
                l1.add(i);
            }else if(words[i].equals(word2)){
                l2.add(i);
            }
        }
        int cur1=0, cur2=0;
        int ret=Math.abs(l1.get(0)-l2.get(0));
        while(cur1<l1.size()&&cur2<l2.size()){
            int temp=Math.abs(l1.get(cur1)-l2.get(cur2));
            if(ret<temp)ret=temp;
            if(l1.get(cur1)<l2.get(cur2))cur1++;
            else cur2++;
        }
        return ret;
    }
	
	public static void main(String[]args){
		ShortestWordDistance test=new ShortestWordDistance();
		String[]words={"a","c","b","a"};
		System.out.println(test.shortestDistance2(words, "a", "b"));
		
	}
}
