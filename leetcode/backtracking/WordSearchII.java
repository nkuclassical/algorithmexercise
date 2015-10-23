package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordSearchII {
	
	public List<String> findWords(char[][] board, String[] words) {
		
		Trie trie = new Trie();
		for (String word : words) {
			trie.insert(word);
		}
		boolean [][]visited=new boolean[board.length][board[0].length];
		HashSet<String>res=new HashSet();
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[i].length;j++){
				dfs(board,i,j,new StringBuilder(),visited,trie,res);
			}
		}
		return new ArrayList<String>(res);
		
	}

	public void dfs(char[][]board,int x,int y,StringBuilder word,boolean[][]visited,Trie trie,HashSet<String>res){
		if(x<0||x>=board.length||y<0||y>=board[0].length||visited[x][y]){
			return;
		}
		word.append(board[x][y]);
		visited[x][y]=true;
		if(trie.startsWith(word.toString())){
			if(trie.search(word.toString())){
				res.add(word.toString());
			}
			
			dfs(board,x-1,y,word,visited,trie,res);
			dfs(board,x+1,y,word,visited,trie,res);
			dfs(board,x,y-1,word,visited,trie,res);
			dfs(board,x,y+1,word,visited,trie,res);
			
			
		}
		
		visited[x][y]=false;
		word.deleteCharAt(word.length()-1);
	}
	
	public static void main(String[]args){
		WordSearchII test=new WordSearchII();
		char[][]board=new char[1][2];
		board[0][0]='a';
//		board[1][0]='a';
		board[0][1]='a';
//		board[1][1]='a';
		
		String[]words=new String[1];
		words[0]="aa";
		List<String>result=test.findWords(board, words);
		for(String r:result){
			System.out.println(r);
		}
	}
	class TrieNode {
	    // Initialize your data structure here.
		public  TrieNode[]son;
		public boolean isEnd;
		public final int SIZE=26;
		public char val;
	    public TrieNode() {
	        this.son=new TrieNode[SIZE];
	        this.isEnd=false;
	    }
	}

	public class Trie {
	    private TrieNode root;

	    public Trie() {
	        root = new TrieNode();
	    }

	    // Inserts a word into the trie.
	    public void insert(String word) {
	        if(word==null||word.length()==0)return;
	        TrieNode curroot=root;
	        for(int i=0;i<word.length();i++){
	        	if(curroot.son[word.charAt(i)-'a']==null){
	        		curroot.son[word.charAt(i)-'a']=new TrieNode();
	        		curroot.son[word.charAt(i)-'a'].val=word.charAt(i);
	        	}
	        	curroot=curroot.son[word.charAt(i)-'a'];
	        	
	        }
	        curroot.isEnd=true;
	    }

	    // Returns if the word is in the trie.
	    public boolean search(String word) {
	        TrieNode cur=root;
	    	for(int i=0;i<word.length();i++){
	    		if(cur.son[word.charAt(i)-'a']!=null){
	    			cur=cur.son[word.charAt(i)-'a'];
	    			continue;
	    		}else return false;
	    		
	    	}
	    	if(cur.isEnd)return true;
	    	else return false;
	    }

	    // Returns if there is any word in the trie
	    // that starts with the given prefix.
	    public boolean startsWith(String prefix) {
	        TrieNode cur=root;
	        for(int i=0;i<prefix.length();i++){
	        	if(cur.son[prefix.charAt(i)-'a']==null){
	        		return false;
	        	}
	        	cur=cur.son[prefix.charAt(i)-'a'];
	        }
	        return true;
	    }
	}
}
