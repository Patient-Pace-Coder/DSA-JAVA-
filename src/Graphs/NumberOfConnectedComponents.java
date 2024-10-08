package Graphs;

import java.util.ArrayList;
import java.util.Stack;

/*

intuition:

 To find the number of connected components, we run dfs on one particular node, which will traverse all those nodes which belong to a single component, and after dfs is completed we increment the count by 1..
 so, if all the nodes in the graph are traversed in the first iteration of dfs then there is only one component in the whole graph.
 by this logic, we can find number of components in a graph.

 */

public class NumberOfConnectedComponents {

    static class Edge{

        int source;
        int dest;

        Edge(int src,int des){

            this.source = src;
            this.dest = des;
        }
    }

    private static void createEdge(ArrayList<Edge> graph[]){

        for( int i=0; i < graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }

//        ex1 :

//        graph[0].add(new Edge(0,4));
////        graph[0].add(new Edge(0,2));  answer is 1
//
//        graph[1].add(new Edge(1,4));
//        graph[2].add(new Edge(2,6));
////        graph[2].add(new Edge(2,0)); answer is 1
//        graph[3].add(new Edge(3,5));
//        graph[4].add(new Edge(4,0));
//        graph[4].add(new Edge(4,1));
//        graph[4].add(new Edge(4,5));
//        graph[5].add(new Edge(5,3));
//        graph[5].add(new Edge(5,4));
//        graph[5].add(new Edge(5,7));
//        graph[6].add(new Edge(6,2));


//        ex2 :

        graph[0].add(new Edge(0,5));
        graph[1].add(new Edge(1,2));
        graph[2].add(new Edge(2,3));
        graph[2].add(new Edge(2,4));
        graph[3].add(new Edge(3,5));
        graph[6].add(new Edge(6,7));

    }

    private static void dfs(ArrayList<Edge> graph[], boolean visited[], int curr){

        visited[curr] = true;

        for( int i=0; i < graph[curr].size(); i++ ){

            Edge e = graph[curr].get(i);

            if( !visited[e.dest]) {
                dfs(graph, visited, e.dest);
            }
        }
    }

    public static void main(String[] args) {

        int V = 8;

        /*

        here, there are two connected components.

        ex1 :

        1 ---- 4 ---- 0     2 --- 6
        |      |
        |      |
        |      |
        7 ---- 5 ---- 3


        ex2 :

        sample input :                  Sample output : 3

        0 --- 5
        1 --- 2
        2 --- 3
        2 --- 4
        3 --- 5
        6 --- 7

         */

        ArrayList<Edge> graph[] = new ArrayList[V];

        boolean visited[] = new boolean[V];
        int countComponents = 0;

        createEdge(graph);

        for(int i = 0; i < V; i++ ){
            if( !visited[i]){
                dfs(graph,visited,i);
                countComponents++;
            }
        }

        System.out.println("Total number of components in the graph are : "+countComponents);
    }
}
