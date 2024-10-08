package Stack;

public class StackLkd {

    static class Node{

        Node next;
        int data;



        Node(int data){
            this.data=data;
            this.next=null;
        }

    }
    int len=0;

    Node top=null;
    Node tail=null;

    public void push(int data){

        if(isEmpty()){
            Node new_node=new Node(data);
            top=new_node;
            tail=new_node;
            len=1;

        }
        else {
            Node new_node=new Node(data);
            new_node.next=top;
            top=new_node;
            len++;
        }

    }

    public void pop(){
        if(!isEmpty()) {

            Node temp = top;
            top = top.next;
            temp.next = null;
            len--;
        }
        else{
            System.out.println("Stack is empty, can't pop!!.");
        }
    }

    public boolean isEmpty(){
        if(top==null){
            return true;
        }
        return false;
    }

    public int peek(){
        if (!isEmpty()){
            return top.data;
        }
        return -1;
    }

    public void displayStk(){
        if(!isEmpty()) {
            Node temp = top;
            for (int i = 1; i <= len; i++) {
                System.out.print(temp.data);
                if (i < len) {
                    System.out.print(" -> ");
                }
                temp = temp.next;
            }
            System.out.println();
        }
        else{
            System.out.println("Stack is empty!!.");
        }
    }

    public static void main(String[] args) {
        StackLkd stk=new StackLkd();
        stk.push(10);
        stk.push(20);
        stk.push(30);
        stk.push(40);
        stk.push(50);
        stk.displayStk();
        stk.pop();
        stk.displayStk();
        stk.pop();
        stk.pop();
        stk.pop();
        stk.displayStk();
        stk.pop();

        stk.pop();
        stk.displayStk();
        System.out.println(stk.peek());
    }
}
