package DynamicProgramming;

import java.util.Arrays;

public class MinimumCostPath {

    /*

   You are given a maze i.e. a 2D array , you have to find the minimum cost required to reach from 0,0 to n,n.

     */

    /*

    1] Meaning of storage : The value stored in each cell represents minimum cost from that cell to n,n.
    2] since minimum cost from n,n to reach n,n is the value in maze[n][n] itself we start solving from n,n towards 0,0.

     */

    private static int minimumCostPath( int maze[][],int dp[][] ){

        for( int i = maze.length - 1; i >=0; i-- ){
            for( int j = maze[i].length - 1; j >= 0; j-- ){

                if( i == maze.length - 1 && j == maze[i].length - 1 ){ // for last corner cell
                    dp[i][j] = maze[i][j];
                }
                else if( j == maze[i].length - 1 ){ // for last column
                    dp[i][j] = maze[i][j] + dp[i + 1][j];
                }
                else if( i == maze.length - 1 ){ // for last row
                    dp[i][j] = maze[i][j] + dp[i][j + 1];
                }
                else{ // remaining cells
                    dp[i][j] = Math.min( maze[i][j] + dp[i + 1][j], maze[i][j] + dp[i][j + 1] );
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));

        return dp[0][0];

    }

    public static void main(String[] args) {

        int maze[][] = {
                {2,8,4,1,6,4,2},
                {6,0,9,5,3,8,5},
                {1,4,3,4,0,6,5},
                {6,4,7,2,4,6,1},
                {1,0,3,7,1,2,7},
                {1,5,3,2,3,0,9},
                {2,2,5,1,9,8,2}
        };

        int dp[][] = new int[maze.length][maze.length];

        System.out.println(minimumCostPath(maze,dp));
    }
}
