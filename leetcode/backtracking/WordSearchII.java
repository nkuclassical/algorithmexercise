package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/**
 * Runtime is 60ms
 * @author yanqiaozhan
 *
 */
public class WordSearchII {
	public List<String> findWords(char[][] board, String[] words) {
        List<String>result=new ArrayList();
        if(board==null||board.length==0||board[0].length==0)return result;
        int row=board.length;
        int col=board[0].length;
        Trie trie=new Trie();
        for(int i=0;i<words.length;i++){
            trie.insert(words[i].toCharArray());
        }
        boolean[][]v=new boolean[row][col];
        HashSet<String>ret=new HashSet();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                helper(trie,board,v,new StringBuilder(),i,j,ret);
            }
        }
        return new ArrayList<String>(ret);
        
    }
    
    public void helper(Trie t, char[][]board, boolean[][]visited, StringBuilder prefix, int i, int j,HashSet<String>ret){
        if(i<0||i>=board.length||j<0||j>=board[0].length||visited[i][j]==true)return;
        prefix.append(board[i][j]);
        visited[i][j]=true;
        char[]c=prefix.toString().toCharArray();
        if(t.startsWith(c)){
            if(t.search(c)){
                ret.add(prefix.toString());
            }
            
            helper(t,board,visited,prefix,i-1,j,ret);
            helper(t,board,visited,prefix,i+1,j,ret);
            helper(t,board,visited,prefix,i,j-1,ret);
            helper(t,board,visited,prefix,i,j+1,ret);
        }
        visited[i][j]=false;
        prefix.deleteCharAt(prefix.length()-1);
    }
    
    public class TrieNode{
        public TrieNode[]son;
        public boolean isEnd;
        public final int SIZE=26;
        public TrieNode(){
            this.son=new TrieNode[SIZE];
            this.isEnd=false;
        }
    }
    public class Trie{
        private TrieNode root;
        public Trie(){
            root=new TrieNode();
        }
        public void insert(char[] word){
            if(word==null||word.length==0)return;
            TrieNode curroot=root;
            for(int i=0;i<word.length;i++){
                if(curroot.son[word[i]-'a']==null){
                    curroot.son[word[i]-'a']=new TrieNode();
                }
                curroot=curroot.son[word[i]-'a'];
            }
            curroot.isEnd=true;
        }
        public boolean search(char[] word){
            TrieNode cur=root;
            for(int i=0;i<word.length;i++){
                if(cur.son[word[i]-'a']!=null){
                    cur=cur.son[word[i]-'a'];
                }else return false;
            }
            return cur.isEnd;
        }
        public boolean startsWith(char[] prefix){
            TrieNode cur=root;
            for(int i=0;i<prefix.length;i++){
                if(cur.son[prefix[i]-'a']==null)return false;
                cur=cur.son[prefix[i]-'a'];
            }
            return true;
        }
    }
}
