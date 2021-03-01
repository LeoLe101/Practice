package src.Leetcode.Problems;

import java.util.*;

import src.Util.GraphNode;

public class LC133CloneGraph {

    public GraphNode cloneGraph(GraphNode node) {
        if (node == null) return node;
        Map<GraphNode, List<GraphNode>> m = new HashMap<>();
        Queue<GraphNode> q = new LinkedList<>();
        q.offer(node);

        

    }
    
}
