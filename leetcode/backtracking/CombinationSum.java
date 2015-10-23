package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSum {
	List<List<Integer>> ret = new ArrayList();

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<Integer> newcandidates = new ArrayList<Integer>();
		for (int i = 0; i < candidates.length; i++) {
			newcandidates.add(i, candidates[i]);
		}
		Collections.sort(newcandidates);

		helper(newcandidates, target, new ArrayList<Integer>());
		return ret;
	}

	public void helper(List<Integer> candidates, int target,
			List<Integer> prefixs) {
		for (int i = 0; i < candidates.size(); i++) {
			int lastprefix = Integer.MIN_VALUE;
			if (!prefixs.isEmpty()) {
				lastprefix = prefixs.get(prefixs.size() - 1);
			}
			if (candidates.get(i).compareTo(lastprefix) >= 0) {
				if (candidates.get(i).equals(target)) {
					prefixs.add(candidates.get(i));
					List<Integer> temp = new ArrayList<Integer>();
					temp.addAll(prefixs);
					ret.add(temp);
					prefixs.remove(prefixs.size() - 1);
					return;
				} else if (candidates.get(i).compareTo(target) > 0) {
					return;
				} else if (candidates.get(i).compareTo(target) < 0) {
					int candidate = candidates.get(i);
					prefixs.add(candidate);
					helper(candidates, target - candidate, prefixs);
					prefixs.remove(prefixs.size() - 1);
				}
			}
		}
	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> ret = new ArrayList();
		helper(candidates, 0, ret, target, new ArrayList());
		return ret;
	}

	public void helper(int[] candidates, int start, List<List<Integer>> ret,
			int target, List<Integer> prefix) {
		if (target == 0) {
			ret.add(new ArrayList(prefix));
			return;
		} else if (target < 0) {
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			prefix.add(candidates[i]);
			if (target < candidates[i]) {
				prefix.remove(prefix.size() - 1);
				return;
			}
			helper(candidates,i , ret, target - candidates[i], prefix);
			prefix.remove(prefix.size() - 1);
		}
	}

	
    public List<List<Integer>> combinationSum3(int[] candidates, int target) {
        List<List<Integer>>ret=new ArrayList();
        Arrays.sort(candidates);
        helper3(candidates,target,0,new ArrayList(),ret);
        return ret;
    }
    
    public void helper3(int[]candidates,int target,int startindex,List<Integer>previous,List<List<Integer>>ret){
        for(int i=startindex;i<candidates.length;i++){
            previous.add(candidates[i]);
            if(target==candidates[i]){
                ret.add(new ArrayList(previous));
                previous.remove(previous.size()-1);
            }else if(target-candidates[i]>0){
                helper3(candidates,target-candidates[i],i,previous,ret);
                previous.remove(previous.size()-1);
            }else{
                previous.remove(previous.size()-1);
                return;  
            } 
        }
    }
	public static void main(String[] args) {
		CombinationSum test = new CombinationSum();
		int[] candidates = new int[2];
		candidates[0] = 1;
		candidates[1] = 1;
//		candidates[2] = 3;
//		candidates[3] = 7;
		List<List<Integer>> result = test.combinationSum2(candidates, 1);
		for (List<Integer> re : result) {
			for (Integer r : re) {
				System.out.print(r + " ");
			}
			System.out.println();
		}
	}
}
