package SortingAlgorithms;

import java.util.Arrays;

public class SortingAlgos{
    public static void bubbleSort(int[] arr){

        // bubble sorting algorithm

        for(int i=0;i<arr.length;i++){

            // since after each pass(step) the last element is being sorted
            // or the index of the last unsorted element is getting decreased,
            // we no longer check the sorted part of the array. so "j" only goes till length-i.

            boolean isSwapped=false; // to stop comparing if the array is sorted already

            for(int j=1;j< arr.length-i;j++){
                if(arr[j]<arr[j-1]){
                    int temp=arr[j]; // swapping
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                    isSwapped=true;
                }
            }
            if(!isSwapped){ // if no swap occurs in array then it means it's sorted.
                break;
            }
            System.out.print("The sorted array after pass "+(i+1)+" : ");
            System.out.println(Arrays.toString(arr));
        }

        System.out.print("The final sorted array : ");
        System.out.println(Arrays.toString(arr));
    }
    public static void selectionSort(int[] arr){

        // in each pass(step) the largest element is swapped with the last unsorted element.


        for(int i=0;i<arr.length;i++){
            int maxNumIndex=0;
            boolean isExist=false; // if there is no element in unsorted array then it means  the array is sorted.
            for(int j=1;j<arr.length-i;j++) {  // we no longer check the sorted part of the array. so "j" only goes till length-i.
                if(arr[maxNumIndex] < arr[j]) {
                    maxNumIndex = j;
                }
                isExist=true;
            }

            if(!isExist){
                break;
            }

            int temp=arr[maxNumIndex];
            arr[maxNumIndex]=arr[arr.length-i-1]; // we need to swap the largest element with the last unsorted element i.e. with  index=length-i-1;
            arr[arr.length-i-1]=temp;

            System.out.print("The sorted array after pass "+(i+1)+" : ");
            System.out.println(Arrays.toString(arr));

        }

        System.out.print("The final sorted array : ");
        System.out.println(Arrays.toString(arr));

    }

