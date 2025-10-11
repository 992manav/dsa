import java.util.*;

class Solution {
    public int equalPairs(int[][] grid) {

        int n = grid.length;
        Map<List<Integer>, Integer> map = new HashMap<>();

        // store each row as a list and count frequency
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(grid[i][j]);
            }
            map.put(row, map.getOrDefault(row, 0) + 1);
        }

        int ans = 0;

        // check each column against row map
        for (int i = 0; i < n; i++) {
            List<Integer> col = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                col.add(grid[j][i]);
            }
            ans += map.getOrDefault(col, 0);
        }

        return ans;
    }
}
