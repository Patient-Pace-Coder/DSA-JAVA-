package Stack;

public class ThreeStacks {

    int len;
    int top1,top2,top3;
    int arr[];

    ThreeStacks(int size){
        arr=new int[size];
        len =size/3;
        top1=-1;
        top2=top1+ len;
        top3=top2+ len;
    }

    public void push1(int ele){
        if(top1+1< len) {
            top1++;
            arr[top1] = ele;
        }
        else {
            System.out.println("can't push!! , stack1 is full");
        }
    }

    public void push2(int ele){
        if(top2+1< len *2) {
            top2++;
            arr[top2] = ele;
        }
        else {
            System.out.println("can't push!! , stack2 is full");
        }
    }

    public void push3(int ele){
        if(top3+1< len *3) {
            top3++;
            arr[top3] = ele;
        }
        else {
            System.out.println("can't push!! , stack3 is full");

//            inabiafatima5
        }
    }

    public void displayStack1(){
        System.out.println("Stack1--------------------------------------------------->");
        for(int i=top1;i>=0;i--){


            System.out.println(arr[i]);
        }
    }
    public void displayStack2(){
        System.out.println("Stack2--------------------------------------------------->");
        for(int i = top2; (i>= len)&&(i< len *2); i--){
            System.out.println(arr[i]);
        }
    }

    public void displayStack3(){
        System.out.println("Stack3--------------------------------------------------->");
        for(int i = top3; (i>= len *2)&&(i< len *3); i--){
            System.out.println(arr[i]);
        }
    }


    public static void main(String[] args) {
        ThreeStacks obj=new ThreeStacks(6);
        obj.push1(3);
        obj.push1(2);
//        obj.push1(1);
//        obj.push1(10);
        obj.push2(6);
        obj.push2(5);
//        obj.push2(4);
//        obj.push2(10);
        obj.push3(9);
        obj.push3(8);
//        obj.push3(7);
//        obj.push3(11);
        obj.displayStack1();
        obj.displayStack2();
        obj.displayStack3();
    }
}
