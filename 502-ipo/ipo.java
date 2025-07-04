class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();

        for (int i = 0; i < profits.length; i++) {
            map.computeIfAbsent(profits[i], key -> new ArrayList<>()).add(capital[i]);
        }

        while (k > 0) {
            boolean found = false;

            // Iterate over profits in descending order
            for (var entry : map.descendingMap().entrySet()) {
                int profit = entry.getKey();
                List<Integer> lst = entry.getValue();

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
