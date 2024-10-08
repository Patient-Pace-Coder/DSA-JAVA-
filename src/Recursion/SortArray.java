package Recursion;

import java.util.Arrays;

public class SortArray {

    private static int[] sort(int arr[], int idx){

        if( idx == arr.length - 2 ){

            if( arr[idx] > arr[idx + 1] ){
                int temp = arr[idx + 1];
                arr[idx + 1] = arr[idx];
                arr[idx] = temp;
                return arr;
            }
            else{
                return arr;
            }
        }

        int[] prevRes = sort(arr, idx + 1); // [ 3,5,6,2,1 ]
        
        for( int i = idx + 1; i < prevRes.length; i++ ){
            if( arr[i - 1] < arr[i] ){
                return arr;
            }
            else{
                int temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
            }
            System.out.println(Arrays.toString(arr));
        }
        return arr;

    }

    public static void main(String[] args) {

        int arr[] = {3,5,6,6,2,2,1,1};
        int res[] = sort(arr,0);
        for( int i = 0; i < res.length; i++ ){
            System.out.print(res[i]+" ");
        }
    }
}
