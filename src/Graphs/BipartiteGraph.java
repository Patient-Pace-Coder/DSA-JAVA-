package Graphs;

import java.util.ArrayList;

public class BipartiteGraph {

    /*

    A Bipartite graph is also known as a special graph such that you can divide the vertex set into 2 disjoint sets such that :
    1. Each vertex belongs to exactly one of the 2 sets. i.e. intersection of sets will be null, and union will be all the nodes in the graph.
    2. Each edge connects vertices of 2 different sets. i.e. there will not be any edge between the nodes of same set.

    ex :

          1                     here A = { 1,3,5 }
       /     \                       B = { 2,4,6 }
      6       2
      |       |             we can rearrange the nodes and edges of this graph as by writing set of both the elements from top to down and then connect them.
      5       3
       \     /                  1 ---- 2   also there will be edges from 1-6,3-2,5-4
          4                     3 ---- 4
                                5 ---- 6

                                we will be given a graph, we need to check if the graph is a bipartite graph or not.
                                for that we will check for two conditions , if any one violates then we will return false, else true.


     intuition :

     - in the dfs function we will add some additional things such as color.

     - since it is a bipartite graph we can only use 2 colors for colouring the nodes.
     - here we will use an array which tracks the color of the nodes i.e. ( 0,1 )

     - while traversing in dfs manner,
     - if the node is not visited, we mark it visited, colour the curr node and then call dfs for child node
     - if the child node is not visited, we mark it visited, colour the child node (curr node ) with opposite or different color
     - if the child node is already visited then we check if the color of parent node and child node are same,
        - if same then it violates the 2nd condition
        - we return false


****  QUESTION :

    Professor hopper is researching the sexual behaviour of a rare species of bugs.
    He assumes that they feature two different genders and that they interact with bugs of the opposite
    gender. In his experiment, individual bugs and their interactions were easy to identify,
    because numbers were printed on their backs.

    Given a list of bugs interactions decide whether the experiment supports his assumption of
    two genders with no homosexual bugs or if it contains some bug interaction that falsify it.

    output format :
     print " No suspicious bugs found! " if the assumption of hopper is correct.
     print " Suspicious bugs found! " if hopper's assumption is definitely wrong.

     intuition :

     it is based on bipartite graph, same concept but here we have to check for genders, no two neighbours must have same gender.
     we assume "male" as 0 and "female" as 1.
     no two neighbours will have either 0 or 1.

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

        // Not a bipartite :

        graph[0].add(new Edge(0,1));
        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,3));
        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,2));
        graph[3].add(new Edge(3,4));
        graph[4].add(new Edge(4,3));

        // for a bipartite graph :

//        graph[0].add(new Edge(0,1));
//        graph[1].add(new Edge(1,0));
//        graph[1].add(new Edge(1,2));
//        graph[2].add(new Edge(2,1));
//        graph[2].add(new Edge(2,3));
//        graph[3].add(new Edge(3,2));
//        graph[3].add(new Edge(3,4));
//        graph[4].add(new Edge(4,3));

    }

    private static boolean dfs(ArrayList<Edge> graph[], boolean visited[],int curr, int colours[], int colour){

        visited[curr] = true;
        colours[curr] = colour;

        for ( int i = 0; i < graph[curr].size(); i++){

            Edge e  = graph[curr].get(i);

            if( !visited[e.destination] ){
                // never forget to add 'return' here, if we dont add return here then everything will be wasted as this function will always return true of line 96.

                // colours[curr]^1 ---: means performing XOR operation as we need to generate 0,1 as colours for different nodes. we can also use 'not ~' operator.
                return dfs(graph, visited, e.destination, colours, ~colour );/* (colours[curr] ^ 1) */
            }

            else {  // checking 2nd condition
                if (colours[curr] == colours[e.destination]){
                    return false;
                }
            }
        }
        return true;

    }


    public static void main(String[] args) {

        int V = 5;

        ArrayList<Edge> graph[] = new ArrayList[V];

        boolean visited[] = new boolean[V];
        int colors[] = new int[V];  // colours value will be 1 | 2.

        createEdge(graph);
        System.out.println("Is graph bipartite ? : "+ dfs(graph,visited,0,colors,1));

    }


}
