import java.util.*;

class Solution {

    public int countCoveredBuildings(int n, int[][] grid) {

        Map<Integer, TreeSet<Integer>> xmap = new HashMap<>();
        Map<Integer, TreeSet<Integer>> ymap = new HashMap<>();

        for (int i = 0; i < grid.length; i++) {
            int x = grid[i][0];
            int y = grid[i][1];

            if (xmap.containsKey(x)) {
                xmap.get(x).add(y);
            } else {
                TreeSet<Integer> set = new TreeSet<>();
                set.add(y);
                xmap.put(x, set);
            }

            if (ymap.containsKey(y)) {
                ymap.get(y).add(x);
            } else {
                TreeSet<Integer> set = new TreeSet<>();
                set.add(x);
                ymap.put(y, set);
            }
        }

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            int x = grid[i][0];
            int y = grid[i][1];

            TreeSet<Integer> setx = ymap.get(y);
            TreeSet<Integer> sety = xmap.get(x);

            if (sety.lower(y) != null &&
                sety.higher(y) != null &&
                setx.lower(x) != null &&
                setx.higher(x) != null) {
                count++;
            }
        }

        return count;
    }
}
