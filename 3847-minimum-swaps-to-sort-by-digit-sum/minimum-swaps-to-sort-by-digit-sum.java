import java.util.*;

class Solution {

    // aa function number na badha digits no sum kadhva mate chhe
    // example: 123 -> 1 + 2 + 3 = 6
    long sum_digits(long x) {
        long sum = 0;
        while (x > 0) {
            sum += x % 10;   // last digit add kari
            x = x / 10;     // last digit hataavi
        }
        return sum;
    }

    // transition[i] batave chhe ke original array ma index i
    // sorted array ma kai index par jase
    int[] transition;

    // visited[i] = true matlab aa index already process thai gayo chhe
    boolean[] visited;

    // DFS function cycle ni length find karva mate
    // merepathmeinvisited -> current DFS path ma kon-kon visited chhe
    int dfs(int i, boolean[] merepathmeinvisited) {

        // jo aa index current path ma already aavi gayo hoy
        // to cycle complete, aagad javanu nathi
        if (merepathmeinvisited[i]) {
            return 0;
        }

        // current DFS path ma aa index ne mark kariye
        merepathmeinvisited[i] = true;

        // globally visited pan mark kariye
        visited[i] = true;

        // next index par DFS call kariye
        // +1 matlab current node ni count
        return dfs(transition[i], merepathmeinvisited) + 1;
    }

    public int minSwaps(int[] nums) {

        int n = nums.length;

        // initialIndexCache:
        // number -> original index
        // aa thi aapde jani sakiye ke element pehla kya hato
        Map<Integer, Integer> initialIndexCache = new HashMap<>();
        for (int i = 0; i < n; i++) {
            initialIndexCache.put(nums[i], i);
        }

        // digitSumCache:
        // number -> ena digits no sum
        // same number mate vaar-vaar sum_digits call na karvu pade
        Map<Long, Long> digitSumCache = new HashMap<>();
        for (int x : nums) {
            long v = (long) x;
            if (!digitSumCache.containsKey(v)) {
                digitSumCache.put(v, sum_digits(v));
            }
        }

        // PriorityQueue banaviye custom sorting sathe
        // pehla digit sum na basis par
        // jo digit sum same hoy to value na basis par
        PriorityQueue<Long> pq = new PriorityQueue<>(
            (a, b) -> {
                long sa = digitSumCache.get(a);
                long sb = digitSumCache.get(b);
                if (sa == sb) {
                    // digit sum same hoy to smaller number pehla
                    return Long.compare(a, b);
                }
                // je no digit sum nano, e pehla
                return Long.compare(sa, sb);
            }
        );

        // badha numbers priority queue ma add kariye
        for (int x : nums) {
            pq.offer((long) x);
        }

        // finalIndexCache:
        // number -> sorted array ma index
        // pq poll karta sorted order mali jase
        Map<Integer, Integer> finalIndexCache = new HashMap<>();
        int idx = 0;
        while (!pq.isEmpty()) {
            finalIndexCache.put(pq.poll().intValue(), idx);
            idx++;
        }

        // transition array build kariye
        // from = original index
        // to   = sorted index
        transition = new int[n];
        for (int i = 0; i < n; i++) {
            int from = initialIndexCache.get(nums[i]);
            int to = finalIndexCache.get(nums[i]);
            transition[from] = to;
        }

        // visited array initialize
        visited = new boolean[n];
        int swaps = 0;

        // permutation ma cycles count kariye
        // cycle length = k hoy to minimum swaps = k - 1
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                // aa array current DFS path track karse
                boolean[] merepathmeinvisited = new boolean[n];

                // dfs thi cycle ni length male
                swaps += dfs(i, merepathmeinvisited) - 1;
            }
        }

        // total minimum swaps return kariye
        return swaps;
    }
}
