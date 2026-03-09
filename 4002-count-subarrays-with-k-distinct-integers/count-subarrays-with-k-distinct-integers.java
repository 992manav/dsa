import java.util.*;

class Solution {
    public long countSubarrays(int[] nums, int k, int m) {
        
        int start1 = 0; // window ka left pointer (distinct elements control karne ke liye)
        int start2 = 0; // second left pointer (frequency >= m control karne ke liye)
        int j = 0;      // right pointer

        int n = nums.length;

        // distinct elements track karne ke liye
        Map<Integer,Integer> dismap = new HashMap<>();

        // frequency >= m track karne ke liye
        Map<Integer,Integer> freqmap = new HashMap<>();

        int dis = 0;            // current window mein distinct elements
        int count_dis_m = 0;    // kitne elements ki frequency >= m ho chuki hai

        long ans = 0;

        while(j < n){

            int cur = nums[j];

            // dismap update (distinct elements count)
            if(dismap.containsKey(cur)){
                dismap.put(cur, dismap.get(cur) + 1);
            }else{
                dismap.put(cur, 1);
                dis++; // naya distinct element mila
            }

            // freqmap update (frequency count)
            if(freqmap.containsKey(cur)){
                freqmap.put(cur, freqmap.get(cur) + 1);
            }else{
                freqmap.put(cur, 1);
            }

            // agar kisi element ki frequency m ho gayi
            if(freqmap.get(cur) == m){
                count_dis_m++;
            }

            // agar distinct elements k se zyada ho gaye
            // toh start1 ko move karke window shrink karo
            while(dis > k){

                int rem = nums[start1];

                // dismap update
                if(dismap.get(rem) == 1){
                    dis--;
                    dismap.remove(rem);         
                } else {
                    dismap.put(rem, dismap.get(rem) - 1);
                }

                // ensure start2 kabhi start1 se peeche na rahe
                if(start2 < start1 + 1){

                    freqmap.put(rem, freqmap.get(rem) - 1);

                    // agar frequency m se kam ho gayi
                    if(freqmap.get(rem) == m - 1){
                        count_dis_m--;
                    }

                    if(freqmap.get(rem) == 0){
                        freqmap.remove(rem);   
                    }

                    start2++;
                }

                start1++;
            }

            // agar elements with freq >= m k ya zyada ho gaye
            // toh start2 move karke window adjust karo
            while(count_dis_m >= k){

                int toremove = nums[start2];

                freqmap.put(toremove, freqmap.get(toremove) - 1);

                if(freqmap.get(toremove) == m - 1){
                    count_dis_m--;
                }

                if(freqmap.get(toremove) == 0){
                    freqmap.remove(toremove);   
                }

                start2++;
            }

            // valid subarrays count karo
            // start1 se start2-1 tak ke starting points valid hain
            if(start2 > start1){
                ans += start2 - start1;
            }
            
            j++;
        }

        return ans;
    }
}