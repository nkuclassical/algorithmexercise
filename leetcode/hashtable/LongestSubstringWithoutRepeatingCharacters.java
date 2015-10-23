package hashtable;

import java.util.HashMap;
import java.util.Map.Entry;

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {

		int[] map = new int[256];
		for (int i = 0; i < map.length; i++)
			map[i] = -1;
		int start = -1;
		int maxLength = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map[(int) c] == -1) {
				map[(int) c] = i;
				maxLength = (maxLength < (i - start)) ? (i - start) : maxLength;
			} else {
				start = map[(int) c];
				for (int j = 0; j < map.length; j++) {
					if (map[j] < start) {
						map[j] = -1;
					}
				}
			}
		}
		return maxLength;
	}
	
	

	public int lengthOfLongestSubstring2(String s) {
		HashMap<Character, Integer> map = new HashMap();
		int slow = 0, fast = 0;
		int max = 0;
		while (fast < s.length()) {
			char cur = s.charAt(fast);
			if (map.containsKey(cur) && map.get(cur) != -1) {
				slow = map.get(cur) + 1;
				for (Entry<Character, Integer> entry : map.entrySet()) {
					if (entry.getValue() < slow) {
						map.put(entry.getKey(), -1);
					}
				}
			}
			map.put(cur, fast);

			max = (fast - slow + 1 > max) ? fast - slow + 1 : max;
			fast++;
		}

		return max;
	}

	public int lengthOfLongestSubstring3(String s) {
		int[] map = new int[256];
		int slow = 0, fast = 0;
		int max = 0;
		for (int i = 0; i < map.length; i++) {
			map[i] = -1;
		}
		while (fast < s.length()) {
			char cur = s.charAt(fast);
			if (map[(int) cur] != -1) {
				slow = map[(int) cur] + 1;
				for (int i = 0; i < map.length; i++) {
					if (map[i] < slow)
						map[i] = -1;
				}
			}
			
			map[(int)cur]=fast;

			max = (fast - slow + 1 > max) ? fast - slow + 1 : max;
			fast++;
		}

		return max;
	}

	
	  public int lengthOfLongestSubstring4(String s) {
	        HashMap<Character, Integer>map=new HashMap();
	        int start=0, end=0, len=0;
	        for(int i=0;i<s.length();i++){
	            char c=s.charAt(i);
	            if(map.containsKey(c)){
	                int size=map.get(c);
	                for(int j=start;j<=size;j++){
	                    map.remove(s.charAt(j));
	                }
	                start=size+1;
	            }
	            map.put(c,i);
	            end++;
	            if(len<end-start)len=end-start;
	        }
	        return len;
	    }
	  
	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters test = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(test.lengthOfLongestSubstring4("c"));
	}
}
