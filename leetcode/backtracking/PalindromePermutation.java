package backtracking;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;



public class PalindromePermutation {
	public boolean canPermutePalindrome(String s) {
		HashMap<Character,Integer>map=new HashMap();
		for(int i=0;i<s.length();i++){
			char c=s.charAt(i);
			if(map.containsKey(c)){
				int time=map.get(c);
				map.put(c, time+1);
			}else{
				map.put(c,1);
			}
		}
		
		Iterator it=map.entrySet().iterator();
		int odd=0;
		while(it.hasNext()){
			Map.Entry<Character,Integer> entry=(Entry) it.next();
			Character c=entry.getKey();
			Integer t=entry.getValue();
			if(t%2==1)odd++;
			if(odd>1)return false;
		}
		return true;
	}
	public static void main(String []args){
		PalindromePermutation test=new PalindromePermutation();
		System.out.println(test.canPermutePalindrome("a"));
	}
}
