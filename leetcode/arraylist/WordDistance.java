package arraylist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordDistance {
	HashMap<String,List<Integer>>map=new HashMap();
    public WordDistance(String[] words) {
        for(int i=0;i<words.length;i++){
            String cur=words[i];
            if(!map.containsKey(cur)){
                map.put(cur,new ArrayList<Integer>());
            }
            map.get(cur).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer>l1=map.get(word1);
        List<Integer>l2=map.get(word2);
        int i1=0,i2=0;
        int ret=Math.abs(l1.get(0)-l2.get(0));
        while(i1<l1.size()&&i2<l2.size()){
            int temp=Math.abs(l1.get(i1)-l2.get(i2));
            if(ret>temp)ret=temp;
            if(l1.get(i1)<l2.get(i2))i1++;
            else i2++;
        }
        return ret;
    }
}
