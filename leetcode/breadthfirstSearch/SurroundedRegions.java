package breadthfirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {

	public void helper(char[][]board,Point point){
		Queue<Point>queue=new LinkedList();
		queue.offer(point);
		board[point.row][point.col]='P';
		while(!queue.isEmpty()){
			Point p=queue.poll();
			if(p.row-1>=0&&board[p.row-1][p.col]=='O'){
				board[p.row-1][p.col]='P';
				queue.offer(new Point(p.row-1,p.col));
			}
			if(p.row+1<board.length&&board[p.row+1][p.col]=='O'){
				board[p.row+1][p.col]='P';
				queue.offer(new Point(p.row+1,p.col));
			}
			if(p.col-1>=0&&board[p.row][p.col-1]=='O'){
				board[p.row][p.col-1]='P';
				queue.offer(new Point(p.row,p.col-1));
			}
			if(p.col+1<board[0].length&&board[p.row][p.col+1]=='O'){
				board[p.row][p.col+1]='P';
				queue.offer(new Point(p.row,p.col+1));
			}
		}
	}
	
    public void solve(char[][] board) {
        if(board==null||board.length==0||board[0].length==0)return;
        int row=board.length;
        int col=board[0].length;
        boolean visited[][]=new boolean[row][col];
        for(int i=0;i<row;i++){
            if(board[i][0]=='O')helper(board,new Point(i,0));
            if(board[i][col-1]=='O')helper(board,new Point(i,col-1));
        }
        for(int i=0;i<col;i++){
            if(board[0][i]=='O')helper(board,new Point(0,i));
            if(board[row-1][i]=='O')helper(board,new Point(row-1,i));
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]=='O')board[i][j]='X';
                else if(board[i][j]=='P')board[i][j]='O';
            }
        }
    }
    

	public static void main(String[]args){
		SurroundedRegions test=new SurroundedRegions();
		char[][]g={{'O','O','O','O','X','X'},{'O','O','O','O','O','O'},{'O','X','O','X','O','O'},{'O','X','O','O','X','O'},{'O','X','O','X','O','O'},{'O','X','O','O','O','O'}};
		test.solve(g);
		
	}
}
