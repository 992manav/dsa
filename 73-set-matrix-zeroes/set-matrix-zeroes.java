import java.util.*;

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        Set<Integer> sti = new HashSet<>();
        Set<Integer> stj = new HashSet<>();

        int[] rowFirstZero = new int[m]; // stores first zero column index per row
        int[] colFirstZero = new int[n]; // stores first zero row index per column

        Arrays.fill(rowFirstZero, n); // initialize with out-of-bound default
        Arrays.fill(colFirstZero, m);

        // Step 1: Identify zero locations
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    sti.add(i);
                    stj.add(j);
                    rowFirstZero[i] = Math.min(rowFirstZero[i], j);
                    colFirstZero[j] = Math.min(colFirstZero[j], i);
                } else {
                    if (sti.contains(i) || stj.contains(j)) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        // Step 2: Set zeros in affected rows
        for (int row : sti) {
            for (int j = 0; j < rowFirstZero[row]; j++) {
                matrix[row][j] = 0;
            }
        }

        // Step 3: Set zeros in affected columns
        for (int col : stj) {
            for (int i = 0; i < colFirstZero[col]; i++) {
                matrix[i][col] = 0;
            }
        }
    }
}
