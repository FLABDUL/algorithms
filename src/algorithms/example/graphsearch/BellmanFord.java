package algorithms.example.graphsearch;

import java.util.*;

class Edge {
    int source, destination, weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

class Graph {
    int vertices, edges;
    List<Edge> edgeList;

    public Graph(int vertices, int edges) {
        this.vertices = vertices;
        this.edges = edges;
        edgeList = new ArrayList<>();
    }

    public void addEdge(int source, int destination, int weight) {
        edgeList.add(new Edge(source, destination, weight));
    }

    public void bellmanFord(int source) {
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);//positive infinity since distance to each node is known
        distance[source] = 0;//we're already here!

        System.out.println("Initial distances: " + Arrays.toString(distance));

        // Relax all edges (V-1) times means taking edge and update value start to end, ensures negative infinity propragation
        for (int i = 1; i < vertices; i++) {
            System.out.println("Iteration " + i);
            for (Edge edge : edgeList) {//each edge relax
                if (distance[edge.source] != Integer.MAX_VALUE && distance[edge.source] + edge.weight < distance[edge.destination]) {//edge + cost > we're we wanna go?
                    distance[edge.destination] = distance[edge.source] + edge.weight;//update shorter path value
                    System.out.println("Updated distance of vertex " + edge.destination + " to " + distance[edge.destination]);
                }
            }
        }

        // Check for negative-weight cycles by second pass! check update better value than known value, if so mark negative cycle (negative infinity)
        for (Edge edge : edgeList) {
            if (distance[edge.source] != Integer.MAX_VALUE && distance[edge.source] + edge.weight < distance[edge.destination]) {
                System.out.println("Graph contains a negative-weight cycle");
                return;
            }
        }

        System.out.println("Final shortest distances from source:");
        for (int i = 0; i < vertices; i++) {
            System.out.println("Vertex " + i + " : " + (distance[i] == Integer.MAX_VALUE ? "Infinity" : distance[i]));
        }
    }
}

public class BellmanFord {
    public static void main(String[] args) {
        int vertices = 5;
        int edges = 8;
        Graph graph = new Graph(vertices, edges);

        // Adding edges (source, destination, weight)
        graph.addEdge(0, 1, -1);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 2);
        graph.addEdge(1, 4, 2);
        graph.addEdge(3, 2, 5);
        graph.addEdge(3, 1, 1);
        graph.addEdge(4, 3, -3);

        graph.bellmanFord(0);
    }
}

/*
 * Bellman-Ford Algorithm
 * YouTube:
 * https://www.youtube.com/watch?v=obWXjtg0L64 high-level
 * https://www.youtube.com/watch?v=lyw4FaxrwHg in-depth
 * Use when Dijkstra's fails e.g. negative cycles
 * ----------------------
 * Time Complexity:
 *  - Best/Average/Worst: O(V * E) where V = vertices, E = edges
 *  - This makes it less efficient than Dijkstra for non-negative weights
 *
 * Space Complexity:
 *  - O(V) for storing distances
 *
 * Pros:
 *  - Works with graphs containing negative weights
 *  - Can detect negative-weight cycles
 *
 * Cons:
 *  - Slower compared to Dijkstra's Algorithm (O(V log V) with priority queue)
 *  - Not suitable for large graphs due to O(VE) complexity
 *
 * Uses:
 *  - Shortest path calculations where negative weights exist
 *  - Used in networking (Routing Protocols like RIP)
 *  - Can be used in arbitrage detection in currency exchange
 */
