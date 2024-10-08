package LinkedLists;

public class CircularSLL {

    static class C_node {
        C_node next;
        int data;

        C_node(int data) {
            this.data = data;
        }

    }

    C_node head = null;
    C_node tail = null;

    int size = 0;

    public void nodeCreation(int data) {  // method to create the first node

        if(head==null) {
            C_node new_node = new C_node(data);
            new_node.next=new_node;  // it points itself in the beginning
            head = new_node;
            tail = new_node;
            size = 1;
        }
        else{
            System.out.println("Initial node is already created.....");
        }
    }

    public void insertInTheBeginning(int data) { // method to insert a new node in the beginning

        if(head==null){
            nodeCreation(data);
        }
        else {

            C_node new_node = new C_node(data);
            new_node.next = head;
            head = new_node;
            tail.next = head;
            size++;
        }

    }

    public void insertInTheEnd(int data) { // method to insert a new node in the end
        C_node new_node = new C_node(data);
        tail.next = new_node;
        tail = new_node;
        tail.next=head;
        size++;
    }

    public void insertAtPos(int data, int pos){
        if(pos==1){
            insertInTheBeginning(data);
        }
        else if(pos>=size){
            insertInTheEnd(data);
        }else{
            C_node temp=head;
            for(int i=1;i<pos-1;i++){
                temp=temp.next;
            }
            C_node new_node=new C_node(data);
            new_node.next=temp.next;
            temp.next=new_node;
            size++;
        }
    }

    public void displayList() {

        if(!isEmpty()) {

            C_node temp = head;

            // alternative

//            do{
//                System.out.print(temp.data+" ");
//                temp=temp.next;
//            }while (temp!=head);
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
            System.out.println(" List is empty..");
        }
    }

    public void deleteFromBeginning() {
        if(!isEmpty()){
            C_node temp=head;
            temp=temp.next;
            head=temp;
            tail.next=head;
            size--;
        }
        else{
            System.out.println(" List is empty");
        }
    }

    public void deleteFromEnd(){

        C_node temp=head;

        while(temp.next!=tail){
            temp=temp.next;
        }
        temp.next=null;
        tail=temp;
        tail.next=head;
        size--;
    }

    public void deleteFromPosition(int pos){

        if(pos==1){
            deleteFromBeginning();
        } else if (pos>=size) {
            deleteFromEnd();
        }
        else {

            C_node temp = head;
            C_node ptr = temp.next;

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

    public int getSize(){
        return size;
    }

    public static void main(String[] args) {

        CircularSLL C_Sll=new CircularSLL();

//        System.out.println(C_Sll.tail.next.data);
        C_Sll.insertInTheBeginning(40);
        C_Sll.insertInTheBeginning(30);
        C_Sll.insertInTheBeginning(20);
        C_Sll.insertInTheBeginning(10);
        System.out.println(C_Sll.tail.next.data);
        C_Sll.displayList();
        System.out.println(C_Sll.getHead());
        System.out.println(C_Sll.getTail());
        System.out.println(C_Sll.getSize());
        C_Sll.insertAtPos(70,2);
        System.out.println(C_Sll.tail.next.data);
        C_Sll.displayList();
        System.out.println(C_Sll.getHead());
        System.out.println(C_Sll.getTail());
        System.out.println(C_Sll.getSize());
        C_Sll.deleteFromEnd();
        System.out.println(C_Sll.tail.next.data);
        C_Sll.displayList();
        System.out.println(C_Sll.getHead());
        System.out.println(C_Sll.getTail());
        System.out.println(C_Sll.getSize());
        C_Sll.deleteFromPosition(3);
        System.out.println(C_Sll.tail.next.data);
        C_Sll.displayList();
        System.out.println(C_Sll.getHead());
        System.out.println(C_Sll.getTail());
        System.out.println(C_Sll.getSize());
        C_Sll.deleteFromBeginning();
        C_Sll.deleteFromBeginning();
        System.out.println(C_Sll.tail.next.data);
        C_Sll.displayList();
        System.out.println(C_Sll.getHead());
        System.out.println(C_Sll.getTail());
        System.out.println(C_Sll.getSize());






    }
}
