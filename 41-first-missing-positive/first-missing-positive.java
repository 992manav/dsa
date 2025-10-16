class Solution {
    int[] nums;
    int n;

    void swap(int i, int j) {
        if (nums[j] < 0 || nums[j] > n) {
            nums[j] = nums[i];
        } else {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public int firstMissingPositive(int[] nums) {
        this.nums = nums;
        n = nums.length;

        for (int i = 0; i < n;) {
            int correctIndex = nums[i] - 1;
            if (nums[i] > 0 && nums[i] <= n && nums[i] != nums[correctIndex]) {
                swap(i, correctIndex);
            } else {
                i++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }
}
