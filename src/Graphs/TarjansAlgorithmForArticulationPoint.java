package Graphs;

import java.util.ArrayList;

public class TarjansAlgorithmForArticulationPoint {


    /*

    Tarjans Algorithm is used to find the bridges, articulation points in the graph, it is also used to find the Strongly connected components of the graph.

Theory :
    Articulation point is a that vertex of a node which when removed (removing of node removes the node ans connected edges from that node too) increases the graph's number of connected components

    ex :

    1 ---- 0 ----- 3
    |     /        | \
    |    /         |   \
    |   /          |    5
    |  /           |  /
     2             4

     here 3 , 0 are articulation points.

    ex2:

            1 ---- 0 ----- 3
            |     /        |
            |    /         |
            |   /          |
            |  /           |
             2             4

            here 0 , 3  are articulation points..

    here,
    if node 0 | 3 is removed then the number of components increase and
    therefore the nodes 0,3 are articulation points.

    Ancestor : a node A that was discovered before curr node in dfs is the ancestor of curr.

     we can use dt[] to know the ancestor of a node.
     i.e. if a node's dt[neighbour] is less than dt[curr] then dt[neighbour] is an ancestor .
    so to do this in code we use two arrays and a variable

    also we use child[] array to store the number of children value.


    we can get the AP's by brute force approach also i.e. by removing a node and counting the number of components and if components are more than 1 then the node is a AP.
    but the problem in this approach is the time complexity i.e. O(V*(V+E))
    instead if we use dfs the complexity will be O(V+E).

    how to decide if a node is AP or not

    rules :

    1.  if a node whose par = -1 i.e. if a node is a starting node
    and it has more than 1 child node and whose child nodes are disconnected (directly snd indirectly) then that node is a AP.

    ex :

        A                            A                      A                              A
       / \                         /  \                   /  \                            /
      B   C                       B -- C                 B    C                          B
     /                            |                      |    |                          |
    D --- E                       D -- E                 D -- E                          D -- E
     \   /                         \  /                   \  /                            \   /
       F                            F                       F                               F

    Here A is an AP,         Here A is not an AP.    Here A is not an AP.              Here A ins not an AP.
    as if A is removed,       ( directly connected    (indirectly connected
    then there will be 2        child nodes (b,c))      child nodes (b,c))
    components.


    2. if par ! = -1

        1. if there's only one way from u to v and there is no back-edge then u is an AP.   // single route

        2. if there exists a cycle from u to v and u is a root node of that cycle then u is an AP.    // cycle


            ex :


                         A
            / \           \          \
           /   \           \          \
          B     C           E           F
         nei   nei         unvisited
        par    visited     child
    so ignore  back-edge
               ancestor







    steps in Tarjans algorithm ::

    1. run normal dfs() {

              visited[curr] = true

              dt[curr] = low[curr] = low[curr] = ++time

              for( int i=0 to number of neighbours)

                   for each edge :

                          if (e.dest == par) : // we cannot guarantee if an edge between a parent node and a child node can be a bridge or not so we ignore it.
                                continue

                          if(visited[e.dest]):   // back-edge  exists, so it is an ancestor

                          in the graph when we be at node 2 ,
                           the neighbours of node 2 are 0,1 and 1 is parent of 2. now 2 sees that its neighbours 0 is already visited but not from 2 so that means that the edge 2-0 cannot be a bridge as there is another way to visit 0 other than the way from 2 to 0.
                           so in this case we don't check for bridge condition and just update the low[curr] value.

                                low[curr] = min( low[curr] , dt[e.dest] )

                          if (!visited[e.dest]):
                                call dfs()
                                low[curr] = min(low[curr],low[e.dest])  // updating the lowest discovery time of the current node with the minimum value between low[curr] && low[e.dest] (i.e. neighbours).

                                if( dt[curr] < low[e.dest] ) // condition for AP // 1. single route
                                       curr - > AP

                                if( dt[curr] = low[e.dest] ) // condition for AP // 2. cycle
                                       curr -> AP

                                 // combination of two AP conditions
                                if ( dt[curr] <= low[e.dest] && par! = -1 ){
                                       curr -> AP
                                }
                                child[curr]++

               if( par = -1 && child > 1 )
                        curr -> AP
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

    public static void dfs(ArrayList<Edge> graph[], int curr, int par, int dt[], int low[], boolean visited[], int time, boolean ap[]){

        visited[curr] = true;
        dt[curr] = low[curr] = ++time;

        int children = 0;

        for(int i=0; i<graph[curr].size(); i++){

            Edge e =graph[curr].get(i);
            int neigh = e.dest;

            if( par == neigh){
                continue;
            } else if (visited[e.dest]) {

                low[curr] = Math.min( low[curr], dt[e.dest]);

            }
            else{

                dfs(graph, neigh, curr, dt, low, visited, time, ap);
                low[curr] = Math.min( low[curr], low[e.dest]);

                if( dt[curr] <= low[neigh] && par != 1){

                    ap[curr] = true;
                }
                children++;
            }
        }

        if( par== -1 && children > 1){
            ap[curr] = true;
        }
    }

    public static void getAP( ArrayList<Edge> graph[], int V){

        int dt[] = new int[V];

        int low[] = new int[V];

        int time = 0;
        boolean visited[] = new boolean[V];
        boolean ap[] = new boolean[V];

        for(int i=0; i<V; i++){

            if(!visited[i]){
                dfs(graph, i,-1, dt, low, visited, time, ap);
            }
        }

        for( int i=0; i<V; i++){

            if(ap[i]){

                System.out.println("AP : "+i);
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

        getAP(graph,V);
    }
}
