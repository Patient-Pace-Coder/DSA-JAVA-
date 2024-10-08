package General;

import java.util.Arrays;

public class SieveOfEratosthenes {

    /*

    We are given two numbers say m and n and we have to print all the prime numbers in this range
    for this type of problems we use sieve of eratosthenes.

    its limit is 10^6. so upto range upto 10^6 we can use sieve of eratosthenes

    steps :
    preprocessing time : (Nlog(logN))
    answer query : O(1)
    extra space : O(N)

    we initialize an array of size m i.e. lets say we want all the prime numbers below 20
    then we initialize an array of size 20
    we mark index 0 as 0 ( 0 indicates composite number ) and rest all as 1's ( 1 indicates prime number )
    so now we start from 2 and mark all the multiples of 2 starting from 4 till 20 (included) as 1 .
    then we move to 3 and repeat the same steps , we ignore if some number is already marked as 1.
    we repeat these steps until square root of n i.e. if n = 50 we check till 7 i.e. we mark only the multiples of number until 7 as 8 * 8 will be 64  > 50 .
    after this , the numbers which are marked as 1 are the prime numbers .

     */

    private static void sieveOfEratosthenes( int n ){

        int arr[] = new int[n + 1];
        Arrays.fill(arr,1);
        arr[0] = 0;
        arr[1] = 0;
        for( int i = 2; i * i <= n; i++ ){
            // for( int j = i * 2; j <= n; j = j + i ){ // j = i * 2 is inefficient because all the multiples below i * i will already be marked as 1 so best to start i * i
            //     if( arr[j] == 1 ){
            //         arr[j] = 0;
            //     }
            // }
            for (int j = i * i; j <= n; j += i) { // Mark all multiples of i starting from i * i
                arr[j] = 0;
            }
        }
        for( int i = 0 ; i < arr.length; i++ ){
            if( arr[i] == 1 ){
                System.out.print(i+" ");
            }
        }
    }

    public static void main(String[] args) {
        sieveOfEratosthenes(10);
    }
}
