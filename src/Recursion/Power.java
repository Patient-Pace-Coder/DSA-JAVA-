package Recursion;

public class Power {

    public int calculatePower(int num,int pow){

        if(pow<0){   // constraint case
            return -1;
        }

        if(pow==0 ){ // base case
            return 1;
        }
        if(pow==1){
            return num;
        }
        return num*calculatePower(num,pow-1);
    }

    public static void main(String[] args) {
        Power power=new Power();
        System.out.println(power.calculatePower(5,3));
    }
}
