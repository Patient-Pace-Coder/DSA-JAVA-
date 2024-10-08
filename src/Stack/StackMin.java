package Stack;

import java.sql.SQLOutput;

public class StackMin {
    int top;

    int len;


    int stackArr[];

    int minStack[];
    int min;

    StackMin(int size){
        stackArr=new int[size];
        minStack=new int[size];
        top=-1;
        len=0;
    }

    public void push(int ele){
        if(!isFull()) {
            top++;
            stackArr[top] = ele;
            if(len==0){
                min=ele;
                minStack[top]=ele;
            }
            else if(ele<min){
                min=ele;
                minStack[top]=ele;
            }
            else{
                minStack[top]=minStack[top-1];
            }
            len++;

        }
        else {
            System.out.println("Stack is Full!!");
        }
    }

    public void pop(){
        if(!isEmpty()) {
            System.out.println("Popped : "+stackArr[top]);
//            stackArr[top] = -1;  optional
            top--;
            len--;
        }
        else {
            System.out.println("Stack is Empty!!");
        }

    }



    public void display(){
        System.out.println("Stack ------------------------------------------>");
        if(!isEmpty()) {
            for (int i = top; i >= 0; i--) {
                System.out.println(stackArr[i]);
            }
        }
        else {
            System.out.println("Stack is Empty!!");
        }
    }

    public boolean isEmpty(){
        if(top==-1){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if(len>=stackArr.length){
            return true;
        }
        return false;
    }

    public int peek(){
        return stackArr[top];
    }

    public StackMin deleteStack(){
        StackMin arr1=new StackMin(0);

        return arr1;

    }


    void minStack(){
        if(!isEmpty()) {
            System.out.println("The minimum element is : " + minStack[top]);
        }
        else{
            System.out.println("The minimum element is : " + -1);
        }
    }


    public static void main(String[] args) {

        StackMin arr=new StackMin(5);
        arr.push(5);
        arr.push(2);
        arr.push(3);
        arr.push(4);
        arr.push(1);
        arr.push(6);
        arr.pop();
        arr.pop();
        arr.pop();
        arr.pop();
        arr.pop();
        arr.minStack();
        arr.display();
//        System.out.println(arr.peek());
        arr.pop();
        arr.pop();
        arr.display();
        arr.push(3);
        arr.display();
        arr.pop();
        arr.display();
        arr= arr.deleteStack();
        arr.display();
//        System.out.println(arr.peek());
//        System.out.println(arr.len);



    }
}
