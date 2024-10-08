package LinkedLists;

public class Main {

    public static void main(String[] args) {
        LinkedList ll=new LinkedList();
        ll.insert(7);
        ll.insert(1);
        ll.insert(6);
        ll.displayList();
        LinkedList ll1=new LinkedList();
        ll1.insert(5);
        ll1.insert(9);
        ll1.insert(2);
        Questions q=new Questions();
//        q.returnNthToLast(ll,3);
//        Node res=q.nthToLast(ll,6);
//        System.out.println(res.data);
//        q.partition(ll,1);
        ll1.displayList();
        LinkedList sumList=q.sumLists(ll,ll1);
        sumList.displayList();



    }
}
