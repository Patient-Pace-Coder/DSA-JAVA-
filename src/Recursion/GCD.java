package Recursion;

public class GCD {

    // Using iteration : brute force solution

    public static int GCD(int first, int second) {

        int ans = 1;
        for (int i = 2; i <= first; i++) {
            if (first % i == 0) {
                if (second % i == 0) {
                    ans = i;
                }
            }
        }
        return ans;
    }


//    Pseudo Code of the Algorithm-
//    Step 1:  Let  a, b  be the two numbers
//    Step 2:  a mod b = R
//    Step 3:  Let  a = b  and  b = R
//    Step 4:  Repeat Steps 2 and 3 until  a mod b  is greater than 0
//    Step 5:  GCD = b
//    Step 6: Finish


    // Using iteration : brute force solution

    public static int GCD1(int first, int second) {

        while( first % second > 0){

            int remainder = first % second;
            first = second;
            second = remainder;

        }
        return second;
    }


    // Recursive solution using Euclidean Algorithm
    public int greatestCommonDivisor(int num1,int num2){

        if(num1<0 || num2<0){
            return -1;
        }

        if(num2==0){
            return num1;
        }

        if (num1==0) {
            return num2;
        }

        if (num1==num2) {
            return num1;
        }
        if( num1 % num2 == 0 ){
            return Math.min(num1,num2);
        }
        return greatestCommonDivisor(num2,num1%num2);   // Euclid's algorithm
    }


    public static void main(String[] args) {

        GCD gcd=new GCD();
       System.out.println(gcd.greatestCommonDivisor(6,8));

        // System.out.println(GCD1(6,8));
        // System.out.println(GCD(6,8));
    }
}
