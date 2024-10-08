package M;

import java.util.Scanner;

public class GCD_HCF {

    private static int gcdOrHcf(int n1, int n2){
        int gcd = 1;
        for( int i = 2; i <= Math.min(n1,n2); i++ ){
            if( (n1 % i) == 0 && (n2 % i) == 0 ){
                gcd = i;
            }
        }
        return gcd;
    }

    private static int gcdOrHcfOpt(int n1, int n2){ // optimized solution for ex n1 = 20; n2 = 40
        int gcd = 1;
        for( int i = Math.min(n1,n2); i > 1; i-- ){
            if( (n1 % i) == 0 && (n2 % i) == 0 ){
                gcd = i;
                break;
            }
        }
        return gcd;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        System.out.println(gcdOrHcf(n1,n2));
        System.out.println(gcdOrHcfOpt(n1,n2));
    }
}
