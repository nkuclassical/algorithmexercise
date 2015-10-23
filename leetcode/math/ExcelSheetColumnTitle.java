package math;

public class ExcelSheetColumnTitle {
	public String convertToTitle(int n) {
		StringBuilder ret = new StringBuilder();
		while (n > 0) {
			char c = (char) ((n - 1) % 26 + 'A');
			ret.insert(0, c);
			n = (n - 1) / 26;
		}
		return ret.toString();
	}

	public String convertToTitle2(int n) {
		StringBuilder sb = new StringBuilder();
		while (n != 0) {
			sb.insert(0, (char) ((n - 1) % 26 + 'A'));
			n = (n-1)/26;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		ExcelSheetColumnTitle test = new ExcelSheetColumnTitle();
		System.out.println(test.convertToTitle2(26));
	}
}
