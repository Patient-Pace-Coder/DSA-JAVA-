package SearchAlgorithms;

import java.util.Arrays;

public class SearchAlgos {




//    binary search with recursion :

    // for binary search the condition is the array is sorted.
    public static int binarySearch(int[] arr,int s,int e,int target){

            if(s>=arr.length){ // base case
                return -1;
            }

            int mid=s+(e-s)/2;

//      if(s<=e) { // optional base case :

            if (target == arr[mid]) {
                return mid;
            } else if (target > arr[mid]) {
                return binarySearch(arr, mid + 1, e, target);
            } else if (target < arr[mid]) {
                return binarySearch(arr, s, mid - 1, target);
            }
//      }

            return -1; // if target is not found return -1;
    }



//  binary search without recursion i.e. with iteration :

    public static int binarySearchWithItr(int[] arr,int s,int e,int target){

        while (s<=e){

            int mid=s+(e-s)/2;

            if(target==arr[mid]){
                return mid;
            }
            else if(target > arr[mid]){
                s=mid+1;
            } else if (target < arr[mid]) {
                e=mid-1;
            }
        }

        return -1;

    }

//     linear search :
    public static int linearSearch(int[] arr,int target){

        for(int i=0;i<arr.length;i++){
            if(arr[i]==target){
                return i;
            }
        }
        return -1;
    }


//    linear search  in 2D array :
    public static int[] linearSearch2D(int[][] arr,int target){

        for(int i=0;i< arr.length;i++){
            for(int j=0;j<arr[i].length;j++){

                if(arr[i][j]==target){
                    return new int[] {i,j};
                }
            }
        }

        return new int[] {0,0};

    }


    public static void main(String[] args) {

//        System.out.println(binarySearch(new int[] {1,2,3,4,5},0,4,6));

//        System.out.println(linearSearch(new int[] {1,2,3,4,5},0,4,4));

//        System.out.println(binarySearchWithItr(new int[] {1,2,3,4,5},0,4,4));

        int[][] arr= {
                     {1,2,3,4,5},
                     {6,7,8,9,10,12},
                     {13,14,15,16,17,18,19}
                     } ;

        System.out.println(Arrays.toString(linearSearch2D(arr,19)));
    }
}
