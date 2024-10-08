package Graphs;

import java.util.ArrayList;

public class WeightedGraph {

    class Edge{

        int source;
        int destination;
        int weight;

        public Edge(int src,int dst,int w){

            this.source=src;
            this.destination=dst;
            this.weight=w;
        }

    }

    public void CreateEdge(ArrayList<Edge> graph[]){ // graph[] is of type ArrayList<Edge>

//        graph[0].add(new Edge(1,2)); // NullPointerException

        for(int i=0;i<graph.length;i++){

            graph[i]=new ArrayList<Edge>(); // since graph is of type ArrayList<Edge> we add arraylist at all indexes. or else we can't add anything into the graph[].
        }

        graph[0].add(new Edge(0,1,2));

        graph[1].add(new Edge(1,0,2));
        graph[1].add(new Edge(1,2,-1));
        graph[1].add(new Edge(1,3,10));

        graph[2].add(new Edge(2,1,-1));
        graph[2].add(new Edge(2,3,0));

        graph[3].add(new Edge(3,1,10));
        graph[3].add(new Edge(3,2,0));
    }

    public void getNeighbours(ArrayList<Edge> graph[], int vertexNum){

        System.out.println(" Neighbours of vertex "+vertexNum+" are : ");
        for ( int i=0;i<graph[vertexNum].size();i++){

            Edge edge = graph[vertexNum].get(i);

            System.out.print(edge.destination+" : "+edge.weight);
            System.out.println();
        }

    }

    private void displayGraph(ArrayList<Edge> graph[]) {

        System.out.println();
        System.out.println(" Graph : ");
        System.out.println();
//        System.out.println("0 1 2 3");
        for ( int i = 0;i < graph.length;i++){

            for ( int j = 0;j < graph[i].size();j++){

                Edge edge = graph[i].get(j);
                System.out.println( " Source : "+edge.source+" , "+" Destination : "+edge.destination+" , "+" Weight : "+edge.weight);
            }
        }
    }


    public static void main(String[] args) {

        int v=4; // number of vertices

        ArrayList<Edge> graph[] = new ArrayList[v];

        WeightedGraph obj=new WeightedGraph();
        obj.CreateEdge(graph);
        obj.displayGraph(graph);
        obj.getNeighbours(graph,1);



    }
}
