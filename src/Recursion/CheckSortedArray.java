package Recursion;

public class CheckSortedArray {

    public static boolean sortedArray(int arr[],int idx){

        if(idx == arr.length-1){
            return true;
        }

        if(arr[idx] < arr[idx+1]){
            return sortedArray(arr,idx+1);
        }
        return false;
    }
    public static void main(String[] args) {
        int arr[]={1,2,4,3,9,12};
        System.out.println(sortedArray(arr,0));
    }
}
