import java.util.*;

class Solution {

    List<Integer> lst;
    int k;

    int binary_search(int target) {

        int low = 0;
        int high = lst.size() - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (lst.get(mid) <= target) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    int lower_bound(int target) {

        int low = 0;
        int high = lst.size() - 1;
        int ans = lst.size();

        while (low <= high) {
            int mid = (low + high) / 2;

            if (lst.get(mid) >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public long minInversionCount(int[] nums, int k) {

        int n = nums.length;
        lst = new ArrayList<>();

        lst.add(nums[0]);
        long inv = 0;

        for (int i = 1; i < k; i++) {
            int idx = binary_search(nums[i]);
            int insertPos = idx + 1;
            lst.add(insertPos, nums[i]);

            int bigger = lst.size() - insertPos - 1;
            inv = inv + bigger;
        }

        long count = inv;
        int j = k;

        while (j < n) {

            int removeIdx = lower_bound(nums[j - k]);
            lst.remove(removeIdx);
            inv = inv - removeIdx;

            int idx = binary_search(nums[j]);
            int insertPos = idx + 1;

            int bigger = lst.size() - insertPos;
            inv = inv + bigger;

            lst.add(insertPos, nums[j]);

            count = Math.min(count, inv);
            j++;
        }

        return count;
    }
}
