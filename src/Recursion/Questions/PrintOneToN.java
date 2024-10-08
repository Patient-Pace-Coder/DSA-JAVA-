package Recursion.Questions;

public class PrintOneToN {
    private static void print(int n){

        if( n == 0 ){
            return;
        }
        print(n-1);
        System.out.print( n + " ");

    }

    private static void printRev(int n){
        if( n == 0 ){
            return;
        }
        System.out.print( n + " ");
        printRev(n-1);

    }
    public static void main(String[] args) {

        print(7);

        System.out.println();

        printRev(7);

    }
}
