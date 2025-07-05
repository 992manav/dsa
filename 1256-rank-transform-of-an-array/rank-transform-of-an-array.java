public class Solution {
    public int[] arrayRankTransform(int[] arr) {

        // Use a Set to store only unique elements
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        // Create a PriorityQueue from the unique elements
        PriorityQueue<Integer> pq = new PriorityQueue<>(set);

        // Map to store rank of each unique number
        HashMap<Integer, Integer> map = new HashMap<>();

        int rank = 1;
        while (!pq.isEmpty()) {
            int p = pq.poll();
            map.put(p, rank++);
        }

        // Replace each value in original array with its rank
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }
}
