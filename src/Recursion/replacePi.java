package Recursion;

public class replacePi {

    public String replacePi(String word){

        if(word.length()<=1){
            return word;
        }
        if(word.substring(0,2).equals("pi")){
            return "3.14"+replacePi(word.substring(2));
        }
        return word.charAt(0)+replacePi(word.substring(1));
    }

    public static void main(String[] args) {
        replacePi str=new replacePi();
        System.out.println(str.replacePi("xpiippipx"));
    }
}
