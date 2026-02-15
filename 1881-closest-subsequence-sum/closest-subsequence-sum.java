import java.util.*;

class Solution {

    int n;
    int[] nums;
    int goal;
    int min;

    void fun(int i, int sum, int end, TreeSet<Integer> set){

        if(i == end){
            set.add(sum);
            min = Math.min(Math.abs(goal - sum), min);
            return;
        }

        fun(i + 1, sum + nums[i], end, set);
        fun(i + 1, sum, end, set);
    }

    public int minAbsDifference(int[] nums, int goal) {

        this.nums = nums;
        this.goal = goal;

        n = nums.length;
        min = Integer.MAX_VALUE;

        int minPossible = 0;
        int maxPossible = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                maxPossible += nums[i];
            } else {
                minPossible += nums[i];
            }
        }

        if (maxPossible < goal) {
            return Math.abs(maxPossible - goal);
        }
        if (minPossible > goal) {
            return Math.abs(minPossible - goal);
        }

        TreeSet<Integer> set1 = new TreeSet<>();
        TreeSet<Integer> set2 = new TreeSet<>();

        fun(0, 0, n/2, set1);
        fun(n/2, 0, n, set2);

        for(Integer key : set1){

            int target = goal - key;

            Integer floor = set2.floor(target);
            if(floor != null){
                min = Math.min(min, Math.abs(goal - (key + floor)));
            }

            Integer ceil = set2.ceiling(target);
            if(ceil != null){
                min = Math.min(min, Math.abs(goal - (key + ceil)));
            }
        }

        return min;
    }
}
