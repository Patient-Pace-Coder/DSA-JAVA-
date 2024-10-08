package Games;

import java.util.Scanner;

public class SudokuGame // AI assignment code
{
    public static boolean SafetyCheck(int[][] grid,
                                      int row, int col,
                                      int num)
    {

        for (int i = 0; i < grid.length; i++)
        {
            if (grid[row][i] == num)
            {
                return false;
            }
        }


        for (int i = 0; i < grid.length; i++)
        {
            if (grid[i][col] == num)
            {
                return false;
            }
        }

        //3x3 grid check
        int root = (int) Math.sqrt(grid.length);
        int Gridrow = row - row % root;
        int GridCol = col - col % root;

        for (int i = Gridrow;i < Gridrow + root; i++)
        {
            for (int j = GridCol;j < GridCol + root; j++)
            {
                if (grid[i][j] == num)
                {
                    return false;
                }
            }
        }


        return true;
    }

    public static boolean SudokuSolver(int[][] grid, int n)
    {
        int row = -1;
        int col = -1;
        boolean empty = true;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] == 0)
                {
                    row = i;
                    col = j;
                    empty = false;
                    break;
                }
            }
            if (!empty)
            {
                break;
            }
        }

        if (empty)
        {
            return true;
        }


        for (int k = 1; k <= n; k++)
        {
            if (SafetyCheck(grid, row, col, k))
            {
                grid[row][col] = k;
                if (SudokuSolver(grid, n))
                {
                    return true;
                }
                else
                {
                    grid[row][col] = 0;
                }
            }
        }
        return false;
    }

    public static void print(int[][] grid, int N)
    {  System.out.println("\n\n\nThe Solution:\n");

        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                System.out.print(grid[i][j]);
                System.out.print(" ");
            }
            System.out.print("\n");

            if ((i + 1) % (int) Math.sqrt(N) == 0)
            {
                System.out.print("");
            }
        }
    }

    // Driver Code
    public static void main(String args[])
    {
        int[][] grid = new int[3][3];
        Scanner s=new Scanner(System.in);
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                grid[i][j]=s.nextInt();

        int length = grid.length;

        if (SudokuSolver(grid, length))
        {
            print(grid, length);
        }
        else
        {
            System.out.println("No Solution Exists");
        }
    }
}