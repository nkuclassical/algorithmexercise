package arraylist;

public class MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int cur=m+n-1;
		int nums1index=m-1,nums2index=n-1;
		while(nums1index>=0&&nums2index>=0){
			nums1[cur--]=nums1[nums1index]<nums2[nums2index]?nums2[nums2index--]:nums1[nums1index--];
		}
		while(nums2index>=0){
			nums1[nums1index--]=nums2[nums2index--];
		}
	}
}
