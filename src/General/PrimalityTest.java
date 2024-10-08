package General;

public class PrimalityTest {

    // brute force approach

    private static boolean isPrimeBrute( int n ){ // TC : O(N)

        if( n == 1 ){
            return false;
        }
        for( int i = 2; i < n; i++ ){
            if( n % i == 0 ){
                return false;
            }
        }
        return true;
    }

    // better approach

    /*

    if  a * b = N then a lies below square root of n and b lies above square root of n
    also to check if a number is prime or not we need not check until n , instead its sufficient to check until root of n

    ex:

    n = 12

    factors = (1,12) (2,6) (3,4)
    here when i = 2 we get 12 % 2 == 0 so we need not check for 6 as they are in pairs
    similarly when i = 3 we get 12 % 3 == 0 . so we need not check for 4 again
    here 3^2 = 9 is less than i so we run loop until 3

     */
    private static boolean isPrimeBetter( int n ){ // TC : O(OtherCodes.Sqrt(n))

        if( n == 1 ){
            return false;
        }
        for( int i = 2; i * i< n; i++ ){
            if( n % i == 0 ){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

        System.out.println(isPrimeBrute(5)); // true
    }
}
