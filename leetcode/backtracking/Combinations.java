package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
//	List<List<Integer>> ret = new ArrayList();
//
//	public List<List<Integer>> combine(int n, int k) {
//		if (k > n)
//			return ret;
//		List<Integer> candidates = new ArrayList<Integer>(n);
//		for (int i = 1; i <= n; i++) {
//			candidates.add(i);
//		}
//		helper(candidates, new ArrayList<Integer>(), k);
//		return ret;
//	}
//
//	public void helper(List<Integer> candidates, List<Integer> prefix, int k) {
//		if (k == 0) {
//			List<Integer> temp = new ArrayList<Integer>();
//			temp.addAll(prefix);
//			ret.add(temp);
//		}
//
//		for (int i = 0; i < candidates.size(); i++) {
//			int prefixlast = Integer.MIN_VALUE;
//			if (!prefix.isEmpty()) {
//				prefixlast = prefix.get(prefix.size() - 1);
//			}
//			int candidate = candidates.get(i);
//			if (candidate <= prefixlast) {
//				continue;
//			} else {
//				prefix.add(candidate);
//				candidates.remove(i);
//				helper(candidates, prefix, k - 1);
//				candidates.add(i, candidate);
//				prefix.remove(prefix.size() - 1);
//			}
//		}
//	}
//
//	public List<List<Integer>> combine2(int n, int k) {
//		List<List<Integer>> ret = new ArrayList();
//		if (k == 0 || n == 0)
//			return ret;
//		List<Integer> candidates = new ArrayList();
//		for (int i = 1; i <= n; i++)
//			candidates.add(i);
//		helper(ret, candidates, new ArrayList(), k);
//		return ret;
//	}
//
//	public void helper(List<List<Integer>> ret, List<Integer> candidates,
//			List<Integer> prefix, int leftk) {
//		if (leftk == 0) {
//			ret.add(new ArrayList(prefix));
//			return;
//		}
//
//		for (int i = 0; i < candidates.size(); i++) {
//			int candidate = candidates.get(i);
//			if (!prefix.isEmpty()) {
//				if (candidate <= prefix.get(prefix.size() - 1))
//					continue;
//			} 
//
//				candidates.remove(i);
//				prefix.add(candidate);
//				helper(ret, candidates, prefix, leftk - 1);
//				prefix.remove(prefix.size() - 1);
//				candidates.add(i, candidate);
//			
//		}
//	}

	
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>ret=new ArrayList();
        helper(ret,new ArrayList<Integer>(),n,k);
        return ret;
    }
    public void helper(List<List<Integer>>ret, List<Integer>prefix, int n, int k){
        if(k==0){
            ret.add(new ArrayList(prefix));
            return;
        }else{
            int limit=0;
            if(prefix.size()==0){
                limit=0;
            }else{
                limit=prefix.get(prefix.size()-1);
            }
            for(int i=limit+1;i<=n;i++){
                    prefix.add(i);
                    helper(ret, prefix, n, k-1);
                    prefix.remove(prefix.size()-1);
            }
        }
    }
	public static void main(String[] args) {
		Combinations test = new Combinations();
		List<List<Integer>> result = test.combine2(10, 7);
		System.out.println(result.size());
		// for (List<Integer> rt : result) {
		// for (Integer r : rt) {
		// System.out.print(r);
		// }
		// System.out.println();
		// }
	}
}
