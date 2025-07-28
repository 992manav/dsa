import java.util.*;

class Solution {
    Map<Integer, Integer> parent = new HashMap<>();

    public int removeStones(int[][] stones) {
        // Badha stone na x (row) ane ~y (column) ne connect kariye
        for (int[] stone : stones) {
            int row = stone[0];
            int col = ~stone[1]; // ~y kariye to row & column unique bane
            union(row, col);
        }

        // Badha unique parents count karva - e means ketla groups che
        Set<Integer> uniqueParents = new HashSet<>();
        for (int[] stone : stones) {
            int row = stone[0];
            int col = ~stone[1];
            uniqueParents.add(find(row));
            uniqueParents.add(find(col));
        }

        // Total stones - connected components = max removable
        return stones.length - uniqueParents.size();
    }

    // DSU find method
    private int find(int x) {
        if (!parent.containsKey(x)) {
            parent.put(x, x); // Pela time x male to self parent banav
        }
        if (parent.get(x) != x) {
            parent.put(x, find(parent.get(x))); // Path compression
        }
        return parent.get(x);
    }

    // DSU union method
    private void union(int x, int y) {
        parent.put(find(x), find(y));
    }
}
