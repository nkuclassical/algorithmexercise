package hashtable;

import java.util.HashMap;
import java.util.Map.Entry;

public class LongestSubstringwithAtMostTwoDistinctCharacters {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		HashMap<Character,Integer>map=new HashMap();
		if(s.length()<=2)return s.length();
		int maxlen=0;
		int curlen=0;
		for(int i=0;i<s.length();i++){
			char c=s.charAt(i);
			if(map.containsKey(c)){
				curlen++;
			}else{
				if(map.size()<2){
					map.put(c, i);
					curlen++;
				}else{
					if(curlen>maxlen)maxlen=curlen;
					for(int j=i-1;j>0;j--){
						if(s.charAt(j)==s.charAt(j-1))continue;
						else {
							int startindex=j;
							curlen=i-j+1;
							map.put(s.charAt(j), j);
							map.remove(s.charAt(j-1));
							map.put(s.charAt(i), i);
							break;
						}
					}
				}
			}
		}
		
		if(maxlen<curlen)maxlen=curlen;
		return maxlen;
	}
	
	
	public int lengthOfLongestSubstringTwoDistinct2(String s) {//better
        int start=0, end=0;
        int len=0;
        HashMap<Character,Integer>map=new HashMap();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
                end=i;
                if(len<end-start+1)len=end-start+1;
            }else{
                if(map.size()<2){
                    map.put(c,1);
                    end=i;
                    if(len<end-start+1)len=end-start+1;
                }else{
                    for(int j=start;j<end;j++){
                        char cur=s.charAt(j);
                        if(map.get(cur)==1){
                            map.remove(cur);
                            start++;
                            map.put(c,1);
                            end=i;
                            if(len<end-start+1)len=end-start+1;
                            break;
                        }else{
                            map.put(cur,map.get(cur)-1);
                            start++;
                        }
                    }
                }
            }
        }
        return len;
    }
	
	public static void main(String[]args){
		LongestSubstringwithAtMostTwoDistinctCharacters test=new LongestSubstringwithAtMostTwoDistinctCharacters();
		System.out.println(test.lengthOfLongestSubstringTwoDistinct("abaccc"));
	}
}
