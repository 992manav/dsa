import java.util.Arrays;

class Solution {
    public long minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int target = nums2[m - 1];
        long sum = 0;

        boolean flag = false;
        int min_cost = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int a = nums1[i];
            int b = nums2[i];

            if (a > b) sum += a - b;
            else sum += b - a;

            // CASE 1: a <= target AND b >= target
            if (a <= target && b >= target) {
                if (!flag) sum++;   // add 1 BEFORE flag becomes true
                flag = true;
            }

            // CASE 2: a >= target AND b <= target
            else if (a >= target && b <= target) {
                if (!flag) sum++;   // add 1 BEFORE flag becomes true
                flag = true;
            }

            else {
                if (!flag) {
                    int diff1 = Math.abs(target - a);
                    int diff2 = Math.abs(target - b);

                    int min = Math.min(diff1, diff2);
                    if (min < min_cost) min_cost = min;
                }
            }
        }

        if (flag) {
            return sum;
        } else {
            return sum + min_cost + 1;
        }
    }
}
