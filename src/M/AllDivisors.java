package M;

import java.util.Scanner;

public class AllDivisors {

    private static void allDivisors(int n){ // brute force approach
        for( int i = 1; i <= n; i++ ){
            if( n % i == 0 ){
                System.out.print(i+" ");
            }
        }
    }

    /*

    approach:

    if i is a factor of n then definitely there should another number whose product with i results in n
    i.e. i X n/i = n; therefore if i is a factor of n then definitely n/i is also a factor of n.

    ex :

    let n = 36,

    i   n/i   n
    1 X 36 = 36
    2 X 18 = 36
    3 X 12 = 36
    4 X 9 = 36
    6 X 6 = 36 -- we will run loop only until this as below this the factors are repeating
    9 X 4 = 36
    12 X 3 = 36
    18 X 2 = 36
    36 X 1 = 36

     */

    private static void allDivisorsOpt(int n){ // optimized
        for( int i = 1; i*i <= n; i++ ){
            if( n % i == 0 ){
                System.out.print(i+" ");
                if( n/i != 1 ){ // if n is a perfect square
                    System.out.print(n/i+" ");
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        allDivisors(n);
    }
}
