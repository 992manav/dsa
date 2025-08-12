import java.util.*;

class Solution {

    private boolean[] visited;
    private List<Integer> result;
    private int total;

    // Recursive DFS function to build Gray Code
    private boolean dfs(int num, int n) {
        if (result.size() == total) {
            return true;
        }

        if (visited[num]) {
            return false;
        }

        visited[num] = true;
        result.add(num);

        for (int i = 0; i < n; i++) {
            int nextNum = num ^ (1 << i);
            if (dfs(nextNum, n)) {
                return true;
            }
        }

        // Backtrack
        result.remove(result.size() - 1);
        visited[num] = false;

        return false;
    }

    public List<Integer> grayCode(int n) {
        total = 1 << n;
        visited = new boolean[total];
        result = new ArrayList<>();

        dfs(0, n);

        return result;
    }
}
