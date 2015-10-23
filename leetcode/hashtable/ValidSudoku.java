package hashtable;

import java.util.HashSet;

public class ValidSudoku {
	
	    public boolean isValidSudoku(char[][] board) {
	        HashSet<Character>set=new HashSet();
	        for(int i=0;i<board.length;i++){
	            set.clear();
	            for(int j=0;j<board[i].length;j++){
	                if(board[i][j]!='.'){
	                    if(set.contains(board[i][j])){
	                        return false;
	                    }else{
	                        set.add(board[i][j]);
	                    }
	                }
	            }
	        }
	        
	        for(int i=0;i<board[0].length;i++){
	            set.clear();
	            for(int j=0;j<board.length;j++){
	                if(board[j][i]!='.'){
	                    if(set.contains(board[j][i])){
	                        return false;
	                    }else{
	                        set.add(board[j][i]);
	                        
	                    }
	                }
	            }
	        }
	        
	        for(int i=0;i<9;i+=3){
	            for(int j=0;j<9;j+=3){
	                set.clear();
	                for(int i1=0;i1<3;i1++){
	                    for(int j1=0;j1<3;j1++){
	                        if(board[i+i1][j+j1]!='.'){
	                            if(set.contains(board[i+i1][j+j1])){
	                                return false;
	                            }else{
	                                set.add(board[i+i1][j+j1]);
	                            }
	                        }
	                    }
	                }
	            }
	        }
	        return true;
	    }
	
}
