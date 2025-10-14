class Solution {

    List<Integer> nums;

    int check_increasing(int i) {
        int j = i + 1;
        int n = nums.size();
        while (j < n && nums.get(j) > nums.get(j - 1)) j++;
        return j - i;
    }

    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        this.nums = nums;
        int n = nums.size(), i = 0;
        boolean flag = false;

        while (i < n) {
            int size = check_increasing(i);
            if (size >= 2 * k) return true;
            if (size >= k) {
                if (flag) return true;
                flag = true;
            } else flag = false;
            i += size;
        }

        return false;
    }
}
