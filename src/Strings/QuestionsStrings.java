package Strings;

public class QuestionsStrings {

    // print all the substrings of s string
    public static void allSubStrings(String s){ // with iteration

        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++) {
                System.out.print(s.substring(i,j)+" ");
            }
        }
    }


    // with recursion

//    public static void allSubStringsRec(String s,int start,int end){ // pending
//
//        if(start>end){
//            return;
//        }
//
//        if(start<=end) {
//
//            System.out.print(s.substring(start, end+1) + " ");
//            allSubStringsRec(s, start + 1, end);
//        }
//    }

/*     given a string the task is to toggle all the characters of the string i.e. to convert upper case to lower case and vice versa

    Ex: PhysICs --- pHYSicS

    Ascii A-65 , a-97, 0-48 .
*/

    public static void toggleCases(String s){

        for(int i=0;i<s.length();i++) {

            if (s.charAt(i) != ' ') {

                if (s.charAt(i) >= 97) {
                    if (i > 0) {
                        s = s.substring(0, i) + (char) (s.charAt(i) - 32) + s.substring(i + 1, s.length());
                    } else {
                        s = (char) (s.charAt(i) - 32) + s.substring(i + 1, s.length());
                    }
                } else if (s.charAt(i) >= 65) {
                    if (i > 0) {
                        s = s.substring(0, i) + (char) (s.charAt(i) + 32) + s.substring(i + 1, s.length());
                    } else {
                        s = (char) (s.charAt(i) + 32) + s.substring(i + 1, s.length());
                    }
                }
            }
        }

        System.out.print("Modified String is : ");
        System.out.println(s);
    }


/*      given a string s, return the number of palindromic subs strings in it.

      Ex: s="abc" : (substrings) ----> a ab abc b bc c
      out of these a,b,c are palindromic substrings . so , the answer is 3.
*/

    public static int palindromicSubstring(String s){

        int count=0;

        for(int i=0;i<s.length();i++){

            for(int j=i+1;j<=s.length();j++) {

                String str = s.substring(i,j);
                String gtr = "";

                for(int k=str.length()-1;k>=0;k--){ // reversing the substring
                    gtr+=str.charAt(k);
                }

//                System.out.println("str :"+str+" "); // debugging purpose
//                System.out.println("gtr :"+gtr+" ");

                if(str.equals(gtr)){
                    count+=1;
                }
//                System.out.println(count); // debugging purpose
            }
        }

        return count;
    }


/*        program to reverse each word in string :

    Ex: (input - I am an educator) , (output - I ma na rotacude)
*/

    public static void reverseEachWord(String s){

        String word = "";

        for(int i=0;i<s.length();i++){

            if(s.charAt(i) ==' ' || i == s.length()-1 ){ //  OR condition is because last character will not be " ".

                if(i == s.length()-1){ // while i is s.length()-1 , the else part will not execute so w e include it here.
                    word+=s.charAt(i); // adding the last character
                }
                if(!word.isEmpty()){ // printing the reverse of the strings
                    String revWord = "";
                    for(int j=word.length()-1;j>=0;j--){
                        revWord += word.charAt(j);
                    }
                    word=""; // once the space is encountered the word should become empty as we have to characters of next word
                    System.out.print(revWord);
                }

                System.out.print(" "); // printing space if we encounter space
            }
            else {
                word+=s.charAt(i); // adding chars of word
            }

        }
    }


/*    the string should be compressed such that consecutive duplicates of characters are replaced
    with the character and followed by the number of consecutive duplicates.

    Ex: input = aaabbbbccddde, output = a3b4c2d3e
*/
    // Brute force solution: O(n^2)
    public static void stringCompression(String s){

        String output="";

        for(int i=0;i<s.length();){ // here i++ is not needed because below in line 156 we have equated i to j, so that's the condition provided. if we again provide i++ here then i will become j+1 which will result in wrong output.

            int count=1;

            for(int j=i+1;j<s.length();j++){
                if(s.charAt(j)==s.charAt(i)){
                    count++;
                }
                else{
                    if(count!=1) {
                        output += ""+s.charAt(i)+count;  // Note : to concatenate string it's better to add ("")this in beginning.
                    }

                    else if (count==1) { // if it only occurs once
                        output += ""+s.charAt(i);
                    }
                    i=j;
                    break;
                }
            }

            if(i==s.length()-1){ // to read the last character
                output += ""+s.charAt(i);
                break;
            }

        }
        System.out.println(output);

    }

//    alternative way : optimized solution - O(n)

    public static void stringCompression2(String s){

        String output=""+s.charAt(0);
        int count=1;
        for(int i=1;i<s.length();i++){ // here i++ is not needed because below in line 156 we have equated i to j, so that's the condition provided. if we again provide i++ here then i will become j+1 which will result in wrong output.

            char curr=s.charAt(i);
            char prev=s.charAt(i-1);

            if(curr==prev){
                count++;
            }

            else{
                if(count>1){
                    output+=count;
                }
                count=1;
                output+=curr;
            }

        }
        if(count>1){
            output+=count;
        }
        System.out.println(output);

    }



    public static void main(String[] args) {

//        String s="abcd";
//
//        allSubStrings(s);

//        String str="PhysICs WallAH";

//        toggleCases(str);

//        String str = "abed";
//        System.out.println("The number of palindromic substring are : "+palindromicSubstring(str));

//        String str="My name is Rahul Katteda";
//        reverseEachWord(str);

        String str = "aaabbbbccdddefffgh";
        stringCompression2(str);

    }
}
