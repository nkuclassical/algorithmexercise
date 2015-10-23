package math;

import java.util.HashMap;

public class FactorialTrailingZeroes {
	public int trailingZeros(int n) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int ret = 0;
		int count = 0;
		long multi = 5, add = 5;
		while (add <= n) {
			if (add == multi) {
				multi *= 5;
				count++;
			}
			ret += count;
			add += 5;
		}
		return ret;
	}

	public int trailingZeroes(int n) {
		if (n < 5)
			return 0;

		int x = 5;
		int zero = 0;
		while (x <= n / 5) {
			zero += n / x;
			x = x * 5;
		}
		zero += n / x;
		return zero;
	}
	
	public int trailingZeroes2(int n) {
//		int x = 5;
		int zero = 0;
		while (n>0) {
			zero += n / 5;
			n/=5;
		}
		return zero;
	}

	public static void main(String[] args) {
		FactorialTrailingZeroes test = new FactorialTrailingZeroes();
		System.out.println(test.trailingZeroes(Integer.MAX_VALUE));
		System.out.println(test.trailingZeroes2(Integer.MAX_VALUE));

	}
}
