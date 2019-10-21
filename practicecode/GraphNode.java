package practicecode;

import java.util.List;
import java.util.Vector;

public class GraphNode {

    public int val;
    public boolean visited;
    public List<GraphNode> neighbourList;



    public GraphNode(int val) {
        this.val = val;
        this.visited = false;
        this.neighbourList = new Vector<GraphNode>();
    }

    public void addNeighbour(GraphNode neighbourNode) {
        this.neighbourList.add(neighbourNode);
    }

    public List<GraphNode> getNeighbours() {
        return this.neighbourList;
    }

    public void setNeighbours(List<GraphNode> neighbourList) {
        this.neighbourList = neighbourList;
    }

}