package Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsequence {

    /*

    Definition :

    Subsequences are sequences that can be derived by deleting some or all or none of the elements
    without changing the order of the remaining elements.

    Total number of subsequences can be calculated using the formula :

    2 ^ n, where n is the length of the string.

    ex :

    for string "abc" , here n = 3, therefore 8 elements.

    [ " ", a, b, c, ab, ac, bc, abc ]

    */

    private static ArrayList<String> getSubsequence1(String word){

        if( word.isEmpty() ){

            ArrayList<String> curArr = new ArrayList<>();
            curArr.add(word);
//            System.out.println(curArr.size()); // debugging
            return curArr;
        }

        ArrayList<String> gssisma = getSubsequence1(word.substring(1));

        ArrayList<String> finalArr = new ArrayList<>(); // since you can't use gssisma for all, this is used to store new result.

        for( String ele : gssisma ){
            char ch = word.charAt(0);
            String res = ch + ele ;
            finalArr.add(res);
        }

        finalArr.addAll(gssisma);
        return finalArr;

    }


//    private static ArrayList<String> getSubsequence(String processed,String unprocessed){
//
//        ArrayList finalArr = new ArrayList();
//
//        for (int i = 0; i < unprocessed.length(); i++) {
//            processed = "" + unprocessed.charAt(i);
//            String up1 = unprocessed.substring(i + 1, i + 3);
//            String up2 = unprocessed.substring(i + 2, i + 3);
//            unprocessed = up1 + up2;
//
//
//            ArrayList prevRes = new ArrayList();
//
//            prevRes = getSubsequence(processed, unprocessed);
//
//            finalArr.addAll(prevRes);
//
//            System.out.println(finalArr);
//        }
//
//    }

    private static void subsequence( String s ){

        helper("",s);
    }

    private static void helper( String processed, String unprocessed ){

        if( unprocessed.isEmpty() ){
            System.out.println(processed);
            return;
        }

        for( int i = 0; i < unprocessed.length() ;i++ ){
            String p = processed + unprocessed.substring(0,i + 1);
            char ch = unprocessed.charAt(i + 1);
            String up = unprocessed.substring(i + 2);
            helper(p, ch + up);
            helper(p, up);
        }
    }

    public static void main(String[] args) {

        String str = "abc";

        // System.out.println(getSubsequence1(str));
        subsequence(str);
    }
}
