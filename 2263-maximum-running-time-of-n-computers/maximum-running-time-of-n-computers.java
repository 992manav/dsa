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
            freq.put(val, freq.getOrDefault(val, 0L) + 1);
        }

        long extra = 0;
        while (!maxHeap.isEmpty()) {
            extra += maxHeap.poll();
        }

        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for (long key : freq.keySet()) {
            minHeap.add(key);
        }

        while (true) {

            long curr = minHeap.poll();
            long count = freq.get(curr);

            if (minHeap.isEmpty()) {
                return curr + extra / count;
            }

            long next = minHeap.poll();
            long diff = next - curr;
            long need = count * diff;

            if (need > extra) {
                return curr + extra / count;
            }

            extra -= need;
            freq.put(next, freq.getOrDefault(next, 0L) + count);
            minHeap.add(next);
        }
    }
}
