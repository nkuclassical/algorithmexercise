package binarysearch;

public class test {
	public int findMin(int[] a) {
	    return search(a, 0, a.length - 1);
	  }

	  private int search(int[] a, int lo, int hi) {
	    // a[] is sorted
	    if (lo > hi)
	      return a[0];

	    int mid = lo + (hi - lo) / 2;

	    if (mid > 0 && a[mid - 1] > a[mid])
	      return a[mid];

	    if (mid < a.length - 1 && a[mid] > a[mid + 1])
	      return a[mid + 1];

	    if (a[lo] == a[mid] && a[mid] == a[hi])
	      return Math.min(search(a, lo, mid - 1), search(a, mid + 1, hi));

	    if (a[lo] <= a[mid])
	      return search(a, mid + 1, hi);
	    else
	      return search(a, lo, mid - 1);
	  }
	  public static void main(String[]args){
		  FindMinimuminRotatedSortedArrayII newtest=new FindMinimuminRotatedSortedArrayII();
		  int[]a=new int[3];
		  a[0]=1;
		  a[1]=1;
		  a[2]=3;
		  int ret=newtest.findMin(a);
		  System.out.println(ret);
	  }
}
