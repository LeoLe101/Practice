import java.util.*;

public class Graph {

    
}

/**
 * 
 * O(v + e) time | O(v) space - where v is the number of vertices of 
 * the unput graph and e is the number edges of the input graph
 */
public class Node {

    public String name;
    List<Node> children = new ArrayList<Node>();

    public Node(String name) {
        this.name = name;
    }

    public List<String> dfs(List<String> arr) {

        return array;
    }

    public Node addChild(String name) {
        Node child = new Node(name);
        children.add(child);
        return this;
    }
}