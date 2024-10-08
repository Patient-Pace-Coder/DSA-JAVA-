package Recursion;

public class ReverseNumber {

    // first way

//    static int sum=0;
//    static int rem;
//    public static void reverse(int n){
//
//        if(n==0){
//            return;
//        }
//        rem=n%10;
//        sum=sum*10+rem;
//        reverse(n/10);
//    }

    // second way

    // sometimes we might need some additional variables in the argument
    // in that case, make another function

    static int rev2(int n){

        int digits= (int)(Math.log10(n))+1;
        return helper(n,digits);
    }

    private static int helper(int n, int digits){
        if(n == 0){
            return 0;
        }
        int rem=n%10;
        return rem*(int)(Math.pow(10,digits-1))+helper(n/10,digits-1);
    }


    public static void main(String[] args) {
//        reverse(1234);
//        System.out.println(sum);

        System.out.println(rev2(123400));
    }
}
