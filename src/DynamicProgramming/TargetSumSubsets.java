package DynamicProgramming;

import java.util.Arrays;

public class TargetSumSubsets {

    /*
    Here we will be given an array, and we have to find if there exists any subsets of
    that array whose sum of elements result in a particular target sum.

    Note: total subsets in an array of n elements is 2^n. as for each element there are two possibilities either to be included in that subset or not.

    ** while solving the problem using pen and paper as we are using tabulation method to solve the problem.
    - write down values in the given array beside the 2D array, since this is a subset question we have to include an empty set on top of everything.
    - write the values from 0 to given sum, as using that table we compute the value of all cells of the dp array.

    1] storage and meaning : in each cell we store if the elements in that subset can make that particular sum
      As we go down the next element in that array gets added to the subset

            sums
 elements   0   1   2   3   4   5       Array       subsets
      []    Y   N   N   N   N   N        []            []
      1     Y   Y   N   N   N   N        [1]          [][1]
      2     Y   Y   Y   Y   N   N       [1,2]       [][1][2][1,2]
      3     Y   Y   y   Y   Y   Y       [1,2,3]     [][1][2][3][1,2][1,3][2,3][1,2,3]

      1st row represents array is empty,2nd row represents array has only 1 element,3rd row represents array has 2 elements and so on.
      sum 0 is common for every subset as every array has empty subset and hence every subset can result in sum 0.
      1st row : Now, since initially the array is empty, we can only achieve sum 0 and not other sums so all the values in that row are N except 0.
      2nd row : Now, since there is 1 element in the array we can only achieve sum 1, and nothing else
      3rd row : since there are two elements 1,2 we can produce the sums 1,2,3 and nothing else.
            Thought process :
            for sum 1 :
            current element is 2 :
            there are two options for 2 either it can be included in making the sum or not
                if it is included : as 2 is included, we cant produce sum 1 if 2 is included so ignore it.
                if it is not included : as 2 is not included, we should produce sum 1 with the help of remaining elements i.e. 1,
                so to know if we can produce sum 1 with the help of 1 we check for previous row,since the previous row of same column stores the value of 1 producing the sum 1, if its a yes then current value is also a yes.
            and so on............................

    Note : Here repetition is not allowed therefore we use 2D array

     */

    private static boolean targetSum( int nums[], int targetSum ){

        boolean dp[][] = new boolean[nums.length][targetSum + 1];

        for( int i = 0; i < dp.length; i++ ){
            for( int j = 0; j < dp[i].length; j++ ){

                if( j == 0 ){ // as sum 0 can be achieved by any subset
                    dp[i][j] = true;
                }
                else if ( i == 0 ) {
                    if( nums[i] == j ){
                        dp[i][j] = true;
                    }
                    else{
                        dp[i][j] = false;
                    }
                }
                else if ( dp[i - 1][j] ) {
                    dp[i][j] = true;
                }
//                else if( nums[i] == j ){ // if element in array equal to sum then sum can be directly achieved,s o it is marked true.
//                    dp[i][j] = true;
//                }
                else if( j < nums[i] ){ // if same sum value in previous row is true (i.e. can be achieved) then it will remain true in this row too.
                    dp[i][j] = dp[i - 1][j];
                }
                else{
                    dp[i][j] = dp[i - 1][j - nums[i]];
                }
            }

        }

        System.out.println(Arrays.deepToString(dp));

        return dp[nums.length - 1][targetSum];
    }


    public static void main(String[] args) {

        int nums[] = {4,2,7,1,3};
        int targetSum = 10;

        System.out.println(targetSum(nums,targetSum));
    }
}
