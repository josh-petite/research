package com.josh.recursion;

public class RobotInAGrid {
    public static void main(String[] args) {
        int[][] grid = new int[][]
                {
                        {1, 1, 0, 0, 0},
                        {1, 1, 1, 1, 1},
                        {1, 1, 0, 0, 0},
                        {0, 1, 1, 1, 0},
                        {0, 1, 0, 1, 1},
                };


        findPath(grid);
    }

    private static void print2dArray(int[][] pathTaken) {
        for (int[] r : pathTaken) {
            for (int c : r) {
                System.out.print(c + " ");
            }

            System.out.println();
        }
    }

    private static void findPath(int[][] grid) {
        int[][] pathTaken = new int[grid.length][grid.length];

        findPathHelper(grid, pathTaken, 0, 0);
    }

    private static void findPathHelper(int[][] grid, int[][] pathTaken, int row, int col) {
        // base case
        if (row == grid.length - 1 && col == grid.length - 1) {
            pathTaken[row][col] = 1;

            System.out.println();
            System.out.println("--- Final ---");
            print2dArray(pathTaken);
            return;
        }

        pathTaken[row][col] = 1;

        // check right
        if (grid.length > col + 1 && grid[row][col + 1] != 0) {
            findPathHelper(grid, pathTaken, row, col + 1);
        }

        // check down
        if (grid.length > row + 1 && grid[row + 1][col] != 0) {
            findPathHelper(grid, pathTaken, row + 1, col);
        }

        pathTaken[row][col] = 0;
    }
}
