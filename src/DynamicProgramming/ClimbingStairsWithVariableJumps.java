package DynamicProgramming;

public class ClimbingStairsWithVariableJumps {

    /*

    The problem is we have to climb from 0th stair to 6th stair.

    Variation is here we are given with variable number of jumps, not fixed.

    we will be given another array which stores the number of jumps we can take from that step.

    i.e. [1,4,5] is the array given then from 0th stair we can take 1 jump
    and from 1th stair we can take 1 || 2 || 3 || 4 jumps.

    we have to return the total number of paths available to climb from 0th stair to nth stair.

     */

    private static int climbStairsVarJumps( int n,int jumps[], int target){

        int countPaths = 0;
        if( n == target ){
            return 1;
        }

        if( n > target ){
            return 0;
        }

        int idx = n;
        for (int i = 1; i <= jumps[idx]; i++) {
            countPaths += climbStairsVarJumps( idx + i,jumps,target);
        }
        return countPaths;

    }

    private static int climbStairsVarJumpsMemo( int n,int jumps[], int target,int dp[]){

        if( n == target ){
            return 1;
        }

        if( n > target ){
            return 0;
        }

        if( n != 0 ){
            return dp[n];
        }

        int idx = n;

        for (int i = 1; i <= jumps[idx]; i++) {
            dp[n] += climbStairsVarJumpsMemo( idx + i,jumps,target,dp);
        }
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

        // int target = 13;

        int dp[] = new int[target + 1];

        // int jumps[] = {5,5,2,4,1,5,9,8,6,3,8,9,1};
       int jumps[] = {2,3,1,2};

        System.out.println(climbStairsVarJumps(0,jumps,4));
//        System.out.println(countPaths);
//        System.out.println(climbStairsVarJumpsMemo(0,jumps,n,dp));
//        System.out.println(climbStairsVarJumpsTab(target,jumps,dp));

    }
}
