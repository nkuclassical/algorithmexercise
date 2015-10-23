package backtracking;

import java.util.HashMap;
import java.util.Map;

public class WordPatternII {
//	public boolean wordPatternMatch(String pattern, String str) {
//        return helper(pattern,str,0,0,new HashMap<Character,String>());
//    }
//    
//    public boolean helper(String pattern, String str, int patternindex, int strindex, Map<Character,String>map){
//        if(patternindex==pattern.length())return strindex==str.length();
//        char c=pattern.charAt(patternindex);
//        if(map.containsKey(c)){
//        	String temp=map.get(c);
//        	if(temp.length()>str.length()-strindex||!str.substring(strindex,strindex+temp.length()).equals(temp)){
//        		return false;
//        	}
//        	if(helper(pattern,str,patternindex+1,strindex+temp.length(),map))
//        		return true;
//        }
//        for(int i=strindex;i<str.length();i++){
//            String temp=str.substring(strindex,i+1);
//            if(map.containsValue(temp))continue;
//            map.put(c, temp);
//            if(helper(pattern,str,patternindex+1,i+1,map))return true;
//            map.remove(c);
//        }
//        return false;
//    }
    
	HashMap<Character,String>map=new HashMap();
	public boolean wordPatternMatch(String pattern, String str){
		if(pattern.length()==0)return str.length()==0;
		char c=pattern.charAt(0);
		if(map.containsKey(c)){
			String t=map.get(c);
			if(t.length()>str.length()||!str.substring(0,t.length()).equals(t))return false;
			if(wordPatternMatch(pattern.substring(1),str.substring(t.length())))
				return true;
		}else{
			for(int i=1;i<=str.length();i++){
				String temp=str.substring(0,i);
				if(map.containsValue(temp)){
					continue;
				}
				map.put(c, temp);
				if(wordPatternMatch(pattern.substring(1),str.substring(i)))
					return true;
				map.remove(c);
			}
		}
		return false;
	}
    public static void main(String[]args){
    	WordPatternII test=new WordPatternII();
    	String pattern="d";
    	String str="e";
    	
//    	"itwasthebestoftimes"
//    	"ittwaastthhebesttoofttimesss"
    	System.out.println(test.wordPatternMatch(pattern, str));
    }
}
