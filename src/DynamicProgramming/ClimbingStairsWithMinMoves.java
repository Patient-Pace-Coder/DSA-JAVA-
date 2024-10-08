package DynamicProgramming;

import java.util.Arrays;

public class ClimbingStairsWithMinMoves {
    /*

    The problem is we have to climb from 0th stair to 6th stair or say nth stair.

    Variation is here we are given with variable number of jumps, not fixed.

    we will be given another array which stores the number of jumps we can take from that step.

    i.e. [1,4,5] is the array given then from 0th stair we can take 1 jump
    and from 1th stair we can take 1 || 2 || 3 || 4 jumps.

    we have to return the minimum number of moves(jumps) with which we can reach from 0th stair to nth stair.

     */

    private static int climbStairsVarJumps( int n,int jumps[], int target, int countMoves ){


        if( n == target ){
            return countMoves;
        }

        if( n > target ){
            // return 0; doesn't work as Math.min(0,something) is always 0.
            return Integer.MAX_VALUE;
        }

        int minMoves = Integer.MAX_VALUE;// minMoves = 0 doesn't work as same reason as above.

        int idx = n;
        for (int i = 1; i <= jumps[idx]; i++) {
            int currMoveCount = climbStairsVarJumps( idx + i,jumps,target,countMoves + 1);

            if( currMoveCount != Integer.MAX_VALUE ){ // if( currMoveCount != 0 ) also doesn't work as currMoveCount will never become 0.
                minMoves = Math.min(currMoveCount,minMoves);
            }

        }

        return minMoves;

    }



    private static int climbStairsVarJumpsMemo( int n,int jumps[], int target,int dp[]){ // yet to complete


        if( n == target ){
            return 0;
        }

        if( n > target ){
            return Integer.MAX_VALUE;
        }

        if( dp[n] != -1 ){
            return dp[n];
        }

        int minMoves = Integer.MAX_VALUE;

        int idx = n;
        for (int i = 1; i <= jumps[idx]; i++) {
            int currMoveCount = climbStairsVarJumpsMemo( idx + i,jumps,target, dp);

            if( currMoveCount != Integer.MAX_VALUE ){
                minMoves = Math.min(minMoves,currMoveCount + 1);
            }
        }

        dp[n] = minMoves;
        return dp[n];

    }


    private static int climbStairsVarJumpsTab( int n,int jumps[], int dp[]){


        dp[n] = 1;

        for( int i = n - 1; i >= 0; i-- ){

            for( int j = 1; j <= jumps[i]; j++ ){

                if( i + j > n ){
                    dp[i] += 0;
                }else {
                    dp[i] += dp[i + j];
                }
            }
        }

//        for( int i = 0; i < dp.length;i++ ){ // debugging
//            System.out.print(dp[i]+" ");
//        }
//        System.out.println();


        return dp[0];

    }

    public static void main(String[] args) {

        int target = 4;

//        int target = 13;

        int dp[] = new int[target + 1];

        Arrays.fill(dp,-1);

//        int jumps[] = {5,5,2,4,1,5,9,8,6,3,8,9,1};
        int jumps[] = {2,3,1,2};

//        System.out.println(climbStairsVarJumps(0,jumps,target,0));
//        System.out.println(countPaths);
        System.out.println(climbStairsVarJumpsMemo(0,jumps,target,dp));
//        System.out.println(climbStairsVarJumpsTab(target,jumps,dp));

    }
}
