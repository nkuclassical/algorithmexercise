package arraylist;

import java.util.ArrayList;
import java.util.List;

public class ShortestWordDistanceIII {
	public int shortestWordDistance(String[] words, String word1, String word2) {//O(1) space O(n) runtime
		int result = Integer.MAX_VALUE;
		if (word1.equals(word2)) {
			int position = -1;
			for (int i = 0; i < words.length; i++) {
				if (words[i].equals(word1)) {
					if (position != -1) {
						if (result > (i - position)) {
							result = i - position;
						}
					}
					position=i;
				}
			}
			return result;
		} else {

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
	}
	
    public int shortestWordDistance2(String[] words, String word1, String word2) {//another solution, more concise O(n) space O(n) runtime
        List<Integer>l1=new ArrayList();
        int ret=words.length;
        if(word1.equals(word2)){
            for(int i=0;i<words.length;i++){
                if(words[i].equals(word1)){
                    l1.add(i);
                }
            }
            for(int i=1;i<l1.size();i++){
                if(l1.get(i)-l1.get(i-1)<ret)ret=l1.get(i)-l1.get(i-1);
            }
        }else{
            List<Integer>l2=new ArrayList();
            for(int i=0;i<words.length;i++){
                if(words[i].equals(word1)){
                    l1.add(i);
                }else if(words[i].equals(word2)){
                    l2.add(i);
                }
            }
            int cur1=0, cur2=0;
            while(cur1<l1.size()&&cur2<l2.size()){
                int temp=Math.abs(l1.get(cur1)-l2.get(cur2));
                if(ret>temp)ret=temp;
                if(l1.get(cur1)<l2.get(cur2))cur1++;
                else cur2++;
            }
        }
        return ret;
    }
}
