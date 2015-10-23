package breadthfirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class NumberofIslands {
	private class Point{
		int row,col;
		public Point(int row,int col){
			this.row=row;
			this.col=col;
		}
	}
	public int numIslands(char[][] g) {
		if(g==null||g.length==0||g[0].length==0)return 0;
		Queue<Point>queue=new LinkedList();
		int ret=0;
		for(int i=0;i<g.length;i++){
			for(int j=0;j<g[i].length;j++){
				if(g[i][j]=='1'){
					ret++;
					queue.add(new Point(i,j));
					g[i][j]='0';
					while(!queue.isEmpty()){
						Point point=queue.poll();
						if(point.row-1>=0&&g[point.row-1][point.col]=='1'){
							g[point.row-1][point.col]='0';
							queue.offer(new Point(point.row-1,point.col));
						}
						if(point.row+1<g.length&&g[point.row+1][point.col]=='1'){
							g[point.row+1][point.col]='0';
							queue.offer(new Point(point.row+1,point.col));
						}
						if(point.col-1>=0&&g[point.row][point.col-1]=='1'){
							g[point.row][point.col-1]='0';
							queue.offer(new Point(point.row,point.col-1));
						}
						if(point.col+1<g[0].length&&g[point.row][point.col+1]=='1'){
							g[point.row][point.col+1]='0';
							queue.offer(new Point(point.row,point.col+1));
						}
					}
				}
			}
		}
		return ret;
	}
	
	public static void main(String[]args){
		NumberofIslands test=new NumberofIslands();
		char[][]g=new char[4][5];
		g[0][0]='1';
		g[0][1]='1';
//		g[0][2]='1';
//		g[0][3]='1';
//		g[0][4]='0';
		g[1][0]='1';
		g[1][1]='1';
//		g[1][2]='1';
//		g[1][3]='1';
//		g[1][4]='1';
//		g[2][0]='1';
//		g[2][1]='1';
		g[2][2]='1';
//		g[2][3]='1';
//		g[2][4]='1';
//		g[3][0]='1';
//		g[3][1]='1';
//		g[3][2]='1';
		g[3][3]='1';
		g[3][4]='1';
		System.out.println(test.numIslands(g));
	}
}
