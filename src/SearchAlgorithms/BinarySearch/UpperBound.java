package SearchAlgorithms.BinarySearch;

public class UpperBound {

    /*

    upper bound finds : first element > x
    upper bound finds : number of element <= x

     */

    private static int upperBound( int arr[], int x ){

        int low = 0;
        int hi = arr.length - 1;
        int ans = arr.length; // default

        while( low <= hi ){

            int mid = (low + hi)/2;

            if( check(mid,arr,x) == 1 ){
                hi = mid - 1;
                ans = mid;
                System.out.println(ans);
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }

    private static int check( int mid,int arr[],int x )
    {
        if( arr[mid] > x ){
            return 1;
        }
        else{
            return 0;
        }
    }
    public static void main(String[] args) {
        // int arr[] = {1,5,10,31,31,33,35,100}; // x = 34 or 32
        int arr[] = {1,2,3,3,3,4,4,6};
        System.out.println(upperBound(arr,3));
    }
}
