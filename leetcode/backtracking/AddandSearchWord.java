package backtracking;

public class AddandSearchWord {
	private class TrieNode {
		public boolean isEnd;
		public final int SIZE = 26;
		public TrieNode[] son;

		public TrieNode() {
			this.son = new TrieNode[SIZE];
			this.isEnd = false;
		}
	}

	TrieNode root = new TrieNode();

	public void addWord(String word) {
		TrieNode cur = root;
		for (int i = 0; i < word.length(); i++) {
			if (cur.son[word.charAt(i) - 'a'] == null) {
				cur.son[word.charAt(i) - 'a'] = new TrieNode();
			}
			cur = cur.son[word.charAt(i) - 'a'];
		}
		cur.isEnd = true;
	}

	// Returns if the word is in the data structure. A word could
	// contain the dot character '.' to represent any one letter.
	public boolean search(String word) {
		return searchHelper(word, root);
	}

	public boolean searchHelper(String word, TrieNode cur) {
		if(cur==null)return false;
		if (word == null || word.length() == 0)
			return cur.isEnd;

		if (word.charAt(0) != '.') {
			if (cur.son[word.charAt(0) - 'a'] != null) {
				cur = cur.son[word.charAt(0) - 'a'];
				return searchHelper(word.substring(1), cur);
			} else
				return false;
		} else if (word.charAt(0) == '.') {
			for (TrieNode son : cur.son) {
				if (searchHelper(word.substring(1), son))
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		AddandSearchWord test = new AddandSearchWord();
		test.addWord("bad");
		test.addWord("dad");
		test.addWord("mad");
		System.out.println(test.search("pad"));
		System.out.println(test.search("bad"));
		System.out.println(test.search(".ad"));
		 System.out.println(test.search("b.."));
		System.out.println(test.search("b.e"));
	}
}
