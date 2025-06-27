class Solution {
    public void setZeroes(int[][] matrix) {

        Set<Integer> sti = new HashSet<>();
        Set<Integer> stj = new HashSet<>();

        int rows = matrix.length;
        int cols = matrix[0].length;

        // First pass: record positions of zeros
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    sti.add(i);
                    stj.add(j);
                }
            }
        }

        // Second pass: set zeros based on recorded rows and columns
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (sti.contains(i) || stj.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
