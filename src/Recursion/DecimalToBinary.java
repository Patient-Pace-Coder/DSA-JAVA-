package Recursion;

public class DecimalToBinary {
    public int toBinary(int num){

        if(num==0){
            return 0;
        }

        return num%2+10*toBinary(num/2);
    }

    public static void main(String[] args) {

        DecimalToBinary number=new DecimalToBinary();
        System.out.println(number.toBinary(10));

    }
}
