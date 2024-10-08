package LinkedLists;

public class LinkedList {


    Node head=null;
    int size=0;
    Node tail=null;

    public void nodeCreation(int data){
        if(isEmpty()) {
            Node new_node = new Node(data);
            head = new_node;
            tail = new_node;
            size = 1;
        }
        else{
            System.out.println("Initial node is already created");
        }
    }


    public void insert(int data) { // method to insert a new node in the end
        if(head==null){
            nodeCreation(data);
        }
        else {
            Node new_node = new Node(data);
            tail.next = new_node;
            tail = new_node;
            size++;
        }
    }

    // private static Node deleteSpecific( LinkedList node ){
    //
    // }

    public void displayList() {

        if(!isEmpty()) {

            Node temp = head;


            for(int i=0;i<size;i++){
                System.out.print(temp.data);
                if(i!=size-1){
                    System.out.print(" -> ");
                }
                temp=temp.next;
            }
            System.out.println();
        }
        else{
            System.out.println(" List is empty..");
        }
    }

    public boolean isEmpty(){
        if(size>=1){
            return false;
        }
        return true;
    }

    public void getHead(){
        System.out.println(head.data);
    }

    public void getTail(){
        System.out.println(tail.data);
    }

    public void getSize(){
        System.out.println(size);
    }


}
