import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int x = 1 << nums.length;
        List<List<Integer>> final_lst = new ArrayList<>();
        
        for (int num = 0; num < x; num++) { 
            int index = 0;
            List<Integer> lst = new ArrayList<>();
            int temp = num;

            while (temp != 0) {
                if ((temp & 1) == 1) {
                    lst.add(nums[index]);
                }
                temp = temp >> 1;
                index++;
            }

            final_lst.add(lst);
        }
        
        return final_lst;
    }
}
