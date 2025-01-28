package algorithms.example.graphsearch;

import java.util.*;

public class DepthFirstSearch {

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

        // Perform DFS
        boolean found = depthFirstSearch(graph, 0, target);

        // Output the result
        if (found) {
            System.out.println("Target " + target + " found.");
        } else {
            System.out.println("Target " + target + " not found.");
        }
    }

    /**
     * Depth-First Search (DFS) Algorithm.
     * Searches for a target value in a graph starting from a given node.
     *
     * @param graph  the graph represented as an adjacency list
     * @param start  the starting node
     * @param target the value to search for
     * @return true if the target is found, false otherwise
     */
    public static boolean depthFirstSearch(Map<Integer, List<Integer>> graph, int start, int target) {
        // Create a set to keep track of visited nodes to avoid re-visiting
        Set<Integer> visited = new HashSet<>();

        // Perform DFS starting from the 'start' node
        System.out.println("Starting DFS from node " + start + " to find target " + target);

        return dfsHelper(graph, start, target, visited);
    }

    /**
     * Helper function for DFS, performing the recursion.
     *
     * @param graph    the graph represented as an adjacency list
     * @param current  the current node being explored
     * @param target   the value to search for
     * @param visited  the set of visited nodes
     * @return true if the target is found, false otherwise
     */
    private static boolean dfsHelper(Map<Integer, List<Integer>> graph, int current, int target, Set<Integer> visited) {
        // Log the current node being processed
        System.out.println("Visiting node: " + current);

        // If the current node is the target, we have found the target
        if (current == target) {
            System.out.println("Target found at node: " + current);
            return true;
        }

        // Mark the current node as visited
        visited.add(current);

        // Get all neighbors of the current node
        List<Integer> neighbors = graph.get(current);
        if (neighbors != null) {
            for (int neighbor : neighbors) {
                // If the neighbor hasn't been visited, continue the DFS
                if (!visited.contains(neighbor)) {
                    System.out.println("Exploring edge (" + current + " -> " + neighbor + ")");
                    if (dfsHelper(graph, neighbor, target, visited)) {
                        return true;  // Return true if the target is found
                    }
                }
            }
        }

        // If the target was not found through any of the neighbors, backtrack
        return false;
    }

    /*
     * Time Complexity:
     * - O(V + E) where V is the number of vertices (nodes) and E is the number of edges.
     *   - Every node is visited once.
     *   - Every edge is considered once.
     *
     * Space Complexity:
     * - O(V) for storing the visited nodes in the set.
     *   - The recursion stack also takes up space proportional to the depth of the search.
     *
     * Pros:
     * - DFS can be more space-efficient for sparse graphs since it doesn't need to store all nodes at the current level.
     * - DFS can be used for problems like topological sorting or finding strongly connected components.
     *
     * Cons:
     * - DFS doesn't guarantee the shortest path in an unweighted graph.
     * - Can be inefficient or lead to infinite recursion in very deep graphs or cycles if not handled properly.
     *
     * Use Cases:
     * - Searching in deep or recursive structures.
     * - Pathfinding in maze-like structures or puzzles.
     * - Finding strongly connected components in directed graphs.
     */
}
