package math;

public class ReverseInteger {

	public int reverse(int x) {
		if (x == Integer.MAX_VALUE || x == Integer.MIN_VALUE)
			return 0;
		int positive = 1;
		if (x < 0) {
			positive = -1;
			x = -x;
		}
		int result = 0;
		while (x != 0) {
			if (result > Integer.MAX_VALUE / 10)
				return 0;
			result = result * 10 + x % 10;
			x /= 10;
		}
		return result * positive;
	}

	public int reverse2(int x) {
		if(x==Integer.MIN_VALUE||x==Integer.MAX_VALUE)return 0;
		boolean negative = false;
		if (x < 0) {
			negative = true;

		}
		int newx = Math.abs(x);
		int ret = 0;
		while (newx > 0) {
			if(ret>Integer.MAX_VALUE/10)return 0;
			ret = ret * 10 + newx % 10;
			newx /= 10;
		}
		if (negative)
			ret = -ret;

		return ret;

	}

	// public int reverse(int x) {
	// String astring=String.valueOf(x);
	// StringBuilder newstring=new StringBuilder();
	// if(astring.charAt(0)=='-'){
	// newstring.append("-");
	// newstring.append(new
	// StringBuilder(astring.substring(1)).reverse().toString());
	// }else{
	// newstring.append(new StringBuilder(astring).reverse().toString());
	// }
	// return Integer.valueOf(newstring.toString());
	// }
	public static void main(String[] args) {
		ReverseInteger ri = new ReverseInteger();
		System.out.println(ri.reverse(1463847412));
		System.out.println(964632435 * 10);
		System.out.println(Integer.MAX_VALUE);
	}
}
