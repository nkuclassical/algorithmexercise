package hashtable;

import java.util.HashMap;

public class ContainsDuplicateII {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				if ((i - map.get(nums[i])) <= k)
					return true;
				else {
					map.put(nums[i], i);
				}
			} else {
				map.put(nums[i], i);
			}
		}
		return false;
	}
	
	public static void main(String[]args){
		String a="Hello world!";
		System.out.println(a.hashCode());
		System.out.println("aa".hashCode());
		System.out.println("aaa".hashCode());
		System.out.println("ab".hashCode());
		System.out.println("ba".hashCode());
		System.out.println("Hello world".hashCode());
	}
}
