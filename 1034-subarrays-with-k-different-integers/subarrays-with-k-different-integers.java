import java.util.*;

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {

        int start1 = 0;
        int start2 = 0;
        int j = 0;

        int n = nums.length;

        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer,Integer> freqmap = new HashMap<>();

        int dis = 0;
        int count = 0;

        int ans = 0;

        while(j < n){

            int cur = nums[j];

            if(map.containsKey(cur)){
                map.put(cur, map.get(cur) + 1);
            }else{
                map.put(cur, 1);
                dis++;
            }

            if(freqmap.containsKey(cur)){
                freqmap.put(cur, freqmap.get(cur) + 1);
            }else{
                freqmap.put(cur, 1);
                count++;
            }

            while(dis > k){
                int rem = nums[start1];
                map.put(rem, map.get(rem) - 1);
                if(map.get(rem) == 0){
                    map.remove(rem);
                    dis--;
                }
                start1++;
            }

            while(count >= k ){
                int rem = nums[start2];
                freqmap.put(rem, freqmap.get(rem) - 1);
                if(freqmap.get(rem) == 0){
                    freqmap.remove(rem);
                    count--;
                }
                start2++;
            }

            ans += start2 - start1;

            j++;
        }

        return ans;
    }
}