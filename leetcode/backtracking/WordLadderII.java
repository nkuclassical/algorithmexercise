package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadderII {
	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>>ret= new ArrayList();
        HashSet<String>alreadyAdd=new HashSet();
        wordList.add(beginWord);
        wordList.add(endWord);
        alreadyAdd.add(beginWord);
        List<String>prefix= new ArrayList();
        prefix.add(beginWord);
        helper(ret,prefix,wordList,alreadyAdd,endWord,beginWord);
        return ret;
    }
    public void helper(List<List<String>>ret, List<String>prefix,Set<String>wordList, Set<String>alreadyAdd, String endWord, String prefixWord){
        if(prefix.size()==wordList.size()){
            return;
        }
        for(int i=0;i<prefixWord.length();i++){
            for(char j='a';j<='z';j++){
                if(j==prefixWord.charAt(i))continue;
                StringBuilder cur=new StringBuilder(prefixWord);
                cur.setCharAt(i, j);
                
                if(wordList.contains(cur.toString())&&!alreadyAdd.contains(cur.toString())){
                    alreadyAdd.add(cur.toString());
                    prefix.add(cur.toString());
                    if(cur.toString().equals(endWord)){
                        ret.add(new ArrayList(prefix));
                        continue;
                    }
                    helper(ret,prefix,wordList,alreadyAdd,endWord,cur.toString());
                    prefix.remove(prefix.size()-1);
                    alreadyAdd.remove(cur);
                }
            }
        }
    }
    
    public static void main(String[]args){
    	WordLadderII test=new WordLadderII();
//    	"hot","dot","dog","lot","log"
    	HashSet<String>set=new HashSet();
    	set.add("hot");
    	set.add("dot");
    	set.add("dog");
//    	set.add("lot");
//    	set.add("log");
    	List<List<String>>result=test.findLadders("hit", "dog",set);
    	for(List<String>rs:result){
    		for(String r:rs){
    			System.out.print(r+" ");
    		}
    		System.out.println();
    	}
    }
}
