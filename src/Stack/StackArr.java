package Stack;

public class StackArr {
    int top;

    int len;


    int stackArr[];

    StackArr(int size){
        stackArr=new int[size];
        top=-1;
        len=0;
    }

    public void push(int ele){
        if(!isFull()) {
            top++;
            stackArr[top] = ele;
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


    public static void main(String[] args) {

        StackMin arr=new StackMin(5);
        arr.push(1);
        arr.push(2);
        arr.push(3);
        arr.push(4);
        arr.push(5);
        arr.push(6);
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
