import java.util.*;

class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length / 2;

        int[] chhota = new int[n];
        int[] bada = new int[n];
        Map<Integer, Integer> yog = new HashMap<>();

        // har pair process kar rahe hain
        for (int i = 0; i < n; i++) {
            int a = nums[i];
            int b = nums[nums.length - 1 - i];

            int minVal = Math.min(a, b);
            int maxVal = Math.max(a, b);

            chhota[i] = minVal;   // pair ka minimum
            bada[i] = maxVal;     // pair ka maximum

            int sum = a + b;
            yog.put(sum, yog.getOrDefault(sum, 0) + 1); // sum count store
        }

        // binary search ke liye sort
        Arrays.sort(chhota);
        Arrays.sort(bada);

        int jawab = Integer.MAX_VALUE;

        // har possible target sum try kar rahe hain
        for (int target = 2; target <= 2 * limit; target++) {

            // already correct pairs (0 move)
            int already = yog.getOrDefault(target, 0);

            // badhao:
            // wo pairs jinke max ko limit tak badha ke bhi
            // target sum nahi ban sakta
            // inko 2 moves chahiye
            int badhao = lowerBound(bada, target - limit);

            // ghatao:
            // wo pairs jinke min ko 1 tak ghatane ke baad bhi
            // target sum se zyada hi rahega
            // inko bhi 2 moves chahiye
            int ghatao = n - lowerBound(chhota, target);

            // total moves calculation:
            // (n - already) -> sab non-perfect pairs ko kam se kam 1 move
            // + badhao + ghatao -> jo pairs 2 moves chahte hain unke liye extra move
            int moves = n - already + badhao + ghatao;

            if (moves < jawab) {
                jawab = moves;
            }
        }

        return jawab;
    }

    // standard lower bound function
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
