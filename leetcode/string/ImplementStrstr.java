package string;

public class ImplementStrstr {
    public int strStr(String haystack, String needle) {
        if(haystack.length()<needle.length())return -1;
        if(needle.length()==0)return 0;
        int i=0,j=0;
        for(i=0;i<=haystack.length()-needle.length();i++){
            for(j=0;j<needle.length();j++){
                if(haystack.charAt(i+j)==needle.charAt(j))continue;
                else break;
            }
            if(j==needle.length()){
                return i;
            }
        }
        return -1;
        
    }
    }
