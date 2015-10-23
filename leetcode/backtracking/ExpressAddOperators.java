package backtracking;

import java.util.ArrayList;
import java.util.List;

public class ExpressAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String>ret=new ArrayList();
        helper(ret,target, num, "",0,0,0);
        return ret;
    }
    
    public void helper(List<String>ret, int target, String num, String path, int pos, long value, long prefixValue){
        if(pos==num.length()){
            if(value==target){
                ret.add(new String(path));
            }
            return;
        }
        for(int i=pos;i<num.length();i++){
            if(i!=pos&&num.charAt(pos)=='0')break;
            long cur=Long.valueOf(num.substring(pos,i+1));
            if(pos==0)
                helper(ret,target,num,path+cur,i+1,value+cur, cur);
            else{
                helper(ret,target,num,path+"+"+cur,i+1,value+cur,cur);   
                helper(ret,target,num,path+"-"+cur,i+1,value-cur,-cur);
                helper(ret,target,num,path+"*"+cur,i+1,value-prefixValue+prefixValue*cur,prefixValue*cur);
                
            }
        }
    }
    
    public static void main(String[]args){
    	ExpressAddOperators test=new ExpressAddOperators();
    	List<String>result=test.addOperators("123", 6);
    	for(String r:result){
    		System.out.println(r);
    	}
    }
}
