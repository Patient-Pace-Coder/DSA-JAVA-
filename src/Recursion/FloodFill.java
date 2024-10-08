package Recursion;

import java.util.Scanner;

public class FloodFill {

    /*

    There is  maze which has obstacles in between
    i.e. the maze is a 2D array in which 0's and 1's will be filled, 0's are empty cells or walkable paths
    whereas 1's are obstacles through which we cannot go.
    so problem is to go from source position to destination, without visiting the same cell twice in a single path.

    Allowed moves :
    we can either move : 1 step down, 1 step top, 1 step left, 1 step right.

     */

    private static void floodFill( int[][] maze, int row,int col,String psf, boolean visited[][] ){


        if( row == maze.length || col == maze[0].length || row < 0 || col < 0 || maze[row][col] == 1 || visited[row][col] == true ){
            return;
        }
        if ( row == maze.length - 1 && col == maze[0].length - 1) {
            System.out.println(psf);
            return;
        }

        visited[row][col] = true;
        // this order is to match the testcases, otherwise order doesn't matter.
        floodFill(maze,row -1, col, psf + "T",visited);
        floodFill(maze,row, col - 1, psf + "L",visited);
        floodFill(maze,row + 1, col, psf + "D",visited);
        floodFill(maze,row, col + 1, psf + "R",visited);

        // Even this works
        // floodFill(maze,row -1, col, psf + "T",visited);
        // floodFill(maze,row + 1, col, psf + "D",visited);
        // floodFill(maze,row, col - 1, psf + "L",visited);
        // floodFill(maze,row, col + 1, psf + "R",visited);

        visited[row][col] = false; //  backtrack
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int row = sc.nextInt();
        int col = sc.nextInt();

        int maze[][] = {
                {0,1,1},
                {0,0,1},
                {1,0,0},
                {0,1,0}
        };
        boolean visited[][] = new boolean[row][col];

        floodFill(maze,0,0,"",visited);
    }
}
