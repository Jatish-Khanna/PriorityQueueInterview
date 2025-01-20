import java.util.*;

/**
 * 4. Overall Time Complexity:
 * Polling happens once per node: O(n).
 * Pushing (inserting edges into the priority queue) happens once per edge: O(E log n).
 * Therefore, the total time complexity of Dijkstra’s algorithm is:
 * <p>
 * <p>
 * O((E+n)logn)
 *
 * space : O(n+E)
 */
public class ShortestPathInWeightedGraph {

  record Node(int id, int weight) {

  }


  private static int[] dijkstra(int n, List<List<Node>> graph, int source) {
    PriorityQueue<Node> closest = new PriorityQueue<>((Comparator.comparing(node -> node.weight)));
    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    closest.offer(new Node(source, 0));
    dist[source] = 0;
    while (!closest.isEmpty()) {
      Node current = closest.poll();
      // pruning: close when weight is already lower
      if (current.weight > dist[current.id]) {
        continue;
      }

      for (Node connected : graph.get(current.id)) {
        int newDist = connected.weight + current.weight;
        if (dist[connected.id] > newDist) {
          dist[connected.id] = newDist;
          closest.offer(new Node(connected.id, newDist));
        }
      }
    }
    return dist;
  }

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
