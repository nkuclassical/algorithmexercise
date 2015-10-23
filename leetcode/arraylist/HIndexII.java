package arraylist;

public class HIndexII {
	public int hIndex(int[] citations) {// 顺序查
		int hindex=0;
        for(int i=citations.length-1;i>=0;i--){
            if(hindex+1>citations[i]){
                return hindex;
            }else hindex++;
        }
        return hindex;
    }

	public int hIndex2(int[] citations) {// binary search
		int length = citations.length;
		if (length == 0)
			return 0;
		int start = 0, end = length - 1;
		int mid;
		while (start < end - 1) {
			mid = start + (end - start) / 2;
			int paper = length - mid;
			if (paper == citations[mid])
				return paper;
			else if (paper < citations[mid]) {
				end = mid;
			} else if (paper > citations[mid]) {
				start = mid;
			}
		}
		if (length - start <= citations[start])
			return length - start;
		if (length - end <= citations[end])
			return length - end;
		return 0;
	}
	
	public int hIndex4(int[] citations) {
        int start=0, end=citations.length-1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(citations[start]<start)return start-1;
            if(citations[start]==start)return start;
            if(citations[end]>=end)return end;
            if(citations[mid]>mid)start=mid+1;
            else if(citations[mid]<mid)end=mid-1;
            else return mid;
        }
        return start;
    }

	public int hIndex3(int[] citations) {// binary search optimize
		int length = citations.length;
		int start = 0, end = length - 1;
		int mid;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (citations[mid] >= length - mid) {
				if (mid < 1 || citations[mid - 1] <= length - mid)
					return length - mid;
				else
					end = mid - 1;
			} else
				start = mid + 1;
		}
		return 0;
	}

	public static void main(String[] args) {
		HIndexII test = new HIndexII();
		int[] a = new int[6];
		a[0] = 0;
		a[1] = 2;
		a[2] = 2;
		a[3] = 2;
		a[4] = 2;

		System.out.println(test.hIndex3(a));
	}
}
