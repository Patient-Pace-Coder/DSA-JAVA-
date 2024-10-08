package Graphs;

import java.util.ArrayList;

public class IsGraphTree {

    /*

    Input format :

    first line contains two integers N and M --- number of nodes and number of edges on the graph ( 0 < N <= 10000. 0 <= M <= 20000).
    Next M lines contain M edges of that graph --- each line contains a pair ( u,v) means there is an edge between node u and v ( 1 <= u,v <= N).

    output format :

    print YES if the given graph is a tree, otherwise print NO.

    intuition :

    for a graph to be tree , a graph must satisfy two conditions :
    1. we must be able to traverse or reach all the nodes from any given node, as it indicates there exists only a single component.
    2. there should not be any cycles existing in the given graph, so that indirectly means the number of edges = number of nodes - 1.

     */

    static class Edge{

        int source;
        int destination;

        Edge(int src, int dest){
            this.source = src;
            this.destination = dest;
        }
    }

    private static void createEdge(ArrayList<Edge> graph[]){ // graph[] is of type ArrayList<Edge>


        for ( int i = 0; i < graph.length; i++){ // initializing
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1));
        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,3));


    }

    private static void dfs(ArrayList<Edge> graph[], boolean visited[], int curr){

        visited[curr] = true;

        for( int i=0; i < graph[curr].size(); i++ ){

            Edge e = graph[curr].get(i);

            if( !visited[e.destination]) {
                dfs(graph, visited, e.destination);
            }
        }
    }

    private static boolean isTree( ArrayList<Edge> graph[], boolean visited[] ){

        int countComponents = 0; // for condition 1
        for(int i = 0; i < graph.length; i++ ){
            if( !visited[i]){
                dfs(graph,visited,i);
                countComponents = countComponents + 1;
            }
        }

        if( countComponents > 1){
            return false;
        }

        for ( int i = 0; i < visited.length; i++){

            if( !visited[i] ){
                return false;
            }
        }

        return true;

    }


    public static void main(String[] args) {

        int V = 4;

        ArrayList<Edge> graph[] = new ArrayList[V];

        boolean visited[] = new boolean[V];

        createEdge(graph);

        System.out.println(isTree(graph,visited));

    }
}
