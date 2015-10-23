package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
//	List<List<Integer>> ret = new ArrayList();
//
//	public List<List<Integer>> combinationSum3(int k,int n) {
//		List<Integer> candidates = new ArrayList<Integer>();
//		for (int i = 1; i <= 9; i++)
//			candidates.add(i);
//		helper(candidates, new ArrayList<Integer>(), n,k);
//		return ret;
//	}
//
//	public void helper(List<Integer> candidates, List<Integer> prefix,
//			int target,int k) {
//		 if (k == 0)
//		 return;
//		for (int i = 0; i < candidates.size(); i++) {
//			int candidate = candidates.get(i);
//			int prefixvalue = Integer.MIN_VALUE;
//			if (!prefix.isEmpty()) {
//				prefixvalue = prefix.get(prefix.size() - 1);
//			}
//			if (candidate >= prefixvalue) {
//
//				if (candidate == target) {
//					 if (k == 1) {
//					prefix.add(candidate);
//					List<Integer> temp = new ArrayList();
//					temp.addAll(prefix);
//					ret.add(temp);
//					prefix.remove(prefix.size() - 1);
//					 }
//				} else if (candidate > target)
//					return;
//				else {
//					if (i > 0) {
//						int lastcandidate = candidates.get(i - 1);
//						if (lastcandidate == candidate)
//							continue;
//					}
//					prefix.add(candidate);
//					candidates.remove(i);
//					helper(candidates, prefix, target - candidate,k-1);
//					candidates.add(i, candidate);
//					prefix.remove(prefix.size() - 1);
//
//				}
//			}
//		}
//	}

	public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>>ret=new ArrayList();
        int[]candidates=new int[9];
        for(int i=1;i<=9;i++)candidates[i-1]=i;
        helper(candidates,k-1,n,0,new ArrayList(),ret);
        return ret;
    }
    public void helper(int[]candidates, int k, int target, int startindex, List<Integer>prefix, List<List<Integer>>ret){
        for(int i=startindex;i<candidates.length;i++){
            prefix.add(candidates[i]);
            if(target==candidates[i]&&k==0){
                ret.add(new ArrayList(prefix));
                prefix.remove(prefix.size()-1);    
            }else if(target>candidates[i]&&k>0){
                helper(candidates,k-1,target-candidates[i],i+1,prefix,ret);
                prefix.remove(prefix.size()-1);    
            }else{
                prefix.remove(prefix.size()-1);    
            } 
        }
    }
    
	public static void main(String[] args) {
		CombinationSumIII test = new CombinationSumIII();
		List<List<Integer>> result = test.combinationSum3(3,9);
		for (List<Integer> rt : result) {
			for (Integer r : rt) {
				System.out.print(r+" ");
			}
			System.out.println();
		}
	}
}
