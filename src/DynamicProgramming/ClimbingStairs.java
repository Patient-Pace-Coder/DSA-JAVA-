package DynamicProgramming;

public class ClimbingStairs {

    /*

    we are given 3  stairs , we have to count total number of paths from 0th step to 3rd step.
    here , total number of paths from 0th step to 3rd step is same as number of paths from 3rd step to 0th step.

    we can either take one step or two steps at once.

     */

    private static int climbStairs(int n){ // with recursion

        if( n == 0 ){
            return 1;
        }

        if( n < 0 ){
            return 0;
        }

        int leftRec = climbStairs(n - 1); // if we take one step
        int rightRec = climbStairs( n - 2); // if we take two steps
        int total_paths = leftRec + rightRec;
        return total_paths;

    }

    // Memoization :
    private static int climbStairsMemo(int n, int dp[]){

        if( n == 0 ){
            return 1;
        }

        if( n < 0 ){
            return 0;
        }

        if( dp[n] != -1 ){
            return dp[n];
        }

        int leftRec = climbStairsMemo(n - 1, dp); // if we take one step

        int rightRec = climbStairsMemo(n - 2, dp); // if we take two steps

        dp[n] = leftRec + rightRec;

        return dp[n];

    }

    /*

    steps :

    1. Storage and meaning :
    - here the value stores at each index refers to number of paths from that index to 0.
   2. Direction :
   - as wkt that number of paths from 0 to 0 is 1(do not move,just stay there)
   and we need to find number of paths from 3rd stair to 0th stair. direction is from 0 to 3.

   3. Travel and solve:
   - here wkt, dp[0] = 1, dp[1] = dp[0] + dp[-1]

     */
    private static int climbStairsTabulation(int n, int dp[]){

        dp[0] = 1;
        for( int i = 1; i < dp.length; i++ ){

            if( i == 1 ){ // if not written then for i = 1 , dp[i-2] will be out of bounds.
                dp[i] = dp[i - 1];
            }
            else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }

        return dp[n];

    }

    public static void main(String[] args) {

        int n = 3;
        System.out.println(climbStairs(n));

        int dp[] = new int[n + 1];
        for( int i =0; i < dp.length; i++){
            dp[i] = -1;
        }
        System.out.println(climbStairsMemo(n,dp));
        System.out.println(climbStairsTabulation(n,dp));
    }
}
