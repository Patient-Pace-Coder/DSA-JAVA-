package Graphs;

import java.util.ArrayList;

// Adjacency List :

// it is more efficient as while retrieving we need not use another ds.
// it is more efficient as we can get neighbours easily without needing
// to search for all elements of Graph[]. we can use indexes as neighbours of 2 will only we stored in AL at Graph[2].


// this approach of storing a graph is called as Adjacency List i.e. Array of ArrayLists.

public class SimpleGraph { // unweighted, undirected


    static class Edge{

        int source;
        int destination;

        public Edge(int src,int dst){

            this.source=src;
            this.destination=dst;
        }

    }

//     public void CreateEdge(ArrayList<Edge> graph[]){ // graph[] is of type ArrayList<Edge>
//
// //        graph[0].add(new Edge(1,2)); // NullPointerException
//
//         for(int i=0;i<graph.length;i++){
//
//             graph[i]=new ArrayList<Edge>(); // since graph is of type ArrayList<Edge> we add arraylist at all indexes. or else we can't add anything into the graph[].
//         }
//
//         graph[0].add(new Edge(0,1));
//
//         graph[1].add(new Edge(1,0));
//         graph[1].add(new Edge(1,2));
//         graph[1].add(new Edge(1,3));
//
//         graph[2].add(new Edge(2,1));
//         graph[2].add(new Edge(2,3));
//
//         graph[3].add(new Edge(3,1));
//         graph[3].add(new Edge(3,2));
//
//
//         // graph[] will be like this
//         // [ {e0} ,{e0,e1,e2} , {e0,e1}, {e0,e1} ]
//     }

    public void CreateEdge(ArrayList<Edge> graph[]){ // graph[] is of type ArrayList<Edge>

//        graph[0].add(new Edge(1,2)); // NullPointerException

        for(int i=0;i<graph.length;i++){

            graph[i]=new ArrayList<Edge>(); // since graph is of type ArrayList<Edge> we add arraylist at all indexes. or else we can't add anything into the graph[].
        }

        graph[0].add(new Edge(0,1));

        // graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));
        graph[2].add(new Edge(2,3));

        // graph[2].add(new Edge(2,1));
        // graph[2].add(new Edge(2,3));

        // graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));


        // graph[] will be like this
        // [ {e0} ,{e0,e1,e2} , {e0,e1}, {e0,e1} ]
    }

    public void getNeighbours(ArrayList<Edge> graph[],int vertexNum){

        System.out.print(" Neighbours of vertex "+vertexNum+" are : ");
        for ( int i=0;i<graph[vertexNum].size();i++){
            Edge edge = graph[vertexNum].get(i);
            System.out.print(edge.destination+" ");
        }

    }

    public void DistanceAfterNQueries(ArrayList<Edge> graph[],int N,int[][] querries){
        for( int i = 0; i < querries.length; i++ ){
            graph[querries[i][0]].add( new Edge(querries[i][0],querries[i][1]));
        }
        int minDist = 0;
        for ( int i=0;i<graph[0].size();i++){
            Edge edge = graph[0].get(i);
            if( edge.destination == N ){
                minDist = 1;
            }
        }
    }

    private void displayGraph(ArrayList<Edge> graph[]) {

//        System.out.println("0 1 2 3");
        for ( int i = 0;i < graph.length;i++){

            for ( int j = 0;j < graph[i].size();j++){

                Edge edge = graph[i].get(j);
                System.out.println( " Source : "+edge.source+" , "+" Destination : "+edge.destination);
            }
        }
    }


    public static void main(String[] args) {

        int v=4; // number of vertices

        ArrayList<Edge> graph[] = new ArrayList[v]; // Array of Arraylist's.

//        int arr[] = new int[size]; above line is similar to this

        SimpleGraph obj=new SimpleGraph();

        obj.CreateEdge(graph);

        obj.displayGraph(graph);

        obj.getNeighbours(graph,2);

    }



}
