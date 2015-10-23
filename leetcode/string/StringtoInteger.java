package string;

public class StringtoInteger {
	public int myAtoi(String str) {
		if (str == null || str.length() == 0)
			return 0;
		boolean positive = true;
		int ret = 0;
		int start = 0;
		while (str.charAt(start) == ' ') {
			start++;
		}
		str = str.substring(start);
		if (str.charAt(0) == '-') {
			positive = false;
			str = str.substring(1);
		} else if (str.charAt(0) == '+') {
			positive = true;
			str = str.substring(1);
		}

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				if (positive) {
					if (ret < Integer.MAX_VALUE / 10)
						ret = ret * 10 + str.charAt(i) - '0';
					else {
						ret = Integer.MAX_VALUE;
						break;
					}
				} else {
					if (ret > Integer.MIN_VALUE / 10) {
						ret = ret * 10 - str.charAt(i) + '0';
					} else if (ret == Integer.MIN_VALUE / 10) {
						if(str.charAt(i)-'0'<=8){
							ret = ret * 10 - str.charAt(i) + '0';	
						}else{ ret=Integer.MIN_VALUE;break;}
					} else {
						ret = Integer.MIN_VALUE;
						break;
					}
				}
			} else
				break;
		}
		return ret;
	}

	public static void main(String[] args) {
		StringtoInteger test = new StringtoInteger();
		System.out.println(test.myAtoi("-2147483647"));
	}
}
