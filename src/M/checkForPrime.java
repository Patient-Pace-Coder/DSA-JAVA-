package M;

import java.util.Scanner;

public class checkForPrime {

    private static void isPrime(int n){ // brute force
        int countFactors = 1;
        for( int i = 2; i <= n; i++ ){
            if( n % i == 0 ){
                countFactors++;
            }
            if( countFactors > 2 ){
                System.out.println("is not a prime");
                break;
            }
        }
        if( countFactors <= 2 ){
            System.out.println("is a prime");
        }
    }

    private static void isPrimeOpt(int n){ // optimized
        int countFactors = 1;
        for( int i = 2; i*i <= n; i++ ){
            if( n % i == 0 ){
                countFactors++;
                if( n/i != 1 ){ // if n is a perfect square
                    countFactors++;
                }
            }
        }
        if( countFactors <= 2 ){
            System.out.println("is a prime");
        }else{
            System.out.println("is not a prime");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        isPrime(n);
        isPrimeOpt(n);
    }
}
