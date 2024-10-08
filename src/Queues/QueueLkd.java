package Queues;


public class QueueLkd {

    static class Node {

        Node next;
        int data;


        Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    int len = 0;

    Node head = null;
    Node tail = null;

    public void enQueue(int data) {

        if (isEmpty()) {
            Node new_node = new Node(data);
            head = new_node;
            tail = new_node;
            len = 1;

        } else {
            Node new_node = new Node(data);
            tail.next = new_node;
            tail = new_node;
            len++;
        }

    }

    public void deQueue() {
        if (!isEmpty()) {

            Node temp = head;
            head = head.next;
            temp.next = null;
            len--;
        } else {
            System.out.println("Queue is empty, can't remove!!.");
        }
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }

    public int peek() {
        if (!isEmpty()) {
            return tail.data;
        }
        return -1;
    }

    public void displayQ() {
        if (!isEmpty()) {
            Node temp = head;
            for (int i = 1; i <= len; i++) {
                System.out.print(temp.data);
                if (i < len) {
                    System.out.print(" -> ");
                }
                temp = temp.next;
            }
            System.out.println();
        } else {
            System.out.println("Queue is empty!!.");
        }
    }

    public static void main(String[] args) {

        QueueLkd obj=new QueueLkd();
        obj.enQueue(1);
        obj.enQueue(2);
        obj.enQueue(3);
        obj.enQueue(4);
        obj.displayQ();
        obj.deQueue();
        obj.displayQ();
        System.out.println(obj.peek());
        obj.deQueue();
        obj.deQueue();
        obj.deQueue();
        System.out.println(obj.peek());
        obj.deQueue();
        obj.displayQ();

    }
}

