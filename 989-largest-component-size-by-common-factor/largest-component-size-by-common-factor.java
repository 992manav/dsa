import java.util.*;

class Solution {
    List<Integer>[] factors;
    Map<Integer, List<Integer>> primeMap;
    boolean[] visited;
    int n;

    void all_factors(int idx, int num) {
        List<Integer> list = new ArrayList<>();
        for (int j = 2; j * j <= num; j++) {
            if (num % j == 0) {
                list.add(j);
                while (num % j == 0) {
                    num /= j;
                }
            }
        }
        if (num > 1) {
            list.add(num);
        }
        factors[idx] = list;

        for (int prime : list) {
            primeMap.putIfAbsent(prime, new ArrayList<>());
            primeMap.get(prime).add(idx);
        }
    }

    int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        int count = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            count++;

            for (int prime : factors[node]) {
                List<Integer> list = primeMap.get(prime);
                if (list != null) {
                    for (int nei : list) {
                        if (!visited[nei]) {
                            visited[nei] = true;
                            q.add(nei);
                        }
                    }
                    primeMap.remove(prime); // avoid revisiting same prime
                }
            }
        }
        return count;
    }

    public int largestComponentSize(int[] nums) {
        n = nums.length;
        factors = new ArrayList[n];
        primeMap = new HashMap<>();
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            all_factors(i, nums[i]);
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                max = Math.max(max, bfs(i));
            }
        }
        return max;
    }
}
