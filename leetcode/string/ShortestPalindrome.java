package string;

public class ShortestPalindrome {

	// KMP!
	public String shortestPalindrome2(String s) {// not work
		int end = s.length() - 1, r = end, l = 0;
		while (end > 0) {
			l = 0;
			r = end;
			while (l < r) {
				if (s.charAt(l) == s.charAt(r)) {
					l++;
					r--;
				} else {
					end--;
					break;
				}
			}
			if (l >= r)
				break;
		}
		StringBuilder temp = new StringBuilder(s.substring(end + 1, s.length()));
		temp = temp.reverse();
		temp.append(s);
		return temp.toString();
	}

	public String shortestPalindrome(String s) {
		int first = 0, last = s.length() - 1, end = last;
		char[] cs=s.toCharArray();//之前的s.charAt(i) 通过不了，使用了char[]cs就可以通过超时，KMP算法太过复杂
		while (first < end) {
			if (cs[first]!= cs[end]) {
				first = 0;
				last--;
				end = last;
			} else {
				first++;
				end--;
			}
		}
		if (first == end) {
			String leftpart = reverse(s.substring(first + 1));
			return leftpart + s.substring(first);
		} else {
			String leftpart = reverse(s.substring(first));
			return leftpart + s.substring(first);
		}

	}

	
    public String shortestPalindrome3(String s) {
        int i=s.length()-1;
        int start=0,end=s.length()-1;
        char[]cs=s.toCharArray();
        int last=s.length()-1;    
        while(start<end){
            if(cs[start]!=cs[end]){
                start=0;
                last--;
                end=last;
            }else{
                start++;
                end--;
            }
        }
        
        if(start==end){
            String front=reverse(s.substring(start+1));
            return front+s.substring(start);
        }else{
            String front=reverse(s.substring(start));
            return front+s.substring(start);
        }
    }
    
	public String reverse(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		ShortestPalindrome test = new ShortestPalindrome();
		System.out.println(test.shortestPalindrome3("aacecaaa"));
	}
}
