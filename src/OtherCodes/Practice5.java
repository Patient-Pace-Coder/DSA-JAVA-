package OtherCodes;

import java.util.Arrays;

public class Practice5 {

    private static double floatReturn( int[] nums ){

        Arrays.sort(nums);
        double averages[] = new double[nums.length/2];
        int j = nums.length - 1;
        double minValue = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length/2; i++ ){
            double val =  (double) (nums[i]+nums[j])/2;
            averages[i] = val;
            j--;
        }

        for( int i = 0; i < averages.length; i++ ){

            if( averages[i] < minValue ){
                minValue = averages[i];
            }
        }
        return minValue;
    }

    public static void main(String[] args) {

//        int nums[] = {7,8,3,4,15,13,4,1}; // [15,13,8,7,4,4,3,1]
        int nums[] = {4,5,5,7};

        System.out.print(floatReturn(nums));

//        for(int i = 0; i < averages.length; i++ ){
//            if( averages[i] % 1 != 0 ){
//                System.out.print(averages[i]);
//                break;
//            }
////            System.out.println(averages[i] + " ");
//        }
    }
}
