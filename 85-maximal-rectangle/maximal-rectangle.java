class Solution {
    int max_area = 0;
    char[][] mat;
    int[][] right;

    void precomputeRight() {
        int rows = mat.length, cols = mat[0].length;
        right = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            int count = 0;
            for (int j = cols - 1; j >= 0; j--) {
                if (mat[i][j] == '1') {
                    count++;
                } else {
                    count = 0;
                }
                right[i][j] = count;
            }
        }
    }

    void fun(int i, int j) {
        int height = 0;
        int max_left = Integer.MAX_VALUE;
        while (i < mat.length && mat[i][j] == '1') {
            max_left = Math.min(max_left, right[i][j]);
            height++;
            int area = height * max_left;
            max_area = Math.max(max_area, area);
            i++;
        }
    }

    public int maximalRectangle(char[][] ma) {
        mat = ma;
        precomputeRight();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == '1') {
                    fun(i, j);
                }
            }
        }
        return max_area;
    }
}
