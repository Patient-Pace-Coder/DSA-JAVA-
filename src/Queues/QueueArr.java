package Queues;

public class QueueArr {

    int front;
    int end;

    int len;
    int qArr[];

    QueueArr(int size){
        qArr=new int[size];
        front=-1;
        end=-1;
        len=size;
    }

    public void enQueue(int ele){

        if(!isFull()) {

            if(front==-1){
                front=0;
            }
            end++;
                qArr[end] = ele;

        }
        else{
            System.out.println("Queue is full!! , can't enqueue");
        }
    }

    public void deQueue(){
        if(!isEmpty()){
            if(front==end){
                front=-1;
                end=-1;
            }

            else {

                front++;
            }

        }
        else {
            System.out.println("Queue is empty!! , can't dequeue");
        }
    }

    public void displayQ(){
        if (!isEmpty()) {
            for (int i = front; i <= end; i++) {
                System.out.print(qArr[i] + " ");
            }
            System.out.println();
        }
        else {
            System.out.println("Queue is empty!!");
        }
    }

    public int peek(){
        if (!isEmpty()) {
            return qArr[end];
        }
        return -1;
    }


    public boolean isEmpty(){
        if(front==-1){ // front will be greater than end initially and also when all the elements are dequeued
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if(end+1>=len){  // (+1) As index starts from 0
            return true;
        }
        return false;
    }

    public void deleteQ(){
        qArr=null;
    }

    public static void main(String[] args) {
        QueueArr obj=new QueueArr(5);
        obj.enQueue(1);
        obj.enQueue(2);
        obj.enQueue(3);
        obj.enQueue(4);
        obj.enQueue(5);
        obj.enQueue(6);
        obj.displayQ();
        obj.deQueue();
        obj.displayQ();
        obj.deQueue();
        obj.deQueue();
        obj.deQueue();
        obj.displayQ();
        System.out.println(obj.peek());
        obj.deQueue();
        obj.deQueue();

        System.out.println(obj.peek());
        obj.deleteQ();
        obj.displayQ();
    }
}
