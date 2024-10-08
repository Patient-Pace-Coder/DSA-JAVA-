package Recursion;

public class MinimumCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) { // code is good but TLE
        int ans1 = helper(cost,-1,0); // idx -1 because we have to reach 0 by paying so we start from 1 index less and then calculate the value in helper
        int ans2 = helper(cost,0,0); // we should start from idx 1 but for that we have to pay cost[1], we calculate that value in helper
        return Math.min(ans1,ans2);
    }
    private  static int helper( int[] cost, int idx,int rate){
        if( idx == cost.length - 1 ){
            return rate;
        }
        else if( idx > cost.length - 1 ){
            return Integer.MAX_VALUE;
        }
        int oneStep = helper( cost, idx + 1,rate + cost[idx + 1]);
        int twoStep = helper( cost, idx + 2,rate + cost[idx + 1]);
        int currentCost = Math.min(oneStep,twoStep);
        return currentCost;
    }


    public int minCostClimbingStairsOpt(int[] cost) { // TC : O(n) SC : O(n)
        int n = cost.length;
        // Initialize dp array where dp[i] will store the minimum cost to reach step i
        int[] dp = new int[n + 1];  // n+1 because we can step beyond the last element

        // Base cases: Starting from the 0th or 1st step has no initial cost
        dp[0] = 0;
        dp[1] = 0;

        // Fill the dp array by calculating the minimum cost at each step
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        // The answer is the minimum cost to reach the top (which can be step n or n-1)
        return dp[n];
    }

    public int minCostClimbingStairsBest(int[] cost) { // TC : O(n) SC : O(1)
        int n = cost.length;
        int prev2 = 0;
        int prev1 = 0;
        for (int i = 2; i <= n; i++) {
            int current = Math.min(prev1 + cost[i - 1], prev2 + cost[i - 2]);
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }

    public static void main(String[] args) {

        /*

        Input: cost = [10,15,20]
        Output: 15
        Explanation: You will start at index 1.
                - Pay 15 and climb two steps to reach the top.
        The total cost is 15.

         */

        /*

                Input: cost = [1,100,1,1,1,100,1,1,100,1]
        Output: 6
        Explanation: You will start at index 0.
        - Pay 1 and climb two steps to reach index 2.
        - Pay 1 and climb two steps to reach index 4.
        - Pay 1 and climb two steps to reach index 6.
        - Pay 1 and climb one step to reach index 7.
        - Pay 1 and climb two steps to reach index 9.
        - Pay 1 and climb one step to reach the top.
        The total cost is 6.


         */
    }
}
