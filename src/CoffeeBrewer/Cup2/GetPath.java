package CoffeeBrewer.Cup2;

import java.util.ArrayList;


// Disclaimer: This code is incomplete. It will not run properly and I am lazy to complete it.
// Also, I would not know if I got it right.
/**
 * Created by HanWei on 20/10/2016.
 */
public class GetPath {
    public static boolean getPath (int r, int c, ArrayList<Point> path, final int [][] grid) {
        if (grid.length * grid[0].length == 1){
            return true;
        }else{
            int[][] rgrid = new int[r-1][c];
            for (int i = 1; i < grid[0].length; i++) {
                for (int j = 0; j < grid.length; j++) {
                    rgrid[i-1][j] = grid[i][j];
                }
            }
            int[][] dgrid = new int[r][c-1];
            for (int i = 0; i < grid[0].length; i++) {
                for (int j = 1; j < grid.length; j++) {
                    dgrid[i][j-1] = grid[i][j];
                }
            }
            if (grid[0][1] != 1 && getPath(r-1, c, path, rgrid)){
//                path.add(Point());
                return true;
            }
        }

        return true; // This was where I stopped. Just returning true to prevent compile errors in
        // this project lolol.
    }

    public static boolean isPercolated(int[][] grid){
        int[] column = new int[grid.length];
        int[] row = new int[grid[0].length];
        int colTotal = 0;
        int rowTotal = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                row[i] += grid[i][j];
                column[j] += grid[j][i];
            }
        }

        for (int a :
                column) {
            if (a == grid.length){
                return false;
            }
        }
        for (int b :
                row) {
            if (b == grid[0].length){
                return false;
            }
        }

        return true; // WARNING: THIS IS NOT WHAT THE QUESTION WAS LOOKING FOR

    }
}

class Point {
    int x;
    int y;

    Point (int x, int y) {
        this.x=x;
        this.y=y;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
