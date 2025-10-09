import java.util.*;

class Solution {

    int[] dp;
    List<Integer>[] graph;

    int dfs(int node, boolean[] visited) {
        if (!visited[node]) {
            visited[node] = true;
            if (dp[node] != -1) return dp[node];
            int max = 0;
            for (int next : graph[node]) {
                if (!visited[next]) max = Math.max(max, dfs(next, visited));
            }
            dp[node] = 1 + max;
        }
        return dp[node];
    }

    public int longestStrChain(String[] words) {
        int n = words.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (check(words[i], words[j])) graph[i].add(j);
        int maxChain = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) maxChain = Math.max(maxChain, dfs(i, visited));
        return maxChain;
    }

    boolean check(String a, String b) {
        if (b.length() != a.length() + 1) return false;
        int i = 0, j = 0;
        boolean skipped = false;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) { i++; j++; }
            else { if (skipped) return false; skipped = true; j++; }
        }
        return true;
    }

}
