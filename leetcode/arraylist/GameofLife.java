package arraylist;

public class GameofLife {
    public void gameOfLife(int[][] board) {
        int d[][] = {{1,-1},{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1},{0,-1}};
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                int live = 0,x,y;
                for(int k = 0; k < 8; k++){
                    x = i + d[k][0];
                    y = j + d[k][1];
                    if(x < 0 || x >= board.length || y < 0 || y>= board[i].length)continue;
                    else{
                        if((board[x][y] & 1) >0)live++;
                    }
                }
                if((board[i][j]&1)>0){
                    if(live < 2){
                        board[i][j] = 1;
                    }else if(live > 3){
                        board[i][j] = 1;
                    }else{
                        board[i][j] = 3;
                    }
                }else{
                    if(live == 3){
                        board[i][j] = 2;
                    }else{
                        board[i][j] = 0;
                    }
                }
            }
        }
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                board[i][j]>>=1;
            }
        }
    }
}
