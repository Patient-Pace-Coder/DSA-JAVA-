package Graphs;


/*

Strongly connected components :

SCC is a component in which we can reach every vertex of the components from evey vertex in that component.

ex :

1 ----> 0 ----> 3
^      /        |        here, Strongly connected components are  :
|     /         |        1. 102
|    /          |        2. 3
|   /           |        3. 4
|  /            >4
2 < (pointer)


other examples:

refer : https://youtu.be/59fUtYYz7ZU?si=2FAM34-jpOs9Zo1w


The concept of SCC exists only for directed graphs.
As for undirected graphs we can reach every node from any node if there's an edge and so the whole graph becomes a single component.

In the above example 102 is a single component because in 102 from any vertex let's say 1 , from 1 we can reach 0 and also from 1 we can reach 2.
Similarly, from 2,1 we can reach to all the vertices in that component.
And 3 and 4 are single components because from three we can reach 4 but from 4 we cannot reach 3 so we cant consider 3,4 as a single component, and so they are 2 different components.

 */

/*

To get the SCC for a given graph we use Kosaraju's Algorithm.

Steps in Kosaraju's Algorithm :

a. Get nodes in stack (topological sort)  (TC : O(v+E) )
b. Transpose the graph (TC : O(v+E) )
c. Do DFS according to stack nodes on the transpose graph.(from top of the stack) (TC : O(v+E) )

topological sort : It states that if there's an edge from u ---> v,
then in the topological order u must come before v.

for step 'a' we perform some steps :
1. perform normal dfs but when there are no neighbours for any node we backtrack,
so while backtracking we push the curr.node

here topological order is [0,3,4,2,1]. i.e. after performing step 'a' the resultant stack will be in that way.


for step 'b' :
transpose refers to reversing the directions of the edges between the nodes.

for step 'c' :
1. for each node in the stack ([0,3,4,2,1])  if the node in the top of the stack is not visited, then perform dfs. and pop it.
2. if the node at top of stack is already visited then just pop it.

 */

import java.util.ArrayList;
import java.util.Stack;

public class KosarajusAlgorithm {

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

        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,4));

    }

    public static void topologicalSort(ArrayList<Edge> graph[], int curr, boolean visited[], Stack<Integer> s){

        visited[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){

            Edge e = graph[curr].get(i);

            if(!visited[e.dest]){
                topologicalSort(graph,e.dest,visited,s);
            }
        }

        s.push(curr); // pushing current node into stack while backtracking,
        // i.e. if all the nodes of the curr is visited then we add it into stack while backtracking.

    }

    public static void dfs( ArrayList<Edge> graph[], int curr,boolean visited[]){

        visited[curr] = true;

        System.out.print(curr+" "); // to print the Strongly connected components

        for( int i=0; i<graph[curr].size(); i++){

            Edge e = graph[curr].get(i);

            if(!visited[e.dest]) {

                dfs(graph,e.dest,visited);

            }
        }
    }

    public static  void kosarajusAlgo(ArrayList<Edge> graph[], int V){

        //Step1 - O(V+E)
        Stack<Integer> s = new Stack<>();

        boolean visited[] = new boolean[V];

        for( int i=0; i<V; i++){
            if(!visited[i]){
                topologicalSort(graph,i,visited,s); // for preparing the stack
            }
        }

        //Step2
        ArrayList<Edge> transpose[] = new ArrayList[V]; // transpose Array of arraylists to store neighbours of transpose graph
        for( int i=0; i<graph.length; i++){
            visited[i] = false; // marking all the nodes as false because we have to perform dfs in next step.
            transpose[i] = new ArrayList<Edge>();// assigning AL at all indices
        }

        for( int i=0; i<V; i++){
            for( int j=0; j<graph[i].size(); j++){
                Edge e = graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest,e.src)); // e.src will become e.dest, and e.dest and will become e.src
            }
        }

        //Step3  - O(V+E)
        while (! s.isEmpty()){ // for each element in stack s [0,3,4,2,1]

            int curr = s.pop();
            if(!visited[curr]){
                dfs(transpose, curr, visited); // as we have o perform dfs on transpose matrix.
                System.out.println(); // for identifying new SCC
            }

        }


    }

    public static void main(String[] args) {

        int V = 5;

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        kosarajusAlgo(graph,V);
    }

}

