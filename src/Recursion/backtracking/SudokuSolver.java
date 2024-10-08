package Recursion.backtracking;

public class SudokuSolver {

    public static boolean isValid(int board[][],int number,int row,int col){

        // check row
        for(int i=0;i<board.length;i++){
            if(board[row][i]==number){
                return false;
            }
        }

        // check col
        for(int i=0;i<board.length;i++){
            if(board[i][col]==number){
                return false;
            }
        }

        // check 3x3 grid
        int rStart=(row/3)*3;
        int cStart=(col/3)*3;

        for(int i=rStart;i<rStart+3;i++) {
            for (int j = cStart; j < cStart + 3; j++) {
                if (board[i][j] == number) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void solveBoard(int[][] board,int row,int col){

        if(row==9){ // base case
            System.out.println();
            for(int[] rows:board){
                for (int ele:rows){
                    System.out.print(ele+" ");
                }
                System.out.println();
            }
            return;
        }

        if(board[row][col]!=0){
            if(col!=8) {
                solveBoard(board, row, col + 1);
            }
            else{
                solveBoard(board,row+1,0);
            }
        }

        else { // if board[row][col]==0
            for (int z = 1; z <= 9; z++) {

                if (isValid(board, z, row, col)) {
                    board[row][col] = z;
                    if (col != 8) {
                        solveBoard(board, row, col + 1);
                    } else {
                        solveBoard(board, row + 1, 0);
                    }
                    board[row][col] = 0; // ----> backtracking
                }
            }
        }


        // error code

//
//        if(board[row][col]==0) {
//
//            for (int z = 1; z <= 9; z++) {
//
//                if (isValid(board, z, row, col)) {
//                    board[row][col] = z;
//                    break;
//                }
//
//            }
//        }
//
//        else {
//
//            if (col != 8) {
//                solveBoard(board, row, col + 1);
//            } else {
//                solveBoard(board, row + 1, 0);
//            }
//            board[row][col] = 0;
//        }
//
    }


    public static void main(String[] args) {



        int board[][]={
                {5,3,0,0,7,0,0,0,0},
                {6,0,0,1,9,5,0,0,0},
                {0,9,8,0,0,0,0,6,0},
                {8,0,0,0,6,0,0,0,3},
                {4,0,0,8,0,3,0,0,1},
                {7,0,0,0,2,0,0,0,6},
                {0,6,0,0,0,0,2,8,0},
                {0,0,0,4,1,9,0,0,5},
                {0,0,0,0,8,0,0,7,9},
        };


        solveBoard(board,0,0);
    }
}
