package Recursion;

public class Frequency {

    public static int frequency(int[] arr,int target){
        return frequency2(arr,target,0);
    }
    public static int frequency2(int[] arr,int target,int index){ // helper function
        int count=0;
        if(arr[index]==target){
            count++;
        }
        if(index >= arr.length-1){
            return count;
        }
        return count + frequency2(arr,target,index+1);
    }
    public static void main(String[] args) {
        System.out.println(frequency(new int[] {1,2,3,4,2,1,2,2,4,2},2));
    }
}
