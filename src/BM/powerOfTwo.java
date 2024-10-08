package BM;

public class powerOfTwo {

    public static boolean isPowerOfTwo(int n) {
        System.out.println(  );
        if(  ( Math.log(n)/ Math.log(2) ) % 1 == 0.0 ){
            return true;
        }
        return false;
    }

    public boolean isPowerOfTwoOpt(int n) { // best
        return (n > 0) && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(4 ));
    }
}
