class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {

        int[][] dat = new int[n][n + 1];

        for (int i = 0; i < queries.length; i++) {
            int r1 = queries[i][0];
            int c1 = queries[i][1];
            int r2 = queries[i][2];
            int c2 = queries[i][3];

            for (int r = r1; r <= r2; r++) {
                dat[r][c1] += 1;
                if (c2 + 1 < n) dat[r][c2 + 1] -= 1;
            }
        }

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            int prev = 0;
            for (int j = 0; j < n; j++) {
                prev += dat[i][j];
                arr[i][j] = prev;
            }
        }

        return arr;
    }
}
