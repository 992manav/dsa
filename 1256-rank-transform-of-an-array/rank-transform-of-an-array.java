public class Solution {
    public int[] arrayRankTransform(int[] arr) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : arr) {
            pq.add(num);
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        int rank = 1;
        while (!pq.isEmpty()) {
            int p = pq.poll();

            if (!map.containsKey(p)) {
                map.put(p, rank);
                rank++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }

        return arr; 
    }
}
