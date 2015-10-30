package string;

import java.util.LinkedList;
import java.util.Queue;

public class ReadNCharactersGivenRead4II {
	/**
	 * function read4 isn't part of my code, just as simulation of an API
	 * 
	 * @param buffer
	 * @return
	 */
	public int read4(char[] buffer) {
		return 0;
	}

	char[] buffer = new char[4];
	int bufoffset = 0;
	int buffercur = 0;
	int buffersize = 0;

	public int read(char[] buf, int n) {
		int bufcur = 0;
		while (buffercur < buffersize) {
			if (bufcur < n) {
				buf[bufoffset + bufcur++] = buffer[buffercur++];
			} else
				return bufcur;
		}
		while (true) {
			int r = read4(buffer);
			for (int i = 0; i < r; i++) {
				if (bufcur < n)
					buf[bufoffset + bufcur++] = buffer[i];
				else {
					buffercur = i;
					buffersize = r;
					return bufcur;
				}
			}
			if (r < 4)
				return bufcur;
		}
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
