package SearchAlgorithms.BinarySearch;

public class PeakFinding {

    /*

    Bitonic arrays :
    arrays which increase until some index and then decrease till the end are called bitonic arrays

    we are given a bitonic array and we have to return the index of the peak element i.e. the first element where array started to increase
    ex : [1,5,9,11,9,2,1]
    here the array started to increase from index 3 i.e. from 11 so output is 3

    task is to find the checker function condition

    if checker( arr[x] < arr[x + 1]
        return 0
    else
        return 1

     */

    private static int findPeak( int arr[] ){

        int lo = 0;
        int hi = arr.length - 1;
        int ans  = -1;// default case if there is no peak i.e. actually it doesn't matter here as for ascending order peak is n - 1 and for descending order peak is 0.

        while( lo <= hi ){

            int mid = (lo + hi)/2;

            if( check( arr,mid) == 1 ){
                ans = mid;
                hi = mid - 1;
            }
            else{
                lo = mid + 1;
            }
        }
        return ans;
    }

    private static int check( int arr[], int mid ){

        if( mid == arr.length - 1 ){ // for descending order case
            return 1;
        }
        else if( arr[mid] < arr[mid + 1] ){
            return 0;
        }
        else {
            return 1;
        }
    }

    public static void main(String[] args) {

        // int arr[] = {1,5,9,11,9,2,1};
        // int arr[] = {1,2,3,4,5,6,7,8};
        // int arr[] = {1,1,1,1,1,1,1};
        int arr[] = {5,6,6,7,2,1};
        System.out.println(findPeak(arr));
    }
}
