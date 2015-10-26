package dynamicprogramming;

public class ClimbingStairs {
	public int climbStairs(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		int num1 = 1, num2 = 2, num3 = 0;
		for (int i = 2; i < n; i++) {
			num3 = num2 + num1;
			num1 = num2;
			num2 = num3;
		}
		return num2;
	}
}
