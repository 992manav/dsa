class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int ans = 0;
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    curr[j + 1] = Math.min(Math.min(prev[j + 1], prev[j]), curr[j]) + 1;
                    ans += curr[j + 1];
                } else {
                    curr[j + 1] = 0;
                }
            }
            // swap rows
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return ans;
    }
}
