//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])
    {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int grid[][] = new int[9][9];
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                    grid[i][j] = sc.nextInt();
            }

            Solution ob = new Solution();

            if(ob.SolveSudoku(grid) == true)
                ob.printGrid(grid);
            else
                System.out.print("NO solution exists");
            System.out.println();

        }
    }
}




// } Driver Code Ends




//User function Template for Java

class Solution
{
    //Function to find a solved Sudoku.
    static boolean SolveSudoku(int grid[][])
    {
        return helper(grid,0,0);

    }
    static boolean helper(int grid[][],int row,int col)
    {
        if(row==9)
        {
            return true;
        }
        int nextrow=row;
        int nextcol=col+1;
        if(col+1==9)
        {
            nextrow++;
            nextcol=0;
        }
        if(grid[row][col]!=0)
        {
            return helper(grid,nextrow,nextcol);
        }
        for(int digit=1;digit<=9;digit++)
        {
            if(issafe(grid,digit,row,col))
            {
                grid[row][col]=digit;
                if(helper(grid,nextrow,nextcol))
                {
                    return true;

                }
                else
                {
                    grid[row][col]=0;
                }
            }
        }
        return false;

    }
    static boolean issafe(int grid[][],int digit,int row,int col)
    {
        for(int i=0;i<9;i++)
        {
            if(grid[row][i]==digit)
            {
                return false;
            }
        }
        for(int j=0;j<9;j++)
        {
            if(grid[j][col]==digit)
            {
                return false;
            }
        }
        int sr=(row/3)*3;
        int sc=(col/3)*3;
        for(int i=sr;i<sr+3;i++)
        {
            for(int j=sc;j<sc+3;j++)
            {
                if(grid[i][j]==digit)
                {
                    return false;
                }
            }

        }
        return true;
    }


    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {

                System.out.print(grid[i][j]+" ");



            }

        }

    }
}