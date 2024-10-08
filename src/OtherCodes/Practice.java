package OtherCodes;

import java.util.Stack;

public class Practice {

    private static boolean isValidParenthesis( String s ){

        Stack<Character> symbols = new Stack<>();

        for( int i = 0; i < s.length(); i++ ){

            if( s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{' ){
                symbols.push(s.charAt(i));
            } else{
                if( symbols.isEmpty() ){
                    return false;
                }
                else if( !isMatching(symbols.peek(),s.charAt(i)) ){
                    return false;
                }
                else{
                    symbols.pop();
                }
            }
        }

        return symbols.isEmpty();
    }

    private static boolean isMatching( char a, char b ){

        if( a == '(' && b == ')' || a == '[' && b == ']' || a == '{' && b == '}' ){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        String s = "{}[]()";

        s = "{[]}";

        System.out.println(isValidParenthesis(s));
    }
}
