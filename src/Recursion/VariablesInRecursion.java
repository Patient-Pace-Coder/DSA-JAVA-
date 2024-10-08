package Recursion;

public class VariablesInRecursion {
    static void fun(){

        int a=1;

        System.out.println(a);
        --a;        // a gets updated , but in every new function call 'a' is a new variable being declared not the old 'a'.
        fun();
    }

    static int b=1;
    static public void fun1(){
        System.out.println(b);
        if( b == 100 ){
            return;
        }
        b++;   // here since b is a static variable it gets updated in every new function call . the same old 'b' is getting updated here.

        fun1();
    }

    public static void main(String[] args) {
        // fun(); // stackoverflow
       fun1();
    }
}
