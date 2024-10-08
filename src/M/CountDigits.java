package M;

import java.util.Scanner;

public class CountDigits {

    private static int countDigits( int n ){
        int countDigits = 0;
        while( n > 0 ){
            n = n / 10; // this operation is what log does as log4(base 2) = 2 because 4/2 = 2 and again 2/2 = 0. since, the operation is performed twice value is 2.
            countDigits++;
        }
        return countDigits;
    }

    private static int countDigitsAlt( int n ){
        int countDigits = (int) Math.log10(n);
        return countDigits + 1;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(countDigits(n));
        System.out.println(countDigitsAlt(n));
    }
}
