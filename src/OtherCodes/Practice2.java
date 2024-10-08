package OtherCodes;

import java.util.Arrays;

public class Practice2 {

    public static int[] plusOne(int[] digits) {

        if( digits.length > 0 && digits[digits.length - 1] != 9 ){
            digits[digits.length - 1] = digits[digits.length - 1] + 1;
            return digits;
        }


        int sum = 0;
        for( int i = 0; i < digits.length; i++ ){
            sum += digits[i]*Math.pow(10,(digits.length - 1) - i );
        }

        sum++;
        int length = String.valueOf(sum).length();
        digits = new int[length];
        int i = length - 1;
        while( sum > 0 && i >= 0 ){
            digits[i] = sum%10;
            sum = sum/10;
            i--;
        }

        return digits;


    }

    public static void main(String[] args) {

        int arr[] = {5,6,2,0,0,4,6,2,4,9};

        int res[] = plusOne(arr);

        System.out.println(Arrays.toString(res));


    }
}
