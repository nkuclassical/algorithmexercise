package graph;

import java.util.HashMap;
import java.util.Map;

public class CloneGraph {	
	Map<UndirectedGraphNode,UndirectedGraphNode>map=new HashMap();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        UndirectedGraphNode newnode=new UndirectedGraphNode(node.label);
        map.put(node,newnode);
        for(UndirectedGraphNode neighbor:node.neighbors){
            UndirectedGraphNode newneighbor=null;
            if(map.containsKey(neighbor)){
                newneighbor=map.get(neighbor);
            }else{
            	newneighbor=cloneGraph(neighbor);
            }
            newnode.neighbors.add(newneighbor);
        }
        return newnode;
    }
}
