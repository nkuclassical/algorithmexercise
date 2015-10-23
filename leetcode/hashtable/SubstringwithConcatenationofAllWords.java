package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringwithConcatenationofAllWords {
	public List<Integer> findSubstring(String s, String[] words) {
		HashMap<String,Integer>map=new HashMap();
		HashMap<String,Integer>newmap=new HashMap();
		List<Integer>ret=new ArrayList();
		if(s==null||words.length==0||s.length()<words[0].length())return ret;
		
		for(int i=0;i<words.length;i++){
			if(map.containsKey(words[i])){
				map.put(words[i], map.get(words[i])+1);
			}else map.put(words[i],1);
		}
		newmap=new HashMap(map);
		int len=words[0].length(),times;
		for(int i=0;i<=s.length()-len*words.length;i++){
		
			int start=i;
			times=words.length;
			String sub=s.substring(start,len+start);
			while(newmap.containsKey(sub)&&newmap.get(sub)>0){
				times--;
				newmap.put(sub, newmap.get(sub)-1);
				start=start+len;
				if(start+len>s.length())break;
				sub=s.substring(start,len+start);
				
			}
			if(times==0)ret.add(i);
			newmap=new HashMap(map);

		}
		return ret;
	}
	
    public List<Integer> findSubstring2(String s, String[] words) {
        HashMap<String,Integer>map=new HashMap();
		HashMap<String,Integer>newmap=new HashMap();
		List<Integer>ret=new ArrayList();
		if(s==null||words.length==0||s.length()<words[0].length())return ret;
		
		for(int i=0;i<words.length;i++){
			if(map.containsKey(words[i])){
				map.put(words[i], map.get(words[i])+1);
			}else map.put(words[i],1);
		}
		newmap=new HashMap(map);
		int len=words[0].length(),times;
		for(int i=0;i<=s.length()-len*words.length;i++){
		
			int start=i;
			times=words.length;
			String sub=s.substring(start,len+start);
			while(newmap.containsKey(sub)&&newmap.get(sub)>0){
				times--;
				newmap.put(sub, newmap.get(sub)-1);
				start=start+len;
				if(start+len>s.length())break;
				sub=s.substring(start,len+start);
				
			}
			if(times==0)ret.add(i);
			newmap=new HashMap(map);

		}
		return ret;
    }
	
	public static void main(String[]args){
		SubstringwithConcatenationofAllWords test=new SubstringwithConcatenationofAllWords();
		String s="wordgoodgoodgoodbestword";
		String[]words=new String[4];
		words[0]="word";
		words[1]="good";
		words[2]="best";
		words[3]="good";
		List<Integer>result=test.findSubstring(s, words);
		for(Integer r:result){
			System.out.println(r);
		}
	}
	
}
