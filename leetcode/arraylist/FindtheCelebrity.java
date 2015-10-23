package arraylist;

//
//0 does not know 1
//0 knows 2; 1 does not know 0
//1 knows 2; 2 does not know 0
//2 does not know 1.


public class FindtheCelebrity {
	public boolean knows(int a,int b){
		if(b==2)return true;
		else if(a==2)return false;
		else if(a==0&&b==1)return false;
		else if(a==1&&b==0)return false;
		else return false;
	};
		
	
	public int findCelebrity(int n) {
	    boolean heknowothers,othersknowhim;
	    for(int i=0;i<n;i++){
	    	System.out.println(i+" "+n);
	    	heknowothers=false;
	    	othersknowhim=true;
	    	for(int j=0;j<i;j++){
	    		if(!knows(j,i)){
	    			othersknowhim=false;
	    			break;
	    		}
	    		if(knows(i,j)){
	    			heknowothers=true;
	    			break;
	    		}
	    	}
	    	if(heknowothers==true||othersknowhim==false)continue;
	    	for(int j=i+1;j<n;j++){
	    		if(!knows(j,i)){
	    			othersknowhim=false;
	    			break;
	    		}
	    		if(knows(i,j)){
	    			heknowothers=true;
	    			break;
	    		}
	    	}
	    	if(heknowothers==false&&othersknowhim==true)return i;
	    }
	    return -1;
	}
	
	public int findCelebrity2(int n) { //O(n)
        int candidate=0;
        for(int i=0;i<n;i++){
            if(!knows(i,candidate)){
                candidate=i;
            }
        }
        
        for(int i=0;i<n;i++){
            if(i==candidate)continue;
            if(knows(candidate,i)||!knows(i,candidate)){
                return -1;
            }
        }
        return candidate;
    }
	
	public static void main(String[]args){
		FindtheCelebrity test=new FindtheCelebrity();
		System.out.println(test.findCelebrity(3));
	}
}
