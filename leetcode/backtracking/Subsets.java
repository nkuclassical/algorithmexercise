package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
	List<List<Integer>> ret = new ArrayList();

	public List<List<Integer>> subsets(int[] nums) {
		Arrays.sort(nums);
		helper(new ArrayList<Integer>(), 0, nums);
		return ret;
	}

	public void helper(List<Integer> prefix, int pos, int[] n) {
		if (pos <= n.length) {
			ret.add(new ArrayList(prefix));
		}
		for (int i = pos; i < n.length; i++) {
			prefix.add(n[i]);
			helper(prefix, i + 1, n);
			prefix.remove(prefix.size() - 1);
			while (i + 1 < n.length && n[i + 1] == n[i])
				i++;
		}
	}

	public List<List<Integer>> subsets2(int[] nums) {
		List<List<Integer>> ret = new ArrayList();
		Arrays.sort(nums);
		helper(ret, nums, 0, new ArrayList());
		return ret;
	}

	public void helper(List<List<Integer>> ret, int[] nums, int pos,
			List<Integer> prefix) {
		if (pos <= nums.length) {
			ret.add(new ArrayList(prefix));
		}
		for (int i = pos; i < nums.length; i++) {
			prefix.add(nums[i]);
			helper(ret, nums, i + 1, prefix);
			prefix.remove(prefix.size() - 1);
			while (i + 1 < nums.length && nums[i] == nums[i + 1])
				i++;
		}
	}
	
	public List<List<Integer>> subsets3(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>ret=new ArrayList();
        helper3(nums,new ArrayList(),0,ret);
        return ret;
    }
    public void helper3(int[]nums,List<Integer>prefix,int startIndex,List<List<Integer>>ret){
//        if(startIndex==nums.length){
            ret.add(new ArrayList(prefix));
//            return;
//        }
        for(int i=startIndex;i<nums.length;i++){
//            helper3(nums,prefix,i+1,ret);
            prefix.add(nums[i]);
            helper3(nums,prefix,i+1,ret);
            prefix.remove(prefix.size()-1);
        }
    }

	public static void main(String[] args) {
		Subsets test = new Subsets();
		int[] nums = new int[4];
		nums[0] = 4;
		nums[1] = 1;
		nums[2] = 0;
		nums[3] = 5;
//		nums[4] = 5;
//		nums[5] = 6;
//		nums[6] = 7;
//		nums[7] = 8;
//		nums[8] = 10;
//		nums[9] = 0;
		List<List<Integer>> result = test.subsets3(nums);
		for (List<Integer> rt : result) {
			for (Integer r : rt) {
				System.out.print(r + " ");
			}
			System.out.println();
		}
		// List<Integer>r=new ArrayList<Integer>();
		// r.add(1);
		// r.add(2);
		// r.add(3);
		// r.add(4);
		// List<Integer>sublist=r.subList(1, r.size());
		// for(Integer s:sublist)System.out.println(s);
	}
}
