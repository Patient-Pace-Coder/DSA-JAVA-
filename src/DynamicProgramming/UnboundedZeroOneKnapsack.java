package DynamicProgramming;

import java.util.Arrays;

public class UnboundedZeroOneKnapsack {
    /*

    Same as zero one knapsack problem but only difference is repetition is allowed
    i.e. we have infinite number of elements of given weights and values.

    dp[] is a 1D array because, repetition is allowed here, and also there is no significance of order of weights we put in the bag,
    so there is no problem in following any of the approaches between cc permutation and cc combination, any approach gives same answer.

    Approach :
    1]
    for each allowed weight we calculate the dp array
    i.e. using each weight we calculate and store the maximum value that item can make out of the allowed weight

    OR

    2]
    for each weight we calculate the dp array
    i.e. we calculate and store the maximum value that item can make out of the allowed weight


    1] Storage and meaning : in each cell in a row we store the maximum value an item with some weight can be made out of the allowed weight.
    2] Direction : smaller problem is dp[0] = 0, i.e. any item of some weight cannot make weight 0, so direction is from known to unknown.
    3]] travel and solve : travel from j = 0 to j = 7

     */

    // Combination approach
    private static int ubZeroOneKnapsackCombination( int weights[],int values[],int n,int targetWeight ){

        int dp[] = new int[targetWeight + 1];
        dp[0] = 0;

        for( int allowedWeight = 1; allowedWeight <= targetWeight; allowedWeight++ ){

            for( int weightIdx = 0; weightIdx < n; weightIdx++) {

                if (weights[weightIdx] > allowedWeight) {
                    continue;
                } else {
                    int prevWeights = dp[allowedWeight];
                    int currWeight = values[weightIdx] + dp[allowedWeight - weights[weightIdx]];
                    dp[allowedWeight] = Math.max(prevWeights, currWeight);
                }
            }
            System.out.println(Arrays.toString(dp)); // debugging
        }


        // System.out.println(Arrays.toString(dp));

        return dp[targetWeight];
    }


    // permutation approach :
    private static int ubZeroOneKnapsackPermutation( int weights[],int values[],int n,int targetWeight ){

        int dp[] = new int[targetWeight + 1];
        dp[0] = 0;

        for( int weightIdx = 0; weightIdx < n; weightIdx++) {

            for( int allowedWeight = 1; allowedWeight <= targetWeight; allowedWeight++ ){

                if (weights[weightIdx] > allowedWeight) {
                    continue;
                } else {
                    int prevWeights = dp[allowedWeight];
                    int currWeight = values[weightIdx] + dp[allowedWeight - weights[weightIdx]];
                    dp[allowedWeight] = Math.max(prevWeights, currWeight);
                }
            }
            System.out.println(Arrays.toString(dp)); // debugging
        }


        // System.out.println(Arrays.toString(dp));

        return dp[targetWeight];
    }

    public static void main(String[] args) {
        int weights[] = {2,5,1,3,4};
        int values[] = {15,14,10,45,30};
        int targetWeight = 7;
        int n = weights.length;

        // System.out.println(ubZeroOneKnapsackCombination(weights,values,n,targetWeight));

        System.out.println(ubZeroOneKnapsackPermutation(weights,values,n,targetWeight));
    }

}
