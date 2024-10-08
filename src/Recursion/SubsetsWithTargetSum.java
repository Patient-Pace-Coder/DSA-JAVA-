package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithTargetSum {



    private static void subsetsWithTargetSum( int arr[], int target ){

        helper(arr,target,0,new ArrayList<>());
    }

    private static void helper(int arr[], int target, int idx, List<Integer> list ){

        if( idx >= arr.length ){
            int sum = 0;
            for( int ele : list ){
                sum += ele;
            }
            if( sum == target ){
                System.out.println(list);
            }
            return;
        }
        helper(arr,target,idx + 1,list);
        list.add(arr[idx]);
        helper(arr,target,idx + 1,list);
        list.remove(list.size() - 1); // backtracking step
    }

    private static void subsetsWithTargetSumOpt( int arr[] , int target ){

        Arrays.sort(arr);
        int i = 0;
        int j = arr.length - 1;
        int sum = 0;
        while( i < j ){
            sum = arr[i] + arr[j];
            if( sum == target ){
                System.out.println("["+arr[i]+","+" "+arr[j]+"]");
                i++;
                while ( arr[i] == arr[i - 1] ){
                    i++;
                }
            }
            else if( sum < target ){
                i++;
            }
            else {
                j--;
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        int target = 5;
        // subsetsWithTargetSum(arr,target);
        subsetsWithTargetSumOpt(arr,target);
    }
}
