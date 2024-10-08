package Arrays;

import java.util.Arrays;

public class MaxProduct {


    public String maxProduct(int arr[]){

        int maxProduct=0;
        String pairs="";

        for(int i=0;i<arr.length-1;i++){
            for( int j=i+1;j<arr.length;j++){

                if(arr[i]*arr[j]>maxProduct){

                    maxProduct=arr[i]*arr[j];

                   // pairs=Integer.toString(arr[i])+","+Integer.toString(arr[j]);  // optional

                    pairs= arr[i] +","+ arr[j];

                }

            }
        }

       return pairs;



    }
    public static void main(String[] args) {

        MaxProduct obj=new MaxProduct();
        int nums[]={2,7,11,6,15,2,3};
        System.out.println(obj.maxProduct(nums));

    }

}
