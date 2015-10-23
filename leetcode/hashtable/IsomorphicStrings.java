package hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {
		Map<Character,Character>map=new HashMap();
		Map<Character,Character>map2=new HashMap();
		for(int i=0;i<s.length();i++){
			if(map.containsKey(s.charAt(i))){
				if(map.get(s.charAt(i))!=t.charAt(i))return false;
			}else{
				map.put(s.charAt(i),t.charAt(i));
			}
			if(map2.containsKey(t.charAt(i))){
				if(map2.get(t.charAt(i))!=s.charAt(i))return false;
			}else{
				map2.put(t.charAt(i), s.charAt(i));
			}
		}
		return true;
	}

	public static void main(String[] args) {
		IsomorphicStrings test = new IsomorphicStrings();
		System.out.println(test.isIsomorphic("apple", "ellpa"));
		System.out.println(test.isIsomorphic("egg", "add"));
		System.out.println(test.isIsomorphic("foo", "bar"));
		System.out.println(test.isIsomorphic("aba", "baa"));
		System.out.println(test.isIsomorphic("ab", "aa"));
		
	}
}
