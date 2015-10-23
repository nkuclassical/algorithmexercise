package binarysearch;

public class SearchforaRange {
//	public int[] searchRange(int[] nums, int target) {
//		int start=binarySearchPrefix(nums,0,nums.length-1,target);
//		int end=binarySearchSufix(nums,0,nums.length-1,target);
//		int []ret=new int[2];
//		if(start==-1||end==-1){
//			ret[0]=-1;
//			ret[1]=-1;
//			return ret;
//		} else{
//			ret[0]=start;
//			ret[1]=end;
//			return ret;
//		}
//	}
//	public int binarySearchPrefix(int[]nums,int start,int end,int target){
//		if(start<0||start>=nums.length||end<0||end>=nums.length)return -1;
//		if(start>end)return -1;
//		if(start==end){
//			if(nums[start]==target){
//				return start;
//			}else return -1;
//		}
//		if(start==end-1){
//			if(nums[start]==target)return start;
//			else if(nums[end]==target)return end;
//			else return -1;
//		}
//		int mid=(start+end)/2;
//		if(nums[mid]==target){
//			if((mid>0&&nums[mid-1]!=target)||mid==0)
//				return mid;
//			else return binarySearchPrefix(nums,start,mid-1,target);
//		}else if(nums[mid]<target){
//			return binarySearchPrefix(nums,mid+1,end,target);
//		}else {
//			return binarySearchPrefix(nums,start,mid-1,target);
//		}
//	}
//	public int binarySearchSufix(int[]nums,int start,int end,int target){
//		if(start<0||start>=nums.length||end<0||end>=nums.length)return -1;
//		if(start>end)return -1;
//		if(start==end){
//			if(nums[start]==target){
//				return start;
//			}else return -1;
//		}
//		if(start==end-1){
//			if(nums[end]==target)return end;
//			else if(nums[start]==target)return start;
//			else return -1;
//		}
//		int mid=(start+end)/2;
//		if(nums[mid]==target){
//			if((mid+1<nums.length&&nums[mid+1]!=target)||mid==nums.length-1)
//				return mid;
//			else return binarySearchSufix(nums,mid+1,end,target);
//		}else if(nums[mid]<target){
//			return binarySearchSufix(nums,mid+1,end,target);
//		}else {
//			return binarySearchSufix(nums,start,mid-1,target);
//		}
//	}
    public int[] searchRange(int[] nums, int target) {
        int []ret=new int[2];
        ret[0]=findFirst(nums,target);
        ret[1]=findLast(nums,target);
        return ret;
    }
    
    public int findFirst(int[]nums, int target){
        int start=0, end=nums.length-1;
        int mid;
        while(start<=end){
            mid=start+(end-start)/2;
            if(nums[start]==target)return start;
            else if(nums[start]>target)return -1;
            if(nums[mid]==target){
                if(mid-1>=0&&nums[mid-1]==target)
                    end=mid-1;
                else return mid;
            }else if(nums[mid]<target){
                start=mid+1;
            }else {
                end=mid-1;
            }
        }
        return -1;
    }
    public int findLast(int[]nums,int target){
        int start=0, end=nums.length-1;
        int mid;
        while(start<=end){
            mid=start+(end-start)/2;
            if(nums[end]==target)return end;
            else if(nums[end]<target)return -1;
            if(nums[mid]==target){
                if(mid+1<nums.length&&nums[mid+1]==target)
                    start=mid+1;
                else return mid;
            }else if(nums[mid]<target){
                start=mid+1;
            }else {
                end=mid-1;
            }
        }
        return -1;
    }
	public static void main(String[]args){
		SearchforaRange test=new SearchforaRange();
		int[]a=new int[6];
		a[0]=5;
		a[1]=7;
		a[2]=7;
		a[3]=7;
		a[4]=7;
		a[5]=10;
		int[]ret=test.searchRange(a, 11);
		for(int i=0;i<ret.length;i++){
			System.out.println(ret[i]);
		}
	}
}
