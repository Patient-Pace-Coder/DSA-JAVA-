package Stack.Questions;

import java.util.Stack;

public class NextGreaterElementInRight {

    /*
    This approach is taking O(n^2) time complexity , we need a solution of O(n)

    Time complexity : O(n^2), Space complexity : O(1)
     */
    private static void nextGreaterElement( int arr[] ){
        Stack<Integer> stk = new Stack<>();

        for( int i = arr.length - 1; i >= 0; i-- ){
            stk.push(arr[i]);
        }

        int idx = 0;
        int maxAtRight = 0;


        while ( !stk.isEmpty() ) {

            boolean isMaxAtRightUpdated = false;

            int curr = stk.pop(); // to check the corresponding element at the top of the stack with array

            for( int i = 0; i < arr.length; i++ ){
                if( arr[i] == curr ){
                    idx = i; // index of that element is stored , so that we can check for next greater element to the right of this.
                    break;
                }

            }

            for (int i = idx + 1; i < arr.length; i++) { // checking for next greater element to the right of idx
                if (arr[i] > curr) {
                    maxAtRight = arr[i];
                    isMaxAtRightUpdated = true; // just to check if the greater element has been changed , as if not changed then it should be -1.
                    break;
                }
            }

            if( isMaxAtRightUpdated ){
                System.out.println( "Next greater element for "+curr+" is "+maxAtRight );
            }
            else {
                System.out.println("Next greater element for " + curr + " is " + -1);
            }
        }
    }

    /*

    This approach contains three steps :
    we start traversing from the end of the array
    1] popping all the elements from the stack which are less than the array[i]
    2] printing the answer i.e. the top of the stack
    3] pushing the arr[i] after checking for condition 1.

    this approach works as in step 1] we remove all the elements which are less than the current element
    then, the remaining element at the top of the stack will be the next greater element to the right of it.
    then, we push the current element as it becomes the right element to the upcoming elements.

     */


    /*

    Time Complexity Analysis ---->

    Each Element's Processing: Each element of the array is processed exactly once in the outer for loop.
    Stack Operations:
        Push Operations: Each element is pushed onto the stack exactly once.
        Pop Operations: Each element is popped from the stack at most once. This is because an element is
        only popped if it's smaller than the current element being processed, ensuring that each element is pushed and popped at most once.

    Time complexity : O(n), Space complexity : O(n)

    Note : O(n),O(n) > O(n^2),O(1) , actually preference depends on constraints, i.e. if memory or speed is a constraint
     */
    private static int[] nextGreaterElementOpt( int arr[] )  {
        Stack<Integer> stk = new Stack<>();
        int[] result = new int[arr.length];

        for( int i = arr.length - 1; i >= 0; i-- ){ // traversing from end to beginning

            while( !stk.isEmpty() && stk.peek() <= arr[i] ){ // if there are some elements less than arr[i]
                stk.pop();
            }
            if( stk.isEmpty() ){ // if there is no greater element towards right or arr[i]
                result[i] = -1;
            }
            else{ // if there is some greater element towards right of arr[i]
                result[i] = stk.peek();
            }
            stk.push(arr[i]);
        }

        return result;

    }

    /*

    This approach contains three steps :
    we start traversing from the start of the array
    1] popping elements from stack which are less than arr[i] and while removing we mark the corresponding result[ele] = arr[i] as arr[i] is greater than that and also right of it.
    2] pushing arr[i] element into the stack.
    3] finally when every element of arr is checked , the remaining elements in the stack are assigned value -1 in the result[] as there are no values greater than them lying to the right side.


    this approach works as in step 1] we remove all the elements which are less than the current element
    but while removing we mark the corresponding index of popped element value in result array to arr[i] value.,
    then, the remaining element at the top of the stack will be the next greater element to the right of it.
    then, we push the current element as it becomes the right element to the upcoming elements.
    finally some elements will be left in the stack after traversing every element in arr[] , they are assigned -1 in the result[].

     */

    private static int[] nextGreaterElementOptAlt( int arr[] )  {

        Stack<Integer> stk = new Stack<>();
        int[] result = new int[arr.length];

        for( int i = 0; i < arr.length; i++ ){

            while( !stk.isEmpty() && arr[stk.peek()] <= arr[i] ){ // if there are some elements less than arr[i]
                int idx = stk.pop();
                result[idx] = arr[i];
            }
            stk.push(i);
        }

        for( int ele : stk ){
            result[ele] = -1;
        }

        return result;

    }



    public static void main(String[] args) {

        int arr[] = {2,5,9,3,1,12,6,8,7};

//        int result[] = nextGreaterElementOpt(arr);
//
//        for (int i = 0; i < result.length; i++) {
//            System.out.println( "Next greater element for "+arr[i]+" is "+result[i]);
//        }

        int result[] = nextGreaterElementOptAlt(arr);

        for (int i = 0; i < result.length; i++) {
            System.out.println( "Next greater element for "+arr[i]+" is "+result[i]);
        }

    }
}
