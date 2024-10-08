package Recursion.Patterns;

import java.util.Arrays;

public class PatternPrinting {


    /*

    * * * *
    * * *
    * *
    *

     */
    public static void pattern(int row,int col){

        // 1. Approach

        /*

        here we have an observation i.e.   4 3 2 1
                                         4 * * * *
                                         3 * * *
                                         2 * *
                                         1 *

         here we can observe that the row number will be until 1, so base case is row==0. then, for every row the sum of row number and column number will not be less than or equal to 5.
         so if the sum or row number and column number is less than 5 then we will decrease the row to row-1, and column will again start from 4.

         */

        if(row==0){ // base case
            return;
        }

        if(row + col >= 5){
            System.out.print("* ");
            pattern(row, col - 1);
        }
        else{
            System.out.println();
            pattern(row-1,4);
        }

    }


    public static void pattern1(int row,int col){

        // 1. Approach

        /*

        here we have an observation i.e.   0 1 2 3
                                         4 * * * *
                                         3 * * *
                                         2 * *
                                         1 *

         here we can observe that the row number will be until 1, so base case is row==0. then, for every row the col number is less than row number we will print * and increase the col number by 1..
         so if column number is greater than or equal to row number, then we will decrease the row by 1 (row=row-1), and column will again start from 0.

         */

        if(row==0){ // base case
            return;
        }

        if(col < row ){
            System.out.print("* ");
            pattern1(row, col + 1);
        }
        else{
            System.out.println();
            pattern1(row-1,0);
        }

    }

    public static void pattern2(int row,int col){

/*        inverted triangle of above one.


                                          *
                                          * *
                                          * * *
                                          * * * *

        System.out.print("* ");
        pattern1(row, col + 1); , by just inverting these two lines we will get inverted triangle.

        System.out.println();
        pattern1(row-1,0); , by just inverting these two lines we will get inverted triangle.


        here we have an observation i.e.

                                           0 1 2 3
                                         4 * * * *
                                         3 * * *
                                         2 * *
                                         1 *

        here we will go recursively until (r,c) will be (0,0) and then backtrack to (1,1) and prints a new line, then control goes to (1,0) and print a '*'.
        then control goes to (2,2) and prints a newline, then goes to (2,1) and prints '*', and control goes to (2,0) and prints another '*' and then control goes to
        (3,3) and prints a newline, and then control goes to (3,2) and prints a '*', and so on.

         */

        if(row==0){ // base case
            return;
        }

        if(col < row ){
            pattern2(row, col + 1);
            System.out.print("* ");

        }
        else{
            pattern2(row-1,0);
            System.out.println();

        }

    }


    // By using the same logic of previous codes, we will get bubble sort.

    public static void bubbleSort(int arr[],int row,int col){

        if(row==0){ // base case
            return;
        }

        if(col < row-1 ){

            if(arr[col] > arr[col + 1]){ // Swapping

                int temp = arr[col];
                arr[col] = arr[col+1];
                arr[col+1] = temp;

            }
            bubbleSort(arr,row, col + 1);

        }
        else{
            bubbleSort(arr,row-1,0);
        }

    }

    public static void selectionSort(int arr[],int row,int col,int maxIndex){

        if(row==0){
            return;
        }

        if( col < row){

            if( arr[col] > arr[maxIndex] ){
                maxIndex = col;
            }
            selectionSort(arr,row,col+1,maxIndex);

        }
        else{

            int temp = arr[col-1];
            arr[col-1] = arr[maxIndex];
            arr[maxIndex] = temp;

            selectionSort(arr,row-1,0,0);

        }

    }







    public static void main(String[] args) {

//        pattern(4,4);

//        pattern1(4,0);

//        pattern2(4,0);

//        int arr[] = {3,1,2,4};
//        bubbleSort(arr,4,0);

        int arr[] = {4,3,2,8,1};
        selectionSort(arr,arr.length,0,0);
        System.out.println(Arrays.toString(arr));
    }
}
