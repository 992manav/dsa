import java.util.*;

class Solution {

    int binary_search(List<Integer> keys, int target) {
        int low = 0;
        int high = keys.size() - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (keys.get(mid) >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public int maxArea(int[] height) {
        int n = height.length;

        TreeMap<Integer, Integer> first = new TreeMap<>();
        TreeMap<Integer, Integer> last = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            if (!first.containsKey(height[i])) {
                first.put(height[i], i);
            }
            last.put(height[i], i);
        }

        int m = first.size();

        List<Integer> lst = new ArrayList<>();
        for (Integer key : last.keySet()) {
            lst.add(last.get(key));
        }

        List<Integer> lst1 = new ArrayList<>();
        for (Integer key : first.keySet()) {
            lst1.add(first.get(key));
        }

        List<Integer> keys = new ArrayList<>(first.keySet());

        int[] suffix_max = new int[m];
        int[] prefix_min = new int[m];

        suffix_max[m - 1] = lst.get(m - 1);
        prefix_min[m - 1] = lst1.get(m - 1);

        for (int i = m - 2; i >= 0; i--) {
            suffix_max[i] = Math.max(lst.get(i), suffix_max[i + 1]);
            prefix_min[i] = Math.min(lst1.get(i), prefix_min[i + 1]);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int idx = binary_search(keys, height[i]);
            if (idx == -1) continue;

            int ri = suffix_max[idx];
            int li = prefix_min[idx];

            if (ri != i) {
                ans = Math.max(ans, height[i] * Math.abs(ri - i));
            }

            if (li != i) {
                ans = Math.max(ans, height[i] * Math.abs(li - i));
            }
        }

        return ans;
    }
}
