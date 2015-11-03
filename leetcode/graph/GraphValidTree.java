package graph;

import java.util.*;

public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        int[]nums=new int[n];
        Arrays.fill(nums,-1);
        for(int[]edge:edges){
            int x=find(nums,edge[0]);
            int y=find(nums,edge[1]);
            if(x==y)return false;
            nums[x]=y;
        }
        return edges.length==n-1;
    }
    public int find(int[]nums, int i){
        if(nums[i]==-1)return i;
        return find(nums,nums[i]);
    }
    
    public static void main(String[]args){
    	GraphValidTree test=new GraphValidTree();
    	int[][]edges={{0,1},{0,2},{2,3},{2,4}};
    	test.validTree(5, edges);
    }
}
