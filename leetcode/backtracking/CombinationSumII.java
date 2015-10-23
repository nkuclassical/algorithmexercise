package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSumII {
	List<List<Integer>> ret = new ArrayList();

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<Integer> candidateslist = new ArrayList(candidates.length);
		for (int i = 0; i < candidates.length; i++) {
			candidateslist.add(i, candidates[i]);
		}
		Collections.sort(candidateslist);
		helper(candidateslist, new ArrayList<Integer>(), target);
		return ret;
	}

	public void helper(List<Integer> candidates, List<Integer> prefix,
			int target) {

		for (int i = 0; i < candidates.size(); i++) {
			int prefixvalue = Integer.MIN_VALUE;
			if (!prefix.isEmpty()) {
				prefixvalue = prefix.get(prefix.size() - 1);
			}
			int candidate = candidates.get(i);
			if (prefixvalue <= candidate) {
				if (candidate == target) {
					prefix.add(candidate);
					List<Integer> temp = new ArrayList();
					temp.addAll(prefix);
					ret.add(temp);
					prefix.remove(prefix.size() - 1);
					return;
				} else if (candidate > target)
					return;
				else {
					if (i > 0) {
						if (candidates.get(i - 1).equals(candidate))
							continue;
					}
					prefix.add(candidate);
					candidates.remove(i);
					helper(candidates, prefix, target - candidate);
					candidates.add(i, candidate);
					prefix.remove(prefix.size() - 1);
				}
			}
		}
	}

	public List<List<Integer>> combinationSum22(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> ret = new ArrayList();
		helper(candidates, 0, target, ret, new ArrayList());
		return ret;
	}

	public void helper(int[] candidates, int start, int target,
			List<List<Integer>> ret, List<Integer> prefix) {
		if (target == 0) {

			if (ret.contains(prefix)) {
				return;
			}
//			if (prefix.equals(ret.get(ret.size() - 1)))
//				return;

			ret.add(new ArrayList(prefix));
			return;
		}
		if (target < 0)
			return;
		for (int i = start; i < candidates.length; i++) {
			if (target < candidates[i])
				return;
			prefix.add(candidates[i]);
			helper(candidates, i + 1, target - candidates[i], ret, prefix);
			prefix.remove(prefix.size() - 1);
		}
	}

	
    public List<List<Integer>> combinationSum23(int[] candidates, int target) {
        List<List<Integer>>ret=new ArrayList();
        Arrays.sort(candidates);
        helper3(candidates,target,0,new ArrayList(),ret);
        return ret;
    }
    
    public void helper3(int[]candidates, int target, int startindex, List<Integer>prefix, List<List<Integer>>ret){
        for(int i=startindex;i<candidates.length;i++){
            if(i>startindex&&candidates[i-1]==candidates[i])continue;
            prefix.add(candidates[i]);
            if(target==candidates[i]){
                ret.add(new ArrayList(prefix));
                prefix.remove(prefix.size()-1);    
            }else if(target>candidates[i]){
                helper3(candidates,target-candidates[i],i+1,prefix,ret);
                prefix.remove(prefix.size()-1);    
            }else{
                prefix.remove(prefix.size()-1);    
                return;
            } 
        }
    }
    
    
	public static void main(String[] args) {
		CombinationSumII test = new CombinationSumII();
		int[] candidates = new int[5];
		candidates[0] = 7;
		candidates[1] = 1;
		candidates[2] = 2;
		candidates[3] = 5;
		candidates[4] = 1;
		// candidates[5] = 1;
		// candidates[6] = 5;
		// candidates[7] = 8;
		// candidates[8] = 9;
		List<List<Integer>> result = test.combinationSum22(candidates, 8);
		for (List<Integer> rt : result) {
			for (Integer r : rt) {
				System.out.print(r + " ");
			}
			System.out.println();
		}
	}

}
