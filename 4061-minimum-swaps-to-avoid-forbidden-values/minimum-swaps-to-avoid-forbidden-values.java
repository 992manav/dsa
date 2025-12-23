import java.util.*;

class Solution {
    public int minSwaps(int[] nums, int[] forb) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        boolean flag = false;
        int same = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == forb[i]) {
                flag = true;
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                same++;
            }
        }

        if (!flag) {
            return 0;
        }

        int total = n + n;

        int[] c = new int[total];
        System.arraycopy(nums, 0, c, 0, n);
        System.arraycopy(forb, 0, c, n, n);

        Arrays.sort(c);

        int cnt = 1;
        for (int i = 1; i < total; i++) {
            if (c[i] == c[i - 1]) {
                cnt++;
            } else {
                if (cnt > total / 2) {
                    return -1;
                }
                cnt = 1;
            }
        }

        if (cnt > total / 2) {
            return -1;
        }

        int swaps = (same + 1) / 2;

        for (Integer key : map.keySet()) {
            int count = map.get(key);
            if (count > swaps) {
                swaps = count;
            }
        }

        return swaps;
    }
}
