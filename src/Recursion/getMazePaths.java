package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class getMazePaths {

    /*

    problem:

    we be given a 2D matrix or grid, N X N grid , we have to reach from (0,0) to (n-1,n-1).
    we can only move either one step vertically or horizontally.

     */

    // One way of doing it :
    static int N;
    static int count = 0; /// to count the number of paths, count is optional not asked in the question.

    // sr - Source Row
    // sc - Source column
    // dr - Destination row
    // dc - Destination column
    private static ArrayList<String> getMazePaths( int sr, int sc, int dr, int dc,String processed){

        if( (sr == N - 1) && (sc == N - 1) ) {
            ArrayList<String> curRes = new ArrayList<>();
            count = count + 1;
            curRes.add(processed + count );
            return curRes;
        }

        ArrayList<String> finalPaths = new ArrayList<>();
        if( sc < N ){ // must use 'if', don't use 'else if'
            ArrayList<String> leftPaths = getMazePaths( sr, sc + 1, dr, dc, processed+ "H");
            finalPaths.addAll(leftPaths);
        }
        if ( sr < N ) { // must use 'if', don't use 'else if'
            ArrayList<String> rightPaths = getMazePaths( sr + 1, sc, dr, dc, processed + "V");
            finalPaths.addAll(rightPaths);
        }

        return finalPaths;

    }

    // Alternative way :

    // 2nd approach is if there is any restriction on parameters, i.e. only given parameters should be used.
    private static ArrayList<String> getMazePathsAlt( int sr, int sc, int dr, int dc){

        if( (sr == N - 1) && (sc == N - 1) ) {
            ArrayList<String> curRes = new ArrayList<>();
            curRes.add("");
            return curRes;
        }

        ArrayList<String> finalPaths = new ArrayList<>();
        if( sc < N ){ // must use 'if', don't use 'else if'
            ArrayList<String> leftPaths = getMazePathsAlt( sr, sc + 1, dr, dc);
            for( String ele : leftPaths ){
                finalPaths.add("H"+ele);
            }
        }
        if ( sr < N ) { // must use 'if', don't use 'else if'
            ArrayList<String> rightPaths = getMazePathsAlt( sr + 1, sc, dr, dc);
            for( String ele : rightPaths ){
                finalPaths.add("V"+ele);
            }
        }

        return finalPaths;

    }


    /*

    problem:

    we be given a 2D matrix or grid, N X N grid , we have to reach from (0,0) to (n-1,n-1).
    we can only move any number of steps either vertically or horizontally, i.e. you can take a jump vertically or horizontally.

    this problem is a combinations of staircase and maze paths.

    Here we calculate or visit only that position which are possible from that position.

                                             (1,1)

                              h1/           h2/          v1\  v2\
                              (1,2)         (1,3)          (2,1) (3,1)

                         h1/  v1\  v2\      v1\  v2\       similarly goes on for this until it reaches (3,3).
                        (1,3) (2,2) (3,2)   (2,3) (3,3)
                                             v1\
                                             (3,3)

        no unwanted calls will be done as done in staircase problem.
        i.e. for staircase problem we used to go till -1,-2 steps which are invalid but here we avoid unwanted paths with the conditions in for loops.

     */

    private static void printMazePathsWithJumps( int sr, int sc, int dr, int dc,String path){

        // we start from  (1,1) and reach (N,N)

        if( (sr == dr) && (sc == dc) ) { // base case
            System.out.print(path+ "  ");
             return;
        }

        for( int moveSize = 1; moveSize <= dc - sc; moveSize++ ){ // we can move horizontally with moveSize equal to dc - sc.
            printMazePathsWithJumps(sr,sc + moveSize,dr,dc,path + "H" + moveSize);
        }

        for( int moveSize = 1; moveSize <= dr - sr; moveSize++ ){ // we can move vertically with moveSize equal to dr - sr.
            printMazePathsWithJumps(sr + moveSize,sc,dr,dc,path + "V" + moveSize);
        }

        for( int moveSize = 1; moveSize <= dr - sr && moveSize <= dc - sc; moveSize++ ){ // we can move diagonally with (moveSize <= dr - sr) && (moveSize <= dc - sc)
            printMazePathsWithJumps(sr + moveSize,sc + moveSize,dr,dc,path + "D" + moveSize);
        }

    }

    private static int totalPaths( int srcRow, int srcCol, int destRow, int destCol ){

        if( srcRow == destRow && srcCol == destCol ){
            return 1;
        }
        else if( srcRow > destRow || srcCol > destCol ){
            return 0;
        }
        int verticalCount = totalPaths(srcRow + 1,srcCol, destRow,destCol);
        int horizontalCount = totalPaths( srcRow,srcCol + 1,destRow,destCol);

        return verticalCount + horizontalCount;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        ArrayList<String> allMazePaths = getMazePaths(0,0,N - 1, N - 1, "");
        System.out.println(allMazePaths);
        System.out.println(allMazePaths.size());

        // ArrayList<String> allMazePaths1 = getMazePathsAlt(0,0,N - 1, N - 1);
        // System.out.println(allMazePaths1);

        // printMazePathsWithJumps(1,1,N, N,"");
        System.out.println(totalPaths(0,0,N - 1,N - 1));
    }
}
