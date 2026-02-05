import java.util.*;

class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    int[] nums;

    void fun(int low, int high, int target) {
        while (low < high) {
            int sum = nums[low] + nums[high];

            if (sum < target) {
                low++;
            } else if (sum > target) {
                high--;
            } else {
                List<Integer> lst = new ArrayList<>();
                lst.add(-target);
                lst.add(nums[low]);
                lst.add(nums[high]);
                ans.add(lst);

                low++;
                high--;

                while (low < high && nums[low] == nums[low - 1]) {
                    low++;
                }

                while (low < high && nums[high] == nums[high + 1]) {
                    high--;
                }
            }
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            fun(i + 1, n - 1, -nums[i]);
        }

        return ans;
    }
}
