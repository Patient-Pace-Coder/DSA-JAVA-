package BM;

public class BinaryAddition {

    public static int add(int a, int b) {
        while (b != 0) {
            // Calculate carry
            int carry = a & b;

            // Calculate sum without carry
            a = a ^ b;

            // Calculate the new value of b, which is carry shifted by 1
            b = carry << 1;
        }
        return a;
    }

    public static void main(String[] args) {
        int a = 15;  // Example numbers
        int b = 32;

        int sum = add(a, b);

        System.out.println("Sum of " + a + " and " + b + " is: " + sum);
    }

}
