package Graphs;



// BellmanFord's Algorithm is used to find the Shortest distance from the source to all the vertices.
// WORKS ON DYNAMIC PROGRAMMING APPROACH
// IT WORKS FOR BOTH +VE AND -VE WEIGHTS.
// MORE TIME COMPLEXITY COMPARED TO DIJKSTRA ALGORITHM

// Note : BFA doesn't work for negative weight cycles, i.e. if there exist a cycle in the graph and the sum of the weights of the  edges in the cycle is -ve ,then BFA doesn't work.

import java.util.ArrayList;

public class BellmanFordAlgorithm {


    static class Edge{
        int src;
        int dest;
        int wt;

        Edge(int s,int d,int w){

            this.src = s;
            this.dest = d;
            this.wt = w;

        }

    }

    public static void createGraph(ArrayList<Edge> graph[]){ // graph[] is of type ArrayList<Edge>

//        graph[0].add(new Edge(1,2)); // NullPointerException

        for(int i=0;i<graph.length;i++){

            graph[i]=new ArrayList<Edge>(); // since graph is of type ArrayList<Edge> we add arraylist at all indexes. or else we can't add anything into the graph[].
        }

        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,2,-4));

        graph[2].add(new Edge(2,3,2));

        graph[3].add(new Edge(3,4,4));

        graph[4].add(new Edge(4,1,-1)); // to see -ve wt cycle replace -1 with 10 here.

    }

    /*

    Bellman ford algorithm steps :

    run a for loop V-1 times, where V is number of vertices

    and in each iteration :
        perform relaxation for all edges :
            for all edges (u,v)
                if dist[u] + wt (u,v) < dist[v]
                    dist[v] = dist[u] + wt (u,v)

     */

    public static void bellmanFord(ArrayList<Edge> graph[] ,int src,int V){ // time complexity O(V.E)

        int dist[] = new int[V];

        // this loop is main as we need to set all the values except source as infinity ,
        // otherwise performing relaxation will be of no use as default values of int[] array is 0.

        for(int i=0; i<V; i++){

            if( i != src){
                dist[i] = Integer.MAX_VALUE; // setting all the values to infinity, except 0.
            }
        }

        for(int i=0; i<V-1; i++){ // for loop V-1 times as per BFA (v-1 because to go from 0 - V one must pass through at  least v-1 nodes

            for(int k=0 ; k< graph.length; k++) { // for accessing all nodes in the graph

                for (int j = 0; j < graph[k].size(); j++) { // for accessing each arraylist (of neighbours)

                    Edge e = graph[k].get(j);
                    int u = e.src;
                    int v = e.dest;

                    if ((dist[u] + e.wt) < dist[v]) {
                        dist[v] = dist[u] + e.wt;
                    }
                }
            }
//            for( int l=0; l<dist.length; l++){ // for debugging
//                System.out.print( dist[l]+" " );
//            }
//            System.out.println();
        }


        // to detect -ve weight cycles
        for(int k=0 ; k< graph.length; k++) { // for accessing all nodes in the graph

            for (int j = 0; j < graph[k].size(); j++) { // for accessing each arraylist (of neighbours)

                Edge e = graph[k].get(j);
                int u = e.src;
                int v = e.dest;

                if ((dist[u] + e.wt) < dist[v]) { // executes only if -ve wt cycle exists
                    System.out.println("negative weight cycle exist !!");
                }
            }
        }

        System.out.println("Distance for source 0 to all other vertices : ");
        for( int i=0; i<dist.length; i++){
            System.out.print( dist[i]+" " );
        }
    }

    public static void main(String[] args) {

        int V = 5;

        /*

        graph used in this code :

             1
            /| \
          2/ |  \-1              Directions :
          0  |-4 \               0 ----> 1,2
          4\ |    4              1 ----> 2
            \|      \4           2 ----> 3
             2 ----- 3           3 ----> 4
                2                4 ----> 1

         */

        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);

        bellmanFord(graph,0,V);

    }


}
