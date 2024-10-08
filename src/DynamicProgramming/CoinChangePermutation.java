package DynamicProgramming;

import java.util.Arrays;

public class CoinChangePermutation {

    /*

    Here we are given an array of coins of different denominations unlimited number of coins, and a total,
    we have to find out the total number of permutations of coins possible whose sum equals the target.

    ex :
    array : [2,3,5] this means that we are given unlimited coins of denominations of 2,3,5.
    sum : 7

    output : 5
    since only combinations possible are (2,2,3)(2,3,2)(3,2,2) and (2,5)(5,2)

    Same as previous problem of combinations,but small changes as we need permutations instead of combinations

    earlier to reach from 3 to 0 using any 2 or 3 or 5 rupee coin we were taking 2 or 3 or 5 steps at once

                    0 - destination
                '.'/ - there is ony one way
                  0
                  2\ - here 2 because we can only take 2 steps (we only have one 2 rupee coin)
                    2 - source

     but here, we take 3 steps simultaneously

                    0 - destination
                '.'/
                  0   -1  -3
                  2\  /3 /5
                     2 - source

     i.e. dp[i] = dp[i - 2] + dp[i - 3] + dp[i - 5]
     i.e. dp[2] = dp[0] + dp[-1] + dp[-3] = 1

     This will result the paths to be in permutations

     Note : Here we use a 1D array as repetitions are allowed, this is the difference between targetSumSubsets and CoinChange problem

     */

    private static int coinChangePermutations( int coins[],int targetSum ){
        int dp[] = new int[targetSum + 1];
        dp[0] = 1;
        for( int amt = 1; amt < dp.length; amt++ ){
            for( int coin : coins ){
                if( amt - coin < 0 ){
                    dp[amt] += 0;
                }
                else {
                    dp[amt] = dp[amt] + dp[amt - coin];
                }
            }
        }

        // System.out.println(Arrays.toString(dp)); // debugging

        if( dp[targetSum] > 0 ){
            return dp[targetSum];
        }
        else{
            return -1;
        }
    }

    public static void main(String[] args) {

        int coins[] = {2,3,5};
        int targetSum = 7;

        System.out.println(coinChangePermutations(coins,targetSum));
    }
}
