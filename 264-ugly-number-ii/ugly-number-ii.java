class Solution {
    public int nthUglyNumber(int n) {

        int[] primes = {2, 3, 5};

        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        HashSet<Long> visited = new HashSet<>();

        minHeap.offer(1L);
        visited.add(1L);

        long current = 0;

        for (int count = 1; count <= n; count++) {
            current = minHeap.poll();

            for (int prime : primes) {
                long next = current * prime;
                if (!visited.contains(next)) {
                    minHeap.offer(next);
                    visited.add(next);
                }
            }
        }

        return (int) current;
    }
}
