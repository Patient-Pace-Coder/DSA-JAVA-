package Recursion;

public class Practice {

    public void run(String str){
        System.out.println(str.replaceAll("h","e"));
    }

    public static void main(String[] args) {
        Practice p=new Practice();
        p.run("hello");
    }
}
