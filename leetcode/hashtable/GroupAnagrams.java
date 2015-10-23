package hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>>ret=new ArrayList();
		if(strs.length==0)return ret;
		HashMap<String, ArrayList<Integer>>map=new HashMap();
		
		for(int i=0;i<strs.length;i++){
			String temp=helper(strs[i]);
			if(map.containsKey(temp)){
				map.get(temp).add(i);
			}else{
				map.put(temp, new ArrayList<Integer>());
				map.get(temp).add(i);
			}
		}
		for(Entry<String,ArrayList<Integer>>entry:map.entrySet()){
			List<String>list=new ArrayList();
			List<Integer>index=entry.getValue();
			for(int i=0;i<index.size();i++){
				list.add(strs[index.get(i)]);
			}
			Collections.sort(list);
			ret.add(list);
		}
		return ret;
	}
	public String helper(String s){
		char[]c=s.toCharArray();
		Arrays.sort(c);
		
		return new String(c);
	}
	
	public static void main(String[]args){
		GroupAnagrams test=new GroupAnagrams();
		String[]strs=new String[6];
		strs[0]="eat";
		strs[1]="tea";
		strs[2]="tan";
		strs[3]="ate";
		strs[4]="nat";
		strs[5]="bat";
		List<List<String>>result=test.groupAnagrams(strs);
		for(List<String>rt:result){
			for(String r:rt){
				System.out.print(r+" ");
			}
			System.out.println();
		}
	}
}
