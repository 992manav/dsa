import java.util.*;

class Solution {

    public static int minDeletionSize(String[] strs) {

        int rows = strs.length;
        int cols = strs[0].length();

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < cols; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[cols];

        for (int c1 = 0; c1 < cols; c1++) {
            for (int c2 = c1 + 1; c2 < cols; c2++) {

                boolean valid = true;

                for (int r = 0; r < rows; r++) {
                    if (strs[r].charAt(c1) > strs[r].charAt(c2)) {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    graph.get(c1).add(c2);
                    indegree[c2]++;
                }
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < cols; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int longestChain = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int col = queue.poll();

                for (int next : graph.get(col)) {
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        queue.add(next);
                    }
                }
            }

            longestChain++;
        }

        return cols - longestChain;
    }
}
