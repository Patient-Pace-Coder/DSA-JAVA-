package Recursion;

public class Factorial {

    public int factorial(int num){

        if(num<0){
            return -1;
        }

        if(num==0 || num==1){
            return 1;
        }
        return num*factorial(num-1);
    }

    public static void main(String[] args) {
        Factorial fact=new Factorial();
        System.out.println(fact.factorial(6));
    }
}
