import java.util.*;

class Solution {
    public long maxRunTime(int n, int[] batteries) {

        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int b : batteries) {
            maxHeap.add((long) b);
        }

        HashMap<Long, Long> freq = new HashMap<>();

        for (int i = 0; i < n; i++) {
            long val = maxHeap.poll();
            if (!freq.containsKey(val)) {
                freq.put(val, 0L);
            }
            freq.put(val, freq.get(val) + 1);
        }

        long extra = 0;
        while (!maxHeap.isEmpty()) {
            extra += maxHeap.poll();
        }

        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for (long k : freq.keySet()) {
            minHeap.add(k);
        }

        while (true) {
            long smaller = minHeap.poll();

            if (minHeap.isEmpty()) {
                return smaller + extra / freq.get(smaller);
            }

            long larger = minHeap.poll();

            long countSmaller = freq.get(smaller);
            long diff = larger - smaller;

            if (countSmaller * diff > extra) {
                return smaller + extra / countSmaller;
            }

            extra -= countSmaller * diff;

            if (!freq.containsKey(larger)) {
                freq.put(larger, 0L);
            }
            freq.put(larger, freq.get(larger) + countSmaller);

            minHeap.add(larger);
        }
    }
}
