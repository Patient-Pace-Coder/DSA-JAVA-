package DynamicProgramming;

import java.util.Arrays;

public class BinaryStrings {

    /*

    we are given a number n which represents the length of the binary string,
    we have to find out the total number of binary strings that can be generated such that it should be of length n
    and it shouldn't contain consecutive zeroes

    Approach :
    we use a 2 1D arrays of size n + 1,
    1st array contains or stores elements of length column number,and ends with 0
    2nd array contains elements of length column number and ends with 1

    working :

    for n = 4, the output is 3 + 5 = 8. i.e. we can have totally 8 binary strings of length 4 in which consecutive zeroes doesn't exist.

    This array stores total number of binary strings of length index,and ends with 0 :

    zeroes[] :
            index :   0  1  2    3    4
                    [ 0, 1, 1  , 2  , 3   ]
    representation       0  10  010  1010
                                110  0110
                                     1110

    This array stores total number of binary strings of length index,and ends with 1 :

    ones[] :
            index :   0  1  2   3     4
                    [ 0, 1, 2 , 3   , 5   ]
    representation       1  01  101  0101
                            11  011  1101
                                111  1011
                                     0111
                                     1111

    Logic :
    ones[i] = zeroes[i - 1] + ones[i - 1]
    zeroes[i] = ones[i - 1]

    for representation :
    ones[i] = for each element at zeroes[i - 1] + '1', for each element as ones[i - 1] + '1'
    zeroes[i] = for each element at ones[i - 1] + '0'


     */

    private static int binaryStrings( int n ){

        int zeroesCount[] = new int[n + 1]; // dp array
        int onesCount[] = new int[n  + 1]; // dp array
        zeroesCount[0] = 0; // trivial or known
        onesCount[0] = 0; // trivial or known

        for( int i = 1; i <= n; i++ ){
            if( i == 1 ){
                zeroesCount[i] = 1;
                onesCount[i] = 1;
            }
            else{

                onesCount[i] = onesCount[i - 1] + zeroesCount[i - 1];
                zeroesCount[i] = onesCount[i - 1];
            }
        }

        System.out.println(Arrays.toString(zeroesCount));
        System.out.println(Arrays.toString(onesCount));

        return zeroesCount[n] + onesCount[n]; // represents total number of binary strings of length n with no consecutive zeroes
    }

    private static int binaryStringsAlt( int n ){ // memory efficient

        int zeroesCount = 0;
        int onesCount = 0;

        for( int i = 1; i <= n; i++ ){
            if( i == 1 ){
                zeroesCount = 1;
                onesCount = 1;
            }
            else{

                int tempOnesCount = onesCount;
                onesCount += zeroesCount;
                zeroesCount = tempOnesCount;
            }
        }

        return zeroesCount + onesCount; // represents total number of binary strings of length n with no consecutive zeroes
    }



    public static void main(String[] args) {
        int n = 5;
        // System.out.println(binaryStrings(n));

        System.out.println(binaryStringsAlt(n));
    }
}
