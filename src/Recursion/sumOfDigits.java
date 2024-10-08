package Recursion;

public class sumOfDigits {

    //int sum=0;
    public int sumOfDigits(int n){
        if(n<0 || n==0){
            return 0;
        }
//        if(n<10) {    not necessary
//            return n;
//        }

//        else{
//            sum+=n%10+sumOfDigits(n/10);
//        }

        //return sum;

        return (n%10+sumOfDigits(n/10));

    }

    public static void main(String[] args) {

        sumOfDigits recursion=new sumOfDigits();
        System.out.println(recursion.sumOfDigits(125));

    }
}


