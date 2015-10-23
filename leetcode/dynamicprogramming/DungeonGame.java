package dynamicprogramming;

public class DungeonGame {
	public int calculateMinimumHP(int[][] d) {
		if (d.length == 0 || d[0].length == 0)
			return 0;
		int row = d.length;
		int column = d[0].length;
		d[row - 1][column - 1] = Math.max(1, 1 - d[row - 1][column - 1]);
		for (int i = row - 2; i >= 0; i--) {
			d[i][column - 1] = Math.max(1, d[i + 1][column - 1]
					- d[i][column - 1]);
		}

		for (int i = column - 2; i >= 0; i--) {
			d[row - 1][i] = Math.max(1, d[row - 1][i + 1] - d[row - 1][i]);
		}
		
		for(int i=row-2;i>=0;i--){
			for(int j=column-2;j>=0;j--){
				d[i][j]=Math.max(1, Math.min(d[i][j+1]-d[i][j], d[i+1][j]-d[i][j]));
			}
		}
		
		return d[0][0];
	}
	
	public static void main(String[]args){
		int[][]d=new int[3][3];
		d[0][0]=-2;
		d[0][1]=-3;
		d[0][2]=3;
		d[1][0]=-5;
		d[1][1]=-10;
		d[1][2]=1;
		d[2][0]=10;
		d[2][1]=30;
		d[2][2]=-5;
		DungeonGame test=new DungeonGame();
		System.out.println(test.calculateMinimumHP(d));
	}
}
