package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AllPaths {

    static Queue<Integer> queue = new LinkedList<>();
    static class Edge{

        int src;
        int dest;

        Edge(int s,int d){
            this.dest=d;
            this.src=s;
        }
    }



    public static void createEdge(ArrayList<Edge> graph[]){ // graph[] is of type ArrayList<Edge>

//        graph[0].add(new Edge(1,2)); // NullPointerException

        for(int i=0;i<graph.length;i++){

            graph[i]=new ArrayList<Edge>(); // since graph is of type ArrayList<Edge> we add arraylist at all indexes. or else we can't add anything into the graph[].
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));

    }

    // Approach used for finding all paths :

    /*


                                                           0
                                                 /                  \
                                                1                    2
                                              /   \                 / \
                                             0     3               0    4
                                                 / | \                / | \
                                                1  4  5              2  3  5
                                                  / \                  /|\
                                               ->2   5                1 4 5

      -> : when allPaths(2) will be called, 2 will be added to queue but since all the neighbours of 2 i.e. (0,4) are already visited the function allPaths(2) will end and we will backtrack to 4 by removing 2 from queue and setting visited[2]=false.

     */


    // same dfs approach
    public static void allPaths(ArrayList<Edge> graph[],boolean visited[] , int src,int destination){  // time complexity : O(v^V)

        queue.add(src); // to store the paths , we can use strings too.

        visited[src] = true;

        if(src==destination){ // base case

            for(int ele : queue){
                System.out.print(ele+" ");
            }
            System.out.println();
            return;
        }

        for(int i=0;i<graph[src].size();i++){
            Edge e=graph[src].get(i);

            if(visited[e.dest] == false  ){  // mistake i did : /* && e.dest>src */ to eliminate visiting lower nodes i.e. avoiding ,movement from node 4 to 2. but, it is not needed as this condition will not generate a path [0 2 4 3 5].
                allPaths(graph,visited,e.dest,destination);
                visited[e.dest]=false; // backtracking step
                queue.remove(e.dest); // removing already visited node, queue.remove() - removes the head of the queue so to remove specific element we have to pass the element through params.
            }
        }
    }

    // Using String

    public static void allPaths(ArrayList<Edge> graph[],boolean visited[] , int src,int destination,String p){  // time complexity : O(v^V)

        p+=" "+src; // to store the paths , we can use strings too.

        visited[src] = true;

        if(src==destination){ // base case

//            for(int ele : queue){
//                System.out.print(ele+" ");
//            }
            System.out.println(p);
//            System.out.println();
            return;
        }

        for(int i=0;i<graph[src].size();i++){
            Edge e=graph[src].get(i);

            if(visited[e.dest] == false  ){  // mistake i did : /* && e.dest>src */ to eliminate visiting lower nodes i.e. avoiding ,movement from node 4 to 2. but, it is not needed as this condition will not generate a path [0 2 4 3 5].
                allPaths(graph,visited,e.dest,destination,p);
                visited[e.dest]=false; // backtracking step
            }
        }
    }



    public static void main(String[] args) {

        int v = 7;

        /*  // graph of the question

            1 -- 3
           /     |  \
          0      |   5 -- 6
           \     |  /
            2 -- 4

         */


        ArrayList<Edge> graph[]=new ArrayList[v];

        createEdge(graph);
        boolean visited[]=new boolean[v];
//        allPaths(graph,visited,0,5);
        allPaths(graph,visited,0,5," ");
    }

}
