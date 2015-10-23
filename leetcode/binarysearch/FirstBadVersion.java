package binarysearch;

public class FirstBadVersion {
	public boolean isBadVersion(int version) {
		if (version >= 1)
			return true;
		else
			return false;
	}

	public int firstBadVersion(int n) {
		return binarySearch(1, n);
	}

	public int binarySearch(int start, int end) {
		if (start > end)
			return -1;
		if (start == end) {
			if (isBadVersion(start))
				return start;
			else
				return -1;
		}
		if (start == end - 1) {
			if (isBadVersion(start))
				return start;
			if (isBadVersion(end))
				return end;
			return -1;
		}
		int mid = start + (end - start) / 2;
		if (isBadVersion(mid)) {
			if (isBadVersion(mid - 1))
				return binarySearch(start, mid - 1);
			else
				return mid;
		}
		return binarySearch(mid + 1, end);
	}

	public static void main(String[] args) {
		FirstBadVersion test = new FirstBadVersion();
		System.out.println(test.firstBadVersion(1));
	}
}
