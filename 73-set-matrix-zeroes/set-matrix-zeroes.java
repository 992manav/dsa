class Solution {
    public void setZeroes(int[][] matrix) {

        Set<Integer> sti = new HashSet<>();
        Set<Integer> stj = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    sti.add(i);
                    stj.add(j);
                }
            }
        }

        for (int row : sti) {
            for (int j = 0; j < matrix[row].length; j++) { // fixed "legnth" to "length"
                matrix[row][j] = 0;
            }
        }

        for (int col : stj) {
            for (int i = 0; i < matrix.length; i++) { // fixed "legnth" to "length", also corrected "j" to "i"
                matrix[i][col] = 0;
            }
        }
    }
}
