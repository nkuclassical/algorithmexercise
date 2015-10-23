package hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
		if(s.length()!=t.length())return false;
		char[]sc=s.toCharArray();
		char[]tc=t.toCharArray();
		Arrays.sort(sc);
		Arrays.sort(tc);
		StringBuilder sbs=new StringBuilder();
		for(int i=0;i<sc.length;i++)
			sbs.append(sc[i]);
		StringBuilder tcs=new StringBuilder();
		for(int i=0;i<tc.length;i++)
			tcs.append(tc[i]);
		System.out.println(sbs);
		System.out.println(tcs);
		return sbs.toString().equals(tcs.toString());
	}
	
	public boolean isAnagram2(String s,String t){
		if(s.length()!=t.length())return false;
		int len=s.length();
		HashMap<Character,Integer>map=new HashMap();
		for(int i=0;i<len;i++){
			if(map.containsKey(s.charAt(i))){
				int time=map.get(s.charAt(i));
				map.put(s.charAt(i), time+1);
			}else{
				map.put(s.charAt(i), 1);
			}
		}
		for(int i=0;i<len;i++){
			if(map.containsKey(t.charAt(i))){
				int time=map.get(t.charAt(i));
				map.put(t.charAt(i), time-1);
			}else{
				return false;
			}
		}
		for(Entry<Character, Integer> entry:map.entrySet()){
			if(entry.getValue()!=0)return false;
		}
		return true;
	}
	public static void main(String[]args){
		ValidAnagram test=new ValidAnagram();
		System.out.println(test.isAnagram2("anagram", "nagaram"));
	}
}
