package Recursion;

public class Count7 {

    public int count7(int num){
        if(num<0){
            return -1;
        }
        if(num==0){
            return 0;
        }
        if(num%10==7){
            return 1+count7(num/10);
        }
        return count7(num/10);
    }

    public static void main(String[] args) {

        Count7 count=new Count7();
        System.out.println(count.count7(717707070));

    }
}
