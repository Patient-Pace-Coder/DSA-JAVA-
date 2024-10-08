package Recursion;

import java.util.ArrayList;
import java.util.List;

public class KeypadCombination {

    /*

    In this question we are given an array which contains alphabets corresponding to their index.

    i.e. in keypad phones we can see 'abc' on '1' numbered button and so on. here 1 represents index of the array and 'abc' represents
    corresponding word.

    we will be given a string say "573" we have to return all the possible combinations of terms we can obtain by multiplying the characters in index 5,7,3

    i.e. in 5 we have "mnop", in 7 we have "uv" and in 3 we have "ghi"
    so here are some possible combinations : [ mug , muh , mui , mvg ,....... ] etc.

    intuition :

    let str be "573"

    gkpc(573) --> gkpc(73) --> gkpc(3) --> [ 'g','h','i' ]

    so [ 'g','h','i' ] is returned to gkpc(73)
        here 7th index element is "uv" so,
        we first add u to all the value in [ 'g','h','i' ]
        then we add v to all the values in [ 'g','h','i' ]
        then we return the array i.e. [ 'ug','uh','ui', 'vg','vh','vi'] is returned

    so [ 'ug','uh','ui', 'vg','vh','vi'] is returned to gkpc(573)
        here 5th index element is "mnop" so,
        we first add m to all the value in [ 'ug','uh','ui', 'vg','vh','vi' ]
        then we add n to all the values in [ 'ug','uh','ui', 'vg','vh','vi' ]
        then we add o to all the values in [ 'ug','uh','ui', 'vg','vh','vi' ]
        then we add p to all the values in [ 'ug','uh','ui', 'vg','vh','vi' ]
        then we return the array [mug, muh, mui, mvg, mvh, mvi, nug, nuh, nui, nvg, nvh, nvi, oug, ouh, oui, ovg, ovh, ovi, pug, puh, pui, pvg, pvh, pvi] to the main function.

     */

    static ArrayList<String> letterCombinations = new ArrayList<>();
    private static ArrayList<String> getKeypadCombination( String str ){ // one way of doing it


//        if( str.length() == 1 ){ // better to go with below one
//
//            ArrayList<String> currArr = new ArrayList<>();
//            int idx = Integer.parseInt(str);
//            for( int i =0; i < letterCombinations.get(idx).length(); i++){
//                currArr.add( ""+letterCombinations.get(idx).charAt(i)); // adding each character individually into the array.
//            }
//            return currArr;
//        }

        if( str.length() == 0 ){

            ArrayList<String> currArr = new ArrayList<>();
            currArr.add("");
            return currArr;
        }

        ArrayList<String> prevRes = getKeypadCombination(str.substring(1));

        ArrayList<String> finalArr = new ArrayList<>();

        int idx = Integer.parseInt(""+str.charAt(0)); // converting index from string to int to access the element.

        for( int i = 0; i < letterCombinations.get(idx).length(); i++ ) {

            for( String ele : prevRes ) { // for each element in prevRes

                String s = letterCombinations.get(idx).charAt(i) + ele; // adding first character of word in letter-combinations index.
                finalArr.add(s);
            }
        }
        System.out.println(finalArr);
        return finalArr;
    }

    static String letters[] = {".,","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    private static ArrayList<String> getKeypadCombination1( String str ){ // another way of doing it


        if( str.length() == 0 ){

            ArrayList<String> currArr = new ArrayList<>();
            currArr.add("");
            return currArr;
        }

        ArrayList<String> prevRes = getKeypadCombination1(str.substring(1));

        ArrayList<String> finalArr = new ArrayList<>();

        // one way :
//        char ch = str.charAt(0);
//        int idx = Integer.parseInt(""+ch); // converting char value of ch into int.
//        String codeForCh = letters[idx];

        // alternative way :

        /*

        Ascii Values:

        '0' = 48
        '1' = 49
        '2' = 50
        '3' = 51
        '4' = 52
        '5' = 53
        '6' = 54

        now we know that, '6' != 6 as compiler will compare Ascii of '6' with 6 i.e. 54 != 6.
        so, if we want to make it equal we have to subtract the ascii of '0' from it i.e. '6' - '0' = 54 - 48 = 6.
        this is the trick to make '6' = 6 or any char 'n' = int n.


         */

        char ch = str.charAt(0);

        String codeForCh = letters[ch - '0'];
        for( int i = 0; i < codeForCh.length(); i++ ) {

            for( String ele : prevRes ) { // for each element in prevRes

                String s = codeForCh.charAt(i) + ele;// adding each alphabet in codeForCh
                finalArr.add(s);
            }
        }

        return finalArr;
    }

    public static void main(String[] args) {


//        ArrayList<String> letterCombinations = new ArrayList<>();

        letterCombinations.add(".,");
        letterCombinations.add("abc");
        letterCombinations.add("def");
        letterCombinations.add("ghi");
        letterCombinations.add("jkl");
        letterCombinations.add("mno");
        letterCombinations.add("pqrs");
        letterCombinations.add("tu");
        letterCombinations.add("vwx");
        letterCombinations.add("yz");


        ArrayList<String> resArr = getKeypadCombination("573");
        System.out.println(resArr);
        System.out.println(resArr.size());

        // ArrayList<String> myResArr = getKeypadCombination1("573");
        // System.out.println(myResArr);
        // System.out.println(myResArr.size());

    }
}
