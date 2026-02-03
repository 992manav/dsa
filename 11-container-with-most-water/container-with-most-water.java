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

        TreeMap<Integer, int[]> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            if (!map.containsKey(height[i])) {
                map.put(height[i], new int[]{i, i});
            } else {
                map.get(height[i])[1] = i;
            }
        }

        List<Integer> keys = new ArrayList<>(map.keySet());
        int m = keys.size();

        int[] left = new int[m];
        int[] right = new int[m];

        for (int i = 0; i < m; i++) {
            left[i] = map.get(keys.get(i))[0];
            right[i] = map.get(keys.get(i))[1];
        }

        int[] suffix_max = new int[m];
        int[] prefix_min = new int[m];

        suffix_max[m - 1] = right[m - 1];
        prefix_min[m - 1] = left[m - 1];

        for (int i = m - 2; i >= 0; i--) {
            suffix_max[i] = Math.max(right[i], suffix_max[i + 1]);
            prefix_min[i] = Math.min(left[i], prefix_min[i + 1]);
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
