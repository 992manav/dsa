import java.util.*;

class Solution {

    List<String> wl;
    int[][] matrig;
    int end;
    int n;

    int bfs(int start) {

        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true; // mark visited immediately
        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int row = q.poll();

                if (row == end) return level;

                for (int j = 0; j < n; j++) {
                    if (matrig[row][j] == 1 && !visited[j]) {
                        visited[j] = true; // mark when adding to queue
                        q.offer(j);
                    }
                }
            }
            level++;
        }

        return Integer.MAX_VALUE;
    }

    boolean check(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
                if (diff > 1) return false;
            }
        }
        return diff == 1;
    }

    public int ladderLength(String bw, String endWord, List<String> wlInput) {
        wl = new ArrayList<>(wlInput);
        n = wl.size();

        if (!wl.contains(endWord)) return 0;

        matrig = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) { // only fill upper triangle
                if (check(wl.get(i), wl.get(j))) {
                    matrig[i][j] = 1;
                    matrig[j][i] = 1;
                }
            }
        }

        end = wl.indexOf(endWord);
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (check(wl.get(i), bw)) {
                min = Math.min(bfs(i), min);
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min + 1;
    }
}
