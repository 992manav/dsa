import java.util.*;

class Solution {
    List<Integer> nums;

    int check_increasing(int i) {
        int j = i + 1;
        int n = nums.size();
        while (j < n && nums.get(j) > nums.get(j - 1)) j++; 
        return j - i; 
    } 
 
    public int maxIncreasingSubarrays(List<Integer> nums) { 
        this.nums = nums; 
        int n = nums.size(), i = 0; 
        boolean flag = false; 
 
        int last_size = 0; 
        int max = 0; 
        while (i < n) { 
            int size = check_increasing(i); 
            max = Math.max(size / 2, max); 
 
            if (last_size <= size) { 
                max = Math.max(last_size, max); 
            } else if (size < last_size) {   
                max = Math.max(size, max); 
            } 
            last_size = size; 
            i += size; 
        } 
 
        return max; 
    } 
}
