import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class ShortestPathInWeightedGraph {

  public static void main(String[] args) {
    // Example graph with 5 nodes (0 to 4)
    int n = 5;

    // Adjacency list representation of the graph
    List<List<Node>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }

    // Adding edges (node, weight)
    graph.get(0).add(new Node(1, 10));
    graph.get(0).add(new Node(4, 5));
    graph.get(1).add(new Node(2, 1));
    graph.get(2).add(new Node(3, 4));
    graph.get(3).add(new Node(0, 7));
    graph.get(4).add(new Node(1, 2));
    graph.get(4).add(new Node(2, 9));

    // Source node is 0
    int source = 0;

    // Find shortest paths from source to all other nodes
    int[] distances = dijkstra(n, graph, source);

    // Print the shortest distance from source to each node
    System.out.println("Shortest distances from node " + source + ":");
    for (int i = 0; i < n; i++) {
      if (distances[i] == Integer.MAX_VALUE) {
        System.out.println("Node " + i + " is unreachable.");
      } else {
        System.out.println("Distance to node " + i + ": " + distances[i]);
      }
    }
  }
}
