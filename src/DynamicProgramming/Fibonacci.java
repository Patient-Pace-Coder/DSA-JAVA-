package DynamicProgramming;

public class Fibonacci {

    private static int memoizationFibo( int n , int dp[]){

        // Space complexity : O(N)+ O(N) : Array space + stack space
        // Time complexity : O(N) ( linear function call from ( n to 0 )

        if( n <= 1 ){
            return n;
        }

        if( dp[n] != -1 ){
            return dp[n];
        }

        dp[n] = memoizationFibo(n - 1,dp) + memoizationFibo(n - 2,dp);
        return dp[n];
    }

    private static int tabulationFibo( int n,int dp[]){

        // Space complexity : O(N) : Array space
        // Time complexity : O(N) ( as we use array for calculating ), can be optimized to O(1).

        // wkt
        dp[0] = 0;
        dp[1] = 1;

        for( int i = 2; i < dp.length; i++ ){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    private static int tabulationFiboOptimized( int n,int dp[] ){

        // Space complexity : O(N) : Array space, and no recursion stack space
        // Time complexity : O(1) ( as we have eliminated the array ), can be optimized to O(1).

        // wkt
        int prev2 = 0;
        int prev = 1;

        for( int i = 2; i < dp.length; i++ ){
            int curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }



    public static void main(String[] args) {

        int n = 8;
        int dp[] = new int[n + 1];
        for( int i =0; i < dp.length; i++ ){
            dp[i] = -1;
        }
//        System.out.println(memoizationFibo(n, dp));
//        System.out.println(tabulationFibo(n,dp));
        System.out.println(tabulationFiboOptimized(n,dp));


    }
}
