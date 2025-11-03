import java.util.*;

class Solution { 
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) { 
        
        int[][] grid = new int[m][n];
        
        // mark guards
        for (int i = 0; i < guards.length; i++) {
            int r = guards[i][0];
            int c = guards[i][1];
            grid[r][c] = 1;
        }
        
        // mark walls
        for (int i = 0; i < walls.length; i++) {
            int r = walls[i][0];
            int c = walls[i][1];
            grid[r][c] = 2;
        }

        // left to right
        for (int i = 0; i < m; i++) {
            boolean flag = false;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    flag = true;
                } else if (grid[i][j] == 2) {
                    flag = false;
                } else {
                    if (flag) {
                        grid[i][j] = 3; // mark as guarded
                    }
                }
            }
        }

        // right to left
        for (int i = 0; i < m; i++) {
            boolean flag = false;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    flag = true;
                } else if (grid[i][j] == 2) {
                    flag = false;
                } else {
                    if (flag) {
                        grid[i][j] = 3;
                    }
                }
            }
        }

        // top to bottom
        for (int j = 0; j < n; j++) {
            boolean flag = false;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) {
                    flag = true;
                } else if (grid[i][j] == 2) {
                    flag = false;
                } else {
                    if (flag) {
                        grid[i][j] = 3;
                    }
                }
            }
        }

        // bottom to top
        for (int j = 0; j < n; j++) {
            boolean flag = false;
            for (int i = m - 1; i >= 0; i--) {
                if (grid[i][j] == 1) {
                    flag = true;
                } else if (grid[i][j] == 2) {
                    flag = false;
                } else {
                    if (flag) {
                        grid[i][j] = 3;
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    count++;
                }
            }
        }
        
        return count;
    } 
}
