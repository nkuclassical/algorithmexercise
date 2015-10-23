package sort;

import java.util.Arrays;
import java.util.Comparator;

class numberComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer a, Integer b) {
		// TODO Auto-generated method stub
		if (a != 0 && b == 0)
			return -1;
		if (a == 0 && b != 0)
			return 1;
		int an = (int) (Math.log10(a) + 1);
		int bn = (int) (Math.log10(b) + 1);
		if (an == bn) {
			if (b > a)
				return 1;
			else
				return -1;
		}
		if (a * Math.pow(10, bn) + b < b * Math.pow(10, an) + a)
			return 1;
		else
			return -1;
	}
}

public class LargestNumber {
	public String largestNumber(int[] nums) {

		Integer[] Num = new Integer[nums.length];
		for (int i = 0; i < nums.length; i++) {
			Num[i] = nums[i];
		}
		Arrays.sort(Num, new numberComparator());
		if(Num[0]==0)return "0";
		StringBuilder ret = new StringBuilder();
		
		for (Integer num : Num) {
			ret.append(num);
		}
		return ret.toString();
	}

	public static void main(String[] args) {
		LargestNumber test = new LargestNumber();
		int[] nums = new int[2];
		nums[0] = 0;
		nums[1] = 0;
//		nums[2] = 34;
//		nums[3] = 5;
//		nums[4] = 93;
		System.out.println(test.largestNumber(nums));
	}

}
