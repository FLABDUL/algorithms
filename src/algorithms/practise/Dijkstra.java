package algorithms.practise;

import java.util.*;

public class Dijkstra {
    /*graph*/
        //vertices
        //list list nodes
        //constructor add vertices lists to nodes
        //addedge for source and destination
    static class Graph {
        int vertices;
        List<List<Node>> neighbours;

        public Graph(int vertices) {
            this.vertices = vertices;
            neighbours = new ArrayList<>();
            for(int i = 0; i < vertices; i++){
                neighbours.add(new ArrayList<>());
            }
        }

        void addEdge(int source, int destination, int weight){
            neighbours.get(source).add(new Node(destination, weight));
            neighbours.get(destination).add(new Node(source, weight));
        }
    }

    /*node class*/
        //vertex and weight
    static class Node {
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    /*iterative djikstra*/
    //new array distances
    //fill max value
    //start 0
    //pq weighted
    //offer first node
    //while not empty
        //poll node
        //get vertex
        //cycle neighbours
        //neighbour and weight
        //check if can get to neighbour
        //set new and offer
    //return dist
    private int[] iterative(Graph graph, int start){
        int[] distance = new int[graph.vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        Queue<Node> pq = new PriorityQueue<>(Comparator.comparing(n -> n.weight));
        //smallest value removal first, weight is distance from source
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()){
            Node current = pq.poll();
            int currentVertex = current.vertex;
            for(Node neighbour : graph.neighbours.get(currentVertex)){
                int vertex = neighbour.vertex;
                int weight = neighbour.weight;
                if(distance[currentVertex] + weight < distance[vertex]){
                    distance[vertex] = distance[currentVertex] + weight;
                    pq.offer(new Node(vertex, distance[vertex]));
                }
            }
        }
        return distance;
    }

    /*djikstra recursive takes in boolean visited[]*/
        //start at first node as visited
        //cycle through all nodes in graph adj list from start
            //get weight and vertex
            //if not visited and strat+wegiht<distance (shorter)
                //set new distance
                //call recursrive
    private void dijkstraRecursive(Graph graph, int start, int[] distances, boolean[] visited) {
        visited[start] = true;
        for(Node node : graph.neighbours.get(start)){
            int weight = node.weight;
            int vertex = node.vertex;
            if(!visited[vertex] && distances[start] + weight < distances[vertex]){
                distances[vertex] = distances[start] + weight;
                dijkstraRecursive(graph, vertex, distances, visited);
            }
        }
    }

    /*djikstra recursive caller* takes graph and start int*/
        //create distance array of size vertices
        //fill it with max value
        //strat is 0
        //create boolean array
        //call recusrive
        //return distance
    public int[] dijkstraRecursiveCaller(Graph graph, int start){
        int[] distances = new int[graph.vertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start]=0;
        boolean[] visited = new boolean[graph.vertices];
        dijkstraRecursive(graph, start, distances, visited);
        return distances;
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
//        int[] distancesIterative = dijkstra.iterative(graph, 0);
//        System.out.println("\nShortest Distances (Iterative): " + Arrays.toString(distancesIterative));

        // Recursive Approach
        int[] distancesRecursive = dijkstra.dijkstraRecursiveCaller(graph, 0);
        System.out.println("\nShortest Distances (Recursive): " + Arrays.toString(distancesRecursive));
    }
}
