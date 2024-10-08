package OtherCodes;

public class Practice4 {

    /*

    Input: a = "11", b = "1"
    Output: "100"

    Input: a = "1010", b = "1011"
    Output: "10101"

     a = "1111"
     b = "1" output = "10000"

     */
    private static String addBinary(String a, String b) {

        String sum = "";

        int diffLengths = Math.max(a.length() , b.length() ) - Math.min( a.length(),b.length() );

        for( int l = 1; l <= diffLengths; l++ ){
            if( b.length() < a.length() ) {
                b = "0" + b;
            }
            else{
                a = "0" + a;
            }
        }

        int i = a.length() - 1;
        int j = b.length() - 1;
        String carry = "0";

        while ( i >= 0 && j >= 0 ){

            char ch = a.charAt(i);
            char ch1 = b.charAt(j);

            if( ch != ch1 ){
                if( carry.equals("1") ){
                    sum = "0"+sum;
                    carry = "1";
                }else {
                    sum = "1" + sum;
                    carry = "0";
                }
            }

            if( ch == '1' && ch == ch1 ){
                if( carry.equals("1") ){
                    sum = carry + sum;
                    carry = "1";
                }
                else{
                    sum = "0"+sum;
                    carry = "1";
                }
            }

            if( ch == '0' && ch == ch1 ){

                if( carry.equals("1") ){
                    sum = carry+sum;
                }else{
                    sum = "0"+sum;
                }
                carry = "0";
            }

            i--;
            j--;

        }

        if( carry.equals("1") ) {
            sum = carry + sum;
        }

        return sum;

    }


    static int bitSum = 0;
    int carry = 0;
    private static String addBinaryOpt(String a, String b) {

        StringBuilder sum  = new StringBuilder();

        int diffLengths = Math.max(a.length() , b.length() ) - Math.min( a.length(),b.length() );

        for( int l = 1; l <= diffLengths; l++ ){
            if( b.length() < a.length() ) {
                b = "0" + b;
            }
            else{
                a = "0" + a;
            }
        }

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while ( i >= 0 && j >= 0 ){

            int bitA = a.charAt(i) - '0';
            int bitB = b.charAt(j) - '0';

            bitSum = bitA + bitB + carry;
            carry = bitSum/2;
            sum.append( bitSum % 2 );

            i--;
            j--;

        }

        if( carry == 1 ) {
            sum.append(carry);
        }

        return sum.reverse().toString();

    }

    public static void main(String[] args) {
        String b1 = "1010";
        String b2 = "1011";

        b1 = "1010";
        b2 = "1011";

        System.out.println(addBinaryOpt(b1,b2));
    }

}
