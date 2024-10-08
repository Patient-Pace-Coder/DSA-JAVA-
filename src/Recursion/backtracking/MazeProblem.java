package Recursion.backtracking;

import java.util.ArrayList;

public class MazeProblem {  //no restrictions

//     Maze is a 3/3 matrix with (0,0) as the starting point/index (S) and we have to reach to end point (E) (2,2).
//     we can only move down or right.
//        |__S_|____|____|     example path: |
//        |____|____|____|                   |D
//        |____|____|__E_|                   |DD __ __   PATH: D-D-R-R.
//                                               R  R
//                            Total possible paths are : RDRD , DRDR , DDRR , RDDR , RRDD , DRRD = 6.

//    without diagonal -------->
//    public static int countPath( int row,int col){
//
//        // base case: because when we reach the last row the only possible path is going towards right till end, so the path is counted 1.
//        // and when we reach the last column the only possible path is going in the downward direction till the end, so the path is counted 1.
//
//        if(row==2 || col==2){
//            return 1;
//        }
//
//        int right=countPath(row,col+1); // MOVING TO RIGHT MEANS COLUMN IS INCREASING
//        int down=countPath(row+1,col); // MOVING TO DOWN MEANS ROW VALUE IS INCREASING
//
//        return right+down;
//
////      return countPath(row,col+1)+countPath(row+1, col); // alternative ,without using any variables
//
//    }

    // using single variable

    public static int countPath( int row,int col){

        int count=0;
        if(row==2 || col==2){
            return 1;
        }

        count+=countPath(row,col+1); // MOVING TO RIGHT MEANS COLUMN IS INCREASING
        count+=countPath(row+1,col); // MOVING TO DOWN MEANS ROW VALUE IS INCREASING

        return count;

    }



    // Normally printing each path
    static void getPaths(String processed,int row,int col){

        if(row==2 && col==2){ // base case: if target grid is reached, then print and explore other paths.
            System.out.print(processed+" ");
            return;
        }

        if(col<2) { // first explores possible paths starting from right.
            getPaths(processed + "H", row, col + 1);
        }
        if(row<2) { // then explores possible paths starting from down
            getPaths(processed + "V", row + 1, col);
        }

    }

    // Storing paths in arraylist and returning the arraylist. - not an optimal way

    public ArrayList<String> getPaths(int row, int col, String processed){

        ArrayList<String> list=new ArrayList<>();

        if(row==2 && col==2){ // base case: if target grid is reached, then print and explore other paths.
            list.add(processed);
            return list;
        }
        ArrayList<String> ansFromPreviousCalls;

        if(col<2) { // first explores possible paths starting from right.

             ansFromPreviousCalls=(getPaths( row, col + 1,processed + "H"));
             list.addAll(ansFromPreviousCalls);
        }
        if(row<2) { // then explores possible paths starting from down

             ansFromPreviousCalls=(getPaths( row + 1, col,processed + "V"));
             list.addAll(ansFromPreviousCalls);
        }
        return list;
    }


    // Using static arraylist - Memory efficient way

//    static ArrayList<String> mainList=new ArrayList<>();
//
//    static ArrayList<String> getPaths(int row, int col, String processed){
//
//        if(row==2 && col==2){ // base case: if target grid is reached, then print and explore other paths.
//            mainList.add(processed);
//            return mainList;
//        }
//
//        if(col<2) { // first explores possible paths starting from right.
//            getPaths( row, col + 1,processed + "R");
//        }
//        if(row<2) { // then explores possible paths starting from down
//            getPaths( row + 1, col,processed + "D");
//        }
//
//        return mainList;
//
//    }


//    with diagonal ---------------------------->

    public static int countPathsWithDiagonal(int row,int col){
        int count=0;

        if(row==2 && col==2){
            return 1;
        }
        if(col<2){
            count+=countPathsWithDiagonal(row,col+1);
        }
        if(row<2){
            count+=countPathsWithDiagonal(row+1,col);
        }
        if(row<2 && col<2){
            count+=countPathsWithDiagonal(row+1,col+1);
        }

        return count;
    }

    public static void getPathsWithDiagonal(String processed,int row,int col){

        if(row==2 && col==2){
            System.out.print(processed+" ");
            return;
        }
        if(col<2){
            getPathsWithDiagonal(processed+"H",row,col+1);
        }
        if(row<2){
            getPathsWithDiagonal(processed+"V",row+1,col);
        }
        if((row<2 && col<2)){
            getPathsWithDiagonal(processed+"D",row+1,col+1);
        }
    }


    public static void main(String[] args) {
//        System.out.println(countPath(0,0));
//        getPaths(" ",0,0);

        MazeProblem obj=new MazeProblem();
       // System.out.println(obj.getPaths(0,0," "));
//        System.out.println(countPathsWithDiagonal(0,0));
        getPaths(" ",0,0);
        System.out.println();
        getPathsWithDiagonal(" ",0,0);
    }
}
