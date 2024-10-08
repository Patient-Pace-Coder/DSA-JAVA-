package SearchAlgorithms.BinarySearch;

public class RotatedArray {

    /*

    the actual array : [1,2,3,5,9]

    given elements are distinct

    rotated once : [9,1,2,3,5]
    rotated twice : [5,9,1,2,3]
    rotated thrice : [3,5,9,1,2]
    rotated 4 times : [2,3,5,9,1]
    rotated 5 times : [1,2,3,5,9]

    here is the question we will be given a rotated array and we need to find out how many rotations has been done to get this array
    ex :
    if input arr[] = [3,5,9,1,2] we have to return 3 as output as it is obtained by rotating the array thrice.


    approach :

    we use the concept of binary search and write a checker function
    here in [3,5,9,1,2] we have to somehow find the index of 1 i.e. (3 here) and it will be the answer.

     i.e. we have to convert the array into [0,0,0,1,1]

     checker function we have to write is if( arr[x] < arr[0] ) return 1; else return 0;
     here arr[0] = 3; x refers to all the elements in the array

     */

    private static int rotatedArray( int arr[] ){

        int low = 0;
        int hi = arr.length - 1;
        int ans = 0; // default as if array is [1,2,3,5,9] then after transforming array will be [0,0,0,0,0] so we have to return 0

        while( low <= hi ){
            System.out.println(low);
            int mid = (low + hi)/2;

            if( check(mid,arr) == 1 ){
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

    private static int check( int mid,int arr[] )
    {
        if( arr[mid] < arr[0] ){
            return 1;
        }
        else{
            return 0;
        }
    }
    public static void main(String[] args) {
        // int arr[] = {3,5,9,1,2};
        int arr[] = {1,2,3,5,9};
        System.out.println(rotatedArray(arr));
    }
}
