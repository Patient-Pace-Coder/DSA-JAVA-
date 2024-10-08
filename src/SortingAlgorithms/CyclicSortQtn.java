package SortingAlgorithms;

import java.util.Arrays;

public class CyclicSortQtn {


    public static int missingNumber(int[] arr){

        for(int i=0;i<arr.length-1;){
            int correctPos=arr[i]-1;
            if(arr[i]!=0) {
                if (arr[i] != arr[correctPos]) {
                    int index = arr[correctPos];
                    int temp = arr[i];
                    arr[correctPos] = temp;
                    arr[i] = index;
                } else {
                    i++;
                }
            }
            else{
                return arr.length-(arr[i]+1);
            }
        }

//
//        for(int i=0;i<arr.length-1;i++){
//            if(arr[i]!=i+1){
//                return arr.length-i;
//            }
//        }

        return -1;
    }


    public static void main(String[] args) {

        System.out.println(missingNumber(new int[] {3,5,4,0,1}));
    }
}
