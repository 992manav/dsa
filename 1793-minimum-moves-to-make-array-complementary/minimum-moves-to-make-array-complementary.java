import java.util.*;
//aaukat ke bahar ka question
class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length / 2;

        int[] chhota = new int[n];
        int[] bada = new int[n];
        Map<Integer, Integer> yog = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int a = nums[i];
            int b = nums[nums.length - 1 - i];

            int minVal = Math.min(a, b);
            int maxVal = Math.max(a, b);

            chhota[i] = minVal;
            bada[i] = maxVal;

            int sum = a + b;
            yog.put(sum, yog.getOrDefault(sum, 0) + 1);
        }

        Arrays.sort(chhota);
        Arrays.sort(bada);

        int jawab = Integer.MAX_VALUE;

        for (int target = 2; target <= 2 * limit; target++) {
            int already = yog.getOrDefault(target, 0);

            int badhao = lowerBound(bada, target - limit);
            int ghatao = n - lowerBound(chhota, target);

            int moves = n - already + badhao + ghatao;
            if (moves < jawab) {
                jawab = moves;
            }
        }

        return jawab;
    }

    int lowerBound(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] < key) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
