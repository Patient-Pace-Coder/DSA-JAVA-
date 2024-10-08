package Stack.Questions;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedBrackets {

    private static boolean balancedBraces( String str ){

        Map<Character,Character> bracesSet = new HashMap<>();
        bracesSet.put('(',')');
        bracesSet.put('{','}');
        bracesSet.put('[',']');
        Stack<Character> stk = new Stack<>();

        for( int i = 0; i < str.length(); i++ ){

            char ch = str.charAt(i);

            if( ch == '(' || ch == '{' || ch == '[' ){
                stk.push(ch);
            }
            if( ch == '+' || ch == '-' || ch == '*' || ch == '/' ){
                stk.push(ch);
            }
            if( ch == ')' || ch == '}' || ch == ']' ){

                if( stk.peek() == '+' || stk.peek() == '-' || stk.peek() == '*' || stk.peek() == '/' ){
                    stk.pop();
                    if( bracesSet.get(stk.peek()) == ch ){
                        stk.pop();
                    }
                    else{
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
        }

        return stk.isEmpty();
    }

    private static boolean balancedBracesAlt( String str ){

        Map<Character,Character> bracesSet = new HashMap<>();
        bracesSet.put('(',')');
        bracesSet.put('{','}');
        bracesSet.put('[',']');
        Stack<Character> stk = new Stack<>();

        for( int i = 0; i < str.length(); i++ ){

            char ch = str.charAt(i);

            if( ch == '(' || ch == '{' || ch == '[' ){
                stk.push(ch);
            }
            if( ch == ')' || ch == '}' || ch == ']' ){
                if( bracesSet.get(stk.peek()) == ch ){
                    stk.pop();
                }
            }
        }

        return stk.isEmpty(); // if the string is valid then all the opening and closing pair will cancel out resulting in an empty string.
    }



    public static void main(String[] args) {

        String str = "[(a+b0+{(c+d)*(e/f)}"; // false as last one is mismatched
//        str = "[(a+b)+{(c+d)*(e/f)}]"; // true;
//        str = "[(a+b)+{(c+d)*(e/f)]}"; // false as last brace is misplaced
//        str = "([(a+b)+{c+d)*(e/f)}]"; // false as first opened bracket is not closed

        System.out.println(balancedBracesAlt(str));
    }
}
