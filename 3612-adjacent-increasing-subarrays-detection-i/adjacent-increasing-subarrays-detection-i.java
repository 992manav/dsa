class Solution {

    List<Integer> nums;

    int check_increasing(int i) {
        int j = i + 1;
        while (j < nums.size() && nums.get(j) > nums.get(j - 1)) {
            j++;
        }
        return j - i;
    }

    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        this.nums = nums;
        int n = nums.size();
        boolean flag = false;
        int i = 0;
        while (i < n) {
            int size = check_increasing(i);
            if (size >= 2 * k) {
                return true;
            } else if (size >= k && size < 2 * k) {
                if (flag) {
                    return true;
                } else {
                    flag = true;
                }
                i += size;
            } else {
                flag = false;
                i += Math.max(1, size);
            }
        }
        return false;
    }
}
