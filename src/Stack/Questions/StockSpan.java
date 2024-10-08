package Stack.Questions;

import java.util.Stack;

public class StockSpan {

    private static int[] stockSpan( int arr[] ){ // simple greater element towards left

        Stack<Integer> stk = new Stack<>();
        int[] span = new int[arr.length];
        stk.push(0);
        span[0] = 1;

        for( int i = 1; i < arr.length; i++ ){

            while( !stk.isEmpty() && arr[stk.peek()] < arr[i] ){ // if there are some elements less than arr[i]
                stk.pop();

            }
            if( stk.isEmpty() ){
                span[i] = i + 1;
            }else{
                span[i] = i - stk.peek();
            }
            stk.push(i);
        }

        return span;

    }

    public static void main(String[] args) {

        int arr[] = {2,5,9,3,1,12,6,5,7};

        int result[] = stockSpan(arr);

        for (int i = 0; i < result.length; i++) {
            System.out.println( "Span for "+arr[i]+" is "+result[i]);
        }
    }
}
