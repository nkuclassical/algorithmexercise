package backtracking;

public class WordSearch {

	public boolean exist(char[][] board, String word) {
		if (board.length == 0 || board[0].length == 0)
			return false;
		boolean[][] visit = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if ((board[i][j] == word.charAt(0))
						&& search(board, visit, word, i, j, 0)) {
					return true;
				}
			}
		}
		return false;

	}

	public boolean search(char[][] board, boolean[][] visit, String word,
			int x, int y, int index) {
		if (index == word.length())
			return true;
		if (x < 0 || x >= board.length || y < 0 || y >= board[0].length
				|| board[x][y] != word.charAt(index) || visit[x][y]) {
			return false;
		} else {
			visit[x][y] = true;
			if (search(board, visit, word, x + 1, y, index + 1)
					|| search(board, visit, word, x - 1, y, index + 1)
					|| search(board, visit, word, x, y - 1, index + 1)
					|| search(board, visit, word, x, y + 1, index + 1)) {
				return true;
			}
			visit[x][y] = false;
			return false;
		}
	}
}
