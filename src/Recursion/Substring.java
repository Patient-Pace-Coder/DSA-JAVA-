package Recursion;

import java.util.ArrayList;

public class Substring {

    /*

    Definition :

    Substring are subsequences which are continuous and the order of original string is maintained.

    Total number of substrings can be calculated using the formula : n(n + 1)/2

    Every substring is a subsequence but every subsequence may not be a substring.

    ex :

    for a string "abc"

    substrings = [ a ab abc b bc c ]

     */

    private static ArrayList<String> getSubstring( String word ){

        if( word.length() == 1 ){
            ArrayList<String> curRes = new ArrayList<>();
            curRes.add(word);
            return curRes;
        }

        ArrayList<String> prevRes = new ArrayList<>();

        prevRes = getSubstring( word.substring(1));

        ArrayList<String> finalArr = new ArrayList<>();

        finalArr.addAll(prevRes); // to store result AL obtained in prevRes
        char ch = word.charAt(0);

        for( int i = 0; i < prevRes.size(); i++ ){

//            if( ( prevRes.get(i).length() == 1) &&  ( ( word.charAt(1) == prevRes.get(i).charAt(0) ) ) ) { // failed logic it only works for string of length 3.
//                finalArr.add(ch + prevRes.get(i));
//            }
//            else if ( prevRes.get(i).length() != 1 ){
//                finalArr.add(ch + prevRes.get(i));
//            }

            String str = ch + prevRes.get(i);
            if( str.charAt(1) == word.charAt(1) ) { // logic which checks if the next character in word is equal to next character in generated substring
                finalArr.add(ch + prevRes.get(i));
            }
        }

        finalArr.add(""+ch);

        return finalArr;

    }

    private static void allSubstrings( String s ){
        helper("",s,"");
    }

    private static void helper( String processed, String unprocessed , String asf ){ // wrong

        if( unprocessed.isEmpty() ){
            return;
        }
        for( int i = 0; i < unprocessed.length(); i++ ){
            String p = unprocessed.substring(0,i + 1);
            String up = unprocessed.substring(i + 1);
            System.out.println(p);
            helper(p,up,asf + p );
        }
    }

    public static void main(String[] args) {

        // String word = "abcdefg";
        String word = "abc";

        // ArrayList<String> answer = getSubstring(word);
        //
        // System.out.println(answer);
        // System.out.println(answer.size());
        // allSubstrings(word);
    }
}
