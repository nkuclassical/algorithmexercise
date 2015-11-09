package backtracking;

public class FlipGameII {
	public boolean canWin(String s) {
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<s.length();i++){
            boolean win=false;
            if(s.charAt(i-1)=='+'&&s.charAt(i)=='+'){
                sb=new StringBuilder(s);
                sb.setCharAt(i-1,'-');
                sb.setCharAt(i,'-');
                win=canWin(sb.toString());
                if(win==false)return true;
            }
        }
        return false;
    }
}
