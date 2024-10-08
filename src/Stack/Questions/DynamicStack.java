package Stack.Questions;

import java.util.Stack;

public class DynamicStack {

    public static void main(String[] args) {

        Stack<Integer> stk = new Stack<>();

        stk.push(1);
        stk.push(2);
        stk.push(3);
        stk.push(4);
        stk.push(5);

        System.out.println(stk);

        System.out.println(stk.pop());
        System.out.println(stk.peek());
        System.out.println(stk.size());
    }
}
