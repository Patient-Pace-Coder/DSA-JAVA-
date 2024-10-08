package Strings;

import java.util.Scanner;

public class Strings {


//    public static void main(String[] args) {

//        Scanner sc=new Scanner(System.in);

//        String s="Rahul";
//
//        System.out.println(s);



//        Ascii values: A-65 , a-97 , 0-48

//        String name=sc.next(); // takes only first word before space as the input
//
//        System.out.println(name);

//        String name1=sc.nextLine(); // takes the whole text as input not only the first word
//
//        System.out.println(name1);

//        char ch=s.charAt(0);
//        System.out.println(s.charAt(3));

//        int index=s.indexOf("l");
//        System.out.println(index);

//        String str="Hello";
//        String gtr="Dello";
//        String btr="Tello";
//        String ktr="Hello";
//
//        System.out.println(str.compareTo(gtr)); // returns 4 as (D E F G H) D + 4 = H
//
//        System.out.println(str.compareTo(btr)); // returns -12 as 20 (T) - 12 = 8 = H. it's actually comparing the Ascii value of the character and returning the difference
//
//        System.out.println(str.compareTo(ktr)); // returns 0 as both are equal.


//        if str > gtr (lexographically) then compareTo() returns +ve number
//        else if str < gtr then compareTo() returns -ve number
//        else if str == gtr then compareTo() returns 0;

//        boolean iscontains = s.contains("r"); // returns false as its case sensitive
//        System.out.println(iscontains);
//
//        iscontains = s.contains("ul");
//        System.out.println(iscontains); // true
//
//        boolean startsWith = s.startsWith("R");
//        System.out.println(startsWith); // true
//
//        boolean endsWith = s.endsWith("R");
//        System.out.println(endsWith); // false
//
//        boolean endsWith1 = s.endsWith("Rahul");
//        System.out.println(endsWith1); // true

//        System.out.println(s.toLowerCase());
//        System.out.println(s.toUpperCase());
//
//        String s1="abc";
//        String s2="def";
//
//        String s3=s1.concat(s2);
//        System.out.println(s3);
//        s3=s3.concat("ghi");
//        System.out.println(s3);

//        s.substring(a,b) : means a is inclusive and b is exclusive i.e. [a,b).

//        s.substring(0,4) ; // 0 is inclusive and 4 is exclusive, so prints only till 3.
//        System.out.println(s.substring(0,4));

//        System.out.println(s.substring(5,5)); // doesn't print anything
//
//        s.substring(0); // o is inclusive
//        System.out.println(s.substring(0)); // prints everything from 0.


//        equality of strings :

//        String str="Hello";  // these both strings point to the same string in the string pool  inside heap .
//        String gtr="Hello";
////
////        System.out.println(str==(gtr)); // returns true as both points to same reference.
//
////        to make these two string point to different references, i.e. to differentiate them, we use new keyword
//
//        String btr = new String("Hello");
////        System.out.println(str==(btr)); // false as both point to different references.
//
//        System.out.println(str.equals(gtr)); // true as both are same words i.e. both contain same characters
//
//        System.out.println(str.equals(btr)); // true as same strings, it only checks content not the address.

//        String s1="Hello";
//        String s2="hello";
//
//        System.out.println(s1.equals(s2));
//        System.out.println(s1.equalsIgnoreCase(s2));
//
////        a negative integer, zero, or a positive integer as the specified String is greater than, equal to,
////        or less than this String, ignoring case considerations.
//
//        System.out.println(s1.compareToIgnoreCase(s2));

//        char ch = 65; // ch=A
//        System.out.println(ch);

//         int ch = (char) 65; // ch=65;
//         System.out.println(ch);

//         for(char i='0';i<'9';i++){
//
//             System.out.println(i);
//
//         }

//         char[][] board=new char[3][3];
//
//         board[0][1] = 3 + '0'; // if we want to insert numbers into char[] array then we need add '0' to the number to convert it into char type.
//         for(char[] arr:board){
//             for(char ele:arr){
//                 System.out.print(ele+" ");
//             }
//             System.out.println();
//         }


//        class Solution {
//            public static int romanToInt(String s) {
//                int count=0;
//                for(int i=0;i<s.length();i++){
//
//                    switch (s.charAt(i)) {
//                        case 'I':
//                            count++;
//                            break;
//
//                        case 'V':
//                            count+=5;
//                            break;
//
//                        case 'X':
//                            count+=10;
//                            break;
//
//                        case 'L':
//                            count+=50;
//                            break;
//
//                        case 'C':
//                            count+=100;
//                            break;
//
//                        case 'D':
//                            count+=500;
//                            break;
//
//                        case 'M':
//                            count+=1000;
//                            break;
//
//                    }
//
//
//                    if( (i>0) && (( s.charAt(i)=='V' && s.charAt(i-1)=='I' ) || ( s.charAt(i)=='X' && s.charAt(i-1)=='I') )) {
//
//                        count-=2;
//
//                    }
////                    if( (i>0) &&  ) {
////                        count-=2;
////                    }
//                    if( (i>0) && ( (s.charAt(i)=='L' && s.charAt(i-1)=='X' ) || ( s.charAt(i)=='C' && s.charAt(i-1)=='X' ) ) ) {
//
//                        count-=20;
//
//                    }
////                    if( (i>0) &&  ) {
////
////                        count-=20;
////
////                    }
//                    if( (i>0) && ( (s.charAt(i)=='D' && s.charAt(i-1)=='C' )  || ( s.charAt(i)=='M' && s.charAt(i-1)=='C' )  ) ) {
//
//                        count-=200;
//
//                    }
//                }
//
//                return count;
//            }


//        }




//    public static void main(String[] args) {
//
//        System.out.println(romanToInt("MCMXCIV"));
//    }
//    }
}
