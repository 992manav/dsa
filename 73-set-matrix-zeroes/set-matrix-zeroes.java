import java.util.*;

class Solution {
    public void setZeroes(int[][] matrix) {

        Set<Integer> sti = new HashSet<>();
        Set<Integer> stj = new HashSet<>();

        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    sti.add(i);
                    stj.add(j);
                    if (!map.containsKey(i)) {
                        map.put(i, j); // changed `add` to `put`
                    }
                    if (!map2.containsKey(j)) {
                        map2.put(j, i); // changed `add` to `put`
                    }
                } else {
                    if (sti.contains(i) || stj.contains(j)) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        for (int row : sti) {
            for (int j = 0; j < map.get(row); j++) {
                matrix[row][j] = 0;
            }
        }

        for (int col : stj) {
            for (int i = 0; i < map2.get(col); i++) {
                matrix[i][col] = 0;
            }
        }
    }
}
