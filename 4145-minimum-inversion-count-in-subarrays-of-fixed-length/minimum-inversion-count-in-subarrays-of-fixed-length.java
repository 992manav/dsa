import java.util.*;

class Solution {

    // Sorted list jo current window ke elements rakhegi
    List<Integer> lst;
    int k;

    // Ye function last index return karta hai
    // jahan value <= target ho
    // INSERTION ke liye use hota hai
    int binary_search(int target) {

        int low = 0;
        int high = lst.size() - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // Agar mid value target se chhoti ya equal hai
            // to ye valid candidate ho sakta hai
            if (lst.get(mid) <= target) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // ans = last index jahan value <= target
        return ans;
    }

    // Ye function first index return karta hai
    // jahan value >= target ho
    // REMOVAL ke liye use hota hai (duplicates ke case me important)
    int lower_bound(int target) {

        int low = 0;
        int high = lst.size() - 1;
        int ans = lst.size();

        while (low <= high) {
            int mid = (low + high) / 2;

            // Agar mid value target se badi ya equal hai
            // to ye remove hone wala candidate ho sakta hai
            if (lst.get(mid) >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        // ans = first index jahan value >= target
        return ans;
    }

    public long minInversionCount(int[] nums, int k) {

        int n = nums.length;

        // Sorted list initialize
        lst = new ArrayList<>();

        // Pehla element directly daal dete hain
        lst.add(nums[0]);

        // inv = current window ka inversion count
        long inv = 0;

        // ---------- FIRST WINDOW BUILD ----------
        for (int i = 1; i < k; i++) {

            // Insert position nikalte hain
            int idx = binary_search(nums[i]);
            int insertPos = idx + 1;

            // Sorted order me insert
            lst.add(insertPos, nums[i]);

            // Insert ke baad jo elements right side me hain
            // wahi inversions banate hain
            int bigger = lst.size() - insertPos - 1;
            inv = inv + bigger;
        }

        // count = ab tak ka minimum inversion
        long count = inv;

        // ---------- SLIDING WINDOW ----------
        int j = k;

        while (j < n) {

            // Window ke left se jo element nikal raha hai
            // uska exact index (leftmost occurrence) nikalte hain
            int removeIdx = lower_bound(nums[j - k]);

            // Remove kar dete hain
            lst.remove(removeIdx);

            // removeIdx elements is element se chhote the
            // ye sab inversions bana rahe the
            inv = inv - removeIdx;

            // Ab new element insert karna hai
            int idx = binary_search(nums[j]);
            int insertPos = idx + 1;

            // Insert se pehle jo elements right side me hain
            // wahi naye inversions banayenge
            int bigger = lst.size() - insertPos;
            inv = inv + bigger;

            // Sorted order me insert
            lst.add(insertPos, nums[j]);

            // Minimum inversion update
            count = Math.min(count, inv);

            j++;
        }

        // Final answer
        return count;
    }
}
