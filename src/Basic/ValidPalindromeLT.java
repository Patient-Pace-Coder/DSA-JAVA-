package Basic;

public class ValidPalindromeLT {

    private static boolean isPalindrome( String str ){
        str = str.toLowerCase();
        StringBuilder str1 = new StringBuilder(str);
        for( int i = 0; i < str1.length();){
            int ch = str1.charAt(i);
            if( ch == ' ' || !( (ch >= 97 && ch <= 122) || (ch >= 48 && ch <= 57)) ){ // as we have lowered all letters in str, we need to check for other characters
                str1.delete(i,i + 1);
                // if we delete a character the next character comes to this index now so we need to check char at this index now therefore we don't increment or decrement i here.
            }
            else{ // if ch is valid then we check the for next character so i++
                i++;
            }
        }
        String str2 = new String((str1));
        String str3 = new String((str1.reverse()));

        return str2.equals(str3);
    }

    public static boolean isPalindromeOpt(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int start = 0;
        int last = s.length() - 1;
        while(start <= last) {
            char currFirst = s.charAt(start);
            char currLast = s.charAt(last);
            if (!Character.isLetterOrDigit(currFirst )) {
                start++;
            } else if(!Character.isLetterOrDigit(currLast)) {
                last--;
            } else {
                if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
                    return false;
                }
                start++;
                last--;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String str = "race a car";

        // str = "A man, a plan, a canal: Panama";
        str = "0P";
        // System.out.println(isPalindrome(str));
        System.out.println(isPalindromeOpt(str));


    }
}
