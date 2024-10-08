package Recursion.SubsetSubsequenceStringQtns;
import java.util.ArrayList;
import java.util.List;

public class SubsetsWithNonAdjacentElements {


        /*

    we are given an array arr[], we have find the maximum sum of the subarray's which doesn't contain any adjacent elements

    let arr[] = {5,10,10,100}

    Approach :

    - since this question is about subset, every element has two choices, it can include or exclude
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
     */


    private static void generateSubsets(int[] arr, int index, List<Integer> current, List<List<Integer>> subsets) {
        if (index >= arr.length) {
            subsets.add(new ArrayList<>(current));
            return;
        }

        // Exclude the current element and move to the next
        generateSubsets(arr, index + 1, current, subsets);

        // Include the current element and skip the next one
        current.add(arr[index]);
        generateSubsets(arr, index + 2, current, subsets);
        current.remove(current.size() - 1); // backtrack
    }

    private static void subsetsWithNonAdjacentElements( int arr[] ){

        for( int i = 0; i < 2; i++ ){
            System.out.println("Helper for : "+i);
            helper(arr,i,0,new ArrayList<>());
        }
    }

    private static void helper( int arr[], int bool, int idx, List<Integer> currList ){

        if( idx >= arr.length - 1 ){
            if( bool == 0 ){
                System.out.println(currList);
            }else{
                currList.add(arr[idx]);
                System.out.println(currList);
                currList.remove(currList.size() - 1); // backtracking
            }
            return;
        }

        if( bool == 0 ){
            helper(arr, 0, idx + 1,currList);
            helper(arr, 1, idx + 1,currList);
        }
        else{
            currList.add(arr[idx]);
            helper(arr, 0, idx + 1,currList);
            currList.remove(currList.size() - 1); // backtracking
        }
    }
    public static void main(String[] args) {
        // int[] arr = {5, 3, 2, 1, 4, 6};
        int arr[] = {5,10,10,100};
        List<List<Integer>> subsets = new ArrayList<>();
        // generateSubsets(arr, 0, new ArrayList<>(), subsets);
        // SubsetsWithNonAdjacentElements s = new SubsetsWithNonAdjacentElements();
        subsetsWithNonAdjacentElements(arr);


        // Printing the subsets
        // for (List<Integer> subset : subsets) {
        //     System.out.println(subset);
        // }
    }

}
