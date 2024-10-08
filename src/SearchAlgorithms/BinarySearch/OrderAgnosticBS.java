package SearchAlgorithms.BinarySearch;

public class OrderAgnosticBS {

    // For binary search the array is sorted , but sometimes we will not be given if its in ascending order or descending order,
    // so we check the first and last index to know in which way its sorted.

    public static int orderAgnosticBS(int[] arr,int s,int e,int target){

        if(s>=arr.length){
            return -1;
        }

        int mid=s+(e-s)/2;

        boolean isAscending=false;

        if( arr[s] < arr[e]){
            isAscending=true;
        }

        if(isAscending){

            if (target == arr[mid]) {
                return mid;
            } else if (target > arr[mid]) {
                return orderAgnosticBS(arr, mid + 1, e, target);
            } else if (target < arr[mid]) {
                return orderAgnosticBS(arr, s, mid - 1, target);
            }

        }
        else{ // if descending

            if (target == arr[mid]) {
                return mid;
            } else if (target > arr[mid]) {
                return orderAgnosticBS(arr, s, mid-1, target);
            } else if (target < arr[mid]) {
                return orderAgnosticBS(arr, mid+1,e , target);
            }
        }

        return -1;

    }

    public static void main(String[] args) {

        System.out.println(orderAgnosticBS(new int[] {5,4,3,2,1},0,4,2));
    }
}
