package OtherCodes;

import java.util.Scanner;
import java.util.*;

public class Practice15 {

    // private static int minimumCost( int arr[] ){ // 2,7,9,11,4
    //     int ptr = 1;
    //     int cost = 0;
    //     int nextPtr = 0;
    //     int linearCost = 1;
    //     for( int i = 0; i < arr.length && ptr < arr.length ;){
    //         if( arr[ptr] % arr[i] == 0 && arr[ptr] != arr[i] ){
    //             nextPtr = ptr;
    //             cost = arr[i];
    //             arr[ptr] = arr[ptr] + 1;
    //             linearCost = cost;
    //         }
    //
    //     }
    //     return cost;
    // }



    public class Solution {

        // static boolean isAnagram(String a, String b) {
        //     // Complete the function
        //     if( a.length() != b.length() ){
        //         return false;
        //     }
        //     Map<Character,Integer> map1 = new HashMap<>();
        //     for( int i = 0; i < a.length(); i++ ){
        //         if( map1.containsKey(a.charAt(i)) ){
        //             int val = map1.get(a.charAt(i));
        //             map1.put(a.charAt(i), val++);
        //         }else{
        //             map1.put(a.charAt(i), 1);
        //         }
        //     }
        //
        //
        // }


        // public static void main(String[] args) {
        //
        //     Scanner scan = new Scanner(System.in);
        //     String a = scan.next();
        //     String b = scan.next();
        //     scan.close();
        //     boolean ret = isAnagram(a, b);
        //     System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
        // }
    }

    // static int cost(int[] arr) {
    //     return helper(arr, 0, 0);
    // }
    //
    // static int helper(int[] arr, int index, int cost) {
    //     if(index == arr.length - 1) {
    //         return cost;
    //     }
    //
    //     int max = count(arr, index, 0, index);
    //     if(max != 0) {
    //         arr[max] = arr[max] + 1;
    //         if(arr.length - 1 - index < arr[index]) {
    //             return helper(arr, max, cost + arr.length - 1- index);
    //         } else {
    //             return helper(arr, max, cost+arr[index]);
    //         }
    //
    //     } else {
    //         return helper(arr, index+1, cost+1);
    //     }
    // }
    //
    // static int count(int[] arr, int index, int max, int nextIndex) {
    //     if(nextIndex == arr.length -1) {
    //         return max;
    //     }
    //
    //     if(arr[nextIndex+1]%arr[index]==0) {
    //         return count(arr, index, nextIndex+1, nextIndex+1);
    //     } else {
    //         return count(arr, index, max, nextIndex+1);
    //     }
    // }
    public static void main(String[] args) {

        // int arr[] = {2,4,7,11,13,17,19,23,27,25};
        int arr[] = {2,7,9,11,4};
        // int arr[] = {2,4,3,6,7};
        // int arr[] = {3,4,2,5,18,7,38};
        // System.out.println(minimumCost(arr));

    }
}
