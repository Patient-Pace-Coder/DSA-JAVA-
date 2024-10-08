package Recursion;

import java.util.ArrayList;

public class StairCases {

    /*

    Problem :

    we are given 4 staircases ------|
                                    |-----|
                                          |----|
                                               |----|
                                                    |
              ----------------------------------------------------

    we should come down by only using [ 1 2 3 ] number of steps
    i.e. we can only climb 1 or 2 or 3 steps at once.

    intuition :

                                        4              we re step number 4
                                 1/       2|      3\ -- from step 4 we can take 1 | 2 | 3 steps

                                 3        2         1 -- we will reach step number 3 | 2 | 1 based on number of steps we took

                                1/           2|        3\
                                2              1        0
                            1/ 2| 3\        1/ 2| 3\
                            1   0  -1       0  -1  -2

                and this goes on until all te leaf nodes are 0 or -ve. ( base cases )

     */

    private static ArrayList<String> getAllSteps( int n ){

        if( n == 0 ){
            ArrayList<String> curRes = new ArrayList<>();
            curRes.add("");
            return curRes;
        }

        if( n < 0 ){
            ArrayList<String> curRes = new ArrayList<>();
            return curRes;
        }

        ArrayList<String> paths1 = getAllSteps(n - 1);
        ArrayList<String> paths2 = getAllSteps(n - 2);
        ArrayList<String> paths3 = getAllSteps(n - 3);

        ArrayList<String> allPaths = new ArrayList<>();

        for ( String ele : paths1 ) {
            allPaths.add( 1 + ele );
        }

        for ( String ele : paths2 ) {
            allPaths.add( 2 + ele );
        }

        for ( String ele : paths3 ) {
            allPaths.add( 3 + ele );
        }

        return allPaths;
    }


    private static int totalPaths( int n ){

        if( n == 0 ){
            return 1;
        }
        else if( n < 0 ){
            return 0;
        }
        int oneSteps = totalPaths(n - 1);
        int twoSteps = totalPaths(n - 2);
        int threeSteps = totalPaths(n - 3);

        return oneSteps + twoSteps + threeSteps;
    }

    private static void allPaths( int n, String path ){

        if( n == 0 ){
            System.out.println(path); ;
        }
        else if( n < 0 ){
            return;
        }
        allPaths(n - 1,path + "1");
        allPaths(n - 2,path + "2");
        allPaths(n - 3,path + "3");
    }


    public static void main(String[] args) {

    // ArrayList<String> allPaths = getAllSteps(4);
    // System.out.println(totalPaths(4));
    allPaths(4,"");

    }
}