    public static void insertionSort(int[] arr){

        // for every index:
        // put that index element at the correct index of the LHS (sorted part/sorted sub array)
        // here j=1 means sort all the elements till index 1, and j=2 means sort all the elements till index 2.....and so on.

        for(int i=0;i<arr.length-1;i++){ // i only till arr.length-1 as j=i+1;
            for(int j=i+1;j>0;j--){
                if (arr[j] < arr[j-1]) { // swapping
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
                else {
                    break;
                }
            }
            System.out.print("The sorted array after pass "+(i+1)+" : ");
            System.out.println(Arrays.toString(arr));
        }
        System.out.print("The final sorted array : ");
        System.out.println(Arrays.toString(arr));
    }


    // Note: if in any question we find given numbers from range [0,n] .... then we have to use cycleSort algo.

    public static void cycleSort(int[] arr){

        // here we will be given index=value-1; i.e. the value of element at that index will be index+1.
        // so array would be [1,2,3,4,5]

        int count=0;

        for(int i=0;i<arr.length;){ // instead of this for loop we can also use while loop.
            int correctPos=arr[i]-1;
            if(arr[i]!=i+1){ /* (or arr[i]!= arr[correctPos] will also work) */  // checking if the element at arr[i] is at its correct position or not.
//                int j=i; no need
                int index=arr[correctPos];
                int temp=arr[i];
                arr[correctPos]=temp;
                arr[i]=index;
//                i=j; // since we have to check if element with which we have swapped is in its correct position or not, so we dont change the index. but since in for loop we didn;t provide any condition, 'i' value will remain same.
                System.out.print("The sorted array after pass "+(++count)+" : ");
                System.out.println(Arrays.toString(arr));
            }
            else{
                i++; // if the element is in correct position then we move to check the next index element.
            }
        }
        System.out.print("The final sorted array : ");
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr,int low,int high) {

        // intuition :
 /*
        to place the pivot at its correct position for each pass or each new pivot.
        here initially first element will be the pivot so we place it in the correct position (using the two pointer approach).
        similarly in left and right sub arrays the first element will be the pivot, so we place it in its correct position
        so eventually every element will be the pivot and every element is being placed at its correct position, and hence array is sorted.

  */

        if(low>=high){ // if low=high that implies there is only one element in the array and low>high means that the array is empty
            return;
        }

//        low and high : tells us which part of the array we are working on
//        start and end : it's used for swapping the elements, at start and end indexes

//        pivot can be selected in 4 ways:
//        - either first one
//        - either last one
//        - randomly choosing any element from the array
//        - or middle element of the array

        int start = low;
        int end = high;
        int mid = start + (end - start) / 2;

        int pivot = arr[mid]; // here we choose pivot as the middle element

        while (start <= end) { // if start > end then it implies the pivot is at its correct position
            while (arr[start] < pivot && start < high) { // checks for start index
                start++;
            }

            while (arr[end] > pivot && end > low) { // checks for end index
                end--;
            }

            if (start <= end) { // if start > end then it implies the pivot is at its correct position
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++; // after swapping the start is incremented and end is decremented
                end--;
            }
        }

            quickSort(arr, low, end); // checks the left sub array
            quickSort(arr, start, high);// checks the right sub array

    }


    // merge sort : both are kk's implementations

    // 1 way of implementation : return type array (here original array is not being modified but a new array with the same elements is being returned)
    static int[] mergeSort(int[] arr) {
        if (arr.length == 1) { // as a single element is sorted itself
            return arr;
        }

        int mid = arr.length / 2;

        // here for both left and right subarrays mid is passed because start is included and end is excluded.
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid)); // copyOfRange will create a sub-array with the provided indices (included,excluded)
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    private static int[] merge(int[] first, int[] second) {
        int[] mix = new int[first.length + second.length];

        int i = 0; // pointer for first array
        int j = 0; // pointer for second array
        int k = 0; // pointer for max array that i.e. the main array to which the first and second array elements are being merged .

        // loop which checks the elements of both arrays and sorts the elements in the mix array
        while (i < first.length && j < second.length) { // loop runs till the end of lowest length array
            if (first[i] < second[j]) {
                mix[k] = first[i];
                i++;
            } else {
                mix[k] = second[j];
                j++;
            }
            k++;
        }

        // it may be possible that one of the arrays is not complete, if both the arrays of different size then some elements of the largest array will be left behind
        // copying the remaining elements

        // out of these two while loops only 1 will run as any one array can be greater than other array.
        while (i < first.length) {
            mix[k] = first[i];
            i++;
            k++;
        }

        while (j < second.length) {
            mix[k] = second[j];
            j++;
            k++;
        }

        return mix;
    }


    // 2nd way of implementation : In place algorithm

    static void mergeSortInPlace(int[] arr, int s, int e) {
        if (e - s == 1) {
            return;
        }

        int mid = (s + e) / 2;

        mergeSortInPlace(arr, s, mid);
        mergeSortInPlace(arr, mid, e);

        mergeInPlace(arr, s, mid, e);
    }

    private static void mergeInPlace(int[] arr, int s, int m, int e) {
        int[] mix = new int[e - s];

        int i = s;
        int j = m;
        int k = 0;

        while (i < m && j < e) {
            if (arr[i] < arr[j]) {
                mix[k] = arr[i];
                i++;
            } else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        // it may be possible that one of the arrays is not complete
        // copy the remaining elements
        while (i < m) {
            mix[k] = arr[i];
            i++;
            k++;
        }

        while (j < e) {
            mix[k] = arr[j];
            j++;
            k++;
        }

        for (int l = 0; l < mix.length; l++) {
            arr[s + l] = mix[l];
        }

    }


    public static void main(String[] args) {
//        bubbleSort(new int[] {5,4,3,2,1});

//        selectionSort(new int[] {5,1,2,3,4});

//        insertionSort(new int[] {5,3,4,1,2});

//        cycleSort(new int[] {3,5,2,1,4});

        int[] arr={10,3,2,7,4,5,8,9,1};

//        quickSort(arr,0,arr.length-1);

//        mergeSortInPlace(arr,0,arr.length);

        int ans[]=mergeSort(arr);
        System.out.println(Arrays.toString(ans));

    }
}
