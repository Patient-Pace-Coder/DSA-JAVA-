package DynamicProgramming;

import java.util.Arrays;

public class GoldMineQuestion {

    /*
    Given a goldmine i.e. a 2D array,and available units of gold in each mine (cell),
    we have to find the maximum amount of gold we can collect by moving from left end of the mine to right.
    from each cell we can take 3 steps, either right cell,top diagonal cell,lower diagonal cell.
     */

    /*
    1] storage and meaning : in each cell we store the maximum of gold we can get if we start digging from that cell towards right end of the maze.
    2] direction : as we know in the last column we cannot further move towards right, the maximum amount of gold we can get will be the same.
    3] travel and solve : we travel from already known side to unknown side, i.e. from right end to left end.

    Approach :
    1] we solve column wise, the values of the last column will remain as it is
    2] for remaining columns as per the condition we solve, i.e. we check for values in top diagonal,right side,lower diagonal of the next column
    and take the maximum value among them and add it and store.
    3] this continues until loop reaches 0th column.

     */

    private static int goldMine( int mine[][] ){

        int dp[][] = new int[mine.length][mine.length];

        for (int j = mine[0].length - 1; j >= 0; j-- ){ // since we move column wise and solve each column
            for( int i = mine.length - 1; i >= 0; i-- ){ // i represent row and j represent column

                if( j == mine.length - 1 ){ // for last column
                    dp[i][j] = mine[i][j];
                }
                else if( i == 0 ){ // from 0th row we cannot go to top diagonal so only right and lower diagonal available
                    dp[i][j] = mine[i][j] + Math.max(dp[i][j + 1],dp[i + 1][j + 1]);
                }
                else if( i == dp.length - 1 ){ // from last row we cannot go to lower diagonal so only right and top diagonal available
                    dp[i][j] = mine[i][j] + Math.max(dp[i][j + 1],dp[i - 1][j + 1]);
                }
                else{
                    dp[i][j] = mine[i][j] + Math.max(Math.max(dp[i][j + 1],dp[i + 1][j + 1]),dp[i - 1][j + 1]);
                }
            }

        }

        int maxGold = dp[0][0];

        for( int i = 0; i < dp.length; i++ ){
            if( dp[i][0] > maxGold ){
                maxGold = dp[i][0];
            }
        }

        System.out.println(Arrays.deepToString(dp));

        return maxGold;

    }

    public static void main(String[] args) {

        int mine[][] = {
                {0,1,4,2,8,2},
                {4,3,6,5,0,4},
                {1,2,4,1,4,6},
                {2,0,7,3,2,2},
                {3,1,5,9,2,4},
                {2,7,0,8,5,1}
        };

        int dp[][] = new int[mine.length][mine.length];

        System.out.println(goldMine(mine));
    }


}
