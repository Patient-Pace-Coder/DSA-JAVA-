package Recursion;

public class Palindrome {

//    public String isPalindrome(String word){  // same as reverse logic
//
//        if(word.isEmpty()){
//            return word;
//        }
//        return isPalindrome(word.substring(1))+word.charAt(0);
//    }

    public boolean isPalindrome(String word){

        if(word.length()==0 || word.length()==1){
            return true;
        }

       if(word.charAt(0)==word.charAt(word.length()-1)){

           return isPalindrome(word.substring(1,word.length()-1));
        }
       return false;

    }

    public static void main(String[] args) {
        Palindrome str=new Palindrome();
        System.out.println(str.isPalindrome("malayalam"));
    }
}
