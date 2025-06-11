import java.util.*;

class Solution {

    List<List<Integer>> final_list = new ArrayList<>();
    int n;

    void fun(int[] nums, int index) {
        if (index == n) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) temp.add(num);
            final_list.add(temp);
            return;
        }

        int swapping_index = nums.length - 1;
        while (swapping_index >= index) {
            swap(nums, index, swapping_index);
            fun(nums, index + 1);
            swap(nums, index, swapping_index);
            swapping_index--;
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        for (int i = 0; i < n; i++) {
            swap(nums, i, 0);
            fun(nums, 1);
            swap(nums, i, 0); 
        }

        return final_list;
    }
}
