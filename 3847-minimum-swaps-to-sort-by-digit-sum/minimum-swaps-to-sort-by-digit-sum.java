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

    int dfs(int i, boolean[] merepathmeinvisited) {
        if (merepathmeinvisited[i]) {
            return 0;
        }
        merepathmeinvisited[i] = true;
        visited[i] = true;
        return dfs(transition[i], merepathmeinvisited) + 1;
    }

    public int minSwaps(int[] nums) {

        int n = nums.length;

        Map<Integer, Integer> initialmap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            initialmap.put(nums[i], i);
        }

        // Pre-calculate digit sums to avoid recalculation
        Map<Long, Long> digitSumCache = new HashMap<>();
        for (int x : nums) {
            long val = (long) x;
            if (!digitSumCache.containsKey(val)) {
                digitSumCache.put(val, sum_digits(val));
            }
        }

        PriorityQueue<Long> pq = new PriorityQueue<>(
            (first, second) -> {
                long sf = digitSumCache.get(first);
                long ss = digitSumCache.get(second);
                if (sf == ss) {
                    return Long.compare(first, second);
                }
                return Long.compare(sf, ss);
            }
        );

        for (int i = 0; i < n; i++) {
            pq.offer((long) nums[i]);
        }

        Map<Integer, Integer> finalmap = new HashMap<>();
        int index = 0;

        while (!pq.isEmpty()) {
            finalmap.put(pq.poll().intValue(), index);
            index++;
        }

        transition = new int[n];

        for (int i = 0; i < n; i++) {
            int ind1 = initialmap.get(nums[i]);
            int ind2 = finalmap.get(nums[i]);
            transition[ind1] = ind2;
        }

        visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                boolean[] merepathmeinvisited = new boolean[n];
                count += dfs(i, merepathmeinvisited) - 1;
            }
        }

        return count;
    }
}