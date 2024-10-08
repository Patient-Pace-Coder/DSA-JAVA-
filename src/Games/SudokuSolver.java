package Games;

public class SudokuSolver { // my own implementation

    public static boolean solveSudoku(int[][] board){

        for(int row=0;row<board.length;row++){ // row number

            for(int col =0; col < board[row].length; col++){ // column number

                if(board[row][col]==0){

                    for(int num = 1;num <= 9; num++){ // trying number from 1-9 to insert

                        if( isSafe(board,row,col,num) == true ){

                            board[row][col] = num;

                            if(solveSudoku(board)){
                                return true;
                            }

                            board[row][col]=0; // backtracking, i.e. setting empty cell to empty.

                        }
                    }

                    return false; // if it cannot find any value between 1-9 as safe returns false;
                }
            }
        }

        return true; // as there are no empty spots found

    }

    private static boolean isSafe(int[][] board, int row, int col, int num) {

        // row check

        for(int i=0;i<9;i++){

            if( board[row][i] == num ){
                return false;
            }
        }

        // column check

        for(int j=0;j<9;j++){

            if( board[j][col] == num){
                return false;
            }
        }

        // box/Grid check

        int rStart = row/3*3;
        int cStart = col/3*3;

        for( int k=rStart;k<rStart+3;k++){
            for(int l=cStart;l<cStart+3;l++){

                if( board[k][l] == num){

                    return false;
                }
            }
        }

        return true;
    }


    public static void main(String[] args) {

        int[][] board = {

                {5,3,0,0,7,0,0,0,0},
                {6,0,0,1,9,5,0,0,0},
                {0,9,8,0,0,0,0,6,0},
                {8,0,0,0,6,0,0,0,3},
                {4,0,0,8,0,3,0,0,1},
                {7,0,0,0,2,0,0,0,6},
                {0,6,0,0,0,0,2,8,0},
                {0,0,0,4,1,9,0,0,5},
                {0,0,0,0,8,0,0,7,9}
        };

        boolean isExist = solveSudoku(board);

        if(isExist){

            System.out.println();
            System.out.println("Solution : ");
            System.out.println();

            for(int[] row:board){
                for(int ele:row){
                    System.out.print(ele+" ");
                }
                System.out.println();
            }
        }
        else{
            System.out.println("Sorry!! , solution doesn't exist.");
        }



    }
}
