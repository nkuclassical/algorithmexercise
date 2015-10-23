package twopointers;

public class TrappingRainWater {
	public int trap(int[] height) {
		int maxIndex = 0;
		for (int i = 0; i < height.length; i++) {
			if (height[i] > height[maxIndex]) {
				maxIndex = i;
			}
		}

		// left part of peek!
		int leftValue = 0;
		int ret = 0;
		for (int i = 1; i < maxIndex; i++) {
			if (height[leftValue] < height[i]) {
				leftValue = i;
			} else {
				ret += height[leftValue] - height[i];
			}
		}
		// right part of peek!
		int rightValue = height.length - 1;
		for (int i = height.length - 2; i > maxIndex; i--) {
			if (height[rightValue] < height[i]) {
				rightValue = i;
			} else {
				ret += height[rightValue] - height[i];
			}
		}
		return ret;
	}

	
	//这种方法更快！
	public int trap2(int[] A) {
		int left = 0, right = A.length - 1;
		int level = 0, result = 0;
		while (left < right) {
			level = Math.max(Math.min(A[left], A[right]), level);
			if (A[left] <= A[right]) {
				result += level - A[left];
				left++;
			} else {
				result += level - A[right];
				right--;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] h = new int[12];
		h[0] = 0;
		h[1] = 1;
		h[2] = 0;
		h[3] = 2;
		h[4] = 1;
		h[5] = 0;
		h[6] = 1;
		h[7] = 3;
		h[8] = 2;
		h[9] = 1;
		h[10] = 2;
		h[11] = 1;
		TrappingRainWater test = new TrappingRainWater();
		System.out.println(test.trap(h));

	}
}
