public class Solution {
    public int[] arrayRankTransform(int[] arr) {

        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        List<Integer> sorted = new ArrayList<>(set);
        Collections.sort(sorted); // O(k log k)

        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (int num : sorted) {
            map.put(num, rank++);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }
}
