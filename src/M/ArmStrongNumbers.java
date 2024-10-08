package M;

import java.util.Scanner;

public class ArmStrongNumbers {

    private static boolean armstrongNumber(int n){
        int countDigits = 0;
        int dupN = n;
        int dupN1 = n;
        int sum = 0;
        while( n > 0 ){
            n = n / 10;
            countDigits++;
        }
        while ( dupN > 0 ){
            sum += Math.pow((dupN % 10),countDigits);
            dupN = dupN/10;
        }
        return sum == dupN1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(armstrongNumber(n));
    }
}
