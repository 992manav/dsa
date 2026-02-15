import java.util.*;

class Solution {

    int n;
    int[] nums;
    int goal;
    int min;

    void fun(int i, int sum, int end, Map<Integer, Integer> map){

        if(i == end){
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            min = Math.min(Math.abs(goal - sum), min);
            return;
        }

        
        fun(i + 1, sum + nums[i], end, map);
        fun(i + 1, sum, end, map);
    }

    public int minAbsDifference(int[] nums, int goal) {

        this.nums = nums;
        this.goal = goal;

        n = nums.length;
        min = Integer.MAX_VALUE;

        TreeMap<Integer,Integer> map = new TreeMap<>();
        TreeMap<Integer,Integer> map1 = new TreeMap<>();
        
        Arrays.sort(nums);

        fun(0, 0, n/2, map);
        fun(n/2, 0, n, map1);
        
        for(Integer key : map.keySet()){

            int target = goal - key;

            // smallest value in map1
            Integer first = map1.firstKey();
            min = Math.min(min, Math.abs(goal - (key + first)));

            // closest lower or equal
            Integer floor = map1.floorKey(target);
            if(floor != null){
                min = Math.min(min, Math.abs(goal - (key + floor)));
            }

            // closest greater or equal
            Integer ceil = map1.ceilingKey(target);
            if(ceil != null){
                min = Math.min(min, Math.abs(goal - (key + ceil)));
            }
        }


        return min;
    }
}
