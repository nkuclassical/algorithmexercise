package trie;

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
    
    public static void main(String[]args){
    	Trie trie = new Trie();
    	 trie.insert("apple");
    	 System.out.println(trie.search("key"));
    	 System.out.println(trie.search("appl"));
    	 System.out.println(trie.startsWith("a"));
    	 System.out.println(trie.startsWith("b"));
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");