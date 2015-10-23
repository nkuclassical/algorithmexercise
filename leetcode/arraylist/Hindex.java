package arraylist;

import java.util.Arrays;
import java.util.Comparator;

public class Hindex {
	public int hIndex(int[] citations) {
		int[] paper = new int[citations.length + 1];
		for (int i = 0; i < citations.length; i++) {
			if (citations[i] >= citations.length) {
				paper[citations.length]++;
			} else {
				paper[citations[i]]++;
			}
		}
		for (int i = paper.length - 2; i >= 0; i--) {
			paper[i] += paper[i + 1];
		}
		for (int i = 0; i <= citations.length; i++) {
			if (paper[i] == i) {
				return i;
			} else if (paper[i] < i)
				return i - 1;
		}
		return 0;
	}

	public int hIndex2(int[] citations) { //better
		int[] paper = new int[citations.length + 1];
		for (int i = 0; i < citations.length; i++) {
			if (citations[i] >= citations.length) {
				paper[citations.length]++;
			} else
				paper[citations[i]]++;
		}
		if (paper[paper.length - 1] >= paper.length - 1)
			return paper.length - 1;
		for (int i = paper.length - 2; i >= 0; i--) {
			paper[i] += paper[i + 1];
			if (paper[i] >= i)
				return i;
		}
		return 0;
	}

	public static void main(String[] args) {
		int[] c = new int[2];
		c[0] = 1;
		c[1] = 1;
		// c[2]=6;
		// c[3]=1000;
		// c[4]=500;
		Hindex test = new Hindex();
		System.out.println(test.hIndex2(c));
	}
}
