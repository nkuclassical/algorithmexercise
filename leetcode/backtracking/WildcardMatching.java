package backtracking;

public class WildcardMatching {
	public boolean isMatch(String s, String p) {
		System.out.println("Compare " + s + "  " + p);
		if (p.length() == 0) {
			return s.length() == 0;
		}
		if (s.length() == 0) {
			for (int i = 0; i < p.length(); i++) {
				if (p.charAt(i) != '*')
					return false;
			}
			return true;
		}
		for (int i = 0; i < s.length() && i < p.length();) {
			if (p.charAt(i) == '?') {
				i++;
				continue;
			} else if (p.charAt(i) == '*') {
				int nextnotstar = i;
				while (nextnotstar < p.length() && p.charAt(nextnotstar) == '*')
					nextnotstar++;
				if (nextnotstar == p.length())
					return true;
				while (i < s.length()) {
					while (i < s.length()
							&& s.charAt(i) != p.charAt(nextnotstar))
						i++;
					if (isMatch(s.substring(i), p.substring(nextnotstar)))
						return true;
					i++;
				}
				return false;
			} else if (p.charAt(i) == s.charAt(i)) {
				i++;

				continue;
			} else
				return false;
		}
		if (s.length() == p.length())
			return true;
		return false;
	}

	public boolean isMatch2(String s, String p) {// this solution doesn't works!
		int i = 0, j = 0;
		int backi = -1, backj = -1;
		while (i < s.length() && j < p.length()) {
			if (s.charAt(i) == p.charAt(j)) {
				j++;
				i++;
			} else if (p.charAt(j) == '?') {
				i++;
				j++;
			} else if (p.charAt(j) == '*') {
				backi = i;
				backj = j;
				j++;
			} else {
				if (backi == -1 || backj == -1)
					return false;
				i = backi + 1;
				j = backj + 1;
				backi = i;

			}

		}

		if (i == s.length()) {
			while (j < p.length()) {
				if (p.charAt(j) != '*')
					return false;
				j++;
			}
			return true;
		}
		return false;
	}
	
	

	static void display(boolean [][]matrix){
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[i].length; j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	public boolean isMatch3(String s, String p) { // perfect, dp!
		int lens = s.length(), lenp = p.length();
		boolean[][] matrix = new boolean[lens + 1][lenp + 1];
		matrix[0][0] = true;
		display(matrix);
		for (int i = 1; i <= lenp; i++)
			matrix[0][i] = p.charAt(i - 1) == '*' && matrix[0][i - 1];
		for (int i = 1; i <= lens; i++) {
			for (int j = 1; j <= lenp; j++) {
				if (p.charAt(j - 1) == '*') {
					matrix[i][j] = matrix[i - 1][j] || matrix[i][j - 1];
				} else if (p.charAt(j - 1) == '?'
						|| p.charAt(j - 1) == s.charAt(i - 1))
					matrix[i][j] = matrix[i - 1][j - 1];

			}
		}

		return matrix[lens][lenp];

	}

	
    public boolean isMatch4(String s, String p) { //perfet!
        int row=p.length();
        int col=s.length();
        boolean m[][]=new boolean[row+1][col+1];
        m[0][0]=true;
        for(int i=1;i<row+1;i++)m[i][0]=(p.charAt(i-1)=='*')?m[i-1][0]:false;
        for(int i=1;i<col+1;i++)m[0][i]=false;
        for(int i=1;i<row+1;i++){
            for(int j=1;j<col+1;j++){
                if(p.charAt(i-1)=='*'){
                    m[i][j]=m[i-1][j]||m[i][j-1];
                }else{
                    m[i][j]=m[i-1][j-1]&&(p.charAt(i-1)=='?'||p.charAt(i-1)==s.charAt(j-1));
                }
            }
        }
        return m[row][col];
    }
	public static void main(String[] args) {
		WildcardMatching test = new WildcardMatching();
		boolean[][]a=new boolean[3][4];
		display(a);
		// System.out.println(test.isMatch3("", "*"));
		// System.out.println(test.isMatch3("aafasdffdae", "a*****e"));
		// System.out.println(test.isMatch3("aa", "*"));
		// System.out.println(test.isMatch3("aaa", "aaa"));
		// System.out.println(test.isMatch3("aa", "a*****a"));
//		System.out.println(test.isMatch3("aa", "a"));
//		System.out.println(test.isMatch3("ab", "?*"));
//		System.out.println(test.isMatch3("aab", "c*a*b"));
//		System.out.println(test.isMatch3("", "*"));
//		System.out.println(test.isMatch3("abefcdgiescdfimde", "ab*cd?i*de"));
/*		System.out
				.println(test
						.isMatch3(
								"abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb",
								"*aa*ba*a*bb*aa*ab*a*aaaaaa*a*aaaa*bbabb*b*b*aaaaaaaaa*a*ba*bbb*a*ba*bb*bb*a*b*bb"));
	*/	// System.out
		// .println(test
		// .isMatch(
		// "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb",
		// "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"));
	}

}
