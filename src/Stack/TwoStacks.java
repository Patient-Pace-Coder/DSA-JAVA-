package Stack;

public class TwoStacks {

    int len1;
    int top1,top2;
    int arr[];

    TwoStacks(int size){
        arr=new int[size];
        len1=size/2;
        top1=-1;
        top2=top1+len1;
    }

    public void push1(int ele){
        if(top1+1<len1) {
            top1++;
            arr[top1] = ele;
        }
        else {
            System.out.println("can't push!! , stack1 is full");
        }
    }

    public void pop1(){

        if (top1>=0) {
            System.out.println("popped "+arr[top1]);
            top1--;
        }
        else {
            System.out.println("stack1 is empty");
        }
    }


    public void push2(int ele){
        if(top2+1<len1*2) {
            top2++;
            arr[top2] = ele;
        }
        else {
            System.out.println("can't push!! , stack2 is full");
        }
    }

    public void pop2(){
        if (top2>=len1) {
            System.out.println("popped " + arr[top2]);
            top2--;
        }
        else {
            System.out.println("stack2 is empty");
        }
    }

    public void displayStack1(){
        if(top1>=0) {
            System.out.println("Stack1--------------------------------------------------->");
            for (int i = top1; i >= 0; i--) {

                System.out.println(arr[i]);
            }
        }
        else {
            System.out.println("stack1 is empty!!");
        }
    }
    public void displayStack2(){
        if(top2>=len1) {
            System.out.println("Stack2--------------------------------------------------->");
            for (int i = top2; (i >= len1) && (i < len1 * 2); i--) {
                System.out.println(arr[i]);
            }
        }
        else {
            System.out.println("stack2 is empty!!");
        }
    }

    public int peek1(){
        return top1;
    }

    public int peek2(){
        return top2;
    }

    public void len1(){
        System.out.println("length of stack 1 is "+(top1+1));
    }

    public void len2(){
        System.out.println("length of stack 2 is "+(top2-len1+1));
    }


    public static void main(String[] args) {
        TwoStacks obj= new TwoStacks(6);
        obj.push1(1);
        obj.push1(2);
        obj.push1(6);
        obj.push1(7);
        obj.len1();
        obj.displayStack1();
        obj.pop1();
        obj.displayStack1();
        obj.len1();
//        obj.push1(8);

        obj.push2(3);
        obj.push2(4);
        obj.push2(5);
        obj.push2(9);
        obj.len2();
        obj.displayStack2();
        obj.pop2();
        obj.pop2();
        obj.pop2();
        obj.pop2();
        obj.len2();
        obj.displayStack2();
        obj.displayStack1();
        obj.pop1();;
        obj.pop1();
        obj.displayStack1();
        obj.displayStack2();

//        obj.push2(10);


    }
}
