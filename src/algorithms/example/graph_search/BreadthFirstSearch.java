package algorithms.example.graph_search;

import java.util.*;

public class BreadthFirstSearch {

    public static void main(String[] args) {
        // Create a sample graph (represented as an adjacency list)
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(0, 3, 4));
        graph.put(2, Arrays.asList(0, 4));
        graph.put(3, Arrays.asList(1));
        graph.put(4, Arrays.asList(1, 2));

        // Target node to find
        int target = 4;

        // Perform BFS
        boolean found = breadthFirstSearch(graph, 0, target);

        // Output the result
        if (found) {
            System.out.println("Target " + target + " found.");
        } else {
            System.out.println("Target " + target + " not found.");
        }
    }

    /**
     * Breadth-First Search (BFS) Algorithm.
     * Searches for a target value in a graph starting from a given node.
     *
     * @param graph  the graph represented as an adjacency list
     * @param start  the starting node
     * @param target the value to search for
     * @return true if the target is found, false otherwise
     */
    public static boolean breadthFirstSearch(Map<Integer, List<Integer>> graph, int start, int target) {
        // Log the starting point and the target
        System.out.println("Starting BFS from node " + start + " to find target " + target);

        // Create a queue to explore the graph level by level
        Queue<Integer> queue = new LinkedList<>();
        // Set to keep track of visited nodes to avoid re-visiting
        Set<Integer> visited = new HashSet<>();

        // Start BFS from the 'start' node
        queue.add(start);
        visited.add(start);

        // Perform BFS
        while (!queue.isEmpty()) {
            int node = queue.poll();  // Get the node at the front of the queue

            // Log the current node being processed
            System.out.println("Visiting node: " + node);

            // Check if we've found the target node
            if (node == target) {
                System.out.println("Target found at node: " + node);
                return true;
            }

            // Get all the neighbors of the current node
            List<Integer> neighbors = graph.get(node);
            if (neighbors != null) {
                for (int neighbor : neighbors) {
                    // Only add unvisited neighbors to the queue
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                        System.out.println("Adding neighbor " + neighbor + " to the queue.");
                    }
                }
            }
        }

        // Log if the target is not found after exploring the graph
        System.out.println("Target " + target + " not found.");
        return false;  // Return false if the target was not found
    }

    /*
     * Time Complexity:
     * - O(V + E) where V is the number of vertices (nodes) and E is the number of edges.
     *   - Every node is visited once.
     *   - Every edge is considered once.
     *
     * Space Complexity:
     * - O(V) for storing the visited nodes and the queue.
     *   - We may store up to all vertices in the queue and visited set in the worst case.
     *
     * Pros:
     * - Finds the shortest path in an unweighted graph.
     * - Guarantees that the first time we reach a node, we do so with the fewest edges.
     *
     * Cons:
     * - Space-intensive because it stores all nodes at the current level in the queue.
     * - May not be suitable for very large graphs if memory is a concern.
     *
     * Use Cases:
     * - Searching in unweighted graphs to find the shortest path.
     * - Level-order traversal in trees.
     * - Suitable for problems where you want to explore all possible nodes from a source.
     */
}
