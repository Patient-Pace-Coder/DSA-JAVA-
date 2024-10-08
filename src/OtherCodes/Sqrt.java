package OtherCodes;

public class Sqrt {
    private static int sqrt( int x ){ // linear search approach - time taking

        if( x == 0 || x == 1 ){
            return x;
        }

        long sqrt = 0;
        for( long i = 1; i <= x/2; i++ ){
            if( i*i <= x ){
                sqrt = i;
                if( i*i == x ){
                    return (int) sqrt;
                }
            }
        }

        return (int) sqrt;
    }


    private static int sqrtOpt( int x ){ // binary search approach

        if( x == 0 || x == 1 ){
            return x;
        }

        long sqrt = 0;
        long start = 1;
        long end = x/2;

        while( start <= end ) {
            long mid = (start + end) / 2;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid > x) {
                end = mid - 1;
            } else if (mid * mid < x) {
                start = mid + 1;
                sqrt = mid;
            }
        }

        return (int) sqrt;
    }

    public static void main(String[] args) {

//        System.out.println(sqrt(2));
//        System.out.println(sqrtOpt(2147395599));  // Output: 46339

        System.out.println( sqrtOpt( 10));
    }
}
