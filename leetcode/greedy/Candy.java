package greedy;

public class Candy {
	public int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0)
			return 0;
		int len = ratings.length;
		int[] candies = new int[len];
		candies[0] = 1;
		for (int i = 1; i < len; i++) {
			if (ratings[i] > ratings[i - 1]) {
				candies[i] = candies[i - 1] + 1;
			} else {
				candies[i] = 1;
			}
		}
		for (int i = len - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				candies[i] = Math.max(candies[i], candies[i + 1] + 1);
			}
		}
		int ret = 0;
		for (int i = 0; i < len; i++) {
			ret += candies[i];
		}
		return ret;
	}

	public static void main(String[] args) {
		Candy test = new Candy();
		int ratings[] = new int[10];
		ratings[0] = 3;
		ratings[1] = 9;
		// ratings[2]=9;
		// ratings[3]=6;
		// ratings[4]=5;
		// ratings[5]=100;
		// ratings[6]=100;
		// ratings[7]=101;
		// ratings[8]=99;
		// ratings[9]=99;
		System.out.println(test.candy(ratings));

	}
}
