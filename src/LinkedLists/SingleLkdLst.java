package LinkedLists;

public class SingleLkdLst {

    static class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    Node head = null;
    Node tail = null;

    int size = 0;

    public void nodeCreation(int data) {  // method to create the first node

        if(head==null) {
            Node new_node = new Node(data);
            head = new_node;
            tail = new_node;
            size = 1;
        }
        else{
            System.out.println("Initial node is already created.....");
        }
    }

    public void insertInTheBeginning(int data) { // method to insert a new node in the beginning

        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
        size++;

    }

    public void insertInTheEnd(int data) { // method to insert a new node in the end
        Node new_node = new Node(data);
        tail.next = new_node;
        tail = new_node;
        size++;
    }

    public void insertRec(int val,int index){
        Node temp=head;
        
    }

    public void displayList() {

        if(!isEmpty()) {

            Node temp = head;

            // alternative
           while (temp != null) {
               System.out.print(temp.data + " ");
               temp = temp.next;
           }
           System.out.println();

            // for(int i=0;i<size;i++){
            //     System.out.print(temp.data);
            //     if(i!=size-1){
            //         System.out.print(" -> ");
            //     }
            //     temp=temp.next;
            // }
            // System.out.println();
        }
        else{
            System.out.println(" List is empty..");
        }
    }

    public void deleteFromBeginning() {
        if(!isEmpty()){
           Node temp=head;
           temp=temp.next;
           head=temp;
           size--;
        }
        else{
            System.out.println(" List is empty");
        }
    }

    public void deleteFromEnd(){
        Node temp=head;
        Node ptr=temp.next;

        while(ptr.next!=null){
            temp=ptr;
            ptr=ptr.next;
        }
        temp.next=null;
        tail=temp;
        size--;
    }

    public void deleteFromPosition(int pos){

        if(pos==1){
            deleteFromBeginning();
        } else if (pos==size) {
            deleteFromEnd();
        }
        else {

            Node temp = head;
            Node ptr = temp.next;

            for (int i = 1; i < pos - 1; i++) {
                temp = ptr;
                ptr = ptr.next;
            }
            temp.next = ptr.next;
            size--;
        }


    }

    public boolean isEmpty(){
        if(size>=1){
            return false;
        }
        return true;
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

    public static void reverseList( Node head ){

        if( head == null || head.next == null ){
            return ;
        }

        Node curr = head;
        Node next = curr.next;
        Node prev = null;

        while( next != null ){
            curr.next = prev;
            prev = curr;
            curr = next;
            next = curr.next;
        }

        Node temp = curr;
        while( temp != null ){
            System.out.print(temp.data+" -> ");
        }
    }

    public int getSize(){
        return size;
    }

    public static void main(String[] args) {

        SingleLkdLst sLL=new SingleLkdLst();
        sLL.nodeCreation(5);
        sLL.insertInTheBeginning(10);
        sLL.insertInTheBeginning(20);
        sLL.insertInTheEnd(30);
        sLL.insertInTheEnd(40);
        sLL.displayList();
        // sLL.deleteFromBeginning();
        // sLL.displayList();
        // System.out.println(sLL.getHead());
        // System.out.println(sLL.getTail());
        // System.out.println(sLL.getSize());
        // sLL.deleteFromEnd();
        // sLL.displayList();
        // System.out.println(sLL.getHead());
        // System.out.println(sLL.getTail());
        // System.out.println(sLL.getSize());
        // sLL.deleteFromPosition(2);
        // sLL.displayList();
        // System.out.println(sLL.getHead());
        // System.out.println(sLL.getTail());
        // System.out.println(sLL.getSize());
        // sLL.deleteFromPosition(2);
        // sLL.displayList();
        // System.out.println(sLL.getHead());
        // System.out.println(sLL.getTail());
        // System.out.println(sLL.getSize());
        sLL.reverseList(sLL.head);
        // sLL.displayList();

        // int n = 51;
        // int revN = 0;
        // int len = String.valueOf(n).length();
        // int i = 1;
        // while( len > 1 ){
        //     i *= 10;
        //     len--;
        // }
        // while ( n > 0 ){
        //     revN += n%10 * i;
        //     n = n/10;
        //     i /= 10;
        //     // System.out.println(revN);
        // }
        // System.out.println(revN);
        // StringBuilder n1 = new StringBuilder(n);
        // n1.reverse();
        // System.out.println(n1);



    }
}
