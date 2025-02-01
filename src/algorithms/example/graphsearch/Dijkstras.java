package algorithms.example.graphsearch;

import java.util.*;

class Dijkstras {
    static class Node {
        int vertex, weight;
        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public static void dijkstra(List<List<Node>> graph, int source) {
        int V = graph.size();
        int[] dist = new int[V]; // Stores shortest distances from the source
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.weight));
        pq.offer(new Node(source, 0));

        System.out.println("Starting Dijkstra's Algorithm from source: " + source);

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.vertex;

            System.out.println("Processing vertex: " + u + " with current shortest distance: " + current.weight);

            for (Node neighbor : graph.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.offer(new Node(v, dist[v]));
                    System.out.println("Updating distance of vertex " + v + " to " + dist[v]);
                }
            }
        }

        System.out.println("Final shortest distances from source:");
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + " : " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 5; // Number of vertices
        List<List<Node>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Sample weighted graph
        graph.get(0).add(new Node(1, 10));
        graph.get(0).add(new Node(4, 3));
        graph.get(1).add(new Node(2, 2));
        graph.get(1).add(new Node(4, 4));
        graph.get(2).add(new Node(3, 9));
        graph.get(3).add(new Node(2, 7));
        graph.get(4).add(new Node(1, 1));
        graph.get(4).add(new Node(2, 8));

        dijkstra(graph, 0);
    }
}

/*
Pros:
- Efficient for graphs with non-negative weights.
- Uses a priority queue (heap) to ensure optimal performance.
- Finds the shortest path from a single source to all vertices.

Cons:
- Doesn't handle negative weights (use Bellman-Ford for that).
- Priority queue operations can be expensive in some cases.

Uses:
- GPS navigation systems.
- Network routing protocols.
- AI pathfinding in games.

Time Complexity:
- O((V + E) log V) where V is the number of vertices and E is the number of edges.
- Each vertex is processed once (O(V log V)), and each edge is relaxed once (O(E log V)).

Space Complexity:
- O(V + E) for the graph representation.
- O(V) for the distance array and priority queue.
*/

//simple https://www.youtube.com/watch?v=_lHSawdgXpI
//thorough https://www.youtube.com/watch?v=bZkzH5x0SKU
