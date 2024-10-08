package Graphs;

/*

There are N countries ( 1,2,3,4...N) ( id's) and (N-1) roads ( depicting a tree )
Bishu lives in country 1 ( this can be considered as root node )
Now there are Q girls who live in different countries ( other than 1 )
All of them want to propose bishu but bishu has some condition.
he accepts the proposal of that girl whose distance is minimum from his country.
Now the distance between two countries is the number of roads between them
if two or more girls are at the same distance from bishu then he will accept the proposal of that girl whose country id is minimum.
No two girls are at the same city.


input format :
first line consists of N , number of countries
Next N-1 lines follow the type u v , which denotes there is road between road u and v
Next line consists of Q
Next Q lines consists of countries where the girls live

output :
print the id of the country of the girl h\whose proposal is accepted

 */

/*

        0 - 1
        0 - 2
        0 - 3
        1 - 4
        1 - 5


                         0
                      /  |  \
                     1   2   3
                    /  \
                    4  5


            [ 2 3 4 5 ] - countryId[]



*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BishuAndHisFriendProblem {

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


        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,4));
        graph[1].add(new Edge(1,5));

    }

    private static void dfs( ArrayList<Edge> graph[], boolean visited[], int distance[], int curr, int dist){

        visited[curr] = true;
        distance[curr] = dist;

        for( int i = 0; i < graph[curr].size(); i++){

            Edge e = graph[curr].get(i);

            if( ! visited[e.destination] ) {

                dfs(graph, visited, distance, e.destination, dist + 1);
            }
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter N ( number of countries ) :");
        int V = sc.nextInt();

        ArrayList<Edge> graph[] = new ArrayList[V];

        // as per question :

//        boolean addMore = true;

//        while(addMore){ // adding nodes of graph
//            System.out.println("Enter Nodes u and v :");
//            int u = sc.nextInt();
//            int v = sc.nextInt();
//            graph[u].add( new Edge(u,v) );
//            System.out.println(" Want to add more ? ");
//            addMore = sc.nextBoolean();
//        }

        createEdge(graph);
        System.out.println("Enter Q ( number of girls ) :");
        int Q = sc.nextInt();

        int distance[] = new int[V];
        int countryId[] = new int[Q];

        boolean visited[] = new boolean[V];

        for( int i = 0; i < Q; i++){ // storing the id's of countries where girl's live
            System.out.println("Enter Countries where girls live :");
            int g = sc.nextInt();
            countryId[i] = g;  // [ 4 5 2 3 ]
        }

        // distance[] = [ 0 1 1 1 2 2 ] // distances of all nodes from node 0.
        // countryId[] =  [ 4 5 2 3 ] // Country id's where only girls live.

        int finalDist[] = new int[Q]; // to store the distances of only countries where girls live
        int min = Integer.MAX_VALUE;

        dfs(graph,visited,distance,0,0);

        for ( int i = 0; i < countryId.length; i++){ // retrieving the distances of nodes 2,3,4,5 to get the shortest distance node

            finalDist[i] = distance[countryId[i]];
            if( distance[countryId[i]] < min ){
                min = distance[countryId[i]]; // to store the shortest distance value of countries where girls live i.e. store the minimum value among [ 2 2 1 1 ].
            }

        }
        // finalDist[] =  [ 2 2 1 1 ]

        int result = Integer.MAX_VALUE;
        for ( int j = 0 ; j < finalDist.length; j++){

            if ( finalDist[j] == min ){

                if ( j < result ){
                    result = j; // to store the minimum countryId, where distance == min, i.e. choice is between countryId ( 2,3 )
                }
            }
        }

        System.out.println( result );

    }
}
