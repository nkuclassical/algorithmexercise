package hashtable;

import java.util.HashMap;
import java.util.HashSet;

public class UniqueWordAbbreviation {
	HashMap<String, Integer>map=new HashMap();
//	HashMap<String,Integer>d=new HashMap();
	HashSet<String>d=new HashSet();
	public UniqueWordAbbreviation(String[]dictionary){
		for(String s:dictionary){
			String temp=process(s);
			if(map.containsKey(temp)){
				map.put(temp, map.get(temp)+1);
			}else map.put(temp,1);
			d.add(s);
		}
	}
	
	public boolean isUnique(String word){
		String s=process(word);
		
		if(map.containsKey(s)){
			if(map.get(s)==1)return d.contains(word);
			else return false;
		}
		return true;
	}
	
	public String process(String s){
		if(s.length()==0)return "";
		StringBuilder sb=new StringBuilder();
		sb.append(s.charAt(0));
		if(s.length()>2){
			sb.append(s.length()-2);	
		}
		sb.append(s.charAt(s.length()-1));
		return sb.toString();
		
	}
	
	public static void main(String[]args){
		
		String[]dictionary=new String[4];
		dictionary[0]="deer";
		dictionary[1]="door";
		dictionary[2]="cake";
		dictionary[3]="card";
		UniqueWordAbbreviation test=new UniqueWordAbbreviation(dictionary);
		System.out.println(test.isUnique("deer"));
		System.out.println(test.isUnique("make"));
		System.out.println(test.isUnique("cane"));
		System.out.println(test.isUnique("cart"));
	}
	
}
