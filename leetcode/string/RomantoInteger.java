package string;

public class RomantoInteger {
	public static int getNum(char c) {
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		}
		return 0;
	}

	public int romanToInt(String s) {
		int ret=0;
        for(int i=0;i<s.length();i++){
            int a=getNum(s.charAt(i));
            int b=0;
            if(i<s.length()-1)
                b=getNum(s.charAt(i+1));
            if(a>=b)ret+=a;
            else{
                ret+=(b-a);
                i++;   
            }
        }
        return ret;	
	}

	public int helper(char s) {
		if (s == 'I') {
			return 1;
		} else if (s == 'V') {
			return 5;
		} else if (s == 'X') {
			return 10;
		} else if (s == 'L') {
			return 50;
		} else if (s == 'C') {
			return 100;
		} else if (s == 'D') {
			return 500;
		} else if (s == 'M') {
			return 1000;
		} else
			return 0;
	}

	public int toint(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int ret = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i + 1 < s.length() && helper(s.charAt(i)) < helper(s.charAt(i + 1))) {
				ret -= helper(s.charAt(i));
			} else
				ret += helper(s.charAt(i));
		}
		return ret;
	}

	public static void main(String[] args) {
		RomantoInteger test = new RomantoInteger();
		System.out.println(test.toint("DCXXI"));
	}
}
