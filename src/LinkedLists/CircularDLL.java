package LinkedLists;

public class CircularDLL {

    static class Node{
        int data;

        Node prev;
        Node next;

        Node(int data){
            this.data=data;
            this.prev=null;
            this.next=null;
        }
    }
    Node head=null;
    int size=0;
    Node tail=null;

    public void nodeCreation(int data){
        if(isEmpty()) {
            Node new_node = new Node(data);
            head = new_node;
            tail = new_node;
            tail.next=head; // tail is connected to head
            head.prev=tail; // head is connected to tail
            size = 1;
        }
        else{
            System.out.println("Initial node is already created");
        }
    }

    public void insertInTheBeginning(int data){
        if(head==null){
            nodeCreation(data);
        }
        else {
            Node new_node = new Node(data);
            head.prev = new_node;
            new_node.next = head;
            head = new_node;
            tail.next=head;
            head.prev=tail;
            size++;
        }
    }

    public void insertInTheEnd(int data){
        Node new_node=new Node(data);
        tail.next=new_node;
        new_node.prev=tail;
        tail=new_node;
        tail.next=head;
        head.prev=tail;
        size++;
    }

    public void insertAtPos(int data,int pos){
        if(pos==1){
            insertInTheBeginning(data);
        } else if (pos>=size) {
            insertInTheEnd(data);
        }
        else{
            Node temp=head;
            Node ptr=temp.next;
            for (int i=1;i<pos-1;i++){
                temp=ptr;
                ptr=ptr.next;
            }
            Node new_node=new Node(data);
            temp.next=new_node;
            new_node.prev=temp;
            ptr.prev=new_node;
            new_node.next=ptr;
            size++;
        }
    }

    public void deleteFromBeginning(){
        if(!isEmpty()) {
            Node temp = head;
            head = temp.next;
//            temp.next = null; // no need of this, garbage collection will take care of it.
            head.prev = tail;
            tail.next=head;
            size--;
        }
        else{
            System.out.println("List is empty..");
        }
    }

    public void deleteFromEnd(){
        if(!isEmpty()) {
            Node temp=tail.prev;
//            tail.prev=null;
            temp.next=head;
            tail=temp;
            head.prev=tail;
            size--;
        }
        else{
            System.out.println("List is empty..");
        }
    }

    public void deleteFromPos(int pos){
        if(pos==1){
            deleteFromBeginning();
        } else if (pos>=size) {
            deleteFromEnd();
        }else{
            Node temp=head;
            Node ptr=temp.next;
            for(int i=1;i<pos-1;i++){
                temp=ptr;
                ptr=ptr.next;
            }
            ptr.prev=null;
            temp.next=ptr.next;
            ptr.next.prev=temp;
            size--;
        }
    }

    public void displayList(){
        if(!isEmpty()) {
            Node temp = head;

            // we use do while loop
//            do{
//                System.out.print(temp.data);
//                temp=temp.next;
//            }while (temp!=head);
//
//            System.out.println();

            // alternatives


            for(int i=0;i<size;i++){
                System.out.print(temp.data);
                if(i!=size-1){
                    System.out.print(" -> ");
                }
                temp=temp.next;
            }
            System.out.println();

//            while (temp != null) {    this condition doesn't work here as tail.next is not null
//                System.out.print(temp.data + " ");
//                temp = temp.next;
//            }

        }
        else{
            System.out.println("List is empty..");
        }
    }

    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        return false;
    }

    public int getHead(){
        if(!isEmpty()) {
            return head.data;
        }
        return 0;
    }

    public int getTail(){
        if (!isEmpty())
            return tail.data;
        return 0;
    }

    public int getSize(){
        return size;
    }

    public static void main(String[] args) {

        CircularDLL dLL=new CircularDLL();
        dLL.insertInTheBeginning(40);
        dLL.insertInTheEnd(10);
        dLL.insertInTheEnd(20);
        dLL.insertAtPos(30,4);
        dLL.displayList();
        System.out.println(dLL.getHead());
        System.out.println(dLL.getTail());
        System.out.println(dLL.getSize());
        dLL.deleteFromBeginning();
        dLL.displayList();
        System.out.println(dLL.getHead());
        System.out.println(dLL.getSize());
        dLL.deleteFromPos(2);
        dLL.displayList();
        System.out.println(dLL.getHead());
        System.out.println(dLL.getTail());
        System.out.println(dLL.getSize());
        dLL.deleteFromEnd();
        dLL.displayList();
        System.out.println(dLL.getHead());
        System.out.println(dLL.getTail());
        System.out.println(dLL.getSize());

    }

}
