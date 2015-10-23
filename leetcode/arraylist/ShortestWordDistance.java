package arraylist;

public class ShortestWordDistance {
	public int shortestDistance(String[] words, String word1, String word2) {
		int result = Integer.MAX_VALUE;
		int position1 = -1;
		int position2 = -1;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1)) {
				position1 = i;
				if (words[i].equals(word1) && position2 != -1) {
					if (Math.abs(i - position2) < result) {
						result = Math.abs(i - position2);
					}
				}
			} else if (words[i].equals(word2)) {
				position2 = i;
				if (position1 != -1) {
					if (Math.abs(i - position1) < result) {
						result = Math.abs(i - position1);
					}
				}
			}
		}
		return result;
	}
}
