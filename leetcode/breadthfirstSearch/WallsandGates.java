package breadthfirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class WallsandGates {
	private class Point{
		int row,col;
		public Point(int row,int col){
			this.row=row;
			this.col=col;
		}
	}
	public void wallsAndGates(int[][] rooms) {
		Queue<Point>queue=new LinkedList();
		for(int i=0;i<rooms.length;i++){
			for(int j=0;j<rooms[i].length;j++){
				if(rooms[i][j]==0)queue.offer(new Point(i,j));
			}
		}
		
		while(!queue.isEmpty()){
			Point point=queue.poll();
			if(point.row-1>=0&&rooms[point.row-1][point.col]==Integer.MAX_VALUE){
				rooms[point.row-1][point.col]=rooms[point.row][point.col]+1;
				queue.offer(new Point(point.row-1,point.col));
			}
			if(point.row+1<rooms.length&&rooms[point.row+1][point.col]==Integer.MAX_VALUE){
				rooms[point.row+1][point.col]=rooms[point.row][point.col]+1;
				queue.offer(new Point(point.row+1,point.col));
			}
			if(point.col-1>=0&&rooms[point.row][point.col-1]==Integer.MAX_VALUE){
				rooms[point.row][point.col-1]=rooms[point.row][point.col]+1;
				queue.offer(new Point(point.row,point.col-1));
			}
			if(point.col+1<rooms[0].length&&rooms[point.row][point.col+1]==Integer.MAX_VALUE){
				rooms[point.row][point.col+1]=rooms[point.row][point.col]+1;
				queue.offer(new Point(point.row,point.col+1));
			}
		}
	}
	
	public static void main(String[]args){
		WallsandGates test=new WallsandGates();
		int[][]rooms=new int[4][4];
		rooms[0][0]=Integer.MAX_VALUE;
		rooms[0][1]=-1;
		rooms[0][2]=0;
		rooms[0][3]=Integer.MAX_VALUE;
		rooms[1][0]=Integer.MAX_VALUE;
		rooms[1][1]=Integer.MAX_VALUE;
		rooms[1][2]=Integer.MAX_VALUE;
		rooms[1][3]=-1;
		rooms[2][0]=Integer.MAX_VALUE;
		rooms[2][1]=-1;
		rooms[2][2]=Integer.MAX_VALUE;
		rooms[2][3]=-1;
		rooms[3][0]=0;
		rooms[3][1]=-1;
		rooms[3][2]=Integer.MAX_VALUE;
		rooms[3][3]=Integer.MAX_VALUE;
		test.wallsAndGates(rooms);
		rooms.toString();
	}
}
