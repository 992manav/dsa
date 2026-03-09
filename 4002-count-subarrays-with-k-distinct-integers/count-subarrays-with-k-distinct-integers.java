import java.util.*;

class Solution {
    public long countSubarrays(int[] nums, int k, int m) {

        int start1 = 0;
        int start2 = 0;
        int j = 0;

        int n = nums.length;

        Map<Integer,Integer> dismap = new HashMap<>();
        Map<Integer,Integer> freqmap = new HashMap<>();

        int dis = 0;
        int count_dis_m = 0;

        long ans = 0;

        while(j < n){

            int cur = nums[j];

            dismap.put(cur, dismap.getOrDefault(cur,0) + 1);
            if(dismap.get(cur) == 1){
                dis++;
            }

            freqmap.put(cur, freqmap.getOrDefault(cur,0) + 1);
            if(freqmap.get(cur) == m){
                count_dis_m++;
            }

            while(dis > k){

                int rem = nums[start1];

                if(dismap.get(rem) == 1){
                    dis--;
                }
                dismap.put(rem, dismap.get(rem) - 1);

                if(start2 < start1 + 1){
                    freqmap.put(rem, freqmap.get(rem) - 1);
                    if(freqmap.get(rem) == m - 1){
                        count_dis_m--;
                    }
                    start2++;
                }

                start1++;
            }

            while(count_dis_m >= k){

                int rem = nums[start2];

                freqmap.put(rem, freqmap.get(rem) - 1);

                if(freqmap.get(rem) == m - 1){
                    count_dis_m--;
                }

                start2++;
            }

            if(start2 > start1){
                ans += start2 - start1;
            }

            j++;
        }

        return ans;
    }
}