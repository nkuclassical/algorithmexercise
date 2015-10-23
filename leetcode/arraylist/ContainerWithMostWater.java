package arraylist;

public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int left=0,right=height.length-1;
		int maxsize=0;
		while(left<right){
			int tempsize=(right-left)*(Math.min(height[left], height[right]));
			if(tempsize>maxsize)maxsize=tempsize;
			if(height[left]<height[right])left++;
			else right--;
		}
		return maxsize;
	}
	public static void main(String[]args){
		ContainerWithMostWater test=new ContainerWithMostWater();
		int[]height=new int[4];
		height[0]=1;
		height[1]=11;
		height[2]=20;
		height[3]=1;
		System.out.println(test.maxArea(height));
	}
}
