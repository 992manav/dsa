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

            if(dismap.containsKey(cur)){
                dismap.put(cur, dismap.get(cur) + 1);
            }else{
                dismap.put(cur, 1);
                dis++;
            }

            if(freqmap.containsKey(cur)){
                freqmap.put(cur, freqmap.get(cur) + 1);
            }else{
                freqmap.put(cur, 1);
            }
            if(freqmap.get(cur) == m){
                count_dis_m++;
            }

            while(dis > k){

                int rem = nums[start1];

                if(dismap.get(rem) == 1){
                    dis--;
                    dismap.remove(rem);          // 🔧 FIX: remove instead of setting to 0
                } else {
                    dismap.put(rem, dismap.get(rem) - 1);
                }

                if(start2 < start1 + 1){
                    freqmap.put(rem, freqmap.get(rem) - 1);
                    if(freqmap.get(rem) == m - 1){
                        count_dis_m--;
                    }
                    if(freqmap.get(rem) == 0){
                        freqmap.remove(rem);     // 🔧 FIX: remove instead of setting to 0
                    }
                    start2++;
                }

                start1++;
            }

            while(count_dis_m >= k){

                int toremove = nums[start2];

                freqmap.put(toremove, freqmap.get(toremove) - 1);

                if(freqmap.get(toremove) == m - 1){
                    count_dis_m--;
                }
                if(freqmap.get(toremove) == 0){
                    freqmap.remove(toremove);    // 🔧 FIX: remove instead of setting to 0
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