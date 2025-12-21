import java.util.*;

class Solution {

    long sum_digits(long x) {
        long sum = 0;
        while (x > 0) {
            sum += x % 10;
            x = x / 10;
        }
        return sum;
    }

    int[] transition;
    boolean[] visited;

    int dfs(int i) {
        if (visited[i]) {
            return 0;
        }

        visited[i] = true;
        return dfs(transition[i]) + 1;
    }

    public int minSwaps(int[] nums) {

        int n = nums.length;
        if (n == 1) {
            return 0;
        }

        // Pre-calculate digit sums to avoid recalculation in comparator
        Map<Integer, Long> digitSumCache = new HashMap<>();
        for (int x : nums) {
            if (!digitSumCache.containsKey(x)) {
                digitSumCache.put(x, sum_digits(x));
            }
        }

        PriorityQueue<Long> pq = new PriorityQueue<>(
            (a, b) -> {
                long sa = digitSumCache.get(a.intValue());
                long sb = digitSumCache.get(b.intValue());
                if (sa == sb) {
                    return Long.compare(a, b);
                }
                return Long.compare(sa, sb);
            }
        );

        for (int x : nums) {
            pq.offer((long) x);
        }

        Map<Integer, Integer> finalmap = new HashMap<>();
        int index = 0;

        while (!pq.isEmpty()) {
            finalmap.put(pq.poll().intValue(), index);
            index++;
        }

        transition = new int[n];
        for (int i = 0; i < n; i++) {
            transition[i] = finalmap.get(nums[i]);
        }

        visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count += dfs(i) - 1;
            }
        }

        return count;
    }
}