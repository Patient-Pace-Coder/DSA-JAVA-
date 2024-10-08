package Recursion.Permutations;

public class PermutationsStrings {


//    using iteration and recursion

//    *** variable number of recursive calls ***

    /*                         (" "/abc)
                                   |
                                (a/bc)
                      /                        \
                  (ba/c)                       (ab/c)
             /      |      \          /      |        \
        (cba/"") (bca/"") (bac/"")  (cab/"") (acb/"") (abc/"")

        total possible permutations is equal to n!, here 3!=6.
        here number of recursive calls = size of processed string + 1.
    
     */
    public static void permutations(String p,String up){

        if(up.isEmpty()){
            System.out.print(p+" ");
            return;
        }

        char ch=up.charAt(0);

        for(int i = 0;i < p.length()+1; i++){

            String f = p.substring(0,i); // f finds position of where all we can place ch
            String s = p.substring(i,p.length()); // s also finds position of where all we can place ch
            permutations(f+ch+s,up.substring(1)); // f is place left to p or p, and s is either p or place right of p, so we add ch in between f and s.
        }

        // for example let's take (ba/c)
        // here one answer will be _ba, " _ " is position of f i.e. [0,0) and s is "ba" i.e. [0,2) and we add f + ch + s, i.e. we add c at "_" hence we get "cba"

    }


    public static int totalPermutations(String p,String up){

        if(up.isEmpty()){
            return 1;
        }

        char ch=up.charAt(0);
        int count=0;
        for(int i = 0;i < p.length()+1; i++){

            String f = p.substring(0,i);
            String s = p.substring(i,p.length());
            count= count + totalPermutations(f+ch+s,up.substring(1));
        }

        return count;
    }

    private static void printPermutations( String s ){
        helper("",s);
    }

    private static void helper( String processed, String unprocessed ){

        if( unprocessed.isEmpty() ){
            System.out.println(processed);
            return;
        }
        char ch = unprocessed.charAt(0);
        for( int i = 0; i <= processed.length(); i++ ){
            String pre = processed.substring(0,i);
            String post = processed.substring(i);
            helper(pre + ch + post,unprocessed.substring(1));
        }
    }

    public static void main(String[] args) {

        PermutationsStrings s = new PermutationsStrings();
        // System.out.println(totalPermutations("","abcd"));
        printPermutations("abcd");
    }

}
