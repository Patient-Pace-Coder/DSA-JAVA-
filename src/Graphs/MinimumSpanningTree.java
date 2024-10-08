package Graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

public class MinimumSpanningTree {

    static class Edge{

        int src;
        int dest;
        int wt;

        public Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }


    public static void createGraph(ArrayList<Edge> graph[]){ // graph[] is of type ArrayList<Edge>

//        graph[0].add(new Edge(1,2)); // NullPointerException

        for(int i=0;i<graph.length;i++){

            graph[i]=new ArrayList<Edge>(); // since graph is of type ArrayList<Edge> we add arraylist at all indexes. or else we can't add anything into the graph[].
        }

        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,2,15));
        graph[0].add(new Edge(0,3,30));

        graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,3,40));

        graph[2].add(new Edge(2,0,15));
        graph[2].add(new Edge(2,3,50));

        graph[3].add(new Edge(3,1,40));

        graph[3].add(new Edge(3,2,50)); // to see -ve wt cycle replace -1 with 10 here.

    }

    /*

    A MST or minimum weight spanning tree is a subset of the edges of a connected, edge weighted undirected graph that
    connects all the vertices together, without any cycles and with the minimum possible total edge weight.

    conditions for MST to be existing :

    1. edge-weighted graph
    2. undirected graph

    things to keep in mind while making MST :
    1. all vertices should be included
    2. all vertices should be connected to least one node.
    3. edge weight should be minimum.
    4. there shouldn't be any cycle.

    there may be many spanning trees for a graph but there will only be a single MST.


          ex:       graph :

                       5
                | -----------|
                |  1      3  |
                A --- B ---- E
                     / \
                   5/   \4
                   C --- D
                      10


          MST :   wt = 13                           ST : wt =21

                                                         5
                                                |--------------
                      1      3                  |   1         |
                  A ---- B ---- E               A ---- B      E
                        / \                          5/
                      5/   \4                        C ---- D
                      C     D                           10


     */

    /*

    Prims Algorithm :

    to get the MST we have an algorithm i.e. Prims Algorithm which works on mst set.

    Steps are  (for theory) :
    1. we have all the nodes of the graph in Non mst set
    2. And the moment each node is visited , the node is removed from non mst set to mst set.
    3. first we will have 0 in mst set as it is the src and all other vertices will be in non mst set. we must compare the elements in mst set with elements in non mst set.
    4. now from 0 we compare all the edge weights for which 0 is the src and pick the least/minimum weight one and remove the destination node from non mst set to mst set.
    4A. from next time we compare all the edge weights irrespective of src and pick the least/minimum  existing in the non mst set
    5. steps 1-4 keeps on repeating until non mst set is empty.


    for coding we use :
    1. we store pair(node,wt) in a pq. (pq i.e. priority queue represents a non mst set).
    here we dont add all the nodes in mst as done in theory but we add pairs one by one.
    2. so initially we add pair(0,0) in pq.
    3. we check for unvisited neighbours of the nodes in pq and add it in pq if they are not visited. (in pq the elements will be sorted in ascending order of wts)
    4. repeat steps 1-3 until pq is empty.

     */


    public static class Pair implements  Comparable<Pair> {

        int node;
        int cost;

        public  Pair(int n,int c){
            this.node=n;
            this.cost=c;
        }

        public  int compareTo(Pair p2){
            return this.cost - p2.cost; // sorting pq elements in ascending order
        }
    }
    public static void primsAlgo(ArrayList<Edge> graph[], int V){

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(); // non mst
        boolean visited[] = new boolean[V];
        pq.add(new Pair(0,0));
        int mstCost = 0;

        while (!pq.isEmpty()){

            Pair curr = pq.remove();
            if(!visited[curr.node]){

                visited[curr.node] = true;
                mstCost += curr.cost;

                for( int i=0; i<graph[curr.node].size(); i++){
                    Edge e = graph[curr.node].get(i);
                    if(!visited[e.dest]){
                        // Iterator<Pair> itr = pq.iterator(); // Debugging purpose
                        // System.out.println("pq Before adding");
                        // while( itr.hasNext() ){
                        //     System.out.println(itr.next().cost);
                        // }
                        pq.add(new Pair(e.dest,e.wt));
                        // System.out.println("pq After adding");
                        // Iterator<Pair> itr1 = pq.iterator(); // Debugging
                        // while( itr1.hasNext() ){
                        //     System.out.println(itr1.next().cost);
                        // }
                    }
                }
            }
        }
        System.out.println("min cost of mst = "+mstCost);
    }
    public static void main(String[] args) {

        int V = 4;

        ArrayList<Edge> graph[] = new ArrayList[V];


        createGraph(graph);
        primsAlgo(graph,V);

    }
}
