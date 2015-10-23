package arraylist;
//The input numbers are sorted!
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class TwoSumII {
	public int[] twoSum(int[] numbers, int target) {
		int start = 0, end = numbers.length - 1;
		int[] ret = new int[2];
		while (start < end) {
			if (numbers[start] + numbers[end] < target) {
				start++;
			} else if (numbers[start] + numbers[end] > target) {
				end--;
			} else {
				ret[0] = start + 1;
				ret[1] = end + 1;
				return ret;
			}
		}
		return ret;
	}

}
