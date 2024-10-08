package BM;

public class IsEvenOrOdd {

    /*

    Basic observations :

    binary representations of even numbers : last bit is 0
    8 : 1000
    4 : 0100
    2 : 0010
    6 : 0110

    binary representations of odd numbers : last bit is 1
    1 : 0001
    3 : 0011
    5 : 0101
    7 : 0111

    to check if a number is odd or even, we add the number with 1
    i.e. let n = 7
    then ,

    0111 --> 7
  & 0001 --> 1
  = 0001 --- > 1

    let n = 8
    then,

    1000 --> 8
  & 0001 --> 1
  = 0000 ---> 0

   therefore if we perform bitwise 'and' operation between two numbers,
   if the result is 1 then it's an odd number, if the result is 0 then, it's an even number.

     */

    public static void main(String[] args) {

        int n = 7;

        // if( n % 2 == 0 ){ // noob -- slow
        //     System.out.println("even");
        // }
        // else{
        //     System.out.println("odd");
        // }

        if( (n & 1) == 1 ){ // best approach
            System.out.println("odd");
        }
        else{
            System.out.println("even");
        }

    }
}
