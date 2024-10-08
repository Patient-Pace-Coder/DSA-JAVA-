package Recursion;

public class ReverseString {

    public String reverse(String word){

        if(word.isEmpty()){
            return word;
        }
        return reverse(word.substring(1))+word.charAt(0);
    }

    public static void main(String[] args) {
        ReverseString str=new ReverseString();
        System.out.println(str.reverse("Malayalam"));
    }
}
