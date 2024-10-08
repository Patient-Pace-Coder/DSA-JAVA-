package Stack;

import java.util.Arrays;

public class StackOfPlates {

    int arr[];
    int top;

    int rowInd;
    int colInd;

    int size;

    StackOfPlates(int threshold){
        arr=new int[threshold];
        top=-1;
        rowInd=0;
        colInd=0;
        size=threshold;
    }

    public void push(int ele){

            top++;
            if(top==arr.length-2){

                int temp[]=new int[arr.length*2];  // doubles the size of the array and assigns the elements of previous array to new array
                for(int i=0;i<arr.length-1;i++){
                    temp[i]=arr[i];
                    if(i==top){
                        temp[i]=ele;
                    }
                }
                arr=temp;
            }
            else{
                arr[top]=ele;
            }

//        System.out.println(Arrays.toString(arr));

    }

    public void display(){
        for(int i=top;i>=0;i--){

            System.out.println(arr[i]);
            if(i!=0 && size%(i+size/2)==0){
                System.out.println();
                System.out.println();
            }

        }
    }



    public static void main(String[] args) {
        StackOfPlates obj=new StackOfPlates(4);
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        obj.push(5);
        obj.display();

    }
}
