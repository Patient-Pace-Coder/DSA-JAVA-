package Recursion;

public class ReduceNumToZero {

    public static int numberOfSteps(int n){
        if(n==0){
            return 0;
        }
        if(n%2==0){
            return 1+numberOfSteps(n/2);
        }
        return 1+numberOfSteps(n-1);
    }

    public static void main(String[] args) {
        System.out.println(numberOfSteps(41));
    }
}
