package Games;

import java.util.Scanner;

// my own implementation

public class TicTacToePrac {

    public static void displayBoard(char[][] board){

        for(char[] arr: board){
            for(char ele: arr){
                System.out.print(" "+ele+" ");
            }
            System.out.println();
        }
    }

    public static void play(char[][] board){

        Scanner sc= new Scanner(System.in);


        while(!haveWon(board) && !isFull(board)) {

            boolean val1=false;
            boolean val2=false;

            while (!val1) {
                System.out.println();
                System.out.print("X's move, enter coordinates of the cell (r,c): (index are from 0-2) : ");
                System.out.println();
                int r = sc.nextInt();
                int c = sc.nextInt();
                if (isSafe(board, r, c)) {
                    board[r][c] = 'X';
                    val1 = true;
                    if(haveWon(board)){
                        System.out.println();
                        System.out.println("'X' has won the game !! ");
                        break;
                    }
                } else {
                    System.out.println("!!! That cell is already filled, enter some other coordinates.");
                }
            }
            System.out.println();

            if(!haveWon(board) && !isFull(board)) {

                while (!val2) {
                    displayBoard(board);
                    System.out.println();
                    System.out.print("O's move, enter coordinates of the cell (r,c): (index are from 0-2) : "); // user2's move is O = 2
                    System.out.println();
                    int r = sc.nextInt();
                    int c = sc.nextInt();
                    if (isSafe(board, r, c)) {
                        board[r][c] = 'O';
                        val2 = true;
                        if(haveWon(board)){
                            System.out.println();
                            System.out.println("'O' has won the game !! ");
                            break;
                        }

                    } else {
                        System.out.println();
                        System.out.println("!!! That cell is already filled, enter some other coordinates.");
                    }
                }
                System.out.println();
                displayBoard(board);
            }
            else{
                break;
            }
        }
        if(isFull(board) && !haveWon(board)){
            System.out.println();
            System.out.println("its a draw.");
        }

    }

    private static boolean haveWon(char[][] board) {


        for(int i=0;i<board.length;i++) {

            // check for same row

            if (board[i][0] == 'X' &&  board[i][board.length - 2]=='X' && board[i][board.length - 1]=='X') {
                return true;
            }

            if (board[i][0] == 'O' &&  board[i][board.length - 2]=='O' && board[i][board.length - 1]=='O') {
                return true;
            }

            // check for same col

            if (board[0][i] == 'X' &&  board[1][i]=='X' && board[2][i]=='X') {
                return true;
            }

            if (board[0][i] == 'O' &&  board[1][i]== 'O' && board[2][i]=='O') {
                return true;
            }

            // check for diagonal

            if(board[0][0]== 'X' && board[1][1]== 'X' && board[2][2]=='X'){
                return true;
            }

            if(board[0][0]== 'O' && board[1][1]== 'O' && board[2][2]=='O'){
                return true;
            }
        }

        return false;
    }

    private static boolean isFull(char[][] board) {

        for(char[] arr: board){
            for(char ele: arr){
                if(ele=='\0'){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isSafe(char[][] board,int row,int col) {

        if(board[row][col]=='\0'){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        char board[][]=new char[3][3];
        System.out.println();
        displayBoard(board);
        System.out.println();
        play(board);
    }
}

