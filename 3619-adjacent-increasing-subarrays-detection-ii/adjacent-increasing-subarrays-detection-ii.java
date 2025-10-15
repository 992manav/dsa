import java.util.*;

class Solution {
    List<Integer> nums;

    int check_increasing(int i) {
        int n = nums.size();
        int j = i + 1;
        while (j < n && nums.get(j) > nums.get(j - 1)) j++;
        return j - i;
    }

    public int maxIncreasingSubarrays(List<Integer> nums) {
        this.nums = nums;
        int n = nums.size();
        int i = 0;
        int last_size = 0;
        int max = 0;

        while (i < n) {
            int size = check_increasing(i);

            if (size / 2 > max) max = size / 2;

            int smaller = size < last_size ? size : last_size;

            if (smaller > max) max = smaller;

            last_size = size;
            i += size;  
        }

        return max;
    }
}
