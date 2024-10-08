package DynamicProgramming;

import java.util.ArrayList;

public class MaximumSumNonAdjacentElements {

    /*

    we are given an array arr[], we have find the maximum sum of the subarray's which doesn't contain any adjacent elements

    let arr[] = {5,10,10,100,5}

    Approach :

    - since this question is about subset, every element has two choices, it can be included or excluded
    here in the above array, there are 5 elements therefore total subsets is equal to 2^5 = 32.
    now, we are also said that subsets must not contain adjacent elements, so we are going to eliminate some subsets,
    i.e. if previous element has been included then the next element must be excluded so if 'y' (in diagram) then it only has 1 choice
    that is 'n' to exclude the current element.
    if previous element has been excluded 'n' (in diagram) then it has two options it can be included or excluded.


    so we can solve using recursion

                    [5,10][5,100] [5]   [10,100][10]  [10] [100] []
            100       /n    y\    /n     y\   n/      n/    y\  n/
                     [5,10]   [5]        [10]        [10]     []
              10        y\  /n          n/            y\      /n
                          [5]           [10]              []
             10            n/           y\                /n
                           [5]                 []
               5             y\                /n
                                       []

                                       WATCH VDO
     */

    /*

    Approach :

    storage and meaning :

    we will use a 2d array as our dp array, in which first row represents inclusion, 2nd row represents exclusion
    In first row, each cell stores the maximum sum of elements (of possible subsets until index j) if that arr[j] is included, where j is the index of arr.
    in the second row, each cell stores the maximum sum of elements (of possible subsets until index j) if that arr[j] is excluded, where j is the index of arr.

    direction of solving :

    wkt, dp[0][0] = 5; as if 5 is included then max sum possible is 5
    and dp[1][0] = 0; if 5 is excluded then max sum possible is 0

    finally our dp[][] looks like

      array elements  5      10        10               100          5       6
            include | 5  |   10  | 15(10+5)      | 110(100+10)    | 20   |   116 |
            exclude | 0  |   5   | 10(max(10,5)) | 15(max(10,15)  | 110  |   110 |

      for 3rd row first column, arr[i] = 10, now if 10 is included then the new sum will be same as previous row's exclude value + arr[i], as previous row's exclude value indicates
      maximum sum of elements of subsets until arr[i-1] th index, with arr[i-1] element being excluded.
      for 3rd row second column, arr[i] = 10, now if 10 is not included then the new sum will be same as maximum of previous column values i.e.
      why only maximum? because we need to calculate the maximum sum of subsets.

      the below code is based on this approach only.

     */

    // private static int maximumSum( int arr[] ){ // [5,10,15,20]
    //
    //     ArrayList<ArrayList<Integer>> finalArraylist = new ArrayList<>();
    //
    //     // for( int i = 0; i < arr.length; i++ ){
    //     //
    //     // }
    //
    //     finalArraylist  = maximumSumHelper(arr,arr[0]);
    //     return 0;
    //
    // }

    // private static ArrayList<ArrayList<Integer>> maximumSumHelper( int arr[], int ele ){
    //
    //     ArrayList<Integer> curList = new ArrayList<>();
    //     curList.add(ele);
    //     for( int i = 1; i < arr.length; i++ ){
    //
    //     }
    //
    //
    // }


    public static void main(String[] args) {

        int arr[] = {5,10,10,100,5,6};
        int inc = arr[0];
        int exc = 0;

        for( int i = 1; i < arr.length; i++ ){
            int ninc = exc + arr[i];
            int nexc = Math.max(inc,exc);

            inc = ninc;
            exc = nexc;
        }

        int ans = Math.max(inc,exc);
        System.out.println(ans);

    }
}
