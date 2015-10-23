package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class LRUCache1 {
	int[][]matrix;
	int[]zerotimes;
	Map<Integer,Integer> cache=new HashMap();
	Map<Integer,Integer> position=new HashMap();
	Map<Integer,Integer> position2value=new HashMap();
	public LRUCache1(int capacity) {
		
		matrix=new int[capacity][capacity];
		zerotimes=new int[capacity];
		for(int i=0;i<capacity;i++){
			zerotimes[i]=0;
			for(int j=0;j<capacity;j++){
				matrix[i][j]=0;
			}
		}
	}

	public int get(int key) {
		if(cache.containsKey(key))return cache.get(key);
		else return -1;
	}

	public void set(int key, int value) {
		if(cache.containsKey(key)){
			int p=position.get(key);
			for(int i=0;i<matrix.length;i++){
				matrix[i][p]=1;
			}
			for(int i=0;i<matrix.length;i++){
				if(matrix[p][i]==1){
					zerotimes[i]=(zerotimes[i]==0)?0:zerotimes[i]-1;
				}
				matrix[p][i]=0;
			}
			cache.put(key, value);
			
		}else{
			int i=0;
			while(zerotimes[i]!=0)i++;
			if(position2value.containsKey(i)){
				position.remove(i);
				cache.remove(position2value.get(i));
				position2value.put(i, key);
				position.put(key, i);
				cache.put(key, value);
			}else{
				position.put(key, i);
				cache.put(key, value);
				position2value.put(i, key);
			}
			for(int j=0;j<matrix.length;j++){
				matrix[j][i]=1;
				
			}
			zerotimes[i]=matrix.length;
			for(int j=0;j<matrix.length;j++){
				if(matrix[i][j]==1){
					zerotimes[j]=(zerotimes[j]==0)?0:zerotimes[j]-1;
				}
				matrix[i][j]=0;
			}
		}
	}
	
	
	public static void main(String[]args){
		LRUCache1 test=new LRUCache1(10);
		test.set(4, 104);
		test.set(1, 101);
		test.set(10, 110);
		test.set(5, 105);
//		test.set(6, 106);
//		test.set(7, 107);
		test.set(10,13);
		test.set(3,17);
		test.set(6,11);
		test.set(10,5);
		test.set(9,10);
		test.get(13);test.set(2,19);
		test.get(2);test.get(3);test.set(5,25);test.get(8);test.set(9,22);test.set(5,5);test.set(1,30);
		test.get(11);test.set(9,12);test.get(7);test.get(5);test.get(8);test.get(9);test.set(4,30);test.set(9,3);
		test.get(9);
		System.out.println(test.get(10));//,get(10),set(6,14),set(3,1),get(3),set(10,11),get(8),set(2,14),get(1),get(5),get(4),set(11,4),set(12,24),set(5,18),get(13),set(7,23),get(8),get(12),set(3,27),set(2,12),get(5),set(2,9),set(13,4),set(8,18),set(1,7),get(6),set(9,29),set(8,21),get(5),set(6,30),set(1,12),get(10),set(4,15),set(7,22),set(11,26),set(8,17),set(9,29),get(5),set(3,4),set(11,30),get(12),set(4,29),get(3),get(9),get(6),set(3,4),get(1),get(10),set(3,29),set(10,28),set(1,20),set(11,13),get(3),set(3,12),set(3,8),set(10,9),set(3,26),get(8),get(7),get(5),set(13,17),set(2,27),set(11,15),get(12),set(9,19),set(2,15),set(3,16),get(1),set(12,17),set(9,1),set(6,19),get(4),get(5),get(5),set(8,1),set(11,7),set(5,2),set(9,28),get(1),set(2,2),set(7,4),set(4,22),set(7,24),set(9,26),set(13,28),set(11,26)
//		int[][]matrixbak=test.matrix;
//		for(int i=0;i<matrixbak.length;i++){
//			for(int j=0;j<matrixbak.length;j++){
//				System.out.print(matrixbak[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println(test.get(4));
//		System.out.println(test.get(5));
	}
}
