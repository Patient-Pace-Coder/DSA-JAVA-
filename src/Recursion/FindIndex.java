package Recursion;

public class FindIndex {

    // given an array [1,2,4,3,9,12] , we have to return the index. the target may or may not exist

    public static int findIndex(int arr[],int target,int index){

        if(index==arr.length){
            return -1;
        }

        if(arr[index]==target){
            return index;
        }
        return findIndex(arr,target,index+1);
    }

    public static void main(String[] args) {
        int arr[]={1,2,4,3,9,12};
        System.out.println(findIndex(arr,13,0));
    }
}


