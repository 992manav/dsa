import java.util.*;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < profits.length; i++) {
            map.computeIfAbsent(profits[i], key -> new ArrayList<>()).add(capital[i]);
        }

        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, Collections.reverseOrder());

        while (k > 0) {
            boolean found = false;

            // Iterate over profits in descending order
            for (int profit : keys) {
                List<Integer> lst = map.get(profit); // fix: get list from map

                // Use iterator for safe in-place removal
                Iterator<Integer> itr = lst.iterator();
                while (itr.hasNext()) {
                    int cap = itr.next();
                    if (cap <= w) {
                        w += profit;
                        itr.remove(); // safe remove while iterating
                        found = true;
                        break;
                    }
                }

                if (found) {
                    k--;
                    break;
                }
            }

            if (!found) break;
        }

        return w;
    }
}
