package string;

import java.util.LinkedList;
import java.util.Queue;

public class ReadNCharactersGivenRead4II {

	Queue<Character> lastLeft = new LinkedList();

	public int read4(char[] buf) {
		String t = "ab";
		buf = t.toCharArray();
		return 2;
	}
	private int bufferPrevious=0;
	private int bufferCurrent=0;
	private char[]buffer=new char[4];
	public int read(char[] buf, int n) {
		int ptr=0;
		while(ptr<n){
			if(bufferPrevious==0){
				bufferCurrent=read4(buffer);
			}
			if(bufferCurrent==0)break;
			while(ptr<n&&bufferPrevious<bufferCurrent){
				buf[ptr++]=buffer[bufferPrevious++];
			}
			if(bufferPrevious>=bufferCurrent)bufferPrevious=0;
				
			
		}
		return ptr;
	}

	public static void main(String[] args) {
		ReadNCharactersGivenRead4II test = new ReadNCharactersGivenRead4II();
		char[] buf = new char[100];
		test.read(buf, 1);
		System.out.println(buf);
		test.read(buf, 2);
		System.out.println(buf);
	}
}
