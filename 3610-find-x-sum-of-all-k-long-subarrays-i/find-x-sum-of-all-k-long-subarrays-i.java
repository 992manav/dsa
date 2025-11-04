import java.util.*;

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int[] freq = new int[51];

        for (int i = 0; i < k; i++) freq[nums[i]]++;

        for (int i = 0; i <= n - k; i++) {

            TreeMap<Integer, Integer> map = new TreeMap<>((a, b) -> {
                if (freq[b] == freq[a]) return b - a;
                return freq[b] - freq[a];
            });

            for (int num = 1; num <= 50; num++) {
                if (freq[num] > 0) map.put(num, freq[num]);
            }

            int count = 0;
            int sum = 0;
            for (int num : map.keySet()) {
                sum += num * map.get(num);
                count++;
                if (count == x) break;
            }

            res[i] = sum;

            if (i + k < n) {
                freq[nums[i]]--;
                freq[nums[i + k]]++;
            }
        }

        return res;
    }
}
