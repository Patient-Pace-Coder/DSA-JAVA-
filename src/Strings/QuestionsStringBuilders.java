package Strings;

import javax.print.DocFlavor;

public class QuestionsStringBuilders {

    // given a string the task is to toggle all the characters of the string i.e. to convert upper case to lower case and vice versa

//    Ex: PhysICs --- pHYSicS

//    Ascii A-65 , a-97, 0-48 .

    public static void toggleCases(StringBuilder s){

       for(int i=0;i<s.length();i++) {

           if (s.charAt(i) != ' ') {
               if (s.charAt(i) >= 97) {
                   s.setCharAt(i, (char) (s.charAt(i) - 32)); // to convert lower to upper subtract 32
               } else if (s.charAt(i) >= 65) {
                   s.setCharAt(i, (char) (s.charAt(i) + 32)); // to convert upper to lower add 32
               }
           }
       }

        System.out.print("Modified String is : ");
        System.out.println(s);
    }


//    note :
//
//    StringBuilder sb1 = new StringBuilder("hello");
//    StringBuilder sb2 = new StringBuilder("hello");
//    System.out.println(sb1.equals(sb2)); // This would return false because for StringBuilders .equals() compares the references,
//    not the content as StringBuilder's .equals() method doesn't override object class's .equals() method.
//    so solution is (str.toString().equals(gtr.toString()) .
//    we convert the str and gtr to strings with toString() method and then use the .equals() method of strings which implements object's .equals() method.

    public static int palidromicSubstrings(StringBuilder s){

        int count=0;

        for(int i=0;i<s.length();i++){

            for(int j=i+1;j<=s.length();j++) {

//                StringBuilder str = new StringBuilder(s.substring(i,j)); // so either we have to pass the string in the argument.

                StringBuilder str=new StringBuilder();

                str.append(s.substring(i,j)); // or we can append whole string.


                // approach not working :

//                StringBuilder gtr = str.reverse(); // here str.reverse() will reverse the string str also, so below while comparing them it will always be true
//
//                str.reverse(); // therefore we reverse it again; but since gtr and str are pointing to same objects gtr also gets reversed so wrong approach

                // alternative way :

                StringBuilder btr= new StringBuilder(str.reverse()); // here str is reversed

                StringBuilder gtr=btr;
                str.reverse(); // reversing str again to make it as it was, so that we can compare it.

                System.out.println("str :"+str+" "); // debugging purpose
                System.out.println("gtr :"+gtr+" ");

//                if(str.equals(gtr)){ // here since str and gtr are StringBuilders not strings , .equals() compares the references of them not the content.
//                    count+=1;
//                }

                // solution is we have to use .toString() method to convert them to strings and then use .equals() to compare.

                if(str.toString().equals(gtr.toString())){ // here for comparing if two stringBuilder content
                    count++;
                }

                System.out.println(count); // debugging purpose

            }
        }

        return count;
    }


    public static void reverseEachWord(StringBuilder s){

        StringBuilder word = new StringBuilder("");

        for(int i=0;i<s.length();i++){

            if(s.charAt(i) ==' ' || i == s.length()-1 ){ //  OR condition is because last character will not be " ".

                if(i == s.length()-1){ // while i is s.length()-1 , the else part will not execute so w e include it here.
                    word.append(s.charAt(i)); // adding the last character
                }
                if(!word.isEmpty()){ // printing the reverse of the strings
                    StringBuilder revWord;
//
                    revWord=word.reverse();
                    System.out.print(revWord);
                    word=word.delete(0,word.length()); // once the space is encountered the word should become empty as we have to characters of next word

                }

                System.out.print(" "); // printing space if we encounter space
            }
            else {
                word.append(s.charAt(i)); // adding chars of word
            }

        }
    }



    public static void main(String[] args) {

//        StringBuilder str=new StringBuilder("PhysICs WallAH");

//        toggleCases(str);

//        StringBuilder str=new StringBuilder("abcd");
//        System.out.println(palidromicSubstrings(str));

//        StringBuilder s=new StringBuilder("My name is Rahul Katteda");
//        reverseEachWord(s);

    }
}
