package string;

public class OneEditDistance {
	public boolean isOneEditDistance(String s, String t) {

		if (s.length() == t.length()) {
			int modify = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) != t.charAt(i)) {
					modify++;
					if (modify > 1)
						return false;
				}
			}
			if (modify == 1)
				return true;
			else
				return false;
		} else if (Math.abs(s.length() - t.length()) == 1) {
			return s.length() > t.length() ? delOneEditDistance(s, t)
					: delOneEditDistance(t, s);
		} else
			return false;
	}

	public boolean delOneEditDistance(String s, String t) {
		StringBuilder sb=new StringBuilder(s);
		int time = 0;
		for (int i = 0; i < t.length(); i++) {
			if (sb.charAt(i) != t.charAt(i)) {
				sb.deleteCharAt(i);
				time++;
				if (time > 1)
					return false;
				i--;
			}
		}
		if (time == 1 || time == 0)
			return true;
		else
			return false;

	}

	
    public boolean isOneEditDistance2(String s, String t) {//better!
        if(Math.abs(s.length()-t.length())>1)return false;
        int edit=0;
        if(s.length()==t.length()){
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)!=t.charAt(i)){
                    if(edit==0)
                        edit=1;
                    else return false;
                }
            }
            if(edit==0)return false;
            else return true;
        }else{
            if(s.length()>t.length()){
                String temp=t;
                t=s;
                s=temp;
            }
            for(int i=0;i<s.length();){
                if(s.charAt(i)!=t.charAt(i+edit)){
                    if(edit==0){
                        edit=1;
                    }else{
                        return false;
                    }
                }else{
                    i++;
                }
            }
            return true;
        }
    }
	public static void main(String[] args) {
		OneEditDistance test = new OneEditDistance();
		System.out.println(test.isOneEditDistance("123", "1423"));
	}
}
