package OtherCodes;

import java.util.HashMap;

public class Practice3 {

    public static void main(String[] args) { // not completed
        // count total pairs of hours whose sum is multiple of 24
        // int hours[] = {12,12,30,24,24};
        int hours[] = {72,48,24,3};
        int freq[] = new int[24];
        int count = 0;
        for( int i = 0; i < hours.length; i++ ){
            int currVal = hours[i];
            int reqVal = (24 - (currVal % 24 )) % 24; // last modulo is if currVal is 24 then reqVal = 24 - 24 % 24 = 24 - 0 = 24 but index of freq is from 0 to 23, so we again do module 24 then we get 0.
            if( freq[reqVal] > 0 ){
                count += freq[reqVal];
            }
            freq[currVal % 24]++;
        }
        System.out.println(count);
    }

        // Input: hours = [12,12,30,24,24]
        //
        // Output: 2
        //
        // Explanation:
        //
        // The pairs of indices that form a complete day are (0, 1) and (3, 4).
        //
        //  Example 2:
        //
        // Input: hours = [72,48,24,3]
        //
        // Output: 3
        //
        // Explanation:
        //
        // The pairs of indices that form a complete day are (0, 1), (0, 2), and (1, 2).


}
