package LinkedLists.questions;

import LinkedLists.SingleLkdLst;

public class SingleLL {

    Node head = null;
    Node tail = null;

    int size = 0;

    private void addLast( int val ){

        if( size == 0 ){
            Node node = new Node(val);
            head = node;
            tail = node;
            size = 1;
        }
        else{
            Node node = new Node(val);
            tail.next = node;
            tail = node;
            size++;
        }
    }

    private void addFirst( int val ){
        if( size == 0 ){
            Node node = new Node(val);
            head = tail = node;
            size++;
        }
        else{
            Node node = new Node(val);
            node.next = head;
            head = node;
            size++;
        }
    }

    private void addAt( int index, int val ){

        if( size == 0 && index == 0 ){
            Node node = new Node(val);
            head = tail = node;
            size++;
        }
        else if( index == 0 ){
            Node node = new Node(val);
            node.next = head;
            head = node;
            size++;
        }
        else if( index == size ){
            Node node = new Node(val);
            tail.next = node;
            tail = node;
            size++;
        }
        else if( index < 0 || index > size ){
            System.out.println("Enter valid index!!");
        }
        else{
            int currIdx = 0;
            Node temp = head;
            Node ptr = temp.next;
            while ( currIdx < index - 1 ){
                temp = temp.next;
                ptr = ptr.next;
                currIdx++;
            }
            Node node = new Node(val);
            temp.next = node;
            node.next = ptr;
            size++;
        }
    }

    private int getFirst(){

        if( size >= 1 ) {
            return head.data;
        }
        else {
            System.out.println("List is empty!!");
            return -1;
        }
    }

    private int getLast(){
        if( size >= 1 ) {
            return tail.data;
        }
        else {
            System.out.println("List is empty!!");
            return -1;
        }
    }

    private int getAt( int index ){
        if( size == 0 ){
            System.out.println("List is empty!!");
            return -1;
        }
        if( index < 0 || index >= size ){
            System.out.println("Invalid arguments");
            return -1;
        }
        // else if( index == 0 ){
        //     return head.data;
        // }
        // else if( index == size - 1 ){
        //     return tail.data;
        // }
        else{
            Node temp = head;
            int currIdx = 0;
            while ( currIdx < size) {
                if( currIdx == index ){
                    return temp.data;
                }
                currIdx++;
                temp = temp.next;
            }
        }

        return -1;
    }

    private Node getNodeAt( int index ){
        if( size == 0 ){
            System.out.println("List is empty!!");
            return null;
        }
        if( index < 0 || index >= size ){
            System.out.println("Invalid arguments");
            return null;
        }
        // else if( index == 0 ){
        //     return head.data;
        // }
        // else if( index == size - 1 ){
        //     return tail.data;
        // }
        else{
            Node temp = head;
            int currIdx = 0;
            while ( currIdx < size) {
                if( currIdx == index ){
                    return temp;
                }
                currIdx++;
                temp = temp.next;
            }
        }

        return null;
    }

    private void removeFirst(){

        if( size == 0 ){
            System.out.println("List is empty!!");
        }
        if( size == 1 ){
            head = tail = null;
            size--;
        }
        if( size > 1 ) {
            // Node temp = head; -- not required
            head = head.next;
            // temp.next = null; -- not required
            size--;
        }

    }

    private void removeLast(){

        if( size == 0 ){
            System.out.println("List is empty!!");
        }
        if( size == 1 ){
            head = tail = null;
            size--;
        }
        if( size > 1 ) {
            Node temp = head;
            for( int i = 1; i < size - 1; i++ ){
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
            size--;
        }

    }

    private void reverseLL(){ // without using any methods i.e. using pointers
        if( size == 0 ){
            System.out.println("Empty linked list");
        }else if( size == 1 ){
            return;
        }
        else{
             int pos = size/2;
             Node headNode = head;
             Node tailNode = tail;
             int headData = headNode.data;
             int tailData = tail.data;
             int idx = 0;
             while ( idx < pos ){
                 int temp = headData;
                 headNode.data = tailData;
                 tailNode.data = temp;
                 idx++;
                 tailNode = headNode;
                 headNode= headNode.next;
                 headData = headNode.data;
                 for( int i = idx; i < size - idx; i++ ){
                     tailNode = tailNode.next;
                 }
                 tailData = tailNode.data;
             }
        }
    }

    private void reverseLLAlt(){ // with using methods // better approach
        if( size == 0 ){
            System.out.println("Empty linked list");
        }else if( size == 1 ){
            return;
        }
        else{
            int left = 0;
            int right = size - 1;
            while ( left < right ){
                Node l = getNodeAt(left);
                Node r = getNodeAt(right);
                int leftData = l.data;
                int rightData =  r.data;

                l.data = rightData;
                r.data = leftData;
                 left++;
                 right--;
            }
        }
    }

    private void reverseLLOpt(){ // without using any methods i.e. using pointers best approach
        if( size == 0 ){
            System.out.println("Empty linked list");
        }else if( size == 1 ){
            return;
        }
        else{

            Node prev = null;
            Node curr = head;

            while ( curr != null ){
                Node next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            Node temp = head;
            head = tail;
            tail = temp;
        }
    }



    public boolean isEmpty(){
        if(size>=1){
            return false;
        }
        return true;
    }

    public void displayList() {

        if(!isEmpty()) {

            Node temp = head;

            // alternative
//            while (temp != null) {
//                System.out.print(temp.data + " ");
//                temp = temp.next;
//            }
//            System.out.println();

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
            System.out.println("List is empty..");
        }
    }

    public static void main(String[] args) {

        SingleLL ll = new SingleLL();
        ll.addLast(10);
        ll.addLast(20);
        ll.addLast(30);
        ll.addLast(40);
        ll.displayList();
        // ll.removeFirst();
        // ll.displayList();
        // ll.removeFirst();
        // ll.displayList();
        // ll.removeFirst();
        System.out.println(ll.getFirst());
        System.out.println(ll.getLast());
        System.out.println(ll.getAt(2));
        ll.addFirst(1);
        ll.displayList();
        System.out.println(ll.size);;
        ll.addAt(3,25);
        ll.displayList();
        ll.removeLast();
        ll.displayList();
        System.out.println(ll.tail.data);
        ll.reverseLLOpt();
        ll.displayList();
        ll.removeLast();
        ll.displayList();
        System.out.println(ll.tail.data);
        ll.addAt(4,5);
        ll.displayList();
        System.out.println(ll.size);
    }
}

