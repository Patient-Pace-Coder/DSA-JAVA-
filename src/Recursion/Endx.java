package Recursion;

//Given a string, compute recursively a new string where all the lowercase 'x' chars
// have been moved to the end of the string.
//        endX("xxre") → "rexx"
//        endX("xxhixx") → "hixxxx"
//        endX("xhixhix") → "hihixxx"

public class Endx {

    private static String endX( String s ){

        if( s.isEmpty() ){
            return s;
        }
        if(s.charAt(0) == 'x' ){
            return endX(s.substring(1)) + 'x';
        }
        else{
            return s.charAt(0) + endX(s.substring(1));
        }
    }

    public static void main(String[] args) {

        // String s = "xxre";
        // String s = "xxhixx";
        String s = "xhixhix";
        System.out.println(endX(s));
    }
}
