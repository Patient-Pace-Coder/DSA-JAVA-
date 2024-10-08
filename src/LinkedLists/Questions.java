package LinkedLists;

import java.util.HashSet;

public class Questions {

    // Method to delete the duplicates in the list.
    // (we make use of hashsets)

    void deleteDups(LinkedList ll){

        HashSet<Integer> hs=new HashSet<>();

        Node cur=ll.head;
        Node prev=null;

        while(cur.next!=null){
            int curdata= cur.data;

            if(hs.contains(curdata)){
                prev.next=cur.next;
                ll.size--;
            }
            else{
                hs.add(curdata);
                prev=cur;
            }
            cur=cur.next; // if this statement is written in else block then
                            // if control goes to if block this will not get executed ,so it's written here i.e. out of all blocks
        }
    }


    // method to return the data of the Nth node from the
    // last (tail) of the linked list.
    void returnNthToLast(LinkedList ll,int n)  {

        if(n==1){
            System.out.println(ll.tail.data);
        }
        else if(n==ll.size){
            System.out.println(ll.head.data);
        }
        else if(n>ll.size || n<1) {
            System.out.println("index out of range");
        }
        else{
            Node temp = ll.head.next;
            for (int i = 2; i < ll.size; i++) {
                if (n == (ll.size + 1 - i)) {
                    System.out.println(temp.data);
                }
                temp = temp.next;
            }
        }


    }

    // Alternative solution

    Node nthToLast(LinkedList ll,int n){
        Node p1=ll.head;
        Node p2=ll.head;

        for( int i=0;i<n;i++){
            if(p2==null) return null;
            p2=p2.next;
        }

        while (p2!=null){
            p1=p1.next;
            p2=p2.next;
        }

        return p1;
    }


    // method to create a partition i.e. lower elements will go
    // to the left sides and higher elements to the right

    public void partition(LinkedList ll, int val){
        Node curNode=ll.head;
        Node tail=curNode;
        Node head=curNode;
        Node p1=ll.head.next;
        Node p2=p1.next;
        while (p2.next!=null){
            if(p1.data>val){
                tail.next=p1;
                tail=p1;
                p1=p1.next;
                p2=p2.next;
            } else if (p1.data<val) {
                Node temp=p1.next;
                p1.next=head;
                head=p1;
                p1=temp;
                p2=p2.next;
            }

//            System.out.println(p1.data);
        }

            if (p1.data > val) {
                tail.next = p1;
                tail = p1;
            } else if (p1.data < val) {
                p1.next = curNode;
                head = p1;
            }
            p1.next = null;



        if(p2.data>=val){
            tail.next=p2;
            tail=p2;
        } else if (p2.data<val) {
            p2.next=head;
            head=p2;
        }
        ll.head=head;
        ll.tail=tail;
    }


    // method to create a list which is the resultant of the sum of the elements of both the lists

    // Input
    // list1 = 7 -> 1 -> 6 (617)
    // list2 = 5 -> 9 -> 2 (295)

    // Output
    // 617+295 = 912
    // list3 = 2 -> 1 -> 9

    public LinkedList sumLists(LinkedList ll,LinkedList ll1){
        LinkedList sumList=new LinkedList();
        int sum1=0;int sum2=0; int sum3=0;
        Node temp1=ll.head;
        Node temp2=ll1.head;
        int m=1;
        for(int i=1;i<=ll.size;i++){  // for totaling list1

            if(temp1==ll.head){
                sum1+= temp1.data;
            }
            else{
                m*=10;
                sum1+= m*temp1.data;
            }
            temp1=temp1.next;
        }
//        System.out.println(sum1);
        m=1;

        for(int i=1;i<=ll1.size;i++){ // for totaling list2

            if(temp2==ll1.head){
                sum2+= temp2.data;
            }
            else{
                m*=10;
                sum2+= m*temp2.data;
            }
            temp2=temp2.next;
        }
//        System.out.println(sum2);

        sum3=sum1+sum2;

        int temp=sum3;
        while(temp>0){
            sumList.insert(temp%10);
            temp=temp/10;
        }

        return sumList;
    }

}
