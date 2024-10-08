package Queues;

// purpose of circular queue is that in case of linear queues the dequeue method causes blank cells (as we use front pointer to dequeue) ,
// which cannot be reused ( as end pointer will not change while performing dequeue , and we use end pointer for enqueue.
// So, the previous blank cells are always blank. CircularQueue helps here)

public class CircularQArr {


    int front;
    int end;

    int len;
    int qArr[];

    CircularQArr(int size){
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
            end=(end+1)%len;
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
                front = ((front+1) % len);
            }
        }
        else {
            System.out.println("Queue is empty!! , can't dequeue");
        }
    }

    public void displayQ(){
        if (!isEmpty()) {
            for(int i=front;i!=end;i=(i+1)%len){
                System.out.print(qArr[i]+" ");
            }
            System.out.print(qArr[end]);
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
        if(front==-1){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if((front==0 && end==len-1) || (front==end+1)){
            return true;
        }
        return false;
    }

    public void deleteQ(){
        qArr=null;
    }

    public static void main(String[] args) {

        CircularQArr obj=new CircularQArr(5);
        obj.enQueue(1);
        obj.enQueue(2);
        obj.enQueue(3);
        obj.enQueue(4);
        obj.enQueue(5);
        obj.displayQ();
        obj.deQueue();
        obj.deQueue();
        obj.enQueue(1);
        obj.displayQ();
        System.out.println(obj.qArr[obj.front]);
        System.out.println(obj.qArr[obj.end]);
    }

}
