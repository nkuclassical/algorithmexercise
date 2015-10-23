package binarysearch;

public class Sqrtx {
	public int mySqrt(int x) {
		if(x>Integer.MAX_VALUE||x<Integer.MIN_VALUE||x==0)return 0;
		int start = 1, end = x;
		int ret = -1;
		if (start  == x/start) {
			return start;
		}
		if (end  == x/end) {
			return end;
		}
		while (start < end - 1) {

			int mid = start + (end-start) / 2;
			if (mid  < x/mid) {
				start = mid;
			} else if (mid  > x/mid) {
				end = mid;
			} else {
				ret = mid;
				break;
			}
		}
		if (ret != -1)
			return ret;
		else
			return start;
	}

	
    public int mySqrt2(int x) {
        if(x<=0)return 0;
        int start=0, end=x;
        while(start<end){
        	int mid=(start+end)/2;
        	if(mid==end||mid==start)break;
        	if(mid==x/mid)return (int)mid;
        	else if(mid<x/mid){
            	start=mid;
            }else {
            	end=mid;
            }
        }
        if(end*end==x)return end;
        return start;
    }
	public static void main(String[] args) {
		Sqrtx test = new Sqrtx();
	for (int i = 1; i < 26; i++)
			System.out.println(i + "  -> " + test.mySqrt2(i)+" -> "+ Math.sqrt(i));
	}

}
