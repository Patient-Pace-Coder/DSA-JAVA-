package SearchAlgorithms.BinarySearch;

public class LowerAndUpperBound {

    /*

    let's say we are given an array [0 0 0 0 0 0 1 1] we have to find the index of first occurrence of 1

     */

    // general binary search implementation for [0 0 0 0 0 0 1 1]

    private static int bs( int arr[] ){

        int low = 0;
        int hi = arr.length - 1;
        int ans = 0;
        while( low <= hi ){

            int mid = (low + hi)/2; // low + (hi - low)/2
            if( arr[mid] == 1 ){
                ans = mid;// store the answer index
                hi = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
         int arr[] = {0,0,1,1,1,1,1,1};
        System.out.println(bs(arr));
    }
}

