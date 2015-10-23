package greedy;

public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int size=gas.length;
		int []diff=new int[size];
		for(int i=0;i<size;i++){
			diff[i]=gas[i]-cost[i];
		}
		
		int sum=0,leftGas=0,startNode=0;
		for(int i=0;i<size;i++){
			leftGas+=diff[i];
			sum+=diff[i];
			if(sum<0){
				startNode=i+1;
				sum=0;
			}
		}
		if(leftGas<0)return -1;
		else return startNode;
	}
	
	
}
