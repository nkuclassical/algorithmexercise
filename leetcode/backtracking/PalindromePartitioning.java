package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	List<List<String>> ret = new ArrayList();

	public List<List<String>> partition(String s) {
		helper(new ArrayList<String>(), s, 0);
		return ret;
	}

	public void helper(List<String> prefix, String s, int pos) {
		int len=s.length();
		if(pos==len){
			ret.add(new ArrayList<String>(prefix));
			return;
		}
		for(int i=pos+1;i<=len;i++){
			String substring=s.substring(pos,i);
			if(!checkPalindrome(substring)){
				continue;
			}
			prefix.add(substring);
			helper(prefix,s,i);
			prefix.remove(prefix.size()-1);
		}
	}

	public boolean checkPalindrome(String s) {
		int l = 0, r = s.length() - 1;
		while (l < r) {
			if (s.charAt(l) == s.charAt(r)) {
				l++;
				r--;
				continue;
			} else
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		PalindromePartitioning test = new PalindromePartitioning();
		List<List<String>> result = test.partition("aabcb");
		for (List<String> rt : result) {
			for (String r : rt) {
				System.out.print(r + " ");
			}
			System.out.println();
		}
	}
}
