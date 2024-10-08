package M;

import java.util.Scanner;

public class SieveOfEratosthenes {

    private static void allPrimesUptilN(int n){ // brute force

        int primes[] = new int[n + 1];

        for( int i = 0;i < primes.length; i++ ){
            primes[i] = 1;
        }

        for( int i = 2; i < n; i++ ){
            if( primes[i] == 1 ) {
                for( int j = 2 * i; j <= n; j += i ){
                    primes[j] = 0;
                }
            }
        }

        for( int i = 2; i < primes.length; i++ ){
            if( primes[i] == 1 ){
                System.out.print(i+" ");
            }
        }

    }

    private static void allPrimesUptilNOpt(int n){ // optimized

        int primes[] = new int[n + 1];

        for( int i = 0;i < primes.length; i++ ){
            primes[i] = 1;
        }

        for( int i = 2; i*i< n; i++ ){ // for ex take n = 30 then all the numbers get marked off when it comes to 5 so condition is i * i < n
            if( primes[i] == 1 ) {
                for( int j = i * i; j <= n; j += i ){ // observation . i.e. if we start from 2 * i then it repeats as it was already marked when i was 2 therefore we start from i * i
                    primes[j] = 0;
                }
            }
        }

        for( int i = 2; i < primes.length; i++ ){
            if( primes[i] == 1 ){
                System.out.print(i+" ");
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        allPrimesUptilN(n1);
        System.out.println();
        allPrimesUptilNOpt(n1);
    }
}
