import java.util.*;

class Solution {

    int[] dp;
    List<Integer>[] graph;

    int dfs(int node, boolean[] visited) {
        if (dp[node] != -1) return dp[node];
        visited[node] = true;
        int max = 0;
        for (int next : graph[node]) {
            if (!visited[next]) max = Math.max(max, dfs(next, visited));
        }
        visited[node] = false;
        return dp[node] = 1 + max;
    }

    public int longestStrChain(String[] words) {
        int n = words.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        Arrays.sort(words, Comparator.comparingInt(String::length));
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        Map<Integer, List<Integer>> byLen = new HashMap<>();
        for (int i = 0; i < n; i++)
            byLen.computeIfAbsent(words[i].length(), k -> new ArrayList<>()).add(i);
        for (int len : byLen.keySet()) {
            if (!byLen.containsKey(len + 1)) continue;
            for (int i : byLen.get(len)) {
                for (int j : byLen.get(len + 1)) {
                    if (check(words[i], words[j])) graph[i].add(j);
                }
            }
        }
        int maxChain = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++)
            maxChain = Math.max(maxChain, dfs(i, visited));
        return maxChain;
    }

    boolean check(String a, String b) {
        int lenA = a.length(), lenB = b.length();
        if (lenB != lenA + 1) return false;
        int i = 0, j = 0, diff = 0;
        while (i < lenA && j < lenB) {
            if (a.charAt(i) == b.charAt(j)) i++;
            else if (++diff > 1) return false;
            j++;
        }
        return true;
    }
}
