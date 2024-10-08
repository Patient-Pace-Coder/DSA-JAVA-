package DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;

public class ZeroOneKnapsack {

    /*

    Description :
    Here we are given n elements with their weights and corresponding value or worth and a bag which can hold up-to m units of weight.
    we have to find the maximum one can make by putting these elements in the bag without exceeding the weight the bag can hold.

    ex :   given weights - values :  2 - 15,5 - 15,1 - 10,3 - 45,4 - 30, target weight = 5
           output : 50 as 2 + 3 = 50 > 1 + 4 = 40

    same approach as usual :

                            weights allowed
                |weights| 0   1   2   3   4   5   6   7
                |   x   | 0   0   0   0   0   0   0   0             x : 0 batsman
                |   2   | 0   0   15  15  15  15  15  15
                |   1   | 0   10  15  25  15  25  25  25
                |   5   | 0   10  25  25  15  25  25  29
                |   3   | 0   10  25  45  55  70  70  60
                |   4   | 0   10  25  45  55  70  70  75

    therefore the final output is 75.

    consider 'weights' as number of batsman batting and 'weights allowed' as number of batsman allowed to bat.
    1] Storage and meaning : in each cell we store the maximum number of runs i(row number) number of batsmen score if j(column) number of batsman are allowed to bat.
    2] Direction: smaller problem is, any i number of batsman will score 0 runs if no batsman(j) is allowed to bat
    3] Travel and solve : we travel from 0 to 7

    let's understand for i = 5 , and follow similar process for rest of the rows,

    i = 5, j = 0 : 0 runs
    i = 5,j = 1 : 5 have two choices, either he can bat or he cannot
    - if he doesnt bat then the rest of the team score 10 runs (dp[i -1][j] = 10),
    - if 5 bats then he cannot score any run because maximum allowed batsman are 1
    similarly until j = 4 dp[i][j] = dp[i - 1][j].
    when i = 5, j = 5 : 5 have two choices, either he can bat or he cannot
    - if he doesnt bat then the rest of the team score 25
    - if he bats then he scores 14 runs and rest of the team will score 0 runs. therefore total runs team scores if he bats 0 + 14 = 14
    i.e. ( max allowed - current number of batsman ) = 5 - 5 = 0, dp[i - 1][0] = 0 runs
    -  since 25 > 14 its better that 5 doesnt bat, so we put 25 there


     */

    private static int zeroOneKnapsack( int weights[],int values[],int n,int targetWeight ){

        int dp[][] = new int[n + 1][targetWeight + 1];


        for( int weightIdx = 0; weightIdx <= n; weightIdx++){
            for( int allowedWeight = 0; allowedWeight <= targetWeight; allowedWeight++ ){

                if( weightIdx == 0 || allowedWeight == 0){ // as first row and first column values are 0
                    dp[weightIdx][allowedWeight] = 0;
                }
                else if( weights[weightIdx - 1] <= allowedWeight ){
                    int valueIfExcluded = dp[weightIdx - 1][allowedWeight];
                    int valueIfIncluded = values[weightIdx - 1] + dp[weightIdx - 1][allowedWeight - weights[weightIdx - 1]];
                    dp[weightIdx][allowedWeight] = Math.max(valueIfExcluded,valueIfIncluded);
                }
                else{
                    dp[weightIdx][allowedWeight] = dp[weightIdx - 1][allowedWeight];
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));

        return dp[weights.length][targetWeight];
    }

    public static void main(String[] args) {
        int weights[] = {2,5,1,3,4};
        int values[] = {15,14,10,45,30};
        int targetWeight = 7;
        int n = weights.length;

        System.out.println(zeroOneKnapsack(weights,values,n,targetWeight));
    }
}
