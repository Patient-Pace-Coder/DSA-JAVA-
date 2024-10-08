package Arrays;
import java.util.*;

// find missing number between 1- 100

public class MissingNumber {


    public int missingNumber(int arr[]){


        //  brute force soln

//        for(int i=1;i<=arr.length;i++){
//            Boolean isPresent=false;
//            if(arr[i-1]==i){
//                isPresent=true;
//            }
//            if(!isPresent){
//                return i;
//            }
//        }
//
//        return -1;


        // algorithm

        int sum1=0;
        int sum2=0;
        for(int i:arr){
            sum1+=i;
        }
        sum2=(arr.length+1)*((arr.length+1)+1)/2;  // sum of n terms formula

        return sum2-sum1;
    }


    public static void main(String[] args) {

        MissingNumber num=new MissingNumber();
        int arr[]={1,4,3,6,2,8,5,9,10};
        Arrays.sort(arr);
        System.out.println(num.missingNumber(arr));



    }
}
