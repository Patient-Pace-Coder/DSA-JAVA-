import java.util.*;

public class GraphTraversalComparison {

//    static class Graph {
//        Map<Long, List<Long>> adjList; // Adjacency list
//
//        Graph() {
//            adjList = new HashMap<>();
//        }
//
//        void addEdge(long v, long w) {
//            adjList.putIfAbsent(v, new ArrayList<>());
//            adjList.putIfAbsent(w, new ArrayList<>());
//            adjList.get(v).add(w);
//        }
//
//        // Breadth First Search
//        void BFS(long s) {
//            Map<Long, Boolean> visited = new HashMap<>();
//            for (long key : adjList.keySet()) {
//                visited.put(key, false);
//            }
//
//            LinkedList<Long> queue = new LinkedList<>();
//            visited.put(s, true);
//            queue.add(s);
//
//            System.out.println("Breadth First Search:");
//
//            while (!queue.isEmpty()) {
//                s = queue.poll();
//                System.out.print(s + " ");
//
//                for (long n : adjList.getOrDefault(s, new ArrayList<>())) {
//                    if (!visited.get(n)) {
//                        visited.put(n, true);
//                        queue.add(n);
//                    }
//                }
//            }
//            System.out.println();
//        }
//
//        // Depth First Search
//        void DFSUtil(long v, Map<Long, Boolean> visited) {
//            visited.put(v, true);
//            System.out.print(v + " ");
//
//            for (long n : adjList.getOrDefault(v, new ArrayList<>())) {
//                if (!visited.get(n)) {
//                    DFSUtil(n, visited);
//                }
//            }
//        }
//
//        void DFS(long v) {
//            Map<Long, Boolean> visited = new HashMap<>();
//            for (long key : adjList.keySet()) {
//                visited.put(key, false);
//            }
//
//            System.out.println("Depth First Search:");
//
//            DFSUtil(v, visited);
//            System.out.println();
//        }
//    }

    public static void main(String[] args) {
//        Graph graph = new Graph();
//
//        // Add edges
//        graph.addEdge(0, 1);
//        graph.addEdge(0, 2);
//        graph.addEdge(1, 2);
//        graph.addEdge(2, 0);
//        graph.addEdge(2, 3);
//        graph.addEdge(3, 3);
//
//        // Add 5 more edges
//        graph.addEdge(1, 3);
//        graph.addEdge(1, 4);
//        graph.addEdge(4, 5);
//        graph.addEdge(5, 6);
//        graph.addEdge(6, 7);
//
//        // Starting vertex for traversal
//        long startingVertex = 2;
//
//        graph.BFS(startingVertex);
//        graph.DFS(startingVertex);\
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);

        queue.remove();

//        for(int ele:queue){
//            System.out.print(ele+" ");
//        }

//        System.out.println( (0-1)/2);

    }

}
