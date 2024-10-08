package SearchAlgorithms.BinarySearch;

public class LowerBound {

    /*

    given an array [1,5,10,31,33,33,35,100], we have to find the lowerBound(32)
    here lowerBound(101) will return 8 as output as there is no element in array >= 101 as arr.length is returned

    lower bound finds : first element >= x
    lower bound finds : number of element < x

    Approach :

    f( index ) = 1   if arr[mid] >= x
                 0   else



   By applying this f function for the given array we get
   [0,0,0,1,1,1,1,1]
   but there is a problem here, as TC of bs is O(logN) and here the transformation of this array takes O(N) time there is no use of this solution
   instead we just convert the mid indexed elements

   so we have converted the problem into the equivalent of finding first occurrence of 1 and we have solved it earlier

     */

    private static int lowerBound( int arr[], int x ){

        int low = 0;
        int hi = arr.length - 1;
        int ans = arr.length; // default

        while( low <= hi ){

            int mid = (low + hi)/2;

            if( check(mid,arr,x) == 1 ){
                hi = mid - 1;
                ans = mid;
                // System.out.println(ans); // for debugging
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }

    private static int check( int mid,int arr[],int x )
    {
        if( arr[mid] >= x ){
            return 1;
        }
        else{
            return 0;
        }
    }
    public static void main(String[] args) {
        // int arr[] = {1,5,10,31,31,33,35,100}; // x = 34 or 32
        int arr[] = {1,2,3,3,3,4,4,6};
        System.out.println(lowerBound(arr,0));
    }
}
