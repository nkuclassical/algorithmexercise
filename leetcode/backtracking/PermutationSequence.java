package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
	StringBuilder sb=new StringBuilder();
	public String getPermutation(int n, int k) {
		List<Integer>unadded=new ArrayList<Integer>();
		for(int i=1;i<=n;i++){
			unadded.add(i);
		}
		helper(unadded,k-1);
		return sb.toString();
	}
	
	public void helper(List<Integer>unadded,int k){
		if(unadded.size()==0)return;
		int size=calculaten(unadded.size()-1);
		int index=k/size;
		sb.append(String.valueOf(unadded.get(index)));
		unadded.remove(index);
		helper(unadded,k%size);
	}

	public int calculaten(int n) {
		int result = 1;
		for (int i = 2; i <= n; i++) {
			result *= i;
		}
		return result;
	}
	
	public String getPermutation2(int n,int k){
		List<Integer>candidates=new ArrayList();
		for(int i=1;i<=n;i++)candidates.add(i);
		return helper(candidates,k-1, new String());
	}

	public String helper(List<Integer>candidates, int k, String prefix){
		if(candidates.size()==0)return prefix;
		int size=getn(candidates.size()-1);
		int index=k/size;
		Integer newadd=candidates.get(index);
		candidates.remove(index);
	return helper(candidates, k-index*size, prefix+newadd);
	}
	public int getn(int n){
		int ret=1;
		for(int i=2;i<=n;i++)ret*=i;
		return ret;
	}

	public static void main(String[]args){
		PermutationSequence test=new PermutationSequence();
		System.out.println(test.getPermutation2(3, 1));
	}
}
