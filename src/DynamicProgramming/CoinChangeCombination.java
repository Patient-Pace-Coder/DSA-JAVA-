package DynamicProgramming;

import java.util.Arrays;

public class CoinChangeCombination {

    /*

    Here we are given an array of coins of different denominations unlimited number of coins, and a total,
    we have to find out the total number of combinations of coins possible whose sum equals the target.

    ex :
    array : [2,3,5] this means that we are given unlimited coins of denominations of 2,3,5.
    sum : 7

    output : 2
    since only 2 combinations possible are (2,2,3) and (2,5)

    if permutations are asked then output is 5, as (2,2,3)(2,3,2)(3,2,2) && (2,5)(5,2) are the possible permutations

    Idea :

    we will use a 1D array here whose length is (targetSum + 1)

    Initially it will look like this :

        0   1   2   3   4   5   6   7  -- refer to the corresponding sum
    [   0   0   0   0   0   0   0   0   ] -- dp[]

    1] Meaning and storage : Here in each cell we store the number of combinations we have for each sum (which is the column number).
    Ex : In dp[0] we store number of combinations we can have using the given coins, whose sum results in 0
         In dp[3] we store number of combinations we can have using the given coins, whose sum results in 3 and so on


    2] direction : as we know smaller sub-problem is at 0 as we can result sum 0 using any number in 1 way i.e. by not using any coin.
    let's us say we have 2 rupee coin and we have to pay amount 0 using it, the number of ways we can pay 0 is 1 i.e by not paying any 2 rupee will result in sum 0.
    and bigger problem is towards 7 as we dont know number of combinations we can pay 7 using these 3 coins.

    3] travel and solve : we travel from 0 to 7 th index.

    Approach :

    first we will solve the array using 2 rupee coin

    first for i = 0 : using 2 rupee coin we have to pay an amount of 0 so we have one way, we represent it using '.'
    therefore,dp[0]=1
    for i = 1 : using 2 rupee coin we have to pay an amount of 1, we cannot pay amount 1 with 2 rupee coin so there are 0 ways to achieve that
    therefore,dp[1]=0
    for i = 2 : using 2 rupee coin we have to pay an amount of 2,
    assume , we have to travel from source 2 to destination 0 using 2, then

                    0 - destination
                '.'/ - there is ony one way
                  0
                  2\ - here 2 because we can only take 2 steps (we only have one 2 rupee coin)
                    2 - source

    from the above diagram, we can see that, from 2 we have travelled a distance of 2 then we reach 0, then from 0 we have one way to reach 0,hence from 2 there is only 1 way to reach 0
    therefore dp[2] = 1, we represent it by '.2' - this representation is for understanding purpose.
    following similar procedure throughout we get,

        0   1   2   3   4   5   6   7  -- refer to the corresponding sum
    [   1   0   1   0   1   0   1   0   ] -- dp[]
        .      .2     .22     .222 - sequence representation

    this implies we can pay sum 4 using 1 way i.e. by paying 2 and 2
    i.e. dp[4] = dp[4] + dp[4 - 2] = 0 + 1 = 1


                        0 - destination
                    '.'/ - there is ony one way
                      0
                    2/
                    2
                    2\ - here 2 because we can only take 2 steps (we only have one 2 rupee coin)
                      4 - source

                      therefore path is '.22'. and so on

     similarly, we now calculate using 3 rupee coin,

     initially it is this way :
        0   1   2   3   4   5   6   7  -- refer to the corresponding sum
    [   1   0   1   0   1   0   1   0   ] -- dp[]
        .      .2     .22     .222 - sequence representation

        now for 3 we start from 3 as no other amounts or sums can be payed or achieved using 3 rupee coin

    first for i = 3 : using 3 rupee coin we have to pay an amount of 3 so we have one way, we represent it using '.3'
    therefore,dp[3] = dp[3] + dp[3 - 3] = 0 + 1 = 1 (.3)

                    0 - destination
                '.'/ - there is ony one way
                  0
                  3\ - here 3 because we can only take 3 steps (we only have one 3 rupee coin)
                    3 - source


                     0 - destination
                '.2'/ - there is ony one way
                  2
                  3\ - here 3 because we can only take 3 steps (we only have one 3 rupee coin)
                    5 - source

    dp[5] = dp[5] + dp[5 - 3] = 0 + 1 = 1 ( .23 )

        0   1   2   3   4   5    6     7  -- refer to the corresponding sum
    [   1   0   1   1   1   1    2     1   ] -- dp[]
        .      .2  .3 .22  .23  .222  .223- sequence representation
                                .33

    similarly calculate for coin 5, we get,

        0   1   2   3   4   5    6     7  -- refer to the corresponding sum
    [   1   0   1   0   1   1    2     2   ] -- dp[]
        .      .2     .22  .23  .222  .223- sequence representation
                                .33   .25

    we return dp[targetSum] = dp[7] = 2.

    ***  Note : we have to use 1D array when repetitions are allowed, here the number of coins are infinite.this is the difference between targetSumSubsets and CoinChange problem.
    This logic avoids permutations and gives us only combinations because we run this array individually for each coin because of which the sequence will be in order of coins
    i.e. the sequence will only be 223,25 i.e. 3's will come only after 2 and 5's will come only after 2 and 3.

     */

    private static int coinChangeCombination( int coins[],int targetSum ){

        int dp[] = new int[targetSum + 1];
        dp[0] = 1;
        for( int coinIdx = 0; coinIdx < coins.length; coinIdx++ ){
            for( int amount = coins[coinIdx]; amount < dp.length; amount++ ){

                dp[amount] = dp[amount] + dp[ amount - coins[coinIdx] ];

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
        int coins[] = {2,5,3,6};
        int targetSum = 7; // coins[] = {2,3,5} output : 2

        targetSum = 10;
        System.out.println(coinChangeCombination(coins,targetSum));
    }
}
