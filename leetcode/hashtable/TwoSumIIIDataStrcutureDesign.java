package hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TwoSumIIIDataStrcutureDesign {
	Map<Integer,Integer>map=new HashMap();
	// Add the number to an internal data structure.
	public void add(int number) {
		if(map.containsKey(number)){
			map.put(number,map.get(number)+1);
		}else{
			map.put(number,1);
		}
	}

	// Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
		for(Entry<Integer,Integer>entry:map.entrySet()){
			if((entry.getKey()*2==value)){
				if(entry.getValue()>=2)return true;	
			}
			else{
				if(map.containsKey(value-entry.getKey()))return true;
			}
		}
		return false;
	}
	
	public static void main(String[]args){
		TwoSumIIIDataStrcutureDesign test=new TwoSumIIIDataStrcutureDesign();
		test.add(0);
		test.add(0);
		System.out.println(test.find(0));
	}
}
