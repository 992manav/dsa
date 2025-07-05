public class Solution {
    public int[] arrayRankTransform(int[] arr) {

        
        List<Integer> lst = new ArrayList<>();
        for (int num : arr) {
            lst.add(num);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(lst);

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
