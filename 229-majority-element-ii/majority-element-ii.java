import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int el1 = 0;
        int el2 = 0;
        int c1 = 0;
        int c2 = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (el1 == x) {
                c1++;
            } else if (el2 == x) {
                c2++;
            } else if (c1 == 0) {
                el1 = x;
                c1 = 1;
            } else if (c2 == 0) {
                el2 = x;
                c2 = 1;
            } else {
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == el1) c1++;
            else if (nums[i] == el2) c2++;
        }
        List<Integer> ans = new ArrayList<>();
        if (c1 > nums.length / 3) ans.add(el1);
        if (c2 > nums.length / 3) ans.add(el2);
        return ans;
    }
}
