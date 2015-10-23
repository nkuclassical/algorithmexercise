package math;

public class RectangleArea {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G,
			int H) {
		int size = (C - A) * (D - B) + (G - E) * (H - F);

		if (helper(A, C, E, G) > 0 && helper(B, D, F, H) > 0) {
			size -= helper(A, C, E, G) * helper(B, D, F, H);
		}
		return size;
	}

	public int helper(int a1, int b1, int a2, int b2) {
		if (a2 > b1 || a1 > b2)
			return 0;
		int length = (Math.min(b1, b2) - Math.max(a1, a2));
		return length;
	}


	public static void main(String[] args) {
		RectangleArea test = new RectangleArea();
		System.out.println(test.computeArea(-2,-2,2,2,-2,-2,2,2));
	}
}
