package Graphs;

import java.util.ArrayList;

public class CyclicGraphs {

    class Edge{

        int src;
        int dest;

        Edge(int s,int d){
            this.dest=d;
            this.src=s;
        }
    }



    public void createEdge(ArrayList<Edge> graph[]){ // graph[] is of type ArrayList<Edge>

//        graph[0].add(new Edge(1,2)); // NullPointerException

        for(int i=0;i<graph.length;i++){

            graph[i]=new ArrayList<Edge>(); // since graph is of type ArrayList<Edge> we add arraylist at all indexes. or else we can't add anything into the graph[].
        }

        // edges for directed graph:
//        graph[0].add(new Edge(0,1));
//        graph[0].add(new Edge(0,2));
//
//        graph[1].add(new Edge(1,0));
//        graph[1].add(new Edge(1,3));
//
//        graph[2].add(new Edge(2,0));
//        graph[2].add(new Edge(2,4));
//
//        graph[3].add(new Edge(3,1));
////        graph[3].add(new Edge(3,4));
////        graph[3].add(new Edge(3,5));
//
//        graph[4].add(new Edge(4,2));
////        graph[4].add(new Edge(4,3));
//        graph[4].add(new Edge(4,5));
//
////        graph[5].add(new Edge(5,3));
//        graph[5].add(new Edge(5,4));
//        graph[5].add(new Edge(5,6));
//
//        graph[6].add(new Edge(6,5));

        // for undirected graph :

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,4));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,4));

        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,2));

        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,4));


    }

    // same dfs approach

    // here cycle exists if there are 2 same elements in the recursion stack, so we use rec_stack to check the condition.
    public boolean isCycleDirected(ArrayList<Edge> graph[], boolean visited[], boolean rec_Stack[] ,int curr){ // not yet resolved
        if(!visited[curr]) {
            visited[curr] = true;
            rec_Stack[curr] = true;


            for (Edge e: graph[curr]) {

                if (!visited[e.dest] && isCycleDirected(graph,visited,rec_Stack,e.dest)) {
                    return true;
                }
                else if (rec_Stack[e.dest] == true) {
                    return true;
                }

            }

        }
        rec_Stack[curr] = false; // backtracking step

        return false;
    }

//    for undirected graphs to check if cycle exists or not we follow below steps
    /*
        1------2
      / |      |
    0   |      |
      \ |      3
        4
         \
          \
           5

        here , we start from node 0 mark it visited . parent of node 0 is -1. for 0 we have two neighbours [1,4] we can move to any neighbours. I prefer going to 1 , mark 1 as visited .so now parent of 1 is 0. now 1 has 3 neighbours [0,2,4] ,
        I go to 2 as it is unvisited mark it visited and parent of 2 is 1. 2 has 2 neighbours [1,3] i go to 3 as it is unvisited and mark it visited. parent of 3 is 2. now, 3 doesn't have any neighbours so it will go back to 2 and from 2 to 1. now 1's other neighbour is 4 so I move to 4 and mark it visited. 4 has 3 neighbours [0,1,5] here 0,1 are visited and 5 is not visited.
        now comes the condition for cycle detection for undirected graphs , i.e. from 4 , 0 is not the parent of 4 and 0 is already visited so this the condition for cycle detection.

        there are 3 types of neighbours :
        1. vis[n]=T;  ---> it implies the graph is cyclic i.e. it is a back-edge
           e.dest != parent (here 0)
        2. vis[n]=T; // in code we ignore this condition as it is not useful
           e.dest == parent (here 1)
        3. vis[n]=F; // in code we use this for visiting unvisited nodes
           e.dest == curr (here 5)
     */
    public boolean isCycleUndirected( ArrayList<Edge> graph[],boolean visited[],int curr,int parent){

        visited[curr] = true;

        for(int i=0;i<graph[curr].size();i++){

            Edge e= graph[curr].get(i);
            if( visited[e.dest] && ( e.dest != parent )) {

                return true;

            }
            else if( !visited[e.dest] ){

                return isCycleUndirected(graph, visited, e.dest, curr);
            }
        }


        return false;
    }

    public static void main(String[] args) {

        int v = 7;

        /*  // graph of the question

            1 -- 3
           /
          0         5 -- 6
           \       /
            2 -- 4

         */


        v=6; // for undirected graph
        ArrayList<Edge> graph[]=new ArrayList[v];

//        for (int i = 0; i < v; i++) {
//            graph[i] = new ArrayList<Edge>();
//        }

        CyclicGraphs obj=new CyclicGraphs();
        obj.createEdge(graph);
        boolean visited[]=new boolean[v];
        boolean rec_stack[]=new boolean[v];

//        System.out.println(" Is graph cyclic ? : "+obj.isCycleDirected(graph,new boolean[v],rec_stack,0));

        System.out.println(obj.isCycleUndirected(graph,visited,0,-1));
    }

}

