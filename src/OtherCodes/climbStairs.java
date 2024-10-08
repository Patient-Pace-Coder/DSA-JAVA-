package OtherCodes;

public class climbStairs {

    private static int countPaths( int n ){

        int dp[] = new int[n + 1];

        return countPathsHelper(n,dp);
    }

    private static int countPathsHelper( int n, int dp[] ){

        dp[0] = 1;
        for( int i = 1; i < dp.length; i++ ){

            if( i == 1 ){
                dp[i] = dp[i - 1];
            }
            else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {

        System.out.println(countPaths(4));
    }
}
