import java.util.*;

/**
 * A graph is minimally-connected if it is connected and there is no edge that can be removed while still leaving the graph connected. For example, any binary tree is minimally-connected.
 * Given an undirected graph, check if the graph is minimally-connected. You can choose to represent the graph as either an adjacency matrix or adjacency list.
 */
class GraphNode{
    char data;
    public List<GraphNode> adjacentNodes;

    GraphNode(char c){
        this.data = c;
        this.adjacentNodes = new LinkedList<>();
    }

    public List<GraphNode> getAdjacentNodes() {
        return adjacentNodes;
    }
}
public class MinimallyConnectedGraph {

    public static void main(String[] args) {
        MinimallyConnectedGraph minimallyConnectedGraph = new MinimallyConnectedGraph();

        GraphNode graphNode =  new GraphNode('b');

        GraphNode graphNode1 = new GraphNode('c');
        GraphNode graphNode2 = new GraphNode('g');

        graphNode.getAdjacentNodes().add(graphNode1);
        graphNode.getAdjacentNodes().add(graphNode2);

        graphNode1.getAdjacentNodes().add(graphNode);
        graphNode1.getAdjacentNodes().add(graphNode2);

        graphNode2.getAdjacentNodes().add(graphNode);
        graphNode.getAdjacentNodes().add(graphNode1);

        System.out.println(minimallyConnectedGraph.isMinimallyConnected(graphNode));

        GraphNode graphNode3 =  new GraphNode('b');

        GraphNode graphNode4 = new GraphNode('c');
        GraphNode graphNode5 = new GraphNode('g');
        graphNode3.getAdjacentNodes().add(graphNode4);
        graphNode4.getAdjacentNodes().add(graphNode5);
        System.out.println(minimallyConnectedGraph.isMinimallyConnected(graphNode3));



    }

    boolean isMinimallyConnected(GraphNode startNode){
        Queue<GraphNode> processingQueue = new LinkedList<>();
        processingQueue.add(startNode);
        Map<GraphNode, Integer> visitedNodes = new HashMap<>();
        Map<GraphNode, Integer> enteredNodes = new HashMap<>();
        enteredNodes.put(startNode, 1);

        while(!processingQueue.isEmpty()){
            GraphNode currentNode = processingQueue.remove();
            visitedNodes.put(currentNode, 1);
            for(GraphNode node : currentNode.getAdjacentNodes()){
                if(!enteredNodes.containsKey(node)){
                    processingQueue.add(node);
                    enteredNodes.put(node, 1);
                }else{
                    return false;
                }
            }
        }
        return true;
    }


}
