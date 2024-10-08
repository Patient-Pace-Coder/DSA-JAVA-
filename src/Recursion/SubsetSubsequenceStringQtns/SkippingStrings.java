package Recursion.SubsetSubsequenceStringQtns;

// given str = baccad , output = bccd //  in short skip a
public class SkippingStrings {

    // with iteration
    public static void skipItr(StringBuilder s){

        // 1st way using a single for loop
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a'){
                s.deleteCharAt(i);
            }
        }
        System.out.println(s);
    }

    // with using a extra string variable
    public static void skip(StringBuilder s){

        // 2nd way using recursion

        String ans=""; // initializing variable to store the answer

        System.out.println(skipRec(s.substring(0),ans));
    }

    private static String skipRec(String str, String ans){ // helper function because we need to pass the updated 'ans' value.


        if(str.length()==0){ // base case not actually needed
            return ans;
        }
        if(str.charAt(0)!='a'){ // ignores if character is not a. if a, then adds it to answer string
            ans+=""+str.charAt(0);
        }
//        if(str.length()!=1) { // this acts as base case
            return skipRec(str.substring(1), ans); // since return type is string we have to put return here too

//          removeARec(str.substring(1), ans); if only this is written (without return ) then we won't get the output we wanted as ans value is different in different calls,
//          so the function returns the ans value of that function call resulting in output 'b' which is the value of ans in first function call.

//        }

//        return ans; // either line 30 or line 44,36-42

    }

    public static String skipRec1(String s){

        if(s.isEmpty()){
            return "";
        }

        char ch=s.charAt(0);

        if(ch == 'a'){ // if ch == a we skip 'a'
            return skipRec1(s.substring(1)); // skipping a
        }

        return ch+ skipRec1(s.substring(1)); // if ch!=a then we add that character and then start the next call.

    }

    // skip word apple

    public static String skipApple(String s){

        if(s.isEmpty()){
            return "";
        }

        if(s.startsWith("apple") || s.startsWith("Apple")){
            return skipApple(s.substring(5));
        }

        char ch=s.charAt(0);

        return ch+skipApple(s.substring(1));

    }

    // skip 'app' only if it's not 'apple'

    public static String skipAppRec(String s){ // bcdappefgapple

        if(s.isEmpty()){
            return "";
        }

        if( ( s.startsWith("App") || s.startsWith("app") ) && ( !s.startsWith("Apple") && !s.startsWith("apple") ) ){

            return skipAppRec(s.substring(3));

        }

        char ch=s.charAt(0);
        return ch+skipAppRec(s.substring(1));

    }

    public static void main(String[] args) {
        StringBuilder str= new StringBuilder("baccad");
//        removeA(str);

//        removeA1(str);

//        System.out.println(skipRec1("baccad"));

//        System.out.println(skipApple("bcdapplefgh"));

        System.out.println(skipAppRec("bcdappefgapple"));
    }
}
