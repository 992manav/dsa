class Solution {

    int fun(char c){
        if(c=='X') return 1;
        else if(c=='Y') return -1;
        else return 0;
    }

    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] prefix_left = new int[n][m];
        for (int i = 0; i < n; i++) {
            prefix_left[i][0] = fun(grid[i][0]);
            for (int j = 1; j < m; j++) {
                prefix_left[i][j] = prefix_left[i][j-1] + fun(grid[i][j]);
            }
        }

        int[][] prefix_down = new int[n][m];
        for (int j = 0; j < m; j++) {
            prefix_down[0][j] = fun(grid[0][j]);
            for (int i = 1; i < n; i++) {
                prefix_down[i][j] = prefix_down[i-1][j] + fun(grid[i][j]);
            }
        }

        
        int[][] prefX = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int val = 0;
                if (grid[i][j] == 'X') {
                    val = 1;
                }

                int top = 0;
                if (i > 0) {
                    top = prefX[i - 1][j];
                }

                int left = 0;
                if (j > 0) {
                    left = prefX[i][j - 1];
                }

                int diag = 0;
                if (i > 0 && j > 0) {
                    diag = prefX[i - 1][j - 1];
                }

                prefX[i][j] = val + top + left - diag;
            }
        }

        Set<Integer> set = new HashSet<>();

        for (int j = 0; j < m; j++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += prefix_left[i][j];
                if(sum == 0 && prefX[i][j] > 0) set.add(i * m + j);
            }
        }

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += prefix_down[i][j];
                if(sum == 0 && prefX[i][j] > 0) set.add(i * m + j);
            }
        }

        return set.size();
    }
}