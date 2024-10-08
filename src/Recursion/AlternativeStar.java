package Recursion;

//Given a string, compute recursively a new string where all the adjacent chars
// are now separated by a "*".

//        allStar("hello") → "h*e*l*l*o"
//        allStar("abc") → "a*b*c"
//        allStar("ab") → "a*b"

public class AlternativeStar {

    public String allStar(String str){
        if(str.length()<=1){
            return str;
        }
        return str.charAt(0)+"*"+allStar(str.substring(1));
    }

    public static void main(String[] args) {

        AlternativeStar obj=new AlternativeStar();
        System.out.println(obj.allStar("Rahul"));
    }

}
