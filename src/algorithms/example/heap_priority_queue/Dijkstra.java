package algorithms.example.heap_priority_queue;

import java.util.*;

public class Dijkstra {

    // Helper class for Graph representation
    static class Graph {
        int vertices;
        List<List<Node>> adjList;

        Graph(int vertices) {
            this.vertices = vertices;
            adjList = new ArrayList<>();
            for (int i = 0; i < vertices; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        // Add an edge between two nodes with weight
        void addEdge(int src, int dest, int weight) {
            adjList.get(src).add(new Node(dest, weight));
            adjList.get(dest).add(new Node(src, weight)); // For undirected graph
        }
    }

    // Helper class to represent a node (destination, weight)
    static class Node {
        int vertex, weight;
        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    // ===================== Iterative Approach using PriorityQueue ===================== //
    public int[] dijkstraIterative(Graph graph, int start) {
        int[] dist = new int[graph.vertices]; // Store shortest distances
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.weight));
        pq.offer(new Node(start, 0));

        System.out.println("Dijkstra Iterative Starting from Node: " + start);

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.vertex;

            System.out.println("Processing Node: " + u + " with current distance: " + dist[u]);

            for (Node neighbor : graph.adjList.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;

                if (dist[u] + weight < dist[v]) { // Relaxation step
                    dist[v] = dist[u] + weight;
                    pq.offer(new Node(v, dist[v]));
                    System.out.println("Updated Distance of Node " + v + " to " + dist[v]);
                }
            }
        }
        return dist;
    }

    // ===================== Recursive Approach using DFS-like Traversal ===================== //
    public void dijkstraRecursive(Graph graph, int start, int[] dist, boolean[] visited) {
        visited[start] = true;
        System.out.println("Recursive Visiting Node: " + start + " with distance: " + dist[start]);

        for (Node neighbor : graph.adjList.get(start)) {
            int v = neighbor.vertex;
            int weight = neighbor.weight;

            if (!visited[v] && dist[start] + weight < dist[v]) {
                dist[v] = dist[start] + weight;
                System.out.println("Recursive Updating Distance of Node " + v + " to " + dist[v]);
                dijkstraRecursive(graph, v, dist, visited);
            }
        }
    }

    public int[] dijkstraRecursiveCaller(Graph graph, int start) {
        int[] dist = new int[graph.vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        boolean[] visited = new boolean[graph.vertices];

        System.out.println("Dijkstra Recursive Starting from Node: " + start);
        dijkstraRecursive(graph, start, dist, visited);
        return dist;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 3, 5);
        graph.addEdge(2, 3, 1);
        graph.addEdge(2, 4, 6);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 3);

        Dijkstra dijkstra = new Dijkstra();

        // Iterative Approach
        int[] distancesIterative = dijkstra.dijkstraIterative(graph, 0);
        System.out.println("\nShortest Distances (Iterative): " + Arrays.toString(distancesIterative));

        // Recursive Approach
        int[] distancesRecursive = dijkstra.dijkstraRecursiveCaller(graph, 0);
        System.out.println("\nShortest Distances (Recursive): " + Arrays.toString(distancesRecursive));
    }
}

/*
=========================================================
🔹 **Pros, Cons, and Use Cases of Dijkstra’s Algorithm**
=========================================================

✅ **Pros:**
1. **Guaranteed Shortest Path**: Works well for graphs with **non-negative weights**.
2. **Efficient with PriorityQueue**: When implemented with a min-heap, it's **O((V + E) log V)**.
3. **Real-World Applications**: Used in **Google Maps, Network Routing, AI pathfinding (A* uses it internally)**.

❌ **Cons:**
1. **Doesn't work with negative weights**: Unlike **Bellman-Ford**, Dijkstra cannot handle negative edges.
2. **Expensive for dense graphs**: If a graph is dense (`E ≈ V^2`), performance degrades.
3. **Recursive approach is inefficient**: Not commonly used due to deep recursive calls.

=================================
🔹 **Time and Space Complexity**
=================================

### **Iterative Approach (Priority Queue)**
- **Time Complexity**: `O((V + E) log V)`
  - Each node is processed **once** → `O(V log V)`
  - Each edge is relaxed **once** → `O(E log V)`
- **Space Complexity**: `O(V + E)`
  - **PriorityQueue stores V elements** → `O(V)`
  - **Adjacency list stores edges** → `O(E)`

### **Recursive Approach**
- **Time Complexity**: `O(V^2)`, as it can visit all nodes recursively.
- **Space Complexity**: `O(V)`, for recursion stack and distance array.

=================================
🔹 **Best Choice?**
=================================
- **Iterative (PriorityQueue) is the standard approach** (Used in real-world applications).
- **Recursive approach is educational** but impractical for large graphs.

=========================================================
*/

/*
https://www.youtube.com/watch?v=EaphyqKU4PQ neetcode
Greedy BFS using min heap e.g. priority queue, get min value efficiently log(n)
variables path (key) and node
add totals from starting position
deciding pops with value shorter path
each time check neighbours than can be reached
every operation worst E*logV^2 edge E, nodes V -> ElogV
 */
