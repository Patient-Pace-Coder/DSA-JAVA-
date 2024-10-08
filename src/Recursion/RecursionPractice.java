package Recursion;



public class RecursionPractice {


    // Online Java Compiler
    // Use this editor to write, compile and run your Java code online

    // class Factorial {

    //     public static int factorial(int n){

    //         if(n==0){
    //             return 1;
    //         }

    //         return n*(factorial(n-1));
    //     }
    //     public static void main(String[] args) {
    //         System.out.println(factorial(10));
    //     }
    // }

    // Online Java Compiler
    // Use this editor to write, compile and run your Java code online

    // class Sum1toN {

    //     public static int sumOfNTerms(int n){

    //         if(n==0){
    //             return 0;
    //         }

    //         return n+sumOfNTerms(n-1);
    //     }
    //     public static void main(String[] args) {
    //         System.out.println(sumOfNTerms(10));
    //     }
    // }


    // Online Java Compiler
    // Use this editor to write, compile and run your Java code online

    // class NthFibinocci {

    //     public static int fibinocci(int n){

    //         if(n==0 || n==1){
    //             return 0;
    //         }

    //         if(n==2 || n==3){
    //             return 1;
    //         }

    //         return fibinocci(n-1)+fibinocci(n-2);
    //     }
    //     public static void main(String[] args) {
    //         System.out.println(fibinocci(10));
    //     }
    // }

    // Online Java Compiler
    // Use this editor to write, compile and run your Java code online

    // class Palindrome {

    //     public static void isPalindrome(String s){

    //         int i=0;
    //         int j=s.length()-1;

    //         while((""+s.charAt(i)).equalsIgnoreCase( (""+s.charAt(j)) )){

    //             i++;
    //             j--;

    //             if(i>j){
    //                 System.out.println("String is palindrome ");
    //                 return;
    //             }
    //         }

    //         System.out.println("String is not a palindrome String");
    //     }
    //     public static void main(String[] args) {
    //         isPalindrome("Malayalm");
    //     }
    // }


    // class PowerOFNumber {

    //     public static int power(int n,int exponent){


    //         if(exponent == 0){
    //             return 1;
    //         }
    //         if(exponent == 1){
    //             return n;
    //         }

    //         return n*power(n,exponent-1);

    //     }
    //     public static void main(String[] args) {
    //         System.out.println(power(3,4));
    //     }
    // }


//    class GCD {
//
//        public static int GCD(int first, int second) {
//
//            int ans = 0;
//            for (int i = 1; i <= first; i++) {
//                if (first % i == 0) {
//                    if (second % i == 0) {
//                        ans = i;
//                    }
//                }
//            }
//
//            return ans;
//
//        }
//
//        public static void main(String[] args) {
//            System.out.println(GCD(20, 10));
//        }
//    }

//    class Frequency {
//
//        public static int frequency(int[] arr,int target){
//
//            return frequency2(arr,target,0);
//
//        }
//
//        public static int frequency2(int[] arr,int target,int index){
//
//            int count=0;
//            if(arr[index]==target){
//                count++;
//            }
//
//            if(index >= arr.length-1){
//                return count;
//            }
//
//            return count + frequency2(arr,target,index+1);
//
//        }
//
//
//        public static void main(String[] args) {
//            System.out.println(frequency(new int[] {1,2,3,2,3,2,2,4},2));
//        }
//    }


//    class LengthOfString {
//
//        public static int lengthOfStr(String s){
//
//
//            int count = 0;
//
//            if(s.isEmpty() ){
//                return count;
//            }
//            count++;
//            return count + lengthOfStr(s.substring(1));
//
//        }
//
//
//        public static void main(String[] args) {
//            System.out.println( lengthOfStr("Rahul"));
//        }
//
//    }


    // recursion tree for maxElement() :

/*              arr : {1,4,3,6,5,2}

    m(arr,0)
       max=1
    ret Math.max(1,6); --> it will return 6 hence the maximum element is 6.
        |
    m(arr,1)
       max=4
    ret Math.max(4,6); it will return 6.
        |
    m(arr,2)
       max=3
    ret Math.max(3,6); it will return 6.
        |
    m(arr,3)
       max=6
    ret Math.max(6,5); it will return 6.
        |
    m(arr,4)
       max=5
    ret Math.max(5,2); it will return 5.
        |
    m(arr,5)
       max=2
    return max; it will return 2.

 */
//    public static int maxElement(int[] arr,int index){
//
//        int max=0;
//
//        if(index==arr.length-1){
//            max=arr[index];
//            return max;
//
//        }
//
//        if(arr[index]>max){
//
//            max=arr[index];
//
//        }
//
//        return Math.max(max,maxElement(arr,index+1)); // comparing current max value and max value of other calls.
//    }
//
//
//    public static void main(String[] args) {
//
//        System.out.println(maxElement(new int[] {1,3,4,5,6,2},0));
//    }

//    public static int prodAll(int[] arr,int index){
//
//        int prod=1;
//
//        if(index==arr.length-1){
//            prod*=arr[index];
//            return prod;
//
//        }
//
//        prod*=arr[index];
//
//        return prod*(prodAll(arr,index+1)); // comparing current max value and max value of other calls.
//    }
//
//
//    public static void main(String[] args) {
//
//        System.out.println(prodAll(new int[] {1,3,4,5,6,2},0));
//    }

//    public static int sumOfDigits(int num){
//
//        int sum=0;
//
//        if(num==0){
//            return sum;
//        }
//
//        sum+=num%10;
//
//        return sum + sumOfDigits(num/10); // comparing current max value and max value of other calls.
//    }
//
//
//    public static void main(String[] args) {
//
//        System.out.println(sumOfDigits(134562));
//    }


    public static boolean isSorted(int[] arr,int index){

        int ele=arr[0];

        if(index==arr.length-1){
            return true;
        }

        if(arr[index] < arr[index+1]){
            return isSorted(arr,index + 1);
        }

        return false;
    }


    public static void main(String[] args) {

        System.out.println(isSorted(new int[] {1,3,4,5,2,6},0));
    }
}




