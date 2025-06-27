import java.util.*;

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[] rowMarked = new boolean[m]; // replaces Set<Integer> sti
        boolean[] colMarked = new boolean[n]; // replaces Set<Integer> stj

        int[] rowFirstZero = new int[m]; // stores first zero column per row
        int[] colFirstZero = new int[n]; // stores first zero row per column

        Arrays.fill(rowFirstZero, n); // init with out-of-bound index
        Arrays.fill(colFirstZero, m);

        // First pass: find all zeroes and mark rows/columns
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rowMarked[i] = true;
                    colMarked[j] = true;
                    rowFirstZero[i] = Math.min(rowFirstZero[i], j);
                    colFirstZero[j] = Math.min(colFirstZero[j], i);
                } else {
                    if (rowMarked[i] || colMarked[j]) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        // Apply zeros to left part of marked rows
        for (int i = 0; i < m; i++) {
            if (rowMarked[i]) {
                for (int j = 0; j < rowFirstZero[i]; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Apply zeros to top part of marked columns
        for (int j = 0; j < n; j++) {
            if (colMarked[j]) {
                for (int i = 0; i < colFirstZero[j]; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
