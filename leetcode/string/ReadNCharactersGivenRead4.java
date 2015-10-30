package string;

public abstract class ReadNCharactersGivenRead4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
	abstract int read4(char[]buf);
    public int read(char[] buf, int n) {
        char[]buffer=new char[4];
        int cur=0;
        while(true){
            int r=read4(buffer);
            for(int i=0;i<r;i++){
                if(cur<n)
                    buf[cur++]=buffer[i];
                else break;
            }
            if(r<4)break;
        }
        return cur;
    }
}
