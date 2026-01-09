class Solution {
    int[][] grid;

    boolean check(int r, int c) {

        boolean[] seen = new boolean[10];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int val = grid[r + i][c + j];
                if (val < 1 || val > 9) {
                    return false;
                }
                if (seen[val]) {
                    return false;
                }
                seen[val] = true;
            }
        }

        int sum = grid[r][c] + grid[r][c + 1] + grid[r][c + 2];

        for (int i = 0; i < 3; i++) {
            int rowSum = 0;
            int colSum = 0;

            for (int j = 0; j < 3; j++) {
                rowSum += grid[r + i][c + j];
                colSum += grid[r + j][c + i];
            }

            if (rowSum != sum || colSum != sum) {
                return false;
            }
        }

        int d1 = grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2];
        int d2 = grid[r][c + 2] + grid[r + 1][c + 1] + grid[r + 2][c];

        if (d1 != sum || d2 != sum) {
            return false;
        }

        return true;
    }

    public int numMagicSquaresInside(int[][] nums) {
        grid = nums;

        int n = nums.length;
        int m = nums[0].length;
        int count = 0;

        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j <= m - 3; j++) {
                if (grid[i + 1][j + 1] == 5) {
                    if (check(i, j)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
