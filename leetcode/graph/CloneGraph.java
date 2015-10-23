package graph;

import java.util.HashMap;
import java.util.Map;

public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap();
		return subClone(node, map);
	}

	public UndirectedGraphNode subClone(UndirectedGraphNode node,
			HashMap<UndirectedGraphNode, UndirectedGraphNode> map) {
		if (node == null)
			return null;
		UndirectedGraphNode newnode = new UndirectedGraphNode(node.label);
		map.put(node, newnode);
		for (UndirectedGraphNode neighbor : node.neighbors) {
			UndirectedGraphNode newneighbor;
			if (map.containsKey(neighbor)) {
				newneighbor = map.get(neighbor);
			} else {
				newneighbor = subClone(neighbor, map);
			}
			newnode.neighbors.add(newneighbor);
		}
		return newnode;
	}
}
