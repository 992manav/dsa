class Solution {

    char check_peak(int[][] mat, int i, int j) {
        int n = mat.length;
        int m = mat[0].length;
        int val = mat[i][j];

        // Check up
        if (i - 1 >= 0 && val <= mat[i - 1][j]) return 'u';
        // Check down
        if (i + 1 < n && val <= mat[i + 1][j]) return 'd';
        // Check left
        if (j - 1 >= 0 && val <= mat[i][j - 1]) return 'l';
        // Check right
        if (j + 1 < m && val <= mat[i][j + 1]) return 'r';

        return 'y';
    }

    public int[] findPeakGrid(int[][] mat) {
        int i = 0;
        int j = 0;
        boolean flag = false;

        while (!flag) {
            char c = check_peak(mat, i, j);

            if (c == 'u') {
                i = i - 1;
            } else if (c == 'd') {
                i = i + 1;
            } else if (c == 'l') {
                j = j - 1;
            } else if (c == 'r') {
                j = j + 1;
            } else {
                flag = true;
                int[] arr = new int[2];
                arr[0] = i;
                arr[1] = j;
                return arr;
            }
        }
        return new int[]{-1, -1}; // fallback return to satisfy compiler
    }
}
