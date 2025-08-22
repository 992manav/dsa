import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        TreeSet<Integer> piles = new TreeSet<>();

        for (int x : nums) {
            Integer just_bigger = piles.ceiling(x);
            if (just_bigger != null) {
                piles.remove(just_bigger); 
            }
            piles.add(x);
        }

        return piles.size();  
    }
}
