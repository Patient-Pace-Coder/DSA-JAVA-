package Basic;

public class HappyNumber {
        public static boolean isHappy(int n) { // not completed
            int len = String.valueOf(n).length();
            int sum = 0;
            while( sum != 1 ){
                sum = 0;
                if( len == 1 ){
                    // while( n != 0 ){
                    //  sum += Math.pow((n%10),2);
                    //  n = n/10;
                    // }
                    // n = 11;
                    return isHappy((int)(Math.pow(n,2)));

                }
                else{
                    while( n != 0 ){
                        sum += Math.pow((n%10),2);
                        n = n/10;
                    }
                    n = sum;
                    if( sum == 1 ){
                        return true;
                    }

                }
            }
            if( sum == 1 ){
                return true;
            }
            return false;
        }

    public static void main(String[] args) {

            int n = 2;

        System.out.println(isHappy(n));
    }
}
