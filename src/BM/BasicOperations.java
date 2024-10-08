package BM;

public class BasicOperations {
    /*

    " BIT OPERATIONS ARE MUCH MORE FASTER THAN DECIMAL OPERATIONS "

    AND : 1 & 0 = 0
          0 & 0 = 0
          0 & 1 = 0
          1 & 1 = 1

   OR :   1 | 0 = 1
          0 | 0 = 0
          0 | 1 = 1
          1 | 1 = 1

   XOR :  1 ^ 0 = 1
          0 ^ 0 = 0
          0 ^ 1 = 1
          1 ^ 1 = 0

   NOT :  ~ 1 = 0
          ~ 0 = 1


          WE CAN VERIFY THE RESULTS OF THE ABOVE OPERATIONS IF NEEDED
     */

    public static void main(String[] args) {

        System.out.println(1 & 1); // 1 ( true)
        System.out.println(0 ^ 1); // 1 as different bits
        System.out.println(1 | 0); // 1 because its or operator

    }
}
