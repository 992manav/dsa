class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> lst = new ArrayList<>();

        int l = 0;
        int r = matrix[0].length;
        int up = 0;
        int down = matrix.length;

        while (up < down && l < r) {

            for (int j = l; j < r; j++) {
                lst.add(matrix[up][j]);
            }

            for (int i = up + 1; i < down; i++) {
                lst.add(matrix[i][r - 1]);
            }

            if (up + 1 < down) {
                for (int j = r - 2; j >= l; j--) {
                    lst.add(matrix[down - 1][j]);
                }
            }

            if (l + 1 < r) {
                for (int i = down - 2; i > up; i--) {
                    lst.add(matrix[i][l]);
                }
            }

            up++;
            down--;
            l++;
            r--;
        }

        return lst;
    }
}
