package binarysearch;

import java.util.HashMap;
import java.util.Map;

public class Powxn {
////	HashMap<Integer, Double> map = new HashMap();
////
////	public double myPow(double x, int n) {
////		if (n >= 0)
////			return powSub(x, 0, n);
////		else
////			return 1 / powSub(x, 0, -n);
////	}
////
////	public double powSub(double x, int start, int len) {
////
////		if (map.containsKey(len))
////			return map.get(len);
////		else if (len > 2) {
////			double ret = powSub(x, start, len / 2)
////					* powSub(x, start + len / 2, len - len / 2);
////			map.put(len, ret);
////			return ret;
////		} else if (len == 2) {
////			map.put(2, x * x);
////			return x * x;
////		} else if (len == 1) {
////			map.put(1, x);
////			return x;
////		} else {
////			map.put(0, 1.0);
////			return 1;
////		}
////	}
////
//	public double myPow2(double x, int n) {
//		HashMap<Double, Double> map = new HashMap();
//		double len=n;
//		if (len >= 0)
//			return helper(x,  len, map);
//		else
//			return 1 / helper(x,  -len, map);
//
//	}
//
//	public double helper(double x,  double len,
//			HashMap<Double, Double> map) {
////		Math.pow(1,2);
//		if(len==0)return 1;
//		
//		else if (len == 1) {
//			map.put(1.0, x);
//			return x;
//		} else if (len == 2) {
//			map.put(2.0, x * x);
//			return x * x;
//		}
//		
//		if (map.containsKey(len)) {
//			return map.get(len);
//		} else {
//
//			double result = helper(x, len / 2, map)
//					* helper(x, len-len/2, map);
//			map.put(len, result);
//			return result;
//		}
//	}

//	
    Map<Double,Double>map=new HashMap();
    public double myPow(double x, int n) {
        boolean negative=(n<0)?true:false;
        double len=n;
        if(len>0){
            return helper(x,len);
        }else return 1/helper(x,-len);
    }
    public double helper(double x, double n){
        if(map.containsKey(n))return map.get(n);
        else if(n==0){
            return 1.0;
        }
        else if(n==1){
            map.put(1.0,x);
            return x;
        }
        else if(n==2){
            map.put(2.0,x*x);
            return x*x;
        }
        else {
            double result=helper(x,Math.ceil(n/2))*helper(x,(n-Math.ceil(n/2))); //Math.ceil() is very import, otherwise it my cause serious load problem!
            map.put(n,result);
            return result;
        }
    }
	public static void main(String[] args) {
		Powxn test = new Powxn();
		// for(int i=0;i<10;i++)
//		System.out.println(test.myPow2(34.00515, -3));
//		System.out.println(test.myPow(1,Integer.MIN_VALUE));
		System.out.println(test.myPow(8.88023,3));
	}
}
