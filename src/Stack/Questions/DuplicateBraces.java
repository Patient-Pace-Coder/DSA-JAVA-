package Stack.Questions;

import java.util.Stack;

public class DuplicateBraces {

    // ((a+b)+(c+d)) - false : as it is valid there is no unnecessary braces
    // (a+b)+((c+d)) - true : as there is unnecessary braces around c+d.

    /*

     steps I followed :
     if '(' or 'any 'operand' then push , if any other character in string then ignore it.
     if ')' then check if the peek is any operand :
          if yes then pop it and then check if the peek is '(' :
              if yes then pop it as it is a valid combination.
              else return true as it is an invalid combination.
         else :
              return true as it is an invalid combination
     finally return !stk.isEmpty() : stack is empty if the braces are valid, we will return false if the braces are valid, so we are returning !stk.isEmpty().

    */


    private static boolean duplicateBraces( String str ){ // duplicate mean unnecessary braces

        Stack<Character> stk = new Stack<>();
        for( int i = 0; i < str.length(); i++ ){
            char ch = str.charAt(i);

            if( ch == '('){
                stk.push(ch);
            }
            if( ch == '+' || ch == '-' || ch == '*' || ch == '/' ){
                stk.push(ch);
            }
            if( ch == ')' ){
                if( stk.peek() == '+' || stk.peek() == '-' || stk.peek() == '*' || stk.peek() == '/' ){
                    stk.pop();
                    if(stk.peek() == '(' ){
                        stk.pop();
                    }
                    else{ // not required if 54 th line is used
                        return true;
                    }
                }
                else{ // not required if 54th line is used
                    return true;
                }
            }

        }

//        return !stk.isEmpty(); // empty stack mean there is no duplicate brace, but according to qtn we have to return false if there is no duplicate brace
        return false;
    }

    public static void main(String[] args) {

        String str = "((a+b)+(c+d))";
//        str = "(a+b)+((c+d))";

        System.out.println(duplicateBraces(str));
    }
}
