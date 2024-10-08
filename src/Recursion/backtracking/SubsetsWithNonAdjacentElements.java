package Recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetsWithNonAdjacentElements {


    private static void subsetsWithNonAdjacentElements( int arr[] ){

        for( int i = 0; i < 2; i++ ){
            System.out.println("Helper for : "+i);
            helper(arr,i,0,new ArrayList<>());
        }
    }

    private static void helper( int arr[], int bool, int idx, List<Integer> currList ) {

        if (idx >= arr.length - 1) {
            if (bool == 0) {
                System.out.println(currList);
            } else {
                currList.add(arr[idx]);
                System.out.println(currList);
                currList.remove(currList.size() - 1); // backtracking
            }
            return;
        }

        if (bool == 0) {
            helper(arr, 0, idx + 1, currList);
            helper(arr, 1, idx + 1, currList);
        } else {
            currList.add(arr[idx]);
            helper(arr, 0, idx + 1, currList);
            currList.remove(currList.size() - 1); // backtracking
        }

    }

    public static void main(String[] args) {
        int arr[] = {5,10,10,100};
        subsetsWithNonAdjacentElements(arr);
    }
}
