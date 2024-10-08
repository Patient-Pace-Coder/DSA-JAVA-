package Recursion;

public class Concept {

//    (n--) : pass the value of n and then decrease the value.
//    (--n) : decrease the value of n and then pass the value.

    public void fun(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
//        fun(n--);  // it will lead to infinite recursion which goes on printing 5.

        fun(--n);
    }

    public static void main(String[] args) {

        Concept obj=new Concept();
        obj.fun(5);
    }
}
