package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GraphTraversals {

    Queue<Integer> queue=new LinkedList<>();

    static class Edge{

        int source;
        int destination;

        public Edge(int src,int dest){
            this.source = src;
            this.destination = dest;
        }
    }

    public static void createEdge(ArrayList<Edge> graph[]){ // graph[] is of type ArrayList<Edge>

//        graph[0].add(new Edge(1,2)); // NullPointerException

        for(int i=0;i<graph.length;i++){

            graph[i]=new ArrayList<Edge>(); // since graph is of type ArrayList<Edge> we add arraylist at all indexes. or else we can't add anything into the graph[].
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2)); // disable for disconnected components

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));// disable for disconnected components
        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,0));// disable for disconnected components
        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,4));// disable for disconnected components

        graph[3].add(new Edge(3,1));// disable for disconnected components
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));// disable for disconnected components

        graph[4].add(new Edge(4,2));// disable for disconnected components
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));// disable for disconnected components

        graph[5].add(new Edge(5,3));// disable for disconnected components
        graph[5].add(new Edge(5,4));// disable for disconnected components
        graph[5].add(new Edge(5,6));// disable for disconnected components

        graph[6].add(new Edge(6,5));// disable for disconnected components
    }

//    In graph traversals we use visited[] array and in tree traversals we won't use visited[] array because cycles exist in graph but in tree there cannot exist any cycles,
//    so we need to keep track of visited nodes in graph and not in trees

    // BFS : GO TO IMMEDIATE NEIGHBOURS FIRST
    // time complexity : O(V+E)

    /*

    check if visited[curr] == false, then
    1. print (curr)
    2. visited[curr] = true;
    3. add neighbours of current node into queue.

     */

    // For Connected components :
    public static void BFS(ArrayList<Edge> graph[],int v){


        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[v];
        queue.add(0);

        while (!queue.isEmpty()) {

            int curr = queue.remove();
            if(visited[curr] == false){

                System.out.print(curr+" ");
                visited[curr] = true;

                for(int i = 0; i < graph[curr].size() ; i++){

                    Edge e = graph[curr].get(i);
                    queue.add(e.destination);
                }
            }
        }
    }


    // For Disconnected components :
    public static void BFS(ArrayList<Edge> graph[],int v,boolean visited[] , int start){


        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {

            int curr = queue.remove();
            if(visited[curr] == false){

                System.out.print(curr+" ");
                visited[curr] = true;

                for(int i=0; i<graph[curr].size() ; i++){

                    Edge e = graph[curr].get(i);
                    queue.add(e.destination);
                }
            }
        }
    }


    // DFS : KEEP GOING TO THE FIRST NEIGHBOUR
    // time complexity : O(V+E)

    /*

    1. print curr
    2. visited[curr] = true;
    3. visit 1 st neighbour of curr node.

     */

    // For Connected components :
    public static void DFS(ArrayList<Edge> graph[],int curr , boolean visited[]){

        // it will backtrack at node 2 (i.e. from node 2 to node 4).

            System.out.print(curr+" ");
            visited[curr] = true;

            for(int i=0; i<graph[curr].size() ; i++){

                Edge e = graph[curr].get(i);

                if(visited[e.destination] == false) { // it will skip the visited neighbour
                    DFS(graph, e.destination, visited); // recursion
                }
            }
    }

    public static void main(String[] args) {

        int v = 7;

        /*  // Connected component

            1 -- 3
           /     |  \
          0      |   5 -- 6
           \     |  /
            2 -- 4

         */

        /*  // Disconnected components

        0 -- 1 -- 2 : 1st component
           3 -- 4 : 2nd component

         */

        ArrayList<Edge> graph[] = new ArrayList[v];
        createEdge(graph);

       // BFS(graph,v); // Connected components

        boolean visited[] = new boolean[v];

       // for(int i=0;i<v;i++){ // for disconnected components
       //     if(visited[i] == false){
       //         BFS(graph,v,visited,i);
       //         System.out.println();
       //     }
       // }

        DFS(graph,0,visited);
        //
        //
        // // for dfs disconnected components :
        // for(int j=0;j<v;j++){
        //     if(visited[j]==false) {
        //         DFS(graph,j, visited);
        //     }
        // }
        // System.out.println();
    }
}
