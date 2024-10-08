package General;

import java.util.Arrays;

public class KthPrimeNumber {

    private static int sieve( int n , int k ){

        int arr[] = new int[n + 1];
        Arrays.fill(arr,1);
        arr[0] = 0;
        arr[1] = 0;
        for( int i = 2; i * i <= n; i++ ){
            for( int j = i * i; j <= n; j+= i ){
                arr[j] = 0;
            }
        }

        // System.out.println("All primes between 1 and "+n+" : "); // debugging
        // for( int i = 2; i < arr.length; i++ ){
        //     if( arr[i] == 1 ){
        //         System.out.print(i+" ");
        //     }
        // }

        System.out.println();
        int count = 0;
        for( int i = 2; i < arr.length; i++ ){
            if( arr[i] == 1 ){
                count++;
            }
            if( count == k ){
                return i;
            }
        }
        return -1; // if there's no k th prime
    }

    public static void main(String[] args) {
        System.out.println(sieve(10,1));
    }
}
