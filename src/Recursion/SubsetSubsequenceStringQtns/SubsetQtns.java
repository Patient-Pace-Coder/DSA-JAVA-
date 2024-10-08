package Recursion.SubsetSubsequenceStringQtns;

import java.util.ArrayList;
import java.util.List;

public class SubsetQtns {

//    *** this pattern of taking some elements and removing some elements is known as subset pattern ***

    // formula to count number of substrings for a string of length n : 2 ^ n

    public static void subsetItr(String s){

        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                System.out.print(s.substring(i,j)+" ");
            }
        }
    }


    // iteration approach :

//                            "abc" initial String
//                               |
//                            [ "" ]
//                               |
//                            [ "" , "a" ]->outer array  , "" , "a" --- inner arrays (i=0)
//                                |
//                            [ "" , "a" , "b" , "ab" ] (i=1)
//                                |
//                            [ "" , "a" , "b" , "ab" , "c" , "ac" , "bc" , "abc" ] (i=2)

    public static List<String> subsetItr1(String s){

        List<String> outer=new ArrayList<>();

        outer.add("");

        int size=s.length();

//        for(int i=0;i<s.length();i++){ mistake is i<s.length as s is getting decreased in line 51 so size of s decreases

        for(int i=0;i<size;i++){

            int n=outer.size();
            for(int j=0;j<n;j++) { // j is used to access each string of outer

                outer.add(outer.get(j)+s.charAt(i)); // adding single character to existing element
                //* outer.add(outer.get(j)+s.charAt(0)); // adding single character to existing element

            }
            //* s=s.substring(1); // as to make s.charAt(0) unique in each iteration

        }
        return outer;
    }


    // recursive approach :

    // In each case we have got only 2 choices either we consider the character or ignore the character
    // left (subtree) : character considered , right (subtree) : character ignored

/*
                                                             ("" , "abc)

                                         /                                              \

                                 (  "a", "bc" )                                                 (  "", "bc" )

                        /                            \                                   /                           \

                 ( "ab", "c" )                         ( "a", "c" )              (  "b", "c" )                   (  "", "c" )

                    /         \                         /         \                 /       \                   /           \

            ( "abc", "" )   ( "ab", "" )        ( "ac", "" )   ( "a", "" )   (  "bc", "" )   (  "b", "" )    (  "c", "" )  (  "", "" )

 */


    public static void subsetRec(String p,String up){ // p : processed String , up: unprocessed String

        if(up.isEmpty()){
            System.out.print(p+" "); // we wil print the processed string
            return;
        }

        char ch=up.charAt(0);

        subsetRec(p+ch,up.substring(1)); // call of : considering the character

        subsetRec(p,up.substring(1)); // call of : ignoring the character

    }


    // return type is Arraylist : passing arraylist in the argument

    public static ArrayList<String> subsetRec1(String p,String up,ArrayList<String> list){ // p : processed String , up: unprocessed String

        if(up.isEmpty()){
            list.add(p); // as list is common Arraylist being passed strings gets added to the same list.
            return list;
        }

        char ch=up.charAt(0);

        subsetRec1(p+ch,up.substring(1),list); // call of : considering the character

        subsetRec1(p,up.substring(1),list); // call of : ignoring the character

        return list; // returns the same list

    }


//     return type array : but array is not being passed in the argument but a list declared in the body of the function.

// working of the approach below :

    /*
                                                                     [] ("" , "abc) [abc,ab,ac,a,bc,b,c,""]

                                                /                                                                         \

                                  []   (  "a", "bc" ) [abc,ab,ac,a]                                                 []  (  "", "bc" ) [bc,b,c,""]

                        /                                    \                                           /                                     \

initially []    ( "ab", "c" )  [abc,ab]                  [] ( "a", "c" ) [ac,a]             [] (  "b", "c" )  [bc,b]                    [](  "", "c" ) [c,""]

                    /         \                         /                  \                   /                  \                             /          \

  []( "abc", "" )["abc"]  [] ( "ab", "" ) [abc,ab]  []( "ac", "" )[ac]  ( "a", "" )[a]  (  "bc", "" )[bc]  [](  "b", "" ) [bc,b]  [](  "c", "" )[c] [](  "", "" ) [c,""]

 */

    public static ArrayList<String> subsetRec2(String p,String up){ // p : processed String , up: unprocessed String

        ArrayList<String> list = new ArrayList<>(); // for every new call there will be new arraylist

        if(up.isEmpty()){
            //* ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch=up.charAt(0);

        ArrayList<String> left = subsetRec2(p+ch,up.substring(1)); // call of : considering the character

        list.addAll(left); // adding elements of AL() left to list(of parent call)

        ArrayList<String> right = subsetRec2(p,up.substring(1)); // call of : ignoring the character

        list.addAll(right); // adding elements of AL() right to list(of parent call)

        return list;

        // alternative of list.addAll(left); list.addAll(right); return list;  :

//        left.addAll(right);
//
//        return left; // returning the list

    }

    // private static ArrayList


    public static void main(String[] args) {

//        subsetItr("abc"); // so total 6 substrings

       // List <String> subsets = subsetItr1("abc");
       // System.out.println(subsets);

//         ArrayList<String> l=new ArrayList<>();
//
// //        System.out.println(subsetRec1("","abc",l));
//
        System.out.print(subsetRec2("","abc"));

    }
}
