package hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
		Set<Integer>map=new HashSet();
		for(int i:nums){
			if(map.contains(i)){
				return true;
			}else{
				map.add(i);
			}
		}
		Stack<Integer>a=new Stack();
		
		return false;
		
	}
}
