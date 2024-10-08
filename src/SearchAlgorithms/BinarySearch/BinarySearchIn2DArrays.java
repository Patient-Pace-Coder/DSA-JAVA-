package SearchAlgorithms.BinarySearch;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BinarySearchIn2DArrays {

    // normal 2D array
    public static int[] search2DArrays(int[][] arr,int target){

        // using for loop

//        for(int i=0;i<arr.length;i++){    O(n^2)
//
//            for(int j=0;j<arr[i].length;j++){
//
//                if(arr[i][j]==target){
//                    return new int[] {i,j};
//                }
//            }
//        }

        // using while loop

        int i=0;
        int j=0;

        while(i< arr.length && j<arr.length){ // optimized

            if(arr[i][j]==target){
                return new int[] {i,j};
            }
            if(j==arr.length-1){
                i++;
                j=j % (arr.length-1); // brackets important as it computes from left to right
            }
            else{
                j++;
            }
        }

        return new int[]{-1,-1};

    }

//     2D array is sorted row wise and column wise
//     Ex :
//        {
//            {10,20,30,40},    here every row is sorted and every column is sorted. so while searching we have element accordingly.
//            {15,25,35,45},    i.e. if the number is 37, then we can completely ignore the 4 th column as every element in it will be greater than 37.
//            {28,29,37,49},    so next, coming to 30 here as 30<37 we can ignore the whole row as all the left side elements of 30 will be <30 & hence <37.
//            {33,34,38,50}     by these kind of steps we reach our target and return (r,c)
//        };
//

    public static int[] binarySearchInSorted2D(int[][] arr,int target){


        // using for loop - O(n^2)

//        for(int i=0;i<arr.length;){ // as usual i represents row
//
//            for(int j=arr.length-1;j>=0;){ // as usual j represents column
//
//                if(i<arr.length) {
//
//                    if (arr[i][j] == target) {
//                        return new int[]{i, j};
//                    } else if (target > arr[i][j]) {
//                        i++; // because it's sorted column wise so target will lie in the same column but in lower rows.
//                    } else if (target < arr[i][j]) {
//                        j--; // because it's sorted row wise so if target is less than it will definitely not lie in that column as it's also sorted column wise
//                        // , and target will lie is previous rows as its sorted row wise, so we decrease column number
//                    }
//                }
//                else{
//                    break;
//                }
//            }
//        }

        // using while loop

        int i=0;
        int j=arr.length-1;

        while(i<arr.length && j>=0){ // optimized O(n)

            if(arr[i][j] == target){
                return new int[] {i,j};
            }
            else if(arr[i][j] > target){
                j--;
            } else if (arr[i][j] < target) {
                i++;
            }
        }

        return new int[] {-1,-1};

    }

    public static void main(String[] args) {

        int[][] arr = {
                {10,20,30,40},
                {50,60,70,80},
                {90,100,110,120},
                {130,140,150,160}
        };

//        System.out.println(Arrays.toString(search2DArrays(arr,40)));

        int[][] arr2 = {
                {10,20,30,40},
                {15,25,35,45},
                {28,29,37,49},
                {33,34,38,50}
        };

        System.out.println(Arrays.toString(binarySearchInSorted2D(arr2,37)));

    }
}
