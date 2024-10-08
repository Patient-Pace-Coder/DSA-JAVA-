package Arrays;
import java.util.Arrays;

public class TwoSum {

//    public void pairs(int arr[],int sum){
//
//        for(int i=0;i<arr.length-1;i++){
//            for( int j=i+1;j<arr.length;j++){
//                if(arr[i]+arr[j]==sum){
//                    System.out.println("["+i+","+j+"]");
//                    break;
//                }
//
//            }
//        }
//
//    }


    public int[] pairs(int arr[],int sum){

        for(int i=0;i<arr.length-1;i++){
            for( int j=i+1;j<arr.length;j++){
                if(arr[i]+arr[j]==sum){
                    return new int[] {i,j};
                }

            }
        }

        throw new IllegalArgumentException("No solution found!!");

    }

    public static void main(String[] args) {

        TwoSum obj=new TwoSum();
        int nums[]={2,7,4,6,15,2,3};
        System.out.println(Arrays.toString(obj.pairs(nums,11)));

    }
}
