import java.util.*;

class Solution {
    int n;
    int[] nums;

    int binary_search(int target) {
        int low = 0;
        int high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    int binary_search1(int target) {
        int low = 0;
        int high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                ans = mid;
                low = mid + 1;
            }
        }
        return ans;
    }

    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);

        n = nums.length;
        this.nums = nums;

        int ans = n;

        for (int i = 0; i < n; i++) {
            int min = nums[i];
            int target = min * k;

            int idx = binary_search(target);
            int remove = n - idx + i;
            ans = Math.min(ans, remove);
        }

        for (int i = n - 1; i >= 0; i--) {
            int max = nums[i];
            int target = max / k;

            int idx = binary_search1(target);
            int remove1 = idx + 1 + (n - i - 1);
            ans = Math.min(ans, remove1);
        }

        return ans;
    }
}
