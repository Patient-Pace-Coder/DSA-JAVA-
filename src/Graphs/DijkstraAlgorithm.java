package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;


// Dijkstra's Algorithm is used to find the Shortest distance from the source to all the vertices.
// WORKS ON GREEDY APPROACH
// IT WORKS IF AND ONLY IF WEIGHTS OF THE EDGES ARE +VE.
// LESS TIME COMPLEXITY COMPARED TO BELLMAN-FORD ALGORITHM

public class DijkstraAlgorithm {

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

        graph[1].add(new Edge(1,3,7));
        graph[1].add(new Edge(1,2,1));

        graph[2].add(new Edge(2,4,3));

        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));

    }

    /*

    Pair class is to store the node and distance of it.
    we implement Comparable interface as we are using priority queue and in it, we need our pair objects to be arranged in ascending order of distances.
    also as Comparable is an interface we need to implement all the methods of it, or we need to declare class as abstract class
     */

    public static class Pair implements Comparable<Pair> {

        int node;
        int dist;

        public Pair(int n,int d){
            this.node = n;
            this.dist = d;
        }


        // compareTo() function returns 3 types of values (+ve , -ve, 0)
        // +ve means this.dist is greater than p2.dist , so new pair should come after p2.
        // -ve means this.dist is less than p2.dist , so new pair should come before p2.
        // 0 means this.dist is equal to p2.dist , so new pair will be added after p2.
        @Override
        public int compareTo(Pair p2) { // for comparing values of the distance in pq
            return this.dist - p2.dist; // ascending , here this.dest refers to dist[v] in pq.add(new Pair(v,dist[v])), and p2.dist refers to already existing pair object's dist.,
            // if there's only one pair object then it adds it without any comparison.
        }
    }

    /*

    priority queue arranges elements of queue in ascending order by default. so we can easily get the shortest distance for each step.

    step to dijkstra's algo :


    1.first we add the pair(node=src,dist=src) into priority queue.

    these steps must be followed for each node ->
    set curr = pq.remove();
    2.then we explore all the neighbours of curr.node
    which satisfies :
        1. vis[cur.node] = false
        2. dist = shortest i.e. distance of first pair object in pq.

    3.set u=e.src
    4.set v=e.dest
    5. check for relaxation condition :
        if(dist[u] + e.wt < dist[v]){ // relaxation condition
            dist[v] = dist[u] + e.wt; // updating dist[v]
            pq.add(new Pair(v,dist[v])); // adding pair into pq
        }
    update distances of its neighbours.
    6. repeat steps 1-5 until priority Queue is empty.

     */
    public static void dijkstra(ArrayList<Edge> graph[], int src,int V){

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int dist[] = new int[V];

        for(int i=0; i<V; i++){

            if( i != src){
                dist[i] = Integer.MAX_VALUE; // setting all the values to infinity, except 0.
            }
        }

        boolean vis[] = new boolean[V]; // for tracking unvisited nodes

        pq.add(new Pair(0,0)); // adding first pair of (src,dest).

        while (!pq.isEmpty()){

            Pair curr = pq.remove(); // accessing src node.
            if( !vis[curr.node] ){
                vis[curr.node] = true; // marking node as visited

                for(int i=0; i<graph[curr.node].size(); i++){

                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;

                    if(dist[u] + e.wt < dist[v]){ // relaxation condition
                        dist[v] = dist[u] + e.wt; // updating dist[v]
                        pq.add(new Pair(v,dist[v])); // adding pair into pq
                    }
                }
            }
        }

        for ( int i=0; i <V; i++){ // final loop to display the shortest distances from source node to all vertices.
            System.out.print(dist[i]+" ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        int V = 6;

        /*

        graph used in this code :

                7
            1 ----- 3
          2/ |      | \1         directions :
          0  |1    2|  5         0 --- > 1,2
          4\ |      | /5         1 ----> 2,3
             2 ---- 4            2 ----> 4
                3                3 ----> 5
                                 4 ----> 3,5
         */

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        dijkstra(graph,0,V);
    }
}
