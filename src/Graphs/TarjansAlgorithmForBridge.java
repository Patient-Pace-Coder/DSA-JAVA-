package Graphs;

import java.util.ArrayList;

public class TarjansAlgorithmForBridge {


    /*

    Tarjans Algorithm is used to find the bridges in the graph, it is also used to find the Strongly connected components of the graph.

Theory :
    Bridge is an edge whose deletion increases the graph's number of connected components

    ex :

    1 ---- 0 ----- 3
    |     /        | \
    |    /         |   \
    |   /          |    5
    |  /           |  /
     2             4


    ex2:

            1 ---- 0 ----- 3
            |     /        |
            |    /         |
            |   /          |
            |  /           |
             2             4

            here 0 --- 3 , 3 --- 4 are bridges.

    here
    if edge 0-3 is removed then the number of components increase and
    therefore the edges 0-3 is a bridge.


    so to do this in code we use two arrays and a variable

    1. dt[] = int[V]

    dt : an array which stores discovery time of each node.

    2. low[] = int[V]

    low : an array which stores lowest discovery time of all neighbours.

    3. int par - it stores the parent node of the current node.


    steps in Tarjans algorithm ::

    1. run normal dfs() {

              visited[curr] = true

              dt[curr] = low[curr] = low[curr] = ++time

              for( int i=0 to number of neighbours)

                   for each edge :

                          if (e.dest == par) : // we cannot guarantee if an edge between a parent node and a child node can be a bridge or not so we ignore it.
                                continue
                          if (!visited[e.dest]):
                                call dfs()
                                low[curr] = min(low[curr],low[e.dest])  // updating the lowest discovery time of the current node with the minimum value between low[curr] && low[e.dest] (i.e. neighbours).

                                if( dt[curr] < low[e.dest] ) // condition for bridge
                                       print(curr ---> e.dest)

                          if(visited[e.dest]):

                          in the graph when we be at node 2 ,
                           the neighbours of node 2 are 0,1 and 1 is parent of 2. now 2 sees that its neighbours 0 is already visited but not from 2 so that means that the edge 2-0 cannot be a bridge as there is another way to visit 0 other than the way from 2 to 0.
                           so in this case we don't check for bridge condition and just update the low[curr] value.

                                low[curr] = min( low[curr] , dt[e.dest] )
          }

     */


    static class Edge{

        int src;
        int dest;

        public Edge(int s,int d){
            this.src = s;
            this.dest = d;
        }
    }


    public static void createGraph(ArrayList<Edge> graph[]){ // graph[] is of type ArrayList<Edge>

//        graph[0].add(new Edge(1,2)); // NullPointerException

        for(int i=0;i<graph.length;i++){

            graph[i]=new ArrayList<Edge>(); // since graph is of type ArrayList<Edge> we add arraylist at all indexes. or else we can't add anything into the graph[].
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,4));
//        graph[3].add(new Edge(3,5));  for ex2

        graph[4].add(new Edge(4,3));
//        graph[4].add(new Edge(4,5)); for ex2

//        graph[5].add(new Edge(5,3));  for ex2
//        graph[5].add(new Edge(5,4));  for ex2

    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean visited[], int dt[], int low[], int time, int par){

        visited[curr] = true;
        dt[curr] = low[curr] = ++time;

        for(int i=0; i<graph[curr].size(); i++){

            Edge e =graph[curr].get(i);

            if(e.dest == par){
                continue;
            } else if (!visited[e.dest]) {
                dfs(graph,e.dest,visited,dt,low,time,curr);
                low[curr] = Math.min( low[curr], low[e.dest]);

                if(dt[curr] < low[e.dest]){

                    System.out.println("Bridge is : "+ curr + " --- " + e.dest);
                }
            }
            else{

                low[curr] =Math.min( low[curr], dt[e.dest]);
            }
        }
    }

    public static void getBridge( ArrayList<Edge> graph[], int V){

        int dt[] = new int[V];

        int low[] = new int[V];

        int time = 0;
        boolean visited[] = new boolean[V];

        for(int i=0; i<V; i++){

            if(!visited[i]){
                dfs(graph,i,visited,dt,low,time,-1);
            }
        }
    }




    public static void main(String[] args) {


//        int V = 6;  // for ex1

        int V = 5;


        /*

            ex1:


            1 ---- 0 ----- 3
            |     /        | \
            |    /         |   \
            |   /          |    5
            |  /           |  /
             2             4


            ex2:

            1 ---- 0 ----- 3
            |     /        |
            |    /         |
            |   /          |
            |  /           |
             2             4

             here 0 --- 3 , 3 --- 4 are bridges.

         */

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        getBridge(graph,V);
    }
}
