package Recursion.backtracking;

import java.util.Arrays;

public class PathRestrictions { // with restrictions

    //        Maze is a 3/3 matrix with (0,0) as the starting point/index (S) and we have to reach to end point (E) (2,2).
//     we can only move down or right.
//        |__S_|____|____|     example path: |
//        |____|____|____|                   |D
//        |____|____|__E_|                   |DD __ __   PATH: D-D-R-R.
//                                               R  R



    public static void getPath(boolean maze[][],String processed,int row,int col){ // only 2 directions were allowed ("H","V)
        if(row==maze.length-1 && col==maze[0].length-1){
            System.out.print(processed+" ");
            return;
        }
        if(col< maze[0].length-1 && (maze[row][col+1]!=false)){
            getPath(maze,processed+"H",row,col+1);
        }
        if(row< maze.length-1 && (maze[row+1][col]!=false)){
            getPath(maze,processed+"V",row+1,col);
        }

//        if(row==col && maze[row+1][col+1]!=false){  // diagonal optional
//            getPath(maze,processed+"D",row+1,col+1);
//        }

    }



//    public static void getAllPaths(boolean maze[][],String processed,int row,int col){ // 4 directions are allowed ("R","D","U","L")
//
//        if(row==maze.length-1 && col==maze[0].length-1){
//            System.out.print(processed+" ");
//            return;
//        }
//
//        if(col< maze[0].length-1 && (maze[row][col+1]!=false)){
//            getAllPaths(maze,processed+"R",row,col+1);
//        }
//        if(row< maze.length-1 && (maze[row+1][col]!=false)){
//            getAllPaths(maze,processed+"D",row+1,col);
//        }
//
//        if(col>0 && maze[row][col-1]!=false){
//            getAllPaths(maze,processed+"L",row,col-1);
//        }
//
//        if (row>0 && maze[row-1][col]!=false){ // results in stack overflow error, as it results in unlimited recursive calls
//            getAllPaths(maze,processed+"U",row-1,col);
//        }
//
//    }

    // SOLUTION FOR THE ABOVE PROBLEM:

//       now what we do is while finding the path we go on marking visited cell as false so that we won't go back to the cell which we already visited
//        but if that's the case then we will only be able to travel in one path as most of the cells will be marked false.
//            so backtracking means after reaching the goal state or after trying for it no matter what the outcome is, while we go back we mark the visited cells to true, i.e. finally after each successful path the maze will remain same as it was initially i.e. all true's.


    public static void getAllPaths(boolean maze[][],String processed,int row,int col){ // 4 directions are allowed ("R","D","U","L") // diagonal not allowed

        maze[row][col]=false; // as the cell is visited we mark it as false, so that we wont come back to already visited cell( rule ).

        if(row==maze.length-1 && col==maze[0].length-1){
            System.out.print(processed+" ");
            return;
        }
        if(col< maze[0].length-1 && (maze[row][col+1]!=false)){
            getAllPaths(maze,processed+"R",row,col+1);
            maze[row][col+1]=true; // reverting the changes i.e. remarking the cells to true...so that it generates a new path.
        }
        if(row< maze.length-1 && (maze[row+1][col]!=false)){
            getAllPaths(maze,processed+"D",row+1,col);
            maze[row+1][col]=true;// reverting the changes i.e. remarking the cells to true...so that it generates a new path.
        }

        if(col>0 && maze[row][col-1]!=false){
            getAllPaths(maze,processed+"L",row,col-1);
            maze[row][col-1]=true;// reverting the changes i.e. remarking the cells to true...so that it generates a new path.
        }

        if (row>0 && maze[row-1][col]!=false){
            getAllPaths(maze,processed+"U",row-1,col);
            maze[row-1][col]=true;// reverting the changes i.e. remarking the cells to true...so that we can generate a new path.
        }
    }

    // displaying the step number, the exact path number wise.

    public static void allPaths(boolean[][] maze,int[][] path,String processed,int row,int col,int step){ // shows path number wise

        maze[row][col]=false;
        path[row][col]=step;

        if(row==maze.length-1 && col== maze.length-1){
            for(int[] arr:path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(processed);
            System.out.println();
            System.out.println();
            return;
        }

        if(col< maze[0].length-1 && (maze[row][col+1] /* maze[row][col+1]!=false */ )){
            allPaths(maze,path,processed+"R",row,col+1,step+1);
            maze[row][col+1]=true; // reverting the changes i.e. remarking the cells to true...so that it generates a new path.
            path[row][col+1]=0; // reverting the changes made in the path
        }
        if(row< maze.length-1 && (maze[row+1][col] /* maze[row+1][col]!=false */ )){
            allPaths(maze,path,processed+"D",row+1,col,step+1);
            maze[row+1][col]=true;// reverting the changes i.e. remarking the cells to true...so that it generates a new path.
            path[row+1][col]=0;
        }

        if(col>0 && maze[row][col-1] /* maze[row][col-1]!=false */ ){
            allPaths(maze,path,processed+"L",row,col-1,step+1);
            maze[row][col-1]=true;// reverting the changes i.e. remarking the cells to true...so that it generates a new path.
            path[row][col-1]=0;
        }

        if (row>0 && maze[row-1][col]  /* maze[row-1][col]!=false */ ){
            allPaths(maze,path,processed+"U",row-1,col,step+1);
            maze[row-1][col]=true;// reverting the changes i.e. remarking the cells to true...so that we can generate a new path.
            path[row-1][col]=0;
        }

        if(row==col && maze[row+1][col+1] /* maze[row+1][col+1]!=false */  ){  // optional diagonal
            allPaths(maze,path,processed+"DI",row+1,col+1,step+1);
            maze[row+1][col+1]=true;
            path[row+1][col+1]=0;
        }

    }

    public static void main(String[] args) {

        boolean maze[][] = { // blocked maze : true:-unblocked cell, false:-blocked cell.
                {true,true,true},
                {true,true,true},
                {true,false,true}
            };

//        getPath(maze," ",0,0);

//         getAllPaths(maze," ",0,0);

        int[][] path=new int[maze.length][maze.length];

        allPaths(maze,path," ",0,0,1);

    }
}
