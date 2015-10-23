package dynamicprogramming;

import java.util.Arrays;

public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		boolean[] match = new boolean[s.length() + 1];
		Arrays.fill(match, false);

		match[s.length()] = true;
		for (int i = p.length() - 1; i >= 0; i--) {
			if (p.charAt(i) == '*') {
				for (int j = s.length() - 1; j >= 0; j--)
					match[j] = match[j]
							|| match[j + 1]
							&& (p.charAt(i - 1) == '.' || s.charAt(j) == p
									.charAt(i - 1));
				i--;
			} else {
				for (int j = 0; j < s.length(); j++)
					match[j] = match[j + 1]
							&& (p.charAt(i) == '.' || p.charAt(i) == s
									.charAt(j));
				match[s.length()] = false;
			}
		}
		return match[0];
	}

	public boolean isMatch2(String s, String p) {// best!
	// if (p.length() == 0 && s.length() != 0)
	// return false;
		int row = s.length();
		int col = p.length();
		boolean matrix[][] = new boolean[row + 1][col + 1];

		matrix[0][0] = true;
		if (p.length() > 0) {
			matrix[0][1] = false;
			for (int i = 2; i <= col; i++)
				matrix[0][i] = p.charAt(i - 1) == '*' ? matrix[0][i - 2]
						: false;

			for (int i = 1; i <= row; i++) {
				matrix[i][0] = false;
			}
			for (int i = 1; i <= row; i++) {
				for (int j = 1; j <= col; j++) {
					if (p.charAt(j - 1) == '*')
						matrix[i][j] = matrix[i][j - 2]
								|| (matrix[i - 1][j] && (p.charAt(j - 2) == '.' || p
										.charAt(j - 2) == s.charAt(i - 1)));
					else {
						matrix[i][j] = matrix[i - 1][j - 1]
								&& (s.charAt(i - 1) == p.charAt(j - 1) || p
										.charAt(j - 1) == '.');
					}
				}
			}
		}
		return matrix[row][col];
	}

	
	public boolean isMatch4(String s, String p){
		int row=p.length();
		int col=s.length();
		boolean m[][]=new boolean[row+1][col+1];
		m[0][0]=true;
		if(p.length()>0){
		m[1][0]=false;
		for(int i=2;i<=row;i++)m[i][0]=p.charAt(i-1)=='*'?m[i-2][0]:false;
		for(int i=1;i<=col;i++)m[0][i]=false;
		for(int i=1;i<=row;i++){
			for(int j=1;j<=col;j++){
				if(p.charAt(i-1)=='*'){
					m[i][j]=m[i-2][j]||(m[i][j-1]&&(p.charAt(i-2)=='.'||p.charAt(i-2)==s.charAt(j-1)));
				}else{
					m[i][j]=m[i-1][j-1]&&(p.charAt(i-1)==s.charAt(j-1)||p.charAt(i-1)=='.');
				}
			}
		}
		for(int i=0;i<row+1;i++){
			for(int j=0;j<col+1;j++){
				System.out.print(m[i][j]+" ");
			}
			System.out.println();
		}
		}
		return m[row][col];
	}
	public boolean isMatch3(String s, String p) {
		if (p.isEmpty())
			return s.isEmpty();

		if (p.length() == 1 || p.charAt(1) != '*') {
			if (s.isEmpty()
					|| (p.charAt(0) != '.' && (p.charAt(0) != s.charAt(0))))
				return false;
			else
				return isMatch3(s.substring(1), p.substring(1));
		}
		while (!s.isEmpty()
				&& (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0))) {
			if (isMatch3(s.substring(1), p.substring(1)))
				return true;
			s = s.substring(1);
		}

		return isMatch3(s, p.substring(2));
	}

	public static void main(String[] args) {
		RegularExpressionMatching test = new RegularExpressionMatching();
		System.out.println(test.isMatch2("", "a"));
		System.out.println(test.isMatch2("a", ""));
//		System.out.println(test.isMatch2("aa", "aa"));
//		System.out.println(test.isMatch2("aaa", "aa"));
//		System.out.println(test.isMatch2("aa", "a*"));
//		System.out.println(test.isMatch2("aa", ".*"));
//		System.out.println(test.isMatch2("ab", ".*"));
//		System.out.println(test.isMatch2("aab", "c*a*b*"));
//		 System.out.println(test.isMatch4("abcca", "a*bc*a"));
	}
}
