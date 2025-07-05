class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);


        for (int num : nums) {
            pq.offer(num);
        }

        k--;
        while (k > 0) {
            pq.poll(); 
            k--;
        }

        return pq.poll();
    }
}
