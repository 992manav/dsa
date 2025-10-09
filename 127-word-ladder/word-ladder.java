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
        int level = 1;

        while (!q.isEmpty()) {

            int size = q.size();
            for (int i = 0; i < size; i++) {

                int row = q.poll();

                if(wl.get(row).equals(wl.get(end))) {
                    return level;
                }
                if (!visited[row]) {

                    visited[row] = true;

                    for (int j = 0; j < n; j++) {
                        if (matrig[row][j] == 1 && !visited[j]) {
                            q.offer(j);
                        }
                    }
                }
            }
            level++;
        }

        return Integer.MAX_VALUE;
    }

    boolean check(String a, String b) {
        if (a.length() != b.length()) return false;
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
            if (diff > 1) return false;
        }
        return diff == 1;
    }

    public int ladderLength(String bw, String endWord, List<String> wlInput) {
    wl = new ArrayList<>(wlInput);
    n = wl.size();

    // Add endWord if it's not already in the list
    if (!wl.contains(endWord)) {
        return 0;
    }

    matrig = new int[n][n];

    for (int i = 0; i < wl.size(); i++) {
        for (int j = 0; j < wl.size(); j++) {
            String a = wl.get(i);
            String b = wl.get(j);
            if (check(a, b)) {
                matrig[i][j] = 1;
                matrig[j][i] = 1;
            }
        }
    }

    int min = Integer.MAX_VALUE;
    end = wl.indexOf(endWord); // now guaranteed to be >= 0
    for (int i = 0; i < n; i++) {
        String s = wl.get(i);
        if (check(s, bw)) {
            min = Math.min(bfs(i), min);
        }
    }

    return Math.max(min+1,0);
}

}
