import java.util.*;

class Solution {
    public int countSubmatrices(int[][] grid, int k) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] prefix_left = new int[n][m];
        for (int i = 0; i < n; i++) {
            prefix_left[i][0] = grid[i][0];
            for (int j = 1; j < m; j++) {
                prefix_left[i][j] = prefix_left[i][j - 1] + grid[i][j];
            }
        }

        int[][] prefix_down = new int[n][m];
        for (int j = 0; j < m; j++) {
            prefix_down[0][j] = grid[0][j];
            for (int i = 1; i < n; i++) {
                prefix_down[i][j] = prefix_down[i - 1][j] + grid[i][j];
            }
        }

        Set<Integer> set = new HashSet<>();

        for (int j = 0; j < m; j++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += prefix_left[i][j];
                if (sum <= k) {
                    set.add(j * k + i);
                }
            }
        }

        for (int i = 1; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += prefix_down[i][j];
                if (sum <= k) {
                    set.add(j * k + i);
                }
            }
        }

        return set.size();
    }
}