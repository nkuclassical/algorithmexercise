package hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ContainsDuplicateIII {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if(nums.length<2||k<1||t<0)return false;
		pairValue[]pv=new pairValue[nums.length];
		for(int i=0;i<nums.length;i++){
			pv[i]=new pairValue(nums[i],i);
		}
		Arrays.sort(pv);
		for(int i=0;i<pv.length;i++){
			for(int j=i+1;j<pv.length&&(((long)pv[j].val-(long)pv[i].val)<=(long)t);j++){
				if(Math.abs(pv[j].pos-pv[i].pos)<=k)return true;
			}
		}
		return false;
		
	}
	class pairValue implements Comparable<pairValue>{

		int val;
		int pos;
		pairValue(int v,int p){
			this.val=v;
			this.pos=p;
		}
		@Override
		public int compareTo(pairValue o) {
			// TODO Auto-generated method stub
			if(o.val<this.val)return 1;
			else if(o.val==this.val)return 0;
			else return -1;
		}
	}
	
	
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        PV[]p=new PV[nums.length];
        for(int i=0;i<nums.length;i++){
            p[i]=new PV(i,nums[i]);
        }
        Arrays.sort(p);
        for(int i=0;i<p.length;i++){
            for(int j=i+1;j<p.length&&(Math.abs((long)p[i].val-(long)p[j].val)<=(t));j++){
                if(Math.abs(p[i].pos-p[j].pos)<=k)return true;
            }
        }
        return false;
    }
    class PV implements Comparable<PV>{
        int pos;
        int val;
        public PV(int p, int v){
            this.pos=p;
            this.val=v;
        }
        public int compareTo(PV p){
            if(this.val>p.val)return 1;
            else if(this.val<p.val)return -1;
            else return 0;
        }
    }
	public static void main(String[]args){
		ContainsDuplicateIII test=new ContainsDuplicateIII();
		int []nums=new int[2];
		nums[0]=-1;
		nums[1]=Integer.MAX_VALUE;
		System.out.println(test.containsNearbyAlmostDuplicate(nums, 1, Integer.MAX_VALUE));
		HashSet<Integer>set=new HashSet();
		HashMap<Integer,Integer>map=new HashMap();
		
	}
}
