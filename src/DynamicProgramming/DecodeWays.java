package DynamicProgramming;

import java.util.Arrays;

public class DecodeWays {

     /*

    given any string say '1123' and also given a = 1 , b = 2 ,...... z = 26.

    we have to print total number of encodings possible using that string.
    i.e.

    String =  "1123" , output : the total number of encodings = 5

    Explanation :

    aabc : a = 1, a = 1, b = 2, c = 3
    kbc : k = 11, b = 2, c = 3
    alc : a = 1, l = 12, c = 3
    aaw : a = 1, a = 1, w = 23
    kw : k = 11, w =23

    intuition : intuition for recursion,

                                1123            1/a : 1 is chosen , below 1/a 123 is remaining string when 1 is chosen from 1123
                           1/a        11\k
                                         23
                         123         2/b  23\w
                      1/a    12\l     3    "kw"
                      23       3     3/c
                    2/b 23\w   3\c   "kbc"
                    3   "aaw"  "alc"
                   3/c
                 "aabc"

                 while choosing the processed string the string value should be <= 26 since we need to add a character corresponding to the processed string.

     Approach using dp :

     1] meaning and storage : in each cell we store the total number of ways we can store the decoding of string of length i.
                                    1   1   2   3 -- characters in the given string
     i.e. let dp[] look like, [ 1   1   2   3   5 ]
                                0   1   2   3   4 - index ( indicates length )

     then that implies that total ways of decoding string of length index if the string is from 0th index to ith index.
     i.e. for string of length 3 i.e. "112" there are 3 ways of decoding it they are "1 1 2","11 2","1 12"

     dp[] :       | 1  |    1  |     2  |     3  -- characters in the given string
           [  1   | 1  | 1 + 1 | 2 + 1  | 3 + 2 ]
              0   | 1  |   2   |   3    |  4 -- index
      ------------| ---|-------|--------|------------------
                  | a  |   aa  |  aab   | aabc
                  |    |    k  |   kb   |  kbc
                  |    |       |   al   |  alc
                  |    |       |        |  aaw
                  |    |       |        |  kw

     2] direction : since we know that dp[0] = 1, we move in the direction of 0 to n - 1.
     3] travel and solve : we travel from index 0 to last index

     Approach :

     since the only valid strings are of length 1 if the string's value is between 1-9
     and are of length 2 if the string's value is between 10 - 26.
     So, there are two cases
     1] for length 1 : string.charAt(i) is valid then dp[i] = dp[i - 1] ( since we can add character at i at the end of strings at dp[i - 1] )
     2] for length 2 : if string.substring(i-1,i+1) i.e. string.charAt(i-1)+string.charAt(i) is valid then dp[i] = dp[i - 2]
     3] if string is valid for both the cases then dp[i] = dp[i - 1] + dp[i - 2];

     invalid strings :

    1] if the string is "0x" x can be anything <= 0
    2] if the string is "0"
    3] if the string is "xy" where xy > 26

     */

    private static int decodeWays( String sequence ){
        int dp[] = new int[sequence.length() + 1];
        dp[0] = 1;
        for(int i = 1; i < dp.length; i++ ){
            int singleChar = 0;
            int doubleChar = 0;
            String singleCharSequence = sequence.substring(i - 1,i);
            if( singleCharSequence.charAt(0) != '0' ) { // ignores string if single character is 0
                singleChar = Integer.parseInt(singleCharSequence);
            }
            if( i >= 2 ) {
                String doubleCharSequence = sequence.substring(i - 2,i);
                if( doubleCharSequence.charAt(0) != '0' ) { // ignores strings if it starts with 0
                    doubleChar = Integer.parseInt( doubleCharSequence );
                }
            }
            if( singleChar < 10 && singleChar > 0 ){ // case for valid single digit
                dp[i] += dp[i - 1];
            }
            if( doubleChar >= 10 && doubleChar < 27 ){ // case for valid double digit
                dp[i] += dp[i - 2];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[sequence.length()];
    }


    public static void main(String[] args) {

        String encodedString = "122016";
        // encodedString = "1123"; // output : 5

        System.out.println( decodeWays(encodedString) );

    }
}
