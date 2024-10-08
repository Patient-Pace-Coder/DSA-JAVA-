package Graphs;

import java.util.ArrayList;

// to find the shortest distances from node 0 to all other nodes

public class SingleSourceShortestDistance {

    static class Edge{

        int source;
        int destination;

        Edge(int src, int dest){
            this.source = src;
            this.destination = dest;
        }
    }

    private static void createEdge(ArrayList<Edge> graph[]){

        for( int i = 0;i < graph.length; i++){

            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1));
        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,3));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

    }

    // same dfs logic but we just added another array which tracks the distances of nodes from a particular node.
    private static void dfs(ArrayList<Edge> graph[], boolean visited[], int distance[],int curr,int dist){

        visited[curr] = true;
        distance[curr] = dist;

//        System.out.println("distance array is : ");  // for debugging
//
//        for ( int i = 0; i < distance.length; i++){ // for debugging
//
//            System.out.print(distance[i] + " ");
//        }
//        System.out.println();


        for( int i=0; i < graph[curr].size(); i++ ){

            Edge e = graph[curr].get(i);

            if( !visited[e.destination]) {
                dfs(graph, visited, distance, e.destination,dist+1);
            }
        }
    }

    public static void main(String[] args) {

        int V = 6;

        boolean visited[] = new boolean[V];
        int distance[] = new int[V];

        ArrayList<Edge> graph[] = new ArrayList[V];

        createEdge(graph);

        dfs(graph,visited,distance,0,0);

        for ( int i = 0; i < distance.length; i++){

            System.out.print(distance[i] + " ");

        }
    }
}
