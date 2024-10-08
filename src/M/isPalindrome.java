package M;

import java.util.Scanner;

public class isPalindrome {

    private static boolean isPalindrome(int n ){
        int revNum = 0;
        int dupN = n;
        while( n > 0 ){
            revNum = (revNum * 10) + n % 10;
            n = n/10;
        }
        return revNum == dupN;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(isPalindrome(n));
    }
}
