class Solution {
    int max_area = 0;
    char[][] mat;

    int max_right(int r, int c) {
        int right = 0;
        for (int j = c; j < mat[0].length; j++) {
            if (mat[r][j] == '1') {
                right++;
            } else {
                break;
            }
        }
        return right;
    }

    void fun(int i, int j) {
        int height = 0;
        int max_left = Integer.MAX_VALUE;

        while (i < mat.length && mat[i][j] == '1') {
            int m = max_right(i, j);
            max_left = Math.min(max_left, m);
            height++;
            int area = height * max_left;
            max_area = Math.max(max_area, area);
            i++;
        }
    }

    public int maximalRectangle(char[][] ma) {
        mat = ma;
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
